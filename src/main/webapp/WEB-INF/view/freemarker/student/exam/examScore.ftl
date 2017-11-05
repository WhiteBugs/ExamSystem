<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>考试成绩</title>
   <link rel="stylesheet" href="../css/stuStyle.css">
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/custom.css"> 
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
         <li class=""><a href="#">列表项</a></li>
         <li><a href="#">列表项</a></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               列表项 <b class="caret"></b>
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

<div class="container-fluid">
<div class="row">
        <!-- Start #sidebar -->
        <div class="col-sm-3">
   <div class="left panel panel-success ">
      <a href="welcome" class="list-group-item">主页</a>
      <a href="studentInfo" class="list-group-item">信息</a>
      <a href="scoreCheck" class="list-group-item">成绩</a>
      <a href="exam" class="list-group-item">考试</a>
   </div>
</div>

        <!-- Start #content -->
        <div id="content">
            <!-- Start .content-wrapper -->
            <div class="content-wrapper col-sm-9 panel panel-success">
            
                <div class="row">
                    <!-- Start .row -->
                    <!-- Start .page-header -->
                    
                    <div class="col-lg-12 heading">
                        <h1 class="page-header" id="stu_exam"><i class="im-screen"></i> 考试成绩</h1>
                        <!-- Start .bredcrumb -->
                        <ul id="crumb" class="breadcrumb">
                        </ul>
                        
                          <table id="stu_examtab">
                             <tr><td>考试名称<td>考试成绩
                             <#list examList as exam>
                               <tr><td>${exam.examName}     <td>    ${exam.score}
                             </#list>
                          </table>                        
                        

                        <!-- End .breadcrumb -->
                        <!-- Start .option-buttons -->
                        <div class="option-buttons">
                            <div class="btn-toolbar" role="toolbar">

                            </div>
                        </div>
                        <!-- End .option-buttons -->
                    </div>
                    <!-- End .page-header -->
                </div>
                <!-- End .row -->
               
            <!-- End .content-wrapper -->
            <div class="clearfix"></div>
        </div>
</div>
</div>

    </body>
</html>