package com.stylefeng.guns.modular.saveLoginName.controller;

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

import com.stylefeng.guns.modular.saveLoginName.service.SaveLoginNameService;
import com.stylefeng.guns.modular.system.dao.OrderMapper;
import com.stylefeng.guns.modular.system.model.Order;
import com.stylefeng.guns.modular.system.model.SaveLoginName;
import com.stylefeng.guns.modular.zxOrder.service.IOrderService;

import net.sf.ehcache.search.expression.Or;

/**
 * 订单管理控制器
 *
 * @author fengshuonan
 * @Date 2018-11-26 18:13:24
 */
@Controller

public class SaveLoginNameController{
	@Autowired
	SaveLoginNameService SaveLoginNameService;
	@RequestMapping("/saveLoginName")
	public void saveLoginName(@RequestParam(value="loginName") String loginName) {
		SaveLoginName SaveLoginName=new SaveLoginName(1,loginName);
		SaveLoginNameService.updateLoginName(SaveLoginName);
	}
	@ResponseBody
	@RequestMapping("/getLoginName")
	public String getLoginName() {
		return SaveLoginNameService.getLoginName();
	}
}
