package com.example.demo.dao;

import com.example.demo.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-23
 * Time: 下午 4:34
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
