<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/9/8
  Time: 10:20
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
<%--        --%>
        <form class="form-inline">
            <%--      id，name缺一不可      --%>
            <div class="form-group">
                <label for="sname">景点名称</label>
                <input type="text" class="form-control" id="sname" name="scename" value="${param.scename}">
            </div>

            <div class="form-group">
                <label for="stid">景点类别</label>
                <select class="form-control" id="stid" name="scetypeid">
                    <option value="">====请选择====</option>
                </select>
            </div>

                <%--区域，票价，季节，地点--%>
            <div class="form-group">
                <label for="aid">区域</label>
                <select class="form-control" id="aid" name="areaid">
                    <option value="">====请选择====</option>
                </select>
            </div>

            <div class="form-group">
                <%--ticket--%>
                <label>票价</label>
                <input type="text" class="form-control" id="lowprice" name="lowprice" value="${param.lowprice}" placeholder="最低价">
                ~
                <input type="text" class="form-control" id="highprice" name="highprice" value="${param.highprice}" placeholder="最高价">
            </div>

            <div class="form-group">
                <label for="ss">季节</label>
                <select class="form-control" id="ss" name="season">
                    <option value="">====请选择====</option>
                </select>
            </div>

            <div class="form-group">
                <label for="loc">地点</label>
                <input type="text" class="form-control" id="loc" name="location" value="${param.location}">
            </div>

            <button type="submit" class="btn btn-primary btn-default">
                <!-- &nbsp; 空格 -->
                <span class="glyphicon glyphicon-search"></span>&nbsp;查询
            </button>
            <%--  data-toggle切换   data-target="#myModal"   不要使用事件打开,要使用方法打开        --%>
<%--            <button type="button" class="btn btn-primary btn-default" data-toggle="modal" data-target="#sceneryModal">添加</button>--%>
                <button type="button" class="btn btn-primary btn-default" onclick="openModel()">
                    <span class="glyphicon glyphicon-plus"></span>&nbsp;添加
                </button>
                <button type="button" class="btn btn-primary btn-default" onclick="batchDelete()">
                    批量删除
                </button>
        </form>

    </div>
</div>

<%--模态框--%>
<!-- 六部分
 外三层:必须,设置外观样式
    1. 动画和索引
        1.class="modal fade" fade淡入淡出
        2.tabindex="-1" 不要动
        3.role="dialog" aria-labelledby="myModalLabel" 默认用
    2. 设置外观,大小
        1.modal-lg 变宽
    3. 设置内容 modal-content必须
        内三层:可选,设置内容
        1.modal-header
        2.modal-body
        3.modal-footer


 -->
<div class="modal" id="sceneryModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title" id="sceneryModalLabel">添加景点</h4>
            </div>
            <div class="modal-body">
                <form id="addScenery">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">景点名称</span>
                                    <input name="sceid" id="sceid" hidden>
                                    <input class="form-control" id="scename" name="scename" placeholder="景点名称">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">景点类别</span>
                                    <select class="form-control" id="scetypeid" name="scetypeid">
                                        <option value="">====请选择====</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
<%--第二行--%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">景点内容</span>
                                    <textarea class="form-control" id="context" name="context" placeholder="景点内容">

                                    </textarea>
                                </div>
                            </div>
                        </div>
                    </div>
<%--        第三行            --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">票价</span>
                                    <input type="number" class="form-control" id="ticket" name="ticket" placeholder="票价">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">区域</span>
                                    <select class="form-control" id="areaid" name="areaid">
                                        <option value="">====请选择====</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
<%--        第四行            --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">季节</span>
                                    <select class="form-control" id="season" name="season">
                                        <option value="">====请选择====</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">等级</span>
                                    <input type="number" class="form-control" id="sceGrade" name="sceGrade">
                                </div>
                            </div>
                        </div>
                    </div>
<%--        5         123456   --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">地点</span>
                                    <input class="form-control" id="location" name="location" placeholder="地点">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">开放时间</span>
                                    <input class="form-control" id="startTime" name="startTime" placeholder="开放时间">
                                </div>
                            </div>
                        </div>
                    </div>
