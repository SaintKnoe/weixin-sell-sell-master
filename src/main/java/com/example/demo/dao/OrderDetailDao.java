package com.example.demo.dao;

import com.example.demo.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 下午 2:14
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {


    List<OrderDetail> findByOrderId(String orderId);
}
