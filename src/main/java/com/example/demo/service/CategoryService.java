package com.example.demo.service;

import com.example.demo.dataObject.ProductCategory;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-23
 * Time: 下午8:07
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
