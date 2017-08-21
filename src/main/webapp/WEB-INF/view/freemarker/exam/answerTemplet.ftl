<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>试卷答案</title>
</head>
<body>
<h3>${exam.examName }</h3>

<#if choiceQuestionAnswers??>
   <h5>选择题答案</h5>
   <div name="choiceQuestionAnswers">
      <#list choiceQuestionAnswers as order,anwer>
          <div>${order}. ${anwer }</div>
      </#list>
   </div>
</#if>

<#if multipleQuestionAnswers??>
   <h5>多选题答案</h5>
   <div name="multipleQuestionAnswers">
      <#list multipleQuestionAnswers as  order,anwer>
          <div>${order}. ${anwer }</div>
      </#list>
   </div>
</#if>

<#if trueFalseQuestionAnswers??>
   <h5>判断题答案</h5>
   <div name="trueFalseQuestionAnswers">
      <#list trueFalseQuestionAnswers as  order,anwer>
          <div>${order}. ${anwer }</div>
      </#list>
   </div>
</#if>

<#if blankQuestionAnswers??>
   <h5>填空题答案</h5>
   <div name="blankQuestionAnswers">
      <#list blankQuestionAnswers as  order,anwer>
          <div>${order}. ${anwer }</div>
      </#list>
   </div>  
</#if>

<#if eassyQuestionAnswers??>
   <h5>简答题答案</h5>
   <div name="eassyQuestionAnswers">
      <#list eassyQuestionAnswers as  order,anwer>
          <div>${order}. ${anwer }</div>
      </#list>
   </div>
</#if>
</body>
</html>