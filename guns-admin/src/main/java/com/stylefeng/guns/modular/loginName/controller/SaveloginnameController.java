package com.stylefeng.guns.modular.loginName.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Saveloginname;
import com.stylefeng.guns.modular.loginName.service.ISaveloginnameService;

/**
 * loginName控制器
 *
 * @author fengshuonan
 * @Date 2018-12-02 16:59:11
 */
@Controller
@RequestMapping("/saveloginname")
public class SaveloginnameController extends BaseController {

    private String PREFIX = "/loginName/saveloginname/";

    @Autowired
    private ISaveloginnameService saveloginnameService;

    /**
     * 跳转到loginName首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "saveloginname.html";
    }

    /**
     * 跳转到添加loginName
     */
    @RequestMapping("/saveloginname_add")
    public String saveloginnameAdd() {
        return PREFIX + "saveloginname_add.html";
    }

    /**
     * 跳转到修改loginName
     */
    @RequestMapping("/saveloginname_update/{saveloginnameId}")
    public String saveloginnameUpdate(@PathVariable Integer saveloginnameId, Model model) {
        Saveloginname saveloginname = saveloginnameService.selectById(saveloginnameId);
        model.addAttribute("item",saveloginname);
        LogObjectHolder.me().set(saveloginname);
        return PREFIX + "saveloginname_edit.html";
    }

    /**
     * 获取loginName列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return saveloginnameService.selectList(null);
    }

    /**
     * 新增loginName
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Saveloginname saveloginname) {
        saveloginnameService.insert(saveloginname);
        return SUCCESS_TIP;
    }

    /**
     * 删除loginName
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer saveloginnameId) {
        saveloginnameService.deleteById(saveloginnameId);
        return SUCCESS_TIP;
    }

    /**
     * 修改loginName
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Saveloginname saveloginname) {
        saveloginnameService.updateById(saveloginname);
        return SUCCESS_TIP;
    }

    /**
     * loginName详情
     */
    @RequestMapping(value = "/detail/{saveloginnameId}")
    @ResponseBody
    public Object detail(@PathVariable("saveloginnameId") Integer saveloginnameId) {
        return saveloginnameService.selectById(saveloginnameId);
    }
}
