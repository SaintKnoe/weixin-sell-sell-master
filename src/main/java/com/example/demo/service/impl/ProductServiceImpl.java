package com.example.demo.service.impl;

import com.example.demo.dao.ProductInfoDao;
import com.example.demo.dataObject.ProductInfo;
import com.example.demo.dto.CartDTO;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-24
 * Time: 上午 10:59
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductInfoDao dao;


    @Override
    public ProductInfo findOne(String productId) {
        return dao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnum.up.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO :cartDTOList){
            ProductInfo productInfo = dao.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            dao.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO :cartDTOList){
            ProductInfo productInfo = dao.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR );
            }
            productInfo.setProductStock(result);
            dao.save(productInfo);
        }
    }
}
