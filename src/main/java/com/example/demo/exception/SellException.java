package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-26
 * Time: 下午 2:23
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
