package com.atguigu.gmall.bean;

import java.io.Serializable;

/* *
 * @Author 19680
 * @Email xiaojm00@163.com
 * @Description 查询的关键字
 * @Date 22:23 2020/1/15
 * @Param
 * @return
 **/
public class PmsSearchParam implements Serializable{

    private String catalog3Id;

    private String keyword;

    private String[] valueId;

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getValueId() {
        return valueId;
    }

    public void setValueId(String[] valueId) {
        this.valueId = valueId;
    }
}
