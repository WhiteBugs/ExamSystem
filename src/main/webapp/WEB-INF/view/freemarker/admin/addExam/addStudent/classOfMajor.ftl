<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<select id="class" name="class" onchange="loadPerson(),loadSubmit()">
  <option>  </option>
  <#list classes as class><option value="${class}">${class}</option></#list>
</select>
<div id="submit">
</div>
</body>
</html>  