package com.stylefeng.guns.modular.saveLoginName.serviceImpl;

import com.stylefeng.guns.modular.system.model.Order;
import com.stylefeng.guns.modular.system.model.SaveLoginName;
import com.stylefeng.guns.modular.saveLoginName.service.SaveLoginNameService;
import com.stylefeng.guns.modular.system.dao.OrderMapper;
import com.stylefeng.guns.modular.system.dao.SaveLoginNameMapper;
import com.stylefeng.guns.modular.zxOrder.service.IOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-11-26
 */
@Service
public class SaveLoginNameServiceImpl implements SaveLoginNameService{
	@Autowired
	SaveLoginNameMapper SaveLoginNameMapper;
	@Override
	public String getLoginName() {
		// TODO Auto-generated method stub
		return SaveLoginNameMapper.getLoginName();
	}

	@Override
	public void updateLoginName(SaveLoginName SaveLoginName) {
		// TODO Auto-generated method stub
		SaveLoginNameMapper.updateLoginName(SaveLoginName);
	}

}
