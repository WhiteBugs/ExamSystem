<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <#list examList as exam>
    <tr><td>${exam.examName }
  </#list>
</table>
</body>
</html>