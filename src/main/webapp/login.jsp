<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>数据 - AdminLTE2定制版 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
        name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <!-- Font Awesome -->
  <!-- Ionicons -->
  <!-- Theme style -->
  <!-- iCheck -->
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<%-- 一个点就表示当前路径 --%>
  <link rel="stylesheet" href="./plugins/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="./plugins/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="./plugins/adminLTE/css/AdminLTE.css">
  <link rel="stylesheet" href="./plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="pages/all-admin-index.html"><b>集思迪</b>后台管理系统</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">登录系统</p>
    <form action="pages/all-admin-index.html" method="get" id="form">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="用户名" id="username" name="username">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" id="password" name="password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label><input type="checkbox"> 记住 下次自动登录</label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="btn" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="#">忘记密码</a><br>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="./plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="./plugins/iCheck/icheck.min.js"></script>
<%--对话框插件--%>
<script src="${pageContext.request.contextPath}/bootbox/bootbox.all.min.js"></script>

<%-- 因为是在下面导入的,因此不需要入口函数 --%>
<script src="./js/login.js"></script>
<script>
  $(function() {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
