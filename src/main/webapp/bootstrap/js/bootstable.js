/*
Bootstable
 @description  Javascript library to make HMTL tables editable, using Bootstrap
 @version 1.2
*/
  "use strict";
//Global variables
var params = null;
var newColHtml = '<div class="btn-group pull-right">'+
'<button id="bEdit" type="button" class="btn btn-sm btn-default" onclick="rowEdit(this);">' +
'<span class="glyphicon glyphicon-pencil" > </span>'+
'</button>'+
'<button id="bElim" type="button" class="btn btn-sm btn-default" onclick="rowElim(this);">' +
'<span class="glyphicon glyphicon-trash" > </span>'+
'</button>'+
'<button id="bAcep" type="button" class="btn btn-sm btn-default" style="display:none;" onclick="rowAcep(this);">' + 
'<span class="glyphicon glyphicon-ok" > </span>'+
'</button>'+
'<button id="bCanc" type="button" class="btn btn-sm btn-default" style="display:none;" onclick="rowCancel(this);">' + 
'<span class="glyphicon glyphicon-remove" > </span>'+
'</button>'+
'</div>';
var colEdicHtml = '<td name="buttons">'+newColHtml+'</td>';
var SetEditable = function (options) {
	var defaults = {
		tabedId:null,					//tableId对列
		onEdit: function() {},			//编辑后回调
		onBeforeDelete: function() {},	//删除前回调
		onDelete: function() {},		//删除后回调
		onAdd: function() {}			//添加新行后调用
	};
	params = $.extend(defaults, options);
	let tabedId = params.tabedId.split(',');
	if(tabedId){
		$.each(tabedId,function(k, v) {
			$('#'+v+'').find('thead tr').append('<th name="buttons"></th>');  	//添加按钮的标题
			$('#'+v+'').find('tbody tr').append(colEdicHtml);					//添加按钮
			let addButton = $('#'+v+'').attr('addButton');						//添加按钮
			if (addButton) {
				$('#'+addButton+'').click(function() {
					rowAddNew(v);
				});
			}
		 });
	}
};
//设置可编辑字段
function IterarCamposEdit($cols, tarea) {
    let n = 0;
	let columnsEd = $($cols).closest('table').attr('columnsEd');//当前可编辑对列
	let colsEdi = columnsEd ? columnsEd.split(',') : null;
    $cols.each(function() {
        n++;
        if ($(this).attr('name')=='buttons') return;  //排除列按钮
        if (!EsEditable(n-1,colsEdi)) return;
        tarea($(this));
    });
    function EsEditable(idx,colsEdi) {
		//判断列是否可编辑
        if (colsEdi==null) {//null代表全部编辑
            return true;
        } else {
            for (var i = 0; i < colsEdi.length; i++) {
              if (idx == colsEdi[i]) return true;
            }
            return false;
        }
    }
}
//编辑状态恢复
function FijModoNormal(but) {
    $(but).parent().find('#bAcep').hide();
    $(but).parent().find('#bCanc').hide();
    $(but).parent().find('#bEdit').show();
    $(but).parent().find('#bElim').show();
    $(but).parents('tr').attr('id', '');
}
//校验编辑状态
function ModoEdicion($row) {
    return $row.attr('id')=='editing' ? true : false;
}
//确定编辑
function rowAcep(but) {
    let $row = $(but).parents('tr');
    let $cols = $row.find('td');
    if (!ModoEdicion($row)) return;
    IterarCamposEdit($cols, function($td) {
      let cont = $td.find('input').val();
      $td.html(cont);
    });
    FijModoNormal(but);
	//编辑后回调函数
	let tableId = $(but).closest('table').attr('id');
	let values={};
	$row.each(function(i){
		$(this).children('td').each(function(j){
			if($(this).text()!='    '){
				values[j] = $(this).text();
			}
		});
	});
    params.onEdit($row,values,tableId);
}
//中断编辑
function rowCancel(but) {
    let $row = $(but).parents('tr');
    let $cols = $row.find('td');
    if (!ModoEdicion($row)) return;
    IterarCamposEdit($cols, function($td) {
        let cont = $td.find('div').html();
        $td.html(cont);
    });
    FijModoNormal(but);
}
//编辑事件
function rowEdit(but) {
    let $row = $(but).parents('tr');
    let $cols = $row.find('td');
    if (ModoEdicion($row)) return; //获取是否编辑中
    IterarCamposEdit($cols, function($td) {
        let cont = $td.html();
        let div = '<div style="display: none;">' + cont + '</div>';
        let input = '<input class="form-control input-sm"  value="' + cont + '">';
        $td.html(div + input);
    });
    $(but).parent().find('#bAcep').show();
    $(but).parent().find('#bCanc').show();
    $(but).parent().find('#bEdit').hide();
    $(but).parent().find('#bElim').hide();
    $row.attr('id', 'editing'); //设置编辑状态
}
//删除事件
function rowElim(but) {
    let $row = $(but).parents('tr');
	let tableId = $(but).closest('table').attr('id');
	let values={};
	$row.each(function(i){
		$(this).children('td').each(function(j){
			if($(this).text()!='    '){
				values[j] = $(this).text();
			}
		});
	});
	//删除表格前事件
    params.onBeforeDelete($row,values,tableId);
    $row.remove();
	//删除表格后事件
    params.onDelete(tableId);
}
//添加新的表格行
function rowAddNew(tabId) {
	let $tab_en_edic = $("#" + tabId);
    let $filas = $tab_en_edic.find('tbody tr');
    if ($filas.length==0) {
        let $cols = $tab_en_edic.find('thead tr').find('th');
        let htmlDat = '';
        $cols.each(function() {
            if ($(this).attr('name')=='buttons') {
                htmlDat = htmlDat + colEdicHtml;
            } else {
				if(htmlDat){
					htmlDat = htmlDat + '<td></td>';
				}else{
					htmlDat = htmlDat + '<td class="hide"></td>';
				}
            }
        });
        $tab_en_edic.find('tbody').append('<tr>'+htmlDat+'</tr>');
    } else {
        let $ultFila = $tab_en_edic.find('tr:last');
        $ultFila.clone().appendTo($ultFila.parent());  
        $ultFila = $tab_en_edic.find('tr:last');
        let $cols = $ultFila.find('td');
        $cols.each(function() {
            if ($(this).attr('name')!='buttons') {
                $(this).html('');
            }
        });
    }
	//添加行后回调
	params.onAdd(tabId);
}