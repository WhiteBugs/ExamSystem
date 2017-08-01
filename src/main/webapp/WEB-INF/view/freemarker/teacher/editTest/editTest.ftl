<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>编辑试题</title>
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
<div>
   <#if choiceQuestion??>
   <form  role="form" action="/ExamSystem/teacher/editTest/commit">
       <input name="type" type="text" style="display:none" value="choiceQuestion">
       <input name="id" type="text" style="display:none" value="${choiceQuestion.choiceQuestionId}">
       <div class="form-group">
          <label for="title">题目</label>
          <input type="text" name="title" value="${choiceQuestion.title}">
       </div>
       <div class="form-group">
          <label for="option1">A.</label>
          <input type="text" name="choice1" value="${choiceQuestion.choice1}">
       </div>
       <div class="form-group">
          <label for="option2">B.</label>
          <input type="text" name="choice2" value="${choiceQuestion.choice2}">
       </div>
       <div class="form-group">
          <label for="option3">C.</label>
          <input type="text" name="choice3" value="${choiceQuestion.choice3}">
       </div>
       <div class="form-group">
          <label for="option4">D.</label>
          <input type="text" name="choice4" value="${choiceQuestion.choice4}">
       </div>
       <div>
          <select name="answer">
             <option value="A" <#if choiceQuestion.answer=="A"> selected="selected" </#if> >A</option>
             <option value="B" <#if choiceQuestion.answer=="B"> selected="selected" </#if> >B</option>
             <option value="C" <#if choiceQuestion.answer=="C"> selected="selected" </#if> >C</option>
             <option value="D" <#if choiceQuestion.answer=="D"> selected="selected" </#if> >D</option>
          </select>
       </div>
       <button type="commit" class="btn btn-default">提交</button>
   </form>
   </#if>
</div>
</body>
</html>