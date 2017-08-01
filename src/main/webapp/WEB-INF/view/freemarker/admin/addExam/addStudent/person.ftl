<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<select id="major" name="major" onchange="loadClasses()">
  <option>  </option>
  <#list majors as major><option value="${major}">${major}</option></#list>
</select>
<div id="classes"></div>
<div id="persons"></div>
</body>
</html>