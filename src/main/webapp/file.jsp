<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/9/12
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%--  客户端和服务器两部分
    1.表单必须是POST,否则只有文件名
    2.请求类型必须是,multipart/form-data,以流的方式上传
--%>
<%--1.客户端--%>
    <h1>同步上传</h1>
    <form action="up" method="POST" enctype="multipart/form-data">
        文件:<input type="file" name="file"><br>
        <button>文件上传</button>
    </form>

<%--导入Jquery--%>
    <h1>异步上传</h1>
    <form id="form">
        用户名:<input name="username"><br>
        文件:<input type="file" name="file" id="file"><br>
        <button type="button" id="btn">文件上传</button>
    </form>

<script>
<%--
  1. processData设为false,默认为true会把data转换成字符串,内置的转换器
  2. contentType:false 设为false表示根据传入的data对象的类型来设置
  3. data应该是一种可以上传文件的格式,FormData,类似于一个Map
  --%>
    $('#btn').on('click',function(){
        <%--//let data = $('#form').serialize()--%>
        <%--//多个上传文件时 #('#file')[1].files[0]--%>
        <%--var data = new FormData();--%>
        <%--console.log($('#file')[0].files[0])--%>
        <%--data.append('file',$('#file')[0].files[0])--%>
        <%--data.append('username',$('#username').val())--%>
        <%--//let username = data.get('username')--%>
        <%--$.ajax({--%>
        <%--    type:'post',--%>
        <%--    url:'${pageContext.request.contextPath}/scenery/addScenery',--%>
        <%--    processData:false,  //不自动处理data--%>
        <%--    contentType:false, //默认--%>
        <%--    data--%>
        <%--})--%>

        //直接把整个form放进去
        let data = new FormData($('#form')[0])
        $.ajax({
            type:'post',
            url:'up',
            data,
            processData:false,  //不自动处理data成字符串
            contentType:false //设置成false可以自动检测data类型,multipart/form-data

        })
    })

</script>

</form>
</body>
</html>