<%--        6            --%>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">剩余票数</span>
                                    <input type="number" class="form-control" id="ticCount" name="ticCount" placeholder="地点">
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
                                    <img src="" class="img" onerror="this.src='${pageContext.request.contextPath}/images/default.jpg'" id="preview">
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

<%-- 表格 ${sceneryList}--%>
    <table class="table table-bordered">
        <tr>
            <th><input type="checkbox" id="all"></th>
            <th>景点编号</th>
            <th>景点名称</th>
            <th>景点类别</th>
            <th>景点内容</th>
            <th>图片</th>
            <th>推荐数</th>
            <th>区域</th>
            <th>票价</th>
            <th>点赞数</th>
            <th>季节</th>
            <th>收藏数</th>
            <th>等级</th>
            <th>地点</th>
            <th>开放时间</th>
            <th>剩余票数</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list}" var="scenery" varStatus="status">
            <tr>
                <td><input type="checkbox" name="sceid" value="${scenery.sceid}"></td>
                <td>${status.count}</td>
                <td>${scenery.scename}</td>
                <td>${scenery.scetype.scename}</td>
                <td>${scenery.context}</td>
                <td><img class="img" src="${pageContext.request.contextPath}/${scenery.pic}" onerror="this.src='${pageContext.request.contextPath}/images/default.jpg'"></td>
                <td>${scenery.recommend}</td>
                <td>${scenery.area.areaname}</td>
                <td>${scenery.ticket}</td>
                <td>${scenery.favorite}</td>
                <td>${scenery.season}</td>
                <td>${scenery.collection}</td>
                <td>${scenery.sceGrade}</td>
                <td>${scenery.location}</td>
                <td>${scenery.startTime}</td>
                <td>${scenery.ticCount}</td>
                <td>
                    <button class="btn btn-info btn-sm" onclick="toUpdate(${scenery.sceid})">
                        <span class="glyphicon glyphicon-pencil"></span>修改
                    </button>
                    <button class="btn btn-danger btn-sm" onclick="delScenery(${scenery.sceid})">
                        <span class="glyphicon glyphicon-trash"></span>删除
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>

<%-- 分页 --%>
    <nav>
        <ul class="pagination">
            <%-- 上一页 --%>
            <c:if test="${pb.curPage>1}">
                <li><a href="?curPage=${pb.curPage-1}&scename=${param.scename}&scetypeid=${param.scetypeid}"><span>&laquo;</span></a></li>
            </c:if>
            <c:if test="${pb.curPage<=1}">
                <li class="disabled"><a href="javascript:;" ><span>&laquo;</span></a></li>
            </c:if>

            <c:forEach begin="1" end="${pb.pages}" var="i">
                <c:if test="${pb.curPage==i}">
                    <li class="active"><a href="javascript:;">${i}</a></li>
                </c:if>
                <c:if test="${pb.curPage!=i}">
                    <li><a href="?curPage=${i}">${i}</a></li>
                </c:if>
            </c:forEach>

            <%-- 下一页 --%>
            <c:if test="${pb.curPage<pb.pages}">
                <li><a href="?curPage=${pb.curPage+1}"><span>&raquo;</span></a></li>
            </c:if>
            <c:if test="${pb.curPage>=pb.pages}">
                <li class="disabled"><a href="javascript:;"><span>&raquo;</span></a></li>
            </c:if>
        </ul>
    </nav>

<%--为了返回异步结果，导入Jquery--%>
<%--为了，导入Jquery--%>
<%--网络传输需要序列化--%>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%--对话框插件--%>
<script src="${pageContext.request.contextPath}/bootbox/bootbox.all.min.js"></script>
<script>
<%--  响应报文里自动转json了,context-applcation  --%>
<%-- 景点类别 --%>
$.ajax({
        url:'${pageContext.request.contextPath}/scetype/findAll',
        success(data){
            data.forEach(function(scetype,i){
                //append(``)里面是模板字符串，用反引号
                //默认认为是java代码,想用EL表达式要加斜杠
                if('${param.scetypeid}' == scetype.scetypeid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#stid').append(`<option selected value="\${scetype.scetypeid}">\${scetype.scename}</oprtion>`)
                }else{
                    $('#stid').append(`<option value="\${scetype.scetypeid}">\${scetype.scename}</oprtion>`)
                }
            })
        }
    })

