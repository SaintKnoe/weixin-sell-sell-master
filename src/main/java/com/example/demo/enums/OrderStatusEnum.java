package com.example.demo.enums;

import lombok.Getter;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 下午 1:51
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
