package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 11:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception{
        ProductInfo productInfo=productService.findOne("123");
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception{
        List<ProductInfo> productInfoList=productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception{
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage=productService.findAll(pageRequest);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());

    }

    @Test
    public void save() throws Exception{
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("110");
        productInfo.setProductName("酸菜鱼");
        productInfo.setProductPrice(new BigDecimal(30));
        productInfo.setProductStock(100);
        productInfo.setProductIcon("..jpg");
        productInfo.setProductStatus(ProductStatusEnum.up.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}