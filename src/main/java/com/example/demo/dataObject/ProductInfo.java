package com.example.demo.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Description:商品
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 10:02
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /*商品名称*/
    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /*库存*/
    private Integer productStock;

    /*描述*/
    private String productDescription;

    /*状态，0正常1下架*/
    private Integer productStatus;

    /*小图*/
    private String productIcon;

    /*类目编号*/
    private Integer categoryType;


}
