package com.example.demo.util;

import com.example.demo.VO.ResultVO;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 上午 11:34
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return  resultVO;
    }
}
