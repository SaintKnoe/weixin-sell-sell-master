package com.example.demo.dao;

import com.example.demo.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-26
 * Time: 上午 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao dao;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12");
        orderDetail.setOrderId("111");
        orderDetail.setProductId("111");
        orderDetail.setProductName("可乐");
        orderDetail.setProductQuantity(100);
        orderDetail.setProductIcon(".....png");
        orderDetail.setProductPrice(new BigDecimal(2.5));

        OrderDetail result = dao.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrderId() {
       List<OrderDetail> orderDetailList= dao.findByOrderId("111");
       Assert.assertNotEquals(0,orderDetailList.size());
    }
}