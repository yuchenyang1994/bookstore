<%  %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!--设置移动端自适应-->
    <meta http-equiv="viewport" content="width=device-width,initial-scale=1.0
      scalable=no">
    <!--bootstrap核心css文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <!-- bootstrap主题文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-theme.css">
    <!-- 主页css文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <!-- jquery的js插件 -->
    <script src="${pageContext.request.contextPath}/js/plugin/jquery-1.12.1.min.js"></script>
    <!--bootstrap核心js文件 -->
    <script src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
    <title>欢迎光临静读在线商城</title>
  </head>
  <body>
      <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.jsp">静读</a>
            </div>
            <div class="collapse navbar-collapse pull-left" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li><a href=""${pageContext.request.contextPath}/page/books/detail.jsp"">全部图书</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                    我的书城
                    <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu">
                    <li><a href="login.jsp" class="text-center">登陆</a></li>
                    <li><a href="register.jsp" class="text-center">注册</a></li>
                  </ul>
                </li>
                <li></li>
                <li></li>
              </ul>
            </div>
      </div>
    </nav>
      <div class="container">

        <form class="form-register" action="doLogin.do" method="post">
          <h2 class="form-register-head text-center">登陆即刻购买</h2>
          <div class="login-wrap">
              <input type="text" class="form-control" placeholder="用户名" id="username" name="account">
              <input type="password" class="form-control" placeholder="密码" id="password" name="password">
              <button type="submit" name="button" class="btn btn-lg btn-block btn-primary">登陆</button>
              <a class="btn btn-lg btn-block btn-default" role="button" href="index.jsp">返回</a>
              <div class="${requestScope.meassageclass}" role="alert" id="message">
                    ${requestScope.message}
              </div>
          </div>
        </form>
      </div>
  </body>

</html>