<%-- 区域 --%>
$.ajax({
    url:'${pageContext.request.contextPath}/area/findAll',
    success(data){
        data.forEach(function(area,i){
            if('${param.areaid}' == area.areaid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                $('#aid').append(`<option selected value="\${area.areaid}">\${area.areaname}</oprtion>`)
            }else{
                $('#aid').append(`<option value="\${area.areaid}">\${area.areaname}</oprtion>`)
            }
        })
    }
})

<%-- 季节 --%>
$.ajax({
    url:'${pageContext.request.contextPath}/scenery/findAllSeason',
    success(data){
        data.forEach(function(scenery,i){
            if('${param.season}' == scenery.season){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                $('#ss').append(`<option selected value="\${scenery.season}">\${scenery.season}</oprtion>`)
            }else{
                $('#ss').append(`<option value="\${scenery.season}">\${scenery.season}</oprtion>`)
            }
        })
    }
})

//在model代开后启动
//但是事件触发会导致打开第二次的时候第一次的数据会残留
$('#sceneryModal').on('show.bs.modal',function(){
    // alert('show.bs.modal')
    //类别
    $.ajax({
        url:'${pageContext.request.contextPath}/scetype/findAll',
        async:false,
        success(data){
            $('#scetypeid')[0].length=0 //用dom清空,还有同一种api清空
            data.forEach(function(scetype,i){
                //append(``)里面是模板字符串，用反引号
                //默认认为是java代码,想用EL表达式要加斜杠
                if('${param.scetypeid}' == scetype.scetypeid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#scetypeid').append(`<option selected value="\${scetype.scetypeid}">\${scetype.scename}</oprtion>`)
                }else{
                    $('#scetypeid').append(`<option value="\${scetype.scetypeid}">\${scetype.scename}</oprtion>`)
                }
            })
        }
    })

    //区域
    $.ajax({
        url:'${pageContext.request.contextPath}/area/findAll',
        async:false,
        success(data){
            $('#areaid')[0].length=0
            data.forEach(function(area,i){
                if('${param.areaid}' == area.areaid){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#areaid').append(`<option selected value="\${area.areaid}">\${area.areaname}</oprtion>`)
                }else{
                    $('#areaid').append(`<option value="\${area.areaid}">\${area.areaname}</oprtion>`)
                }
            })
        }
    })

    //季节
    $.ajax({
        url:'${pageContext.request.contextPath}/scenery/findAllSeason',
        async:false,
        success(data){
            $('#season')[0].length=0
            data.forEach(function(scenery,i){
                if('${param.season}' == scenery.season){ //有一个" == scetype.scetypeid"的问题，加上单引号为空的话就''字符串
                    $('#season').append(`<option selected value="\${scenery.season}">\${scenery.season}</oprtion>`)
                }else{
                    $('#season').append(`<option value="\${scenery.season}">\${scenery.season}</oprtion>`)
                }
            })
        }
    })


    //上传文件事件
    $('#fileBtn').on('click',function(){
        $('#file').trigger('click')//注意这里激活上传控件的方法
    })
    //替换图片,MDN网站看一下
    //base64: 代表一张图片的data字符串,可以直接写在jsp里,把图片转成字符串
    //字符串占物理硬盘,文本是占用大小的,因此大图片不要使用这个技术
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
})

