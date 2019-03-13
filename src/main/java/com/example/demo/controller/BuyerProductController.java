package com.example.demo.controller;

import com.example.demo.VO.ProductInfoVO;
import com.example.demo.VO.ProductVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.dataObject.ProductCategory;
import com.example.demo.dataObject.ProductInfo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 下午 2:08
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2.查询类目(一次性查询)
        //List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        /*for (ProductInfo productInfo : productInfoList){
            productInfo.getCategoryType();
        }*/
        //精简方法(java8,lambda)
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e ->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        // 3.数据拼装
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                    /*productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVO.setProductDescription(productInfo.getProductDescription());
                    productInfoVO.setProductIcon(productInfo.getProductIcon());*/
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
