package com.example.demo.VO;

import lombok.Data;

/**
 * Description:http请求返回的最外层对象
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 下午 2:13
 */
@Data
public class ResultVO<T> {

    /*错误码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体内容*/
    private T data;
}
