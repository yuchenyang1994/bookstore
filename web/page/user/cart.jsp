<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/2
  Time: 9:23
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
    <%--购物车JS文件--%>
    <script src="${pageContext.request.contextPath}/js/cart.js"></script>
    <title>欢迎光临静读在线商城</title>
</head>
<body style="padding-top: 70px">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">静读</a>
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
                        <li class="text-center" ><font color="red">欢迎${sessionScope.account}登录</font></li>
                        <li><a class="btn btn-default btn-sm" role="button"
                               href="${pageContext.request.contextPath}/page/user/cart.jsp">
                            管理购物车
                        </a></li>
                        <li><a class="btn btn-default btn-sm" role="button"
                               href="${pageContext.request.contextPath}/page/user/userinfo.jsp">
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
    <h3 class="text-center">我的购物车</h3>
    <div style="padding:5px;">
        <table class="table table-hover table-condensed">
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.cart}" var="cartmap" varStatus="varstatus">
            <tr id="id${cartmap.value.book.id}">
                <td>${cartmap.key}</td>
                <td>${cartmap.value.book.name}</td>
                <td>${cartmap.value.book.selling_price}</td>
                <td>${cartmap.value.quantity}</td>
                <td><fmt:formatNumber type="number">${cartmap.value.getTotal()}</fmt:formatNumber></td>
                <td><a role="button" class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/deletecart.do?booksid=${cartmap.value.book.id}">删除</a></td>
            </tr>
            </c:forEach>
        </table>
        <p>合计:${sessionScope.total}</p>
        <a href="${pageContext.request.contextPath}/page/user/order.jsp" role="button"
           class="btn btn-primary btn-lg btn-block">立即购买</a>
        <a href="${pageContext.request.contextPath}/page/books/detail.jsp" role="button"
           class="btn btn-primary btn-lg btn-block" >返回</a>
    </div>
</div>
</body>
</html>
