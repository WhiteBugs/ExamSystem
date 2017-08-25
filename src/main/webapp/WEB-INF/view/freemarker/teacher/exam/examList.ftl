<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>欢迎考官</title>
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
   <div class="container-fluid"> 
   <div class="navbar-header">
      <a class="navbar-brand" href="/ExamSystem/teacher/welcome">主页</a>
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
<div class="panel">
  <table class="table">
  <tr><td>考试名称
  <#list examList as exam>
    <tr><td>${exam.examName }<td><a href="/ExamSystem/teacher/exam/studentExamList?examId=${exam.examId}">编辑考生试卷</a><td><a href="/ExamSystem/teacher/exam/editExam?examId=${exam.examId}">编辑试卷</a><td><a href="/ExamSystem/teacher/exam/answer?examId=${exam.examId}">查看答案</a>
  </#list>
  </table>
</div>
</body>
</html>