//添加用户
$('#handleButton').on('click',function(){
    <%--//获取form表单 addBtn,这个要看一下文档--%>
    <%--let data = $('#addScenery').serialize()--%>
    <%--//默认是get,绝对路径--%>
    <%--$.ajax({--%>
    <%--    type:'post',--%>
    <%--    url:'${pageContext.request.contextPath}/scenery/addScenery',--%>
    <%--    data,--%>
    <%--    success(data){--%>
    <%--        //1.提示信息--%>
    <%--        bootbox.alert({ //异步对话框,alert是同步的--%>
    <%--            message: data.message,--%>
    <%--            size: 'small',--%>
    <%--            callback() {    //要在按钮点击后callback--%>
    <%--                if(data.success){--%>
    <%--                    //2.关闭窗口,--%>
    <%--                    $('#sceneryModal').modal('hide')--%>
    <%--                    //3.刷新页面--%>
    <%--                    location.reload()--%>
    <%--                }--%>
    <%--            }--%>
    <%--        });--%>
    <%--    }--%>
    <%--})--%>

    let data = new FormData($('#addScenery')[0])
    $.ajax({
        type:'post',
        //url:'${pageContext.request.contextPath}/scenery/addScenery',
        url:`${pageContext.request.contextPath}/scenery/\${scenery==null?'addScenery':'updateScenery'}`,
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
                        $('#sceneryModal').modal('hide')
                        //3.刷新页面
                        location.reload()
                    }
                }
            });
        }
    })
})

//打开添加修改的模态框
let scenery //用一个全局变量接受一下sucess地反向会结果
//获取ID打开窗口
function toUpdate(sceid){
    //alert(sceid)
    //1.取得Scenery
    $.ajax({
        url:`${pageContext.request.contextPath}/scenery/\${sceid}`, //模板字符串和EL表达式冲突了
        //data:{sceid},以前是let data = $('#addScenery').serialize(),现在是RESTful超链接传值
        async: false,   //没有执行完success,不让执行后面的方法,就是按顺序执行
        success(data){
            //console.log(data)
            scenery = data //这样是不行的,
        }
    })
    console.log(scenery) //之前异步的时候可能拿不到data
    //2.打开模态框
    $('#sceneryModal').modal('show')
    //3.数据回显,打开模态框之前是没有用的
    $('#sceid').val(scenery.sceid)
    $('#scename').val(scenery.scename)
    $('#scetypeid').val(scenery.scetypeid)
    $('#context').val(scenery.context)
    $('#ticket').val(scenery.ticket)
    $('#areaid').val(scenery.areaid)
    $('#season').val(scenery.season)
    $('#sceGrade').val(scenery.sceGrade)
    $('#location').val(scenery.location)
    $('#startTime').val(scenery.startTime)
    $('#ticCount').val(scenery.ticCount)
    if(scenery.pic!=null){
        $('#preview').prop("src",'/'+scenery.pic)   //变成绝对路径
    }
    $('#sceneryModalLabel').html('修改景点')
    $('#handleButton').html('修改')

}
//添加模态框
function openModel(){
    //DOM有清除表单的功能
    $('#sceneryModal').modal('show')
    $('#sceneryModalLabel').html('添加景点')
    $('#handleButton').html('添加')
    //重置表单
    $('#addScenery')[0].reset();//但好像不能清空隐藏的值
    scenery = null //清空景点对象
}

//删除
function delScenery(sceid){
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
                    url:`${pageContext.request.contextPath}/scenery/\${sceid}`,
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

//全选取消
$('#all').on('click',function(){
    $('[name=sceid]').prop('checked',this.checked)
})

$('[name=sceid]').on('click',function(){
    //alert($('[name=sceid]',$('table')[0]).length)//表示范围
    $('#all').prop('checked',$('table [name=sceid]:checked').length===$('[name=sceid]',$('table')[0]).length)
})

//批量删除
function batchDelete(){
    //1.判断有没有选中的
    if($('table [name=sceid]:checked').length==0){
        bootbox.alert({ //异步对话框,alert是同步的
            message: '没有景点被选中',
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
                let sceidStr=''
                $('table [name=sceid]:checked').each(function(i,scenery){
                    sceidStr+=scenery.value+","
                })
                sceidStr = sceidStr.slice(0,-1)
                console.log(sceidStr)
                //3.发送请求,逗号转数组
                $.ajax({
                    url:`${pageContext.request.contextPath}/scenery/batchDelete?sceids=\${sceidStr}`,
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
    })
}
</script>

</body>
</html>
