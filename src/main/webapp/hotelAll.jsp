<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/9/12
  Time: 7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        .img{
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<%--多条件查询--%>
    <div class="panel panel-primary">
        <div class="panel-heading">多条件查询</div>
        <div class="panel-body">
            <form class="form-inline">
                <%--      id，name缺一不可,查询项目都是主表ID      --%>
                <div class="form-group">
                    <label for="hname">酒店名称</label>
                    <input type="text" class="form-control" id="hname" name="hotelname" value="${param.hotelname}">
                </div>

                <div class="form-group">
                    <label for="haid">区域</label>
                    <select class="form-control" id="haid" name="hotelareaid">
                        <option value="">====请选择====</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="rtid">房间类型</label>
                    <select class="form-control" id="rtid" name="roomtypeid">
                        <option value="">====请选择====</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">
                    <span class="glyphicon glyphicon-search"></span>&nbsp;查询
                </button>
<%--                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#hotelModal">--%>
<%--                    <span class="glyphicon glyphicon-plus"></span>&nbsp;添加--%>
<%--                </button>--%>
                <button type="button" class="btn btn-primary" onclick="openModel()">
                    <span class="glyphicon glyphicon-plus"></span>&nbsp;添加
                </button>
                <button type="button" class="btn btn-primary btn-danger" onclick="batchDelete()">
                    <span class="glyphicon glyphicon-trash"></span>&nbsp;批量删除
                </button>
            </form>
        </div>
    </div>

<%--hotelModal--%>
<div class="modal" id="hotelModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title" id="hotelModalLabel">添加酒店</h4>
            </div>
            <div class="modal-body">
                <form id="addHotel">
                    <%-- 第一行 --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">酒店名称</span>
                                    <input id="hotelid" name="hotelid" hidden>
                                    <input class="form-control" id="hotelname" name="hotelname" placeholder="酒店名称">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <%--   隐藏原始控件,用一个按钮来调用空间    --%>
                                    <button class="btn btn-info" id="fileBtn" type="button">
                                        <span class="glyphicon glyphicon-cloud-upload"></span>上传图片</button>
                                    <input type="file" name="file"  class="hidden" id="file" >
                                    <%--     onerror: src没有的时候显示一个默认图片    --%>
                                    <img src="" class="img" onerror="this.src='${pageContext.request.contextPath}/images/DefaultHotel.jpg'" id="preview">
                                </div>
                            </div>
                        </div>
                    </div>
                        <%-- 第2行 --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">入住时间</span>
                                    <input class="form-control" id="intime" name="intime">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">退房时间</span>
                                    <input class="form-control" id="outtime" name="outtime">
                                </div>
                            </div>
                        </div>
                    </div>
                        <%-- 第3行 --%>
                    <div class="row">
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">酒店位置</span>
                                    <select class="form-control" id="hotelareaid" name="hotelareaid">
                                        <option value="">====请选择====</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">房型</span>
                                    <select class="form-control" id="roomtypeid" name="roomtypeid">
                                        <option value="">====请选择====</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                        <%-- 第4行 --%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">内容描述</span>
                                    <textarea class="form-control" id="context" name="context"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-- 第5行 --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">房间总数</span>
                                    <input class="form-control" id="roomcount" name="roomcount">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">地址</span>
                                    <input class="form-control" id="site" name="site">
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-- 第6行 --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">酒店联系电话</span>
                                    <input class="form-control" id="hotelphone" name="hotelphone">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">价格</span>
                                    <input class="form-control" id="price" name="price">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="handleButton">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>

        </div>
    </div>
</div>

<%--表格 ${pb.list}--%>
<table class="table table-bordered">
    <tr>
        <th><input type="checkbox" id="all"></th>
        <th>酒店ID</th>
        <th>酒店名称</th>
        <th>入住时间</th>
        <th>退房时间</th>
        <th>图片</th>
        <th>区域</th>
        <th>房间类型</th>
        <th>内容</th>
        <th>收藏数</th>
        <th>点赞数</th>
        <th>房间数</th>
        <th>地址</th>
        <th>电话</th>
        <th>价格</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${pb.list}" var="hotel" varStatus="status">
        <tr>
            <td><input type="checkbox" name="hotelcheck" value="${hotel.hotelid}"></td>
            <td>${hotel.hotelid}</td>
            <td>${hotel.hotelname}</td>
            <td>${hotel.intime}</td>
            <td>${hotel.outtime}</td>
            <td><img class="img" src="${pageContext.request.contextPath}/${hotel.pic}" onerror="this.src='${pageContext.request.contextPath}/images/DefaultHotel.jpg'"></td>
            <td>${hotel.hotelarea.areaname}</td>
            <td>${hotel.roomtype.roomtype}</td>
            <td>${hotel.context}</td>
            <td>${hotel.collection}</td>
            <td>${hotel.favorite}</td>
            <td>${hotel.roomcount}</td>
            <td>${hotel.site}</td>
            <td>${hotel.hotelphone}</td>
            <td>${hotel.price}</td>
            <td>
                <button class="btn btn-info btn-sm" onclick="toUpdateRoom(${hotel.hotelid})">
                    <span class="glyphicon glyphicon-cog"></span>&nbsp;管理房间
                </button>
                <button class="btn btn-info btn-sm" onclick="toUpdate(${hotel.hotelid})">
                    <span class="glyphicon glyphicon-pencil"></span>修改
                </button>
                <button class="btn btn-danger btn-sm" onclick="delHotel(${hotel.hotelid})">
                    <span class="glyphicon glyphicon-trash"></span>&nbsp;删除
                </button>
            </td>
        </tr>
    </c:forEach>
</table>


<%--管理房间modal--%>
<%--hotelModal--%>
<div class="modal" id="hotelRoomModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

        </div>
    </div>
</div>

<%-- 分页 --%>
<nav>
    <ul class="pagination">
        <%-- 上一页 --%>
        <c:if test="${pb.curPage>1}">
            <li><a href="?curPage=${pb.curPage-1}&hotelname=${hotelname}&hotelareaid=${hotelareaid}&roomtypeid=${roomtypeid}"><span>&laquo;</span></a></li>
        </c:if>
        <c:if test="${pb.curPage<=1}">
            <li class="disabled"><a href="javascript:;" ><span>&laquo;</span></a></li>
        </c:if>
        <%--    每一页    --%>
        <c:forEach begin="1" end="${pb.pages}" var="i">
            <c:if test="${pb.curPage==i}">
                <li class="active"><a href="javascript:;">${i}</a></li>
            </c:if>
            <c:if test="${pb.curPage!=i}">
                <li><a href="?curPage=${i}&hotelname=${hotelname}&hotelareaid=${hotelareaid}&roomtypeid=${roomtypeid}">${i}</a></li>
            </c:if>
        </c:forEach>

        <%-- 下一页 --%>
        <c:if test="${pb.curPage<pb.pages}">
            <li><a href="?curPage=${pb.curPage+1}&hotelname=${hotelname}&hotelareaid=${hotelareaid}&roomtypeid=${roomtypeid}"><span>&raquo;</span></a></li>
        </c:if>
        <c:if test="${pb.curPage>=pb.pages}">
            <li class="disabled"><a href="javascript:;"><span>&raquo;</span></a></li>
        </c:if>
    </ul>
</nav>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/bootbox/bootbox.all.min.js"></script><%--对话框插件--%>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstable.js"></script><%--表格插件--%>


<script>
<%--  酒店位置下拉框  --%>
$.ajax({
    //url:'${pageContext.request.contextPath}/hotelarea/findAll',
    url:`${pageContext.request.contextPath}/hotelarea/findAll`,     //模板字符串
    success(data){
        data.forEach(function(hotelarea,i){
            if('${param.hotelareaid}' == hotelarea.hotelareaid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                $('#haid').append(`<option selected value="\${hotelarea.hotelareaid}">\${hotelarea.areaname}</oprtion>`)
            }else{
                $('#haid').append(`<option value="\${hotelarea.hotelareaid}">\${hotelarea.areaname}</oprtion>`)
            }
        })
    }
})

<%--  房间类型  --%>
$.ajax({
    url:'${pageContext.request.contextPath}/roomtype/findAll',
    success(data){
        data.forEach(function(roomtype,i){
            if('${param.roomtypeid}' == roomtype.roomtypeid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                $('#rtid').append(`<option selected value="\${roomtype.roomtypeid}">\${roomtype.roomtype}</oprtion>`)
            }else{
                $('#rtid').append(`<option value="\${roomtype.roomtypeid}">\${roomtype.roomtype}</oprtion>`)
            }
        })
    }
})

//1.打开modal后加载
$('#hotelModal').on('show.bs.modal',function(){
    console.log('show.bs.modal事件')
    <%--  酒店位置  --%>
    $.ajax({
        url:'${pageContext.request.contextPath}/hotelarea/findAll',
        success(data){
            $('#hotelareaid')[0].length=0
            data.forEach(function(hotelarea,i){
                if(Hotel!=null&&Hotel.hotelareaid == hotelarea.hotelareaid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#hotelareaid').append(`<option selected value="\${hotelarea.hotelareaid}">\${hotelarea.areaname}</oprtion>`)
                }else{
                    $('#hotelareaid').append(`<option value="\${hotelarea.hotelareaid}">\${hotelarea.areaname}</oprtion>`)
                }
            })
        }
    })

    <%--  房间类型  --%>
    $.ajax({
        url:'${pageContext.request.contextPath}/roomtype/findAll',
        success(data){
            $('#roomtypeid')[0].length=0
            data.forEach(function(roomtype,i){
                if(Hotel!=null&&Hotel.roomtypeid == roomtype.roomtypeid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#roomtypeid').append(`<option selected value="\${roomtype.roomtypeid}">\${roomtype.roomtype}</oprtion>`)
                }else{
                    $('#roomtypeid').append(`<option value="\${roomtype.roomtypeid}">\${roomtype.roomtype}</oprtion>`)
                }
            })
        }
    })
})

//
$('#hotelRoomModal').on('loaded.bs.modal',function(){
    console.log('触发 loaded.bs.modal')
    //添加按钮
    $('#but_add').click(function() {
        //初始化一行,但是hotelid为null
        rowAddNew('roomtable');
    });

    //3.4 仅刷新
    $('#but_ref').click(function(){
        console.log('关闭并刷新')
        $('#hotelRoomModal').modal('hide')
        location.reload()
    })

    //编辑按钮
    var table = SetEditable({
        tabedId:'roomtable',
        onEdit: function(row,values,tableid) {
            //编辑后回调
            console.log(row);//tr对象
            console.log(values);//数组 0:"1",1:"标准间"}这样的
            //拿到key和值,能在前端处理就不要再后台处理
            let data = {}
            for(i in values){
                //console.log(i,values[i])
                if(i in values){
                    console.log(i,values[i])
                    if(i == 0){
                        data['roomtypeid']=values[i];
                    }else if(i == 1){
                        data['roomtype']=values[i];
                    }else if(i == 2){
                        data['roomprice']=values[i];
                    }else if(i == 3){
                        data['roomnum']=values[i];
                    }else if(i == 4){
                        data['intime']=values[i];
                    }else if(i == 5){
                        data['outtime']=values[i];
                    }else if(i == 6){
                        //data['hotelid']=values[i];
                        data['hotelid']=30;
                    }
                }
            }
            console.log(data)//可以直接转换的格式,格式也是form域

            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/roomtype/updatyeRoomType",
                data,
                async: false,
                success: function (data) {
                    bootbox.alert({ //异步对话框,alert是同步的
                        message: data.message,
                        size: 'small',
                    });
                }
            });
        },
        onBeforeDelete: function(row,values,tableid) {
            //删除前回调

            console.log(row);
            console.log(values);
            console.log(tableid);

            let roomtypeid = values[0]

            console.log('删除前')
            console.log(roomtypeid)

            bootbox.confirm({
                title: '确认操作',
                message: '确认要删除吗?',
                buttons: {
                    cancel: {
                        label: '<i class="glyphicon glyphicon-remove"></i> 取消'
                    },
                    confirm: {
                        label: '<i class="glyphicon glyphicon-ok"></i> 确定'
                    }
                },
                callback: function (result) {
                    //console.log('This was logged in the callback: ' + result);
                    if(result){
                        $.ajax({
                            type:'delete',
                            url:`${pageContext.request.contextPath}/roomtype/\${roomtypeid}`,
                            success(data){
                                //1.提示信息
                                bootbox.alert({ //异步对话框,alert是同步的
                                    title:'结果',
                                    message: data.message,
                                    size: 'small',
                                    callback() {    //要在按钮点击后callback
                                        if(data.success){
                                            //3.刷新页面
                                            location.reload()
                                        }
                                    }
                                });
                            }
                        })
                    }
                }
            });

            //获取第一个单元格隐藏的id
            console.log(row.children('td').eq(0).text());




        },
        onDelete: function(tableid) {
            console.log('删除后')
            //删除后回调
            console.log(tableid);
        },
        onAdd: function(tableid) {
            //添加表格后回调
            console.log(tableid);
        },

    });
})

