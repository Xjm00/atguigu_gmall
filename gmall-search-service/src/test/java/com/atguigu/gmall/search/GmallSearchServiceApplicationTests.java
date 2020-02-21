package com.atguigu.gmall.search;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsSearchSkuInfo;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.search.bean.Movie;
import com.atguigu.gmall.service.PmsSkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GmallSearchServiceApplicationTests {

    @Autowired
    JestClient jestClient;

    @Reference
    PmsSkuService pmsSkuService;

    /* *
     * @Author 19680
     * @Email xiaojm00@163.com
     * @Description 插入数据
     * @Date 22:35 2020/1/15
     * @Param []
     * @return void
     **/
    @Test
    public void contextLoads() throws IOException {
        List<PmsSkuInfo> skuInfoList = pmsSkuService.getAllSkuInfo();

        ArrayList<PmsSearchSkuInfo> searchSkuInfos = new ArrayList<>();

        for (PmsSkuInfo pmsSkuInfo : skuInfoList) {
            PmsSearchSkuInfo searchSkuInfo = new PmsSearchSkuInfo();

            BeanUtils.copyProperties(pmsSkuInfo, searchSkuInfo);
            // 向elasticsearch插入sku数据
            Index index = new Index.Builder(searchSkuInfo).id(searchSkuInfo.getId()).type("pmsSearchSkuInfo").index("gmall_test1").build();

            // 执行elasticsearch
            jestClient.execute(index);
            searchSkuInfos.add(searchSkuInfo);
        }

    }

    /* *
     * @Author 19680
     * @Email xiaojm00@163.com
     * @Description 查询数据
     * @Date 22:36 2020/1/15
     * @Param []
     * @return void
     **/
    @Test
    public void searchTest() throws IOException {
        // 查询的dsl的封装对象
        String query = "";
        query = getSearchSourceBuilder();
        Search search = new Search.Builder(query).addIndex("gmall_test1").addType("pmsSearchSkuInfo").build();
        SearchResult execute = jestClient.execute(search);

        List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);

        for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
            PmsSearchSkuInfo source = hit.source;
            System.out.println(source.getSkuName());
        }

        System.out.println(execute);
    }

    public String getSearchSourceBuilder() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
//        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
//        new HighlightBuilder();
//
//        // term
//        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("id", 1);
//        boolQueryBuilder.filter(termQueryBuilder);
//
//        // query
//        searchSourceBuilder.query(boolQueryBuilder);

        return searchSourceBuilder.toString();
    }

}
