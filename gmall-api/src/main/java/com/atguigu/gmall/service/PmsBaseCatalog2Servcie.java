package com.atguigu.gmall.service;import com.atguigu.gmall.bean.PmsBaseCatalog1;import com.atguigu.gmall.bean.PmsBaseCatalog2;import java.util.List;/** * @InterfaceName PmsBaseCatalog2Servcie * @Description TODO * @Author 19680 * @Date 2020/1/7 14:23 * @Version 1.0 **/public interface PmsBaseCatalog2Servcie {    List<PmsBaseCatalog2> getCatalog2ByCatalog1Id(String catalog1Id);}