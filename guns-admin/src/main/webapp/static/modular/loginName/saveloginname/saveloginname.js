/**
 * loginName管理初始化
 */
var Saveloginname = {
    id: "SaveloginnameTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Saveloginname.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Saveloginname.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Saveloginname.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加loginName
 */
Saveloginname.openAddSaveloginname = function () {
    var index = layer.open({
        type: 2,
        title: '添加loginName',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/saveloginname/saveloginname_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看loginName详情
 */
Saveloginname.openSaveloginnameDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'loginName详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/saveloginname/saveloginname_update/' + Saveloginname.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除loginName
 */
Saveloginname.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/saveloginname/delete", function (data) {
            Feng.success("删除成功!");
            Saveloginname.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("saveloginnameId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询loginName列表
 */
Saveloginname.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Saveloginname.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Saveloginname.initColumn();
    var table = new BSTable(Saveloginname.id, "/saveloginname/list", defaultColunms);
    table.setPaginationType("client");
    Saveloginname.table = table.init();
});
