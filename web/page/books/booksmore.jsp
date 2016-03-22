<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/1
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">静读</a>
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
                        <li class="text-center" ><font color="red">欢迎${sessionScope.account}登录</font></li>
                        <li><a class="btn btn-default btn-sm" role="button" href="${pageContext.request.contextPath}/page/user/cart.jsp">
                            管理购物车<
                        </a></li>
                        <li><a class="btn btn-default btn-sm" role="button" href="${pageContext.request.contextPath}/page/user/userinfo.jsp">
                            我的信息
                        </a></li>
                        <li><a href="${pageContext.request.contextPath}/exit.do" class="btn btn-default btn-sm" role="button">
                            安全退出
                        </a></li>
                    </ul>
                </li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <image src="${books.image}" class=".img-responsive" style="padding-top: 100px;padding-left: 100px;"></image>
        </div>
        <div class="col-md-6">
            <h3 class="text-center">${books.name}</h3>
            <h4>简介</h4>
            <p>
                ${books.description}
            </p>
            <ul class="list-group">
                <li class="list-group-item">单价：<fmt:formatNumber type="number">${books.selling_price}</fmt:formatNumber></li>
                <li class="list-group-item">作者:${books.author} <span class="badge">热</span></li>
                <li class="list-group-item">出版社：${books.book_concern}</li>
                <li class="list-group-item">出版时间：2014-3-1</li>
                <li class="list-group-item">ISBN:${books.isbn}</li>
            </ul>
            <div class="gou" style="padding-bottom: 0px;">
                <a class="btn btn-default" href="ShopCart.do?booksid=${books.id}">加入购物车</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="" style="padding-bottom:0px">
            <hr>
            <h3 class="text-center">内容介绍</h3>
            <hr>
            <p>
                ${books.instroduction}
            </p>
        </div>
    </div>
    <div class="row">
        <div class="" style="padding-bottom:0px">
            <hr>
            <h3 class="text-center">作者简介</h3>
            <hr>
            <p>
                ${books.author_introduction}
            </p>
        </div>

    </div>
    <div class="row">
        <div class="" style="padding-bottom:0px">
            <hr>
            <h3 class="text-center">目录</h3>
            <hr>
            <c:forEach items="${books.bookChapterList}" var="bookcpt">
                <p>
                    ${books.name}
                </p>
            </c:forEach>

        </div>
    </div>
</div>
</div>

</body>
</html>
