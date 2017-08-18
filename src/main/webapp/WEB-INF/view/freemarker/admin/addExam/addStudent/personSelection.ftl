<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div>
   <#list persons as person><input type="checkbox" name="student" value="${person.studentId}">${person.studentId}</#list>
</div>
<div>
   <input type="submit">
</div>
</body>
</html>