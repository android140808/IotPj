package cn.zhian.avater.databasemodule.tables;

import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-09 9:21
 * @Description:
 */
public class ProductDB extends LitePalSupport {
    private int id;
    private String phoneNumber;//用户
    private int productSortId;//序号
    private String productBrand;//产品品牌
    private String productName;//产品名称
    private String productCode;//产品型号
    private String productType;//产品品类
    private String productPlatform;//产品所属平台
    private String productAddTime;//添加时间
    private String productUpdateTime;//修改时间
    private int productOperate;//操作类型,1详情，2编辑，3删除
    private String productMacAddress;//设备mac地址
    private String productIconPath;//产品图片地址


}
