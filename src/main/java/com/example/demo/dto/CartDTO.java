package com.example.demo.dto;

import lombok.Data;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-29
 * Time: 上午 10:47
 */
@Data
public class CartDTO {

    /*商品Id*/
    private String productId;

    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
