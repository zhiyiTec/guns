/**
 * 初始化loginName详情对话框
 */
var SaveloginnameInfoDlg = {
    saveloginnameInfoData : {}
};

/**
 * 清除数据
 */
SaveloginnameInfoDlg.clearData = function() {
    this.saveloginnameInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SaveloginnameInfoDlg.set = function(key, val) {
    this.saveloginnameInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SaveloginnameInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SaveloginnameInfoDlg.close = function() {
    parent.layer.close(window.parent.Saveloginname.layerIndex);
}

/**
 * 收集数据
 */
SaveloginnameInfoDlg.collectData = function() {
    this
    .set('name')
    .set('id');
}

/**
 * 提交添加
 */
SaveloginnameInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/saveloginname/add", function(data){
        Feng.success("添加成功!");
        window.parent.Saveloginname.table.refresh();
        SaveloginnameInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.saveloginnameInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SaveloginnameInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/saveloginname/update", function(data){
        Feng.success("修改成功!");
        window.parent.Saveloginname.table.refresh();
        SaveloginnameInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.saveloginnameInfoData);
    ajax.start();
}

$(function() {

});
