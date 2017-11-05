<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>添加试题</title>
   <link rel="stylesheet" href="../css/adminStyle.css">
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script type="text/javascript">
   function addStudent(){
   		var xmlhttp;
   		if (window.XMLHttpRequest){
   			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp=new XMLHttpRequest();
		}else{
			// IE6, IE5 浏览器执行代码
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById("selectStudent").innerHTML=xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET","/ExamSystem/admin/addExam/studentType?studentType="+document.getElementById("studentType").value,true);
		xmlhttp.send();
	}
   
   function loadClasses(){
	  	var xmlhttp;
	  	if (window.XMLHttpRequest){
	   			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	   			xmlhttp=new XMLHttpRequest();
	   		}else{
				// IE6, IE5 浏览器执行代码
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange=function(){
				if (xmlhttp.readyState==4 && xmlhttp.status==200){
					document.getElementById("classes").innerHTML=xmlhttp.responseText;
				}
			}
		xmlhttp.open("GET","/ExamSystem/admin/addExam/studentType/class?major="+document.getElementById("major").value,true);
		xmlhttp.send();
	  }
   
    function loadPerson(){
    	var xmlhttp;
	  	if (window.XMLHttpRequest){
	   			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	   			xmlhttp=new XMLHttpRequest();
	   		}else{
				// IE6, IE5 浏览器执行代码
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange=function(){
				if (xmlhttp.readyState==4 && xmlhttp.status==200){
					document.getElementById("persons").innerHTML=xmlhttp.responseText;
				}
			}
		xmlhttp.open("GET","/ExamSystem/admin/addExam/studentType/person?major="+document.getElementById("major").value+"&&class="+document.getElementById("class").value,true);
		xmlhttp.send();
    }
    function loadSubmit(){
    	document.getElementById("submit").innerHTML="<input type=\"submit\">";
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
      <a class="navbar-brand" href="/ExamSystem/admin/welcome">主页</a>
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
<div id="add_container">
<h3>添加考试</h3>
<form action="/ExamSystem/admin/addExam/commit" method="post">
    <div class="panel">
        <div class="add_section">
        	<label for="examName">考试名称</label>
    	    <input type="text" name="examName">
        </div>
         <hr>
    	<div>
    		<div  class="add_section"><label for="examBeginTime">考试开始时间</label></div>
    		<div name="examBeginTime" class="add_section">
    			<input type="date" name="beginDate">
    			<input type="time" name="beginTime">
    		</div>
    		<div  class="add_section"><label for="examEndTime">考试结束时间</label></div>
    		<div name="examEndTime"  class="add_section">
    		    <input type="date" name="endDate">
    		    <input type="time" name="endTime">
    		</div>
    		<div  class="add_section"><label for="examTime">考试时间</label></div>
    		<div  class="add_section" >
    		    <input type="time" name="examTime">
    		</div>
    	</div>
       <hr>
    	<div id="examStaff">
    	</div>
    	<div name="selectTeacher" class="add_section" >
    	    <div class="add_section"><label for="teachers">添加考官</label></div>
    	    <#list teachers as teacher><input type="checkbox" name="teachers" value="${teacher.count}">${teacher.count}</#list>
    	</div>
       <hr>
    	<div  class="add_section">
    		<label for="studentType">添加学生</label>
    		<select id="studentType" onchange="addStudent()">
    		    <option>  </option>
    			<option value="major">以专业为单位添加</option>
    			<option value="class">以班级为单位添加</option>
    			<option value="person">以个体为单位添加</option>
    		</select>
    		<div id="selectStudent">
    		</div>
    		
    	</div>
    </div>
    
</form>
</div>
</body>
</html>