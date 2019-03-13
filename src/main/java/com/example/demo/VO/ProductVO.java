package com.example.demo.VO;

import com.example.demo.dataObject.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:商品(包含类目)
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 下午 2:29
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
