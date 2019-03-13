package com.example.demo.dao;

import com.example.demo.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 下午 2:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao dao;

    private final String Openid="312";
    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("122");
        orderMaster.setBuyerName("xlp");
        orderMaster.setBuyerPhone("18368493694");
        orderMaster.setBuyerAddress("hzt");
        orderMaster.setBuyerOpenid(Openid);
        orderMaster.setOrderAmount(new BigDecimal(50));

        OrderMaster result = dao.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenId() {
        PageRequest pageRequest = new PageRequest(0,1);
        Page<OrderMaster> result = dao.findByBuyerOpenid(Openid,pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());

    }
}