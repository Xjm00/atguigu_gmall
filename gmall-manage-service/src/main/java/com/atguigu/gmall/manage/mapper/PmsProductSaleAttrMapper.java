package com.atguigu.gmall.manage.mapper;import com.atguigu.gmall.bean.PmsProductSaleAttr;import tk.mybatis.mapper.common.Mapper;import java.util.List;/** * @InterfaceName PmsProductSaleAttrMapper * @Description TODO * @Author 19680 * @Date 2020/1/7 20:41 * @Version 1.0 **/public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(String spuid, String skuid);}