<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        .container{
            border: solid 1px red;
        }

        div{
            border: solid 1px red;
        }

        img{
            min-height: 350px;
            max-height: 350px;
        }
        .icon{
            height: 100%;
        }

    /*  图片  */
        .news{
            background-color: #eee;
            border-bottom: 1px solid #ccc;
        }

        .news ul{
            list-style: none;
        }

        .news li {
            float: left;
            width: 20%;
            padding-right: 10px;
            margin-bottom: 10px;
        }

        .news li a {
            position: relative;
            display: block;
            width: 100%;
            height: 100%;
        }

        .news li a img {
            width: 100%;
            height: 100%;
        }

        .news li a p{
            /* 绝对定位不占用空间,可以放在图片上
            位置相对于最近的已定位祖先元素
            */
            position: absolute;
            bottom: 0;
            left: 0;

            width: 100%;
            height: 41px;
            padding: 5px 10px;
            margin-bottom: 0;
            background: rgba(0, 0, 0, .5);
            font-size: 12px;
            color: #fff;
        }
    </style>
</head>
<body>

<%-- 1. header --%>
<div class="container"><!-- bootStrap的css，自带一个缩进 -->
    <div class="nav navbar-nav navbar-left col-lg-4 icon">
        飞鸟旅游图标
    </div>

    <div>
        <form class="navbar-form navbar-left col-lg-4">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
    </div>

    <div class="nav navbar-nav navbar-right col-lg-4">
        民宿客栈图标
    </div>
</div>

<%-- 2. navbar --%>
<nav class="navbar navbar-inverse"><!-- 占整个宽度的大背景 -->
    <div class="container"><!-- 带个缩进 -->
        <%--    nav可以有header等等    --%>
        <div class="navbar-header col-lg-2">
            <%--      整个“首页”按钮是一个可折叠的组件      --%>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand active" href="index.jsp">首页</a>
        </div>
        <!--点了toggle后根据id显示下面的-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="col-lg-6 nav navbar-nav">
            <%--    这个li自带css   --%>
                <li class="col-lg-2"><a href="/hotel/page">酒店</a></li>
                <li class="col-lg-2"><a href="/scenery/page">景点</a></li>
                <li class="col-lg-2"><a href="#">攻略</a></li>
            </ul>
        </div>
    </div>
</nav>


    <div class="container">
        <div class="row">

            <div class="col-lg-7">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="/img/01.jpg" alt="...">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                        <div class="item">
                            <img src="/img/02.jpg" alt="...">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                        <div class="item">
                            <img src="/img/03.jpg" alt="...">
                            <div class="carousel-caption">
                                ...
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

            <div class="col-lg-5">
                5
            </div>
        </div>
    </div>


    <div class="container">
        <ul class="nav nav-pills">
            <li role="presentation"><a href="#">旅游度假</a></li>
            <li role="presentation"><a href="#">当季热卖</a></li>
            <li role="presentation"><a href="#">国内游</a></li>
            <li role="presentation"><a href="#">更多>></a></li>
        </ul>
    </div>


    <div class="container">
        <div class="row">
            <div class="news">
                <ul>
                    <li><a href="">
                        <img src="img/01.jpg">
                        <p>天涯海角|世界的尽头</p>
                    </a></li>
                    <li><a href="">
                        <img src="img/01.jpg">
                        <p>天涯海角|世界的尽头</p>
                    </a></li>
                    <li><a href="">
                        <img src="img/01.jpg">
                        <p>天涯海角|世界的尽头</p>
                    </a></li>
                    <li><a href="">
                        <img src="img/01.jpg">
                        <p>天涯海角|世界的尽头</p>
                    </a></li>
                </ul>
            </div>
        </div>
    </div>
</div>



    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootbox/bootbox.all.min.js"></script><%--对话框插件--%>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstable.js"></script><%--表格插件--%>
</body>
</html>