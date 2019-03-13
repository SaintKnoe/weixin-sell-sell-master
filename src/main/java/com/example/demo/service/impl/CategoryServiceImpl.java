package com.example.demo.service.impl;

import com.example.demo.dao.ProductCategoryDao;
import com.example.demo.dataObject.ProductCategory;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-23
 * Time: 下午8:29
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryDao dao;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return dao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
