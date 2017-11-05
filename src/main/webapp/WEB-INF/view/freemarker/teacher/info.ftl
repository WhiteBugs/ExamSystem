<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>info</title>
        <!-- Mobile specific metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Force IE9 to render in normal mode -->
        <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
        <meta name="description" content=""/>
        <meta name="keywords" content=""/>
        <!-- Import google fonts - Heading first/ text second -->
        <link rel='stylesheet' type='text/css' />
        <!--[if lt IE 9]>
        <![endif]-->
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
${info }
</body>
</html>