//事件时触发
$('hotelRoomModal').on('hidden.bs.modal',function (){
    location.reload()
})

//2.上传文件事件
$('#fileBtn').on('click',function(){
    $('#file').trigger('click')//注意这里激活上传控件的方法
})

//3.替换图片,MDN网站看一下
$('#file').on('change',function(){
    //1.创建fileReader对象
    let fr = new FileReader();//ES5提供的用来做文件预览的
    //2.加载图片
    console.log(this.files[0])
    fr.readAsDataURL(this.files[0])//其他方法和含义去看MDN网站
    console.log(fr.result)//结果会被保存result里面
    //3.加载完成事件
    fr.onload = function (){
        //console.log(fr.result)
        $('#preview').prop('src',fr.result)
    }
})


//3.添加/修改Modal
//3.1 添加按钮
function openModel(){
    console.log('openModel')
    //1. 使用modal('show')打开模态框
    $('#hotelModal').modal('show')
    //2. 修改lable和按钮的文字
    $('#hotelModalLabel').html('添加酒店')
    $('#handleButton').html('添加')
    //3. 重置表单
    console.log($('#addHotel')[0])
    $('#addHotel')[0].reset();//但好像不能清空隐藏的值
    Hotel = null //手动清空景点对象
}

//3.2修改按钮
let Hotel = null//1. 用一个全局变量接受一下sucess的返回结果

