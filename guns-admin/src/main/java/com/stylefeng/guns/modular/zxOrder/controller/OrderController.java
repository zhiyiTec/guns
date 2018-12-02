package com.stylefeng.guns.modular.zxOrder.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;

import com.stylefeng.guns.modular.system.dao.OrderMapper;
import com.stylefeng.guns.modular.system.model.Order;
import com.stylefeng.guns.modular.zxOrder.service.IOrderService;

import net.sf.ehcache.search.expression.Or;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2018-11-26 18:13:24
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private String PREFIX = "/zxOrder/order/";

    @Autowired
    private IOrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 跳转到订单管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "order.html";
    }

    /**
     * 跳转到添加订单管理
     */
    @RequestMapping("/order_add")
    public String orderAdd() {
        return PREFIX + "order_add.html";
    }

    /**
     * 跳转到修改订单管理
     */
    @RequestMapping("/order_update/{orderId}")
    public String orderUpdate(@PathVariable Integer orderId, Model model) {
        Order order = orderService.selectById(orderId);
        model.addAttribute("item",order);
        LogObjectHolder.me().set(order);
        return PREFIX + "order_edit.html";
    }

    /**
     * 获取订单管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    List<Order>lOrders=new LinkedList<Order>();
    	if(condition==null||condition.equals("")) {
    		lOrders= orderService.selectList(null);
    	}
    	else {
    		EntityWrapper<Order> ew=new EntityWrapper<Order>();
    		Wrapper<Order> order_name=ew.like("order_name","%"+condition+"%");
    		lOrders= orderService.selectList(order_name);
    	}
    	return lOrders;
        
    }

    /**
     * 新增订单管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(Order order) {
    	if(order.getId()==null) {
    		long dataTime=Calendar.getInstance().getTimeInMillis();
    		Integer ra_id=(int)(dataTime);
    		order.setId(ra_id);
    	}
    	if(order.getOrderTime()==null||order.getOrderTime().equals(" ")) {
    		order.setOrderTime(new Date());
    	}
    	orderMapper.addOrder(order);
       
    }
    /**
     * 删除订单管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orderId) {
        orderService.deleteById(orderId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Order order) {
        orderService.updateById(order);
        return SUCCESS_TIP;
    }

    /**
     * 订单管理详情
     */
    @RequestMapping(value = "/detail/{orderId}")
    @ResponseBody
    public Object detail(@PathVariable("orderId") Integer orderId) {
        return orderService.selectById(orderId);
    }
}
