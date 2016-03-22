<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/2
  Time: 9:27
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
    <script>
        $.ready(
                $.ajax({
                    async:true,
                    cache:false,
                    type:"POST",
                    dataType : 'json',
                    url:"/ajaxdoAddConsignees.do",
                    success:function(json){
                        alert(json[0].id)
                    }
                })
        );


    </script>
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
    <hr>
    <h3 class="text-center">收货人</h3>
    <hr>
    <div style="padding:5px;">
        <table class="table table-hover table-condensed">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>电话</th>
                <th>省市</th>
                <th>详细地址</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.conList}" var="consignees">
            <tr>
                <td>${consignees.id}</td>
                <td>${consignees.full_name}</td>
                <td>${consignees.tel}</td>
                <td>${consignees.city}</td>
                <td>${consignees.extra}</td>
                <td><a href="${pageContext.request.contextPath}/deleteConsignee.do?conid=${consignees.id}" role="button" class="btn btn-danger btn-sm active">删除</a></td>
            </tr>
            </c:forEach>
        </table>
        <hr>
        <h3 class="text-center">收货人</h3>
        <form action="${pageContext.request.contextPath}/doAddConsignees.do" method="post">
            <hr>
            <h3 class="text-center">收货人</h3>
            <div>
                <label>姓名:</label>
                <input type="text" class="form-control" placeholder="姓名" id="username" name="name">
                <label>电话:</label>
                <input type="text" class="form-control" placeholder="电话" id="tel" name="tel">
                <label>省/市:</label>
                <select class="form-control" name="city">
                    <option value="beijing">北京</option>
                    <option value="shanghai">上海</option>
                    <option value="guangzhou">广州</option>
                </select>
                <label>详细地址:</label>
                <input type="text" class="form-control" placeholder="详细地址" id="email" name="address">
                <button type="submit" name="button" class="btn btn-lg btn-block btn-primary">增加收货人</button>
                <button type="reset" name="button" class="btn btn-lg btn-block btn-default">重置</button>
            </div>
        </form>
    </div>

</div>

</body>
</html>
