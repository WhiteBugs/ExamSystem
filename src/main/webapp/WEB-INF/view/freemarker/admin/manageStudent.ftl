<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <#list studentList as student>
    <tr><td>${student.name}
  </#list>
</table>
</body>
</html>