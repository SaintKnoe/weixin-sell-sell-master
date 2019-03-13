package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.converter.OrderForm2OrderDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.OrderForm;
import com.example.demo.service.BuyerService;
import com.example.demo.service.OrderService;
import com.example.demo.util.ResultVOUtil;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: SaintChan
 * Date: 2018-02-02
 * Time: 下午 2:23
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表

    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> orderDTOList(@RequestParam("openid") String openid,
                                                 @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size",defaultValue = "10") Integer size){

        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOpage = orderService.findList(openid,request);

         return ResultVOUtil.success(orderDTOpage.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        if(StringUtils.isEmpty(orderId)){
            log.error("【查询订单列表】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        //TODO 不安全的用法,改进
        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                                         @RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        if(StringUtils.isEmpty(orderId)){
            log.error("【查询订单列表】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        //TODO 不安全的用法,改进

        buyerService.cancelOrder(openid,orderId);

        return ResultVOUtil.success();
    }

}
