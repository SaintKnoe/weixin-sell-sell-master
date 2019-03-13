package com.example.demo.enums;

import lombok.Getter;

/**
 * Description:商品状态
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 11:06
 */
@Getter
public enum ProductStatusEnum {

    up(0,"上架中"),
    dowm(1,"下架");

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
