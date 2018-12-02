package com.stylefeng.guns.modular.saveLoginName.service;

import com.stylefeng.guns.modular.system.model.Order;
import com.stylefeng.guns.modular.system.model.SaveLoginName;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-11-26
 */
public interface SaveLoginNameService{
	public String getLoginName();
	public void updateLoginName(SaveLoginName SaveLoginName);
}
