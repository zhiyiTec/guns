/**
 * xueyuanmgr管理初始化
 */
var Org = {
    id: "OrgTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Org.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'num', visible: true, align: 'center', valign: 'middle'},
            {title: '父部门id', field: 'pid', visible: true, align: 'center', valign: 'middle'},
            {title: '父级ids', field: 'pids', visible: true, align: 'center', valign: 'middle'},
            {title: '简称', field: 'simplename', visible: true, align: 'center', valign: 'middle'},
            {title: '全称', field: 'fullname', visible: true, align: 'center', valign: 'middle'},
            {title: '提示', field: 'tips', visible: true, align: 'center', valign: 'middle'},
            {title: '版本（乐观锁保留字段）', field: 'version', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Org.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Org.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加xueyuanmgr
 */
Org.openAddOrg = function () {
    var index = layer.open({
        type: 2,
        title: '添加xueyuanmgr',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/org/org_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看xueyuanmgr详情
 */
Org.openOrgDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'xueyuanmgr详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/org/org_update/' + Org.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除xueyuanmgr
 */
Org.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/org/delete", function (data) {
            Feng.success("删除成功!");
            Org.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orgId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询xueyuanmgr列表
 */
Org.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Org.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Org.initColumn();
    var table = new BSTable(Org.id, "/org/list", defaultColunms);
    table.setPaginationType("client");
    Org.table = table.init();
});
