<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Welcome</title>
        <!-- Mobile specific metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Force IE9 to render in normal mode -->
        <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
        <meta name="description" content=""/>
        <meta name="keywords" content=""/>
        <!-- Import google fonts - Heading first/ text second -->
        <link rel='stylesheet' type='text/css' />
        <!--[if lt IE 9]>
        <![endif]-->
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

<div class="panel panel-default panel-group" id="accordion">
    <div class="panel panel-default">
    <form action="/ExamSystem/teacher/editQuestion/addQuestion/commit">
    <input type="hidden" name="examId" value="${examId}">
    <#if choiceQuestions??>
    <input type="hidden" name="type" value="choiceQuestion">
    <#list choiceQuestions as choiceQuestion>
       <div class="panel-heading">
            <input type="checkbox" name="id" value="${choiceQuestion.choiceQuestionId}">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse_${choiceQuestion_index}">
               ${choiceQuestion.title}
            </a>
        </div>
        <div id="collapse_${choiceQuestion_index}" class="panel-collapse collapse">
            <div class="panel-body">
                A.${choiceQuestion.choice1 }　　　　　　
                B.${choiceQuestion.choice2 }　　　　　　
                C.${choiceQuestion.choice3 }　　　　　　
                D.${choiceQuestion.choice4 }　　　　　　
            </div>
            <div class="panel-body">
                answer :　${choiceQuestion.answer}
            </div>
        </div>
    </#list>
    </#if>
    
    <#if blankFillingQuestions??>
    <input type="hidden" name="type" value="blankFillingQuestion">
    <#list blankFillingQuestions as blankFillingQuestion>
       <div class="panel-heading">
            <input type="checkbox" name="id" value="${blankFillingQuestion.blankFillingQuestionId}">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse_${blankFillingQuestion_index}">
               ${blankFillingQuestion.title}
            </a>
        </div>
        <div id="collapse_${blankFillingQuestion_index}" class="panel-collapse collapse">
            <div class="panel-body">
               　　　　　<#list blankFillingQuestion.answers as answer>
               ${answer_index+1 }. ${answer.answer }     
            </#list>
            </div>
        </div>
    </#list>
    </#if>
    
    
    <#if eassyQuestions??>
    <input type="hidden" name="type" value="eassyQuestion">
    <#list eassyQuestions as eassyQuestion>
        <div class="panel-heading">
            <input type="checkbox" name="id" value="${eassyQuestion.eassyQuestionId}">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse_${eassyQuestion_index}">
               ${eassyQuestion.title}
            </a>
        </div>
        <div id="collapse_${eassyQuestion_index}" class="panel-collapse collapse">
            <div class="panel-body">
                ${eassyQuestion.answer}
            </div>
        </div>
    </#list>
    </#if>
    <input type="submit">
    </form>
    </div>
</div>
</body>
</html>