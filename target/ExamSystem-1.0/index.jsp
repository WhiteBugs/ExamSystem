<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录界面</title>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }
    </style>
</head>
<body>

        <!-- 跳转登录注册页面 -->
        <div id="regLogin" class="row clearfix">
        <br>
        ${info}
            <a href="system.do">
                <button id="login" class="btn btn-large btn-info">现在登录</button>
            </a>
            <a href="reg.do">
                <button id="reg" class="btn btn-large btn-info">现在注册</button>
            </a>
        </div>
</body>