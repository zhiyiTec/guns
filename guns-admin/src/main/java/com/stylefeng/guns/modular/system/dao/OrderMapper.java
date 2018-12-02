package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2018-11-26
 */
public interface OrderMapper extends BaseMapper<Order> {
	public void addOrder(Order order);
}
