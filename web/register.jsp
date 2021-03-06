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
      <script>
          function checkpassword(){
              var password = $("#password").val();
              var partrn = /^(\w){6,20}$/;
              if (partrn.test(password))
              {
                  $("#message").attr("class","alert alert-danger hidden");
              }
              else {
                  $("#message").attr("class","alert alert-danger");
                  $("#message").text("你输入的密码不符合规则");
              }
          };
          function checkenterpassword(){
              var enterpassword = $("#enterpassword").val();
              var password = $("#password").val();
              var partrn = /^(\w){6,20}$/;
              if(enterpassword!=password){
                  $("#message").attr("class","alert alert-danger");
                  $("#message").text("您确认密码与密码不符合");
              }
              else if (partrn.test(enterpassword))
              {
                  $("#message").attr("class","alert alert-danger hidden");
              }
              else {
                  $("#message").attr("class","alert alert-danger");
                  $("#message").text("你输入的密码不符合规则");
              }
          };
              function checkemail(){
                  var email = $("#email").val();
                  var partrn= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                  if(partrn.test(email)){
                      $("#message").attr("class","alert alert-danger hidden");
                  }
                  else{
                      $("#message").attr("class","alert alert-danger");
                      $("#message").text("你输入的邮箱不符合规则");
                  }
          };
          function checkusername(){
              var username= $("#username").val();
              var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
              $.ajax({
                        type:"GET",
                        url:"checkusername.do",
                        data:{username:username},
                        dataType:"json",
                        success:function(data)
                        {
                            if (data.result==1){
                                $("#message").attr("class","alert alert-danger hidden");
                                $("#message").text("您可以注册这个用户名");
                                if(patrn.test(username))
                                {
                                    $("#message").attr("class","alert alert-danger hidden");
                                }
                                else{
                                    $("#message").attr("class","alert alert-danger");
                                    $("#message").text("您的用户名不符合规则");

                                };
                            }
                            else if(data.result==0){
                                $("#message").attr("class","alert alert-danger");
                                $("#message").text("这个用户名已经被注册,请重新换一个");

                            }


                        }


                    });




                }
      </script>
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
                    <li><a href="login.jsp">登陆</a></li>
                    <li><a href="register.jsp">注册</a></li>
                  </ul>
                </li>
                <li></li>
                <li></li>
              </ul>
            </div>
      </div>
    </nav>
      <div class="container">

        <form class="form-register" action="DoRegister.do" method="post">
          <h2 class="form-register-head text-center">现在就来注册吧</h2>
          <div class="login-wrap">
              <input type="text" class="form-control" placeholder="用户名" id="username" name="account" onblur="checkusername();">
              <input type="password" class="form-control" placeholder="密码" id="password" name="password" onblur="checkpassword();">
              <input type="password" class="form-control" placeholder="确认密码" id="enterpassword" name="enterpassword" onblur="checkenterpassword();">
              <input type="text" class="form-control" placeholder="邮箱" id="email" name="email" onblur="checkemail();">
              <button type="submit" name="button" class="btn btn-lg btn-block btn-primary">注册</button>
              <button type="reset" name="button" class="btn btn-lg btn-block btn-default">重置</button>
              <div class="alert alert-danger hidden" role="alert" id="message">
              </div>
          </div>
        </form>
      </div>
  </body>
</html>
