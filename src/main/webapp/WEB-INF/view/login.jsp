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
            <form id="login_form" action="login/loginCheck"   method="post">
                  <div class="form_group g1">
                      <label for="user_name" class="info">账号</label>
                      <input name="userName" type="text" value="" class="user_name_input" placeholder="请输入账号">
                  </div>
                  <div class="form_group g2">
                      <label for="user_password" class="info">密码</label>
                      <input name="userPassword"  type="password" value="" class="user_password_input" placeholder="请输入密码">
                  </div>
                  <div class="form_group g3">
                       <div class="select_count_class">
                           <select name="countType"  >
                              <option value="student">学生</option>
                              <option value="teacher">监考老师</option>
                              <option value="admin">管理员</option>
                           </select>
                       </div>  
                  </div>
                  <div class="form_group g4">
                      <button type="submit" onclick="checkUser()" class="submit_btn">登录</button>
                  </div>
            </form>
        </div>
     </div>
  </div> 

</body>
<script type="text/javascript">
function checkUser(){
	
	var user_name=document.getElementsByName("userName")[0];
	var user_password=docment.getElementsByName("userPassword")[0];
	alert("sdfse");
	alert(user_name.value);
	return true;
}
</script>
</html>