function toUpdate(hotelid){ //获取ID打开窗口
    //1.取得Scenery
    $.ajax({
        //2.只传一个值的话可以使用restful传值
        url:`${pageContext.request.contextPath}/hotel/\${hotelid}`, //模板字符串和EL表达式冲突了
        async: false,   //没有执行完success,不让执行后面的方法,就是按顺序执行
        success(data){
            Hotel = data
        }
    })
    //console.log(scenery) //之前异步的时候可能在这里拿不到data

    console.log(Hotel)
    //3.打开模态框
    $('#hotelModal').modal('show')

    //4.数据回显,打开模态框之前是没有用的
    $('#hotelid').val(Hotel.hotelid)
    $('#hotelname').val(Hotel.hotelname)
    if(Hotel.pic!=null){
        $('#preview').prop("src",'/'+Hotel.pic)   //变成绝对路径
    }
    $('#intime').val(Hotel.intime)
    $('#outtime').val(Hotel.outtime)
    $('#hotelareaid').val(Hotel.hotelareaid)
    $('#roomtypeid').val(Hotel.roomtypeid)
    $('#context').val(Hotel.context)
    $('#roomcount').val(Hotel.roomcount)
    $('#site').val(Hotel.site)
    $('#hotelphone').val(Hotel.hotelphone)
    $('#price').val(Hotel.price)

    $('#sceneryModalLabel').html('修改酒店')
    $('#handleButton').html('修改')

}

