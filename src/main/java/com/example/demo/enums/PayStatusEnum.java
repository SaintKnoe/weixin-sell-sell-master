package com.example.demo.enums;

import lombok.Getter;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 下午 1:54
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
