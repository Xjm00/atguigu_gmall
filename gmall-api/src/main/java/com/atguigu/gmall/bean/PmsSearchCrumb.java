package com.atguigu.gmall.bean;

/* *
 * @Author 19680
 * @Email xiaojm00@163.com
 * @Description 查询到的结果集
 * @Date 22:23 2020/1/15
 * @Param
 * @return
 **/
public class PmsSearchCrumb {

    private String valueId;
    private String valueName;
    private String urlParam;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }
}