//3.3 保存按钮
$('#handleButton').on('click',function(){
    let data = new FormData($('#addHotel')[0])
    $.ajax({
        type:'post',
        url:`${pageContext.request.contextPath}/hotel/\${Hotel==null?'addHotel':'updateHotel'}`,
        data,
        processData:false,  //不自动处理data成字符串
        contentType:false, //设置成false可以自动检测data类型,multipart/form-data
        success(data){
            //1.提示信息
            bootbox.alert({ //异步对话框,alert是同步的
                message: data.message,
                size: 'small',
                callback() {    //要在按钮点击后callback
                    if(data.success){
                        //2.关闭窗口,
                        $('#hotelModal').modal('hide')
                        //3.刷新页面
                        location.reload()
                    }
                }
            });
        }
    })
})



//4.多选
//4.1全选的时候全选
$('#all').on('click',function(){
    $('[name=sceid]').prop('checked',this.checked)
})
//4.2每条都选中的时候把最上面的也选中
$('[name=sceid]').on('click',function(){
    //alert($('[name=sceid]',$('table')[0]).length)//表示范围
    $('#all').prop('checked',$('table [name=sceid]:checked').length===$('[name=sceid]',$('table')[0]).length)
})

//5.1 删除
//删除
function delHotel(hotelid){
    bootbox.confirm({
        title: '确认操作',
        message: '确认要删除吗?',
        buttons: {
            cancel: {
                label: '<i class="glyphicon glyphicon-remove"></i> 取消'
            },
            confirm: {
                label: '<i class="glyphicon glyphicon-ok"></i> 确定'
            }
        },
        callback: function (result) {
            //console.log('This was logged in the callback: ' + result);
            if(result){
                $.ajax({
                    type:'delete',
                    url:`${pageContext.request.contextPath}/hotel/\${hotelid}`,
                    success(data){
                        //1.提示信息
                        bootbox.alert({ //异步对话框,alert是同步的
                            title:'结果',
                            message: data.message,
                            size: 'small',
                            callback() {    //要在按钮点击后callback
                                if(data.success){
                                    //3.刷新页面
                                    location.reload()
                                }
                            }
                        });
                    }
                })
            }
        }
    });
}

