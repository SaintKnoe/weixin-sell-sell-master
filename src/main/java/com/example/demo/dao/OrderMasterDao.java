package com.example.demo.dao;

import com.example.demo.dataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-01-25
 * Time: 下午 2:10
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String>{

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
