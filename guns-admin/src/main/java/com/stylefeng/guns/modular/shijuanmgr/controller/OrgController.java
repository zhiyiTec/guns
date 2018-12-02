package com.stylefeng.guns.modular.shijuanmgr.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Org;
import com.stylefeng.guns.modular.shijuanmgr.service.IOrgService;

/**
 * xueyuanmgr控制器
 *
 * @author fengshuonan
 * @Date 2018-07-20 18:28:58
 */
@Controller
@RequestMapping("/org")
public class OrgController extends BaseController {

    private String PREFIX = "/shijuanmgr/org/";

    @Autowired
    private IOrgService orgService;

    /**
     * 跳转到xueyuanmgr首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "org.html";
    }

    /**
     * 跳转到添加xueyuanmgr
     */
    @RequestMapping("/org_add")
    public String orgAdd() {
        return PREFIX + "org_add.html";
    }

    /**
     * 跳转到修改xueyuanmgr
     */
    @RequestMapping("/org_update/{orgId}")
    public String orgUpdate(@PathVariable Integer orgId, Model model) {
        Org org = orgService.selectById(orgId);
        model.addAttribute("item",org);
        LogObjectHolder.me().set(org);
        return PREFIX + "org_edit.html";
    }

    /**
     * 获取xueyuanmgr列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return orgService.selectList(null);
    }

    /**
     * 新增xueyuanmgr
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Org org) {
        orgService.insert(org);
        return SUCCESS_TIP;
    }

    /**
     * 删除xueyuanmgr
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orgId) {
        orgService.deleteById(orgId);
        return SUCCESS_TIP;
    }

    /**
     * 修改xueyuanmgr
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Org org) {
        orgService.updateById(org);
        return SUCCESS_TIP;
    }

    /**
     * xueyuanmgr详情
     */
    @RequestMapping(value = "/detail/{orgId}")
    @ResponseBody
    public Object detail(@PathVariable("orgId") Integer orgId) {
        return orgService.selectById(orgId);
    }
}
