package com.example.demo.service;

import com.example.demo.dataObject.ProductInfo;
import com.example.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 10:52
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /*查询所有上架的商品*/
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
