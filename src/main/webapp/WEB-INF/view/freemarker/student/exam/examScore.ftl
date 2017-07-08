<!DOCTYPE html>
<html lang="en">
    <head>
        
        <meta charset="utf-8">
        <title>Welcome</title>
        <!-- Mobile specific metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Force IE9 to render in normal mode -->
        <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
        <meta name="description" content=""
        />
        <meta name="keywords" content=""
        />
        <!-- Import google fonts - Heading first/ text second -->
        <link rel='stylesheet' type='text/css' />
        <!--[if lt IE 9]>
        <![endif]-->
        
        <!-- Css files -->
        <!-- Icons -->
        <link href="/ExamSystem/css/icons.css" rel="stylesheet" />
        <!-- jQueryUI -->
        <link href="/ExamSystem/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet" />
        <!-- Bootstrap stylesheets (included template modifications) -->
        <link href="/ExamSystem/css/bootstrap.css" rel="stylesheet" />
        <!-- Plugins stylesheets (all plugin custom css) -->
        <link href="/ExamSystem/css/plugins.css" rel="stylesheet" />
        <!-- Main stylesheets (template main css file) -->
        <link href="/ExamSystem/css/main.css" rel="stylesheet" />
        <!-- Custom stylesheets ( Put your own changes here ) -->
        <link href="/ExamSystem/css/custom.css" rel="stylesheet" />
        <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
        <meta name="msapplication-TileColor" content="#3399cc" />
    </head>
    <body>
        <!-- Start #header -->
        <div id="header">
            <div class="container-fluid">
                <div class="navbar">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="index.html">
                            <i class="im-windows8 text-logo-element animated bounceIn"></i><span class="text-logo">gdut</span><span class="text-slogan"></span> 
                        </a>
                    </div>
                    <nav class="top-nav" role="navigation">
                        
                        <ul class="nav navbar-nav pull-right">
                            <li>
                                <a href="/ExamSystem/login/loginOut" id="toggle-header-area">login out<i class="ec-download"></i></a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- End #header -->
        <!-- Start #sidebar -->
        <div id="sidebar">
            <!-- Start .sidebar-inner -->
            <div class="sidebar-inner">
                <!-- Start #sideNav -->
                <ul id="sideNav" class="nav nav-pills nav-stacked">
                    <li>
                       <a href="studentWelcome">Dashboard <i class="im-screen"></i></a>
                    </li>
                    <li>
                       <a href="studentInfo">User info <i class="st-chart"></i></a>
                    </li>
                    <li>
                      <a href="exam">exam<i class="im-paragraph-justify"></i></a>
                    </li>
                    <li>
                      <a href="scoreCheck">find score<i class="im-table2"></i></a>
                    </li>
                </ul>
                <!-- End #sideNav -->
            </div>
            <!-- End .sidebar-inner -->
        </div>
        <!-- End #sidebar -->

        <!-- Start #content -->
        <div id="content">
            <!-- Start .content-wrapper -->
            <div class="content-wrapper">
            
                <div class="row">
                    <!-- Start .row -->
                    <!-- Start .page-header -->
                    
                    <div class="col-lg-12 heading">
                        <h1 class="page-header"><i class="im-screen"></i> 考试成绩</h1>
                        <!-- Start .bredcrumb -->
                        <ul id="crumb" class="breadcrumb">
                        </ul>
                        
                          <table>
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
    </body>
</html>