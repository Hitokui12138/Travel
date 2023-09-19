<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023/9/14
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    ${roomtypeList}--%>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
        <h4 class="modal-title" id="sceneryModalLabel">添加酒店</h4>
    </div>

    <div class="modal-body">
        <table class="table table-bordered table-stripedd" id="roomtable">
            <thead>
                <tr>
                    <th class="hidden">房间类型编号</th>
                    <th>房间类型</th>
                    <th>房间价格</th>
                    <th>房间数量</th>
                    <th>入住时间</th>
                    <th>退房时间</th>
                    <th class="hidden">酒店id</th>
                </tr>
            </thead>
            <c:forEach items="${roomtypeList}" var="roomtype" varStatus="status">
                <tr><!-- 替换:双击后ctrl + R -->
                    <td class="hidden">${roomtype.roomtypeid}</td>
                    <td>${roomtype.roomtype}</td>
                    <td>${roomtype.roomprice}</td>
                    <td>${roomtype.roomnum}</td>
                    <td>${roomtype.intime}</td>
                    <td>${roomtype.outtime}</td>
                    <td class="hidden">${roomtype.hotelid}</td>
                </tr>
            </c:forEach>
        </table>
        <button type="button" class="btn btn-primary btn-sm" id="but_add">
            <span class="glyphicon glyphicon-plus"> 添加</span>
        </button>
    </div>


    <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="but_ref">保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
    </div>


    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootbox/bootbox.all.min.js"></script><%--对话框插件--%>

<script>

</script>
</body>
</html>
