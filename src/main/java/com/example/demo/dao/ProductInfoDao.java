package com.example.demo.dao;

import com.example.demo.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 10:22
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
