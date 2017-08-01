<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<#list persons as person><input type="checkbox" name="student" value="${person.studentId}">${person.studentId}</#list>
</body>
</html>