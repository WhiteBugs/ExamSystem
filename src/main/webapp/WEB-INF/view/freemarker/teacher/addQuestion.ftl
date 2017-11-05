<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>添加试题</title>
   <link rel="stylesheet" href="../css/teaStyle.css">
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script>
   function loadPage()
   	{
   		var xmlhttp;
   		if (window.XMLHttpRequest)
   		{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("myDiv1").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","/ExamSystem/teacher/addQuestion/loadPage?type="+document.getElementById("type").value,true);
	xmlhttp.send();
   }
   
</script>
</head>
<style>
@media (min-width: 768px){
.navbar {
    height: 54px;
}
.nav>li{
  height: 54px;
}
.nav>li button{
   margin-top: -10px;
}
.nav>li>a{
  height: 54px;
}
}
</style>
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
<div class="panel panel-success">
	<div class="" id="tea_add">
		<form id="test" action="/ExamSystem/teacher/addQuestion/submit" >
			<select id="type" name="type" onchange="loadPage()">
				<option value="choice">选择题</option>
				<option value="blankFilling">填空题</option>
				<option value="eassy">简答题</option>
			</select>
			<div id="myDiv1">
				<div>
					<label for="title">title</label>
					<input type="text" name="title">
				</div>
				<div class="option">
					<div>
						<label for="option1">A.</label>
						<input type="text" name="option1">
					</div>
					<div>
						<label for="option2">B.</label>
						<input type="text" name="option2">
					</div>
					<div>
						<label for="option3">C.</label>
						<input type="text" name="option3">
					</div>
					<div>
						<label for="option4">D.</label>
						<input type="text" name="option4">
					</div>
				</div>
				<div>
				    <label for="answer">答案</label>
					<select name="answer">
					  <option value="A">A</option>
					  <option value="B">B</option>
					  <option value="C">C</option>
					  <option value="D">D</option>
					</select>
				</div>
			</div>
			<div>
				<button type="submit" id="tea_btn">提交</button>
			</div>
			<div id="myDiv2"></div>
		</form>
	</div>
</div>
</body>
</html>