<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style type="text/css">
    body {
        padding-top: 200px;
        padding-bottom: 40px;
        /*background-image: url('https://s3.jpg.cm/2020/12/14/FF4vk.jpg');*/
        background-image: url('${pageContext.request.contextPath}/images/bg.jpg');
        background-position: center;
        background-repeat: no-repeat;
        background-attachment: fixed;
    }
    .form-signin-heading{
        text-align: center;
    }
    .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        box-shadow: 0 1px 2px rgba(0,0,0,.05);

    }
    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
    }
    .input{
        text-align: center;
    }
    .login{
        text-align: center;
    }
    .btn-primary {
        color: #ffffff;
        text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
        background-color: #006dcc;
        *background-color: #0044cc;
        background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
        background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
        background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
        background-image: -o-linear-gradient(top, #0088cc, #0044cc);
        background-image: linear-gradient(to bottom, #0088cc, #0044cc);
        background-repeat: repeat-x;
        border-color: #0044cc #0044cc #002a80;
        border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
        background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
    }
    .btn-large {
        padding: 11px 19px;
        font-size: 17.5px;
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        border-radius: 6px;
    }
    a{
        text-decoration: none;
    }
</style>
<body>

<div align="center">
    <font color="red">${msg}</font>
</div>
<div class="container">
    <form  class="form-signin" action="${pageContext.request.contextPath}/login/first" method="post">
        <h2 class="form-signin-heading"><font color="gray">学生查重管理系统</font></h2>
        <div class="input">
        <input  name="username" type="text" class="input-block-level" placeholder="用户名...">
        <input  name="password" type="password" class="input-block-level" placeholder="密码..." ><br>
        </div>
        <div class="login">
        <button class="btn btn-large btn-primary"  type="submit">登录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-primary" type="reset" >重置</button>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="btn " href="<c:url value='/jsp2/register.jsp'/>" target="body" id="z" >注册</a>
    </form>
   </div>

<div align="center">
    <font id="error" color="red">${error1}</font>
</div>
</body>
</html>
