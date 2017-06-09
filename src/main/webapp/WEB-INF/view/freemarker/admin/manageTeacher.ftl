<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
manageTeacher


<table border=1>
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
</body>
</html>