/**
 * 初始化xueyuanmgr详情对话框
 */
var OrgInfoDlg = {
    orgInfoData : {}
};

/**
 * 清除数据
 */
OrgInfoDlg.clearData = function() {
    this.orgInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrgInfoDlg.set = function(key, val) {
    this.orgInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrgInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrgInfoDlg.close = function() {
    parent.layer.close(window.parent.Org.layerIndex);
}

/**
 * 收集数据
 */
OrgInfoDlg.collectData = function() {
    this
    .set('id')
    .set('num')
    .set('pid')
    .set('pids')
    .set('simplename')
    .set('fullname')
    .set('tips')
    .set('version');
}

/**
 * 提交添加
 */
OrgInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/org/add", function(data){
        Feng.success("添加成功!");
        window.parent.Org.table.refresh();
        OrgInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orgInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OrgInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/org/update", function(data){
        Feng.success("修改成功!");
        window.parent.Org.table.refresh();
        OrgInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orgInfoData);
    ajax.start();
}

$(function() {

});
