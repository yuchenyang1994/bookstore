<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <!-- jquery的js插件 -->
  <script src="${pageContext.request.contextPath}/js/plugin/jquery-1.12.1.min.js"></script>
  <!--bootstrap核心js文件 -->
  <script src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
  <title>欢迎光临静读在线商城</title>
</head>
<body style="padding-top: 70px">
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
        <li><a href="${pageContext.request.contextPath}/page/books/detail.jsp">全部图书</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
            我的书城
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li class="text-center"><a href="login.jsp">登录</a></li>
            <li class="text-center"><a href="register.jsp">注册</a></li>
          </ul>
        </li>
        <li></li>
        <li></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
    <div id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="images/books/bookcol001.jpg" alt="">
                <div class="carousel-caption">
                    <h4>从零到一</h4>
                    <p> 新书到货</p>
                </div>
            </div>
            <div class="item">
                <img src="images/books/bookcol002.jpg" alt="">
                <div class="carousel-caption">
                    <h4>创业维艰</h4>
                    <p>新书到货</p>
                </div>
            </div>
            <div class="item">
                <img src="images/books/bookcol003.jpg" alt="">
                <div class="carousel-caption">
                    <h4>Google重新定义公司</h4>
                    <p>新春钜惠0</p>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
    <hr>
    <script>
        $('.carousel').carousel()
    </script>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="0" end="2">
        <div class="col-md-4">
                <a href="BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="2" end="4">
            <div class="col-md-4">
                <a href="BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>

</div>
</body>
</html>