//5.2 批量删除
//批量删除
function batchDelete(){
    //1.判断有没有选中的
    if($('table [name=hotelcheck]:checked').length==0){
        bootbox.alert({ //异步对话框,alert是同步的
            message: '没有酒店被选中',
            size: 'small',
        });
        return
    }

    bootbox.confirm({
        title: '确认操作',
        message: '确认要删除吗?',
        buttons: {
            cancel: {
                label: '<i class="glyphicon glyphicon-remove"></i> 取消'
            },
            confirm: {
                label: '<i class="glyphicon glyphicon-ok"></i> 确定'
            }
        },
        //选确定
        callback: function (result) {
            //console.log('This was logged in the callback: ' + result);
            if(result){
                //2.拼接成id
                let hotelidStr=''
                $('table [name=hotelcheck]:checked').each(function(i,hotel){
                    hotelidStr+=hotel.value+","
                })
                hotelidStr = hotelidStr.slice(0,-1)
                console.log(hotelidStr)
                //3.发送请求,逗号转数组
                <%--$.ajax({--%>
                <%--    url:`${pageContext.request.contextPath}/scenery/batchDelete?sceids=\${sceidStr}`,--%>
                <%--    success(data){--%>
                <%--        //1.提示信息--%>
                <%--        bootbox.alert({ //异步对话框,alert是同步的--%>
                <%--            title:'结果',--%>
                <%--            message: data.message,--%>
                <%--            size: 'small',--%>
                <%--            callback() {    //要在按钮点击后callback--%>
                <%--                if(data.success){--%>
                <%--                    //3.刷新页面--%>
                <%--                    location.reload()--%>
                <%--                }--%>
                <%--            }--%>
                <%--        });--%>
                <%--    }--%>
                <%--})--%>
            }
        }
    })
}


//6.管理房间
//取得酒店房间(bootstrap动态加载列表)
function toUpdateRoom(hotelid){
    //$('#hotelRoomModal')[0].show()
    //底层用的是JQery ajax的load方法,看一下
    $('#hotelRoomModal').modal({
        remote:`${pageContext.request.contextPath}/roomtype/\${hotelid}`
    })
}

function findRoomByRoomtypeId(roomtypeid){
    <%--alert(${'roomtypeid'})--%>

}



</script>
</body>
</html>
