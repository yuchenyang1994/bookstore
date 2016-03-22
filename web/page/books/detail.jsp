<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/1
  Time: 13:24
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
                <li><a href="${pageContext.request.contextPath}/page/books/detail.jsp">全部图书</a></li>
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
        <c:forEach items="${books}" var="book" begin="0" end="2">
            <div class="col-md-4">
                <div class="book">
                    <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="3" end="5">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="5" end="7">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="8" end="10">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="11" end="13">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
                <div class="book">
                    <h5>书名:${book.name}</h5>
                    <p>单价:<fmt:formatNumber type="number">${book.selling_price}</fmt:formatNumber></p>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="row">
        <c:forEach items="${books}" var="book" begin="14" end="16">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}\BookServlet.do?bookid=${book.id}" ><image src="${book.image}"></image></a>
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
