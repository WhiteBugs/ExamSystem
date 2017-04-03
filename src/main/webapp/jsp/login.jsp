<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>"> 
<meta content="text/html;charset=utf-8"/>
<meta charset="utf-8"/>
<meta http-equiv="content-language" content="zh-CN" />
<link rel="stylesheet" href="/ExamSystem/css/login.css">
<title>登录界面</title>
</head>

<body background="/ExamSystem/images/background.jpg">
<div class="parent">
    <div class="main_box">
        <div class="gdut_logo">
            <img src="/ExamSystem/images/gdut_logo.png">
        </div>
        <div class="login_form">
            <form id="login_form" action="LoginCheck"   method="post">
                  <div class="form_group g1">
                      <label for="user_name" class="info">账号</label>
                      <input id="user_name" type="text" value="" class="user_name_input" placeholder="请输入账号">
                  </div>
                  <div class="form_group g2">
                      <label for="user_password" class="info">密码</label>
                      <input id="user_password" value="" type="password" class="user_password_input" placeholder="请输入密码">
                  </div>
                  <div class="form_group g3">
                       <div class="select_count_class">
                           <select id="select_count"  >
                              <option value="admin">学生</option>
                              <option value="teacher">监考老师</option>
                              <option value="student">管理员</option>
                           </select>
                       </div>  
                  </div>
                  <div class="form_group g4">
                      <button type="submit" onClick="checkUser()" class="submit_btn">登录</button>
                  </div>
            </form>
        </div>
     </div>
  </div> 
  

  
</body>
<script type="text/javascript">
function checkUser(){
	var user_name=document.getElementById("user_name").value;
	var user_password=document.getElementById("user_password").value;                  
	if(user_name==""){
		alert("用户名不能为空");
		return false;
	}
	if(user_password==""){
		alert("密码不能为空");
		return false;
	}else{
		return true;
	}
}
</script>
</html>