package com.example.demo.dao;

import com.example.demo.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-23
 * Time: 下午 4:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findoneTest(){
      ProductCategory productCategory = dao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("酒水",3);
        ProductCategory result =dao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = dao.findByCategoryTypeIn(list);
        //aa
        Assert.assertNotEquals(0,result.size());
    }
}