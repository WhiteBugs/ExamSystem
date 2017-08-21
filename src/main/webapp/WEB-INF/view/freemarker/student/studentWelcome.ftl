<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>Student Welcome</title>
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/custom.css"> 
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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
      <a class="navbar-brand" href="#">GDUT</a>
   </div>
   <div class="collapse navbar-collapse" id="example-navbar-collapse">
      <ul class="nav navbar-nav">
         <li class=""><a href="#">#</a></li>
         <li><a href="#">#</a></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               # <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#">jmeter</a></li>
               <li><a href="#">EJB</a></li>
               <li><a href="#">Jasper Report</a></li>
               <li class="divider"></li>
               <li><a href="#">分离的链接</a></li>
               <li class="divider"></li>
               <li><a href="#">另一个分离的链接</a></li>
            </ul>
         </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <li >
             <a href="/ExamSystem/login/loginOut"><button type="button"  class="btn btn-default navbar-btn">注销</button></a>
         </li>
      </ul>
      
   </div>
   </div>
</nav>
<div class="panel panel-success">
   <div class="left panel panel-success ">
      <a href="welcome" class="list-group-item">主页</a>
      <a href="studentInfo" class="list-group-item">信息</a>
      <a href="scoreCheck" class="list-group-item">成绩</a>
      <a href="exam" class="list-group-item">考试</a>
   </div>
   <div class="panel panel-success ">
        <div class="panel-heading">
          <h5 class="panel-tittle">个人信息</h3>
        </div>
        <div class="panel-body">
          欢迎  ${user.name}
          <table class="table">
             <th></th><th> </th>
             <tr><td>产品 A</td><td>200</td></tr>
             <tr><td>产品 B</td><td>400</td></tr>
          </table>
        </div>
    </div>
</div>

</body>
</html>