<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>学生试卷链接</title>
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/custom.css"> 
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
      <input type="hidden" name="examId" value="${examId }">
      <tr><td>专业</td>  <td>班级</td> <td>名字</td><td>学号</td><td>编辑试卷</td></tr>
<#list students as student>
      <tr><td>${student.major}</td>  <td>${student.classes}</td> <td>${student.name}</td><td>${student.studentId}</td><td><a href="/ExamSystem/teacher/exam/editStudentExam?studentId=${student.studentId}&&examId=${examId }">编辑试卷</a></td></tr>
   </#list>
</table>

</body>
</html>