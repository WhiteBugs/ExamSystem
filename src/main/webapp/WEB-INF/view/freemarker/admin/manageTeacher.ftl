<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>管理考官</title>
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
   <div class="container-fluid"> 
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target="#example-navbar-collapse">
         <span class="sr-only">切换导航</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/ExamSystem/admin/welcome">主页</a>
   </div>
   <div class="collapse navbar-collapse" id="example-navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
         <li >
             <a href="/ExamSystem/login/loginOut"><button type="button"  class="btn ">注销</button></a>
         </li>
      </ul>
   </div>
   </div>
</nav>
<div>
  <table class="table" border=1>
  <tr><td>账号<td>密码
  <#list teacherList as teacher>
  <tr><td>${teacher.count}<td>${teacher.password} 
     </#list>
  </table>
  <form action="manageTeacher/addTeacher" method="post">
      <label for="teacherCount">考官账号</label>
      <input name="teacherCount" type="text" placeholder="请输入英文组成的 账号">
      <p>
        <label for="teacherPassword">密码</label>
        <input name="teacherPassword" type="password" placeholder="请输入密码">
      <p>
         <button type="submit">提交</button>
   </form>
</div>
</body>