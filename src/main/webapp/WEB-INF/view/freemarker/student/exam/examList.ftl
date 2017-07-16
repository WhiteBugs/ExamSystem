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
                <!-- Start #header-area -->
                
                <!-- End #header-area -->
            </div>
            <!-- Start .header-inner -->
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
                <!-- Start .sidebar-panel -->
                
                <!-- End .sidebar-panel -->
            </div>
            <!-- End .sidebar-inner -->
        </div>
        <!-- End #sidebar -->
        <!-- Start #right-sidebar -->
        
        <!-- End #right-sidebar -->
        <!-- Start #content -->
        <div id="content">
            <!-- Start .content-wrapper -->
            <div class="content-wrapper">
                <div class="row">
                    <!-- Start .row -->
                    <!-- Start .page-header -->
                    <div class="col-lg-12 heading">
                        <h1 class="page-header"><i class="im-screen"></i> 考试列表</h1>
                        <!-- Start .bredcrumb -->
                        <ul id="crumb" class="breadcrumb">
                        </ul>
                           <table border=1>
                              <#list examList as exam>
                                 <tr><td><a href="http://www.baidu.com">${exam.examName}</a><td><a href=${exam.url}>enter exam  </a>
                                 
                              </#list>
                           </table>
                        </div>
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
        <!-- End #content -->
        <!-- Javascripts -->
        <!-- Load pace first -->
        <script src="assets/plugins/core/pace/pace.min.js"></script>
        <!-- Important javascript libs(put in all pages) -->
        <script src="assets/js/jquery-1.8.3.min.js"></script>
        <script>
        window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
        </script>
        <script src="assets/js/jquery-ui.js"></script>
        <script>
        window.jQuery || document.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
        </script>
        <!--[if lt IE 9]>
  <script type="text/javascript" src="assets/js/libs/excanvas.min.js"></script>
  <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <script type="text/javascript" src="assets/js/libs/respond.min.js"></script>
<![endif]-->
        <!-- Bootstrap plugins -->
        <script src="assets/js/bootstrap/bootstrap.js"></script>
        <!-- Core plugins ( not remove ever) -->
        <!-- Handle responsive view functions -->
        <script src="assets/js/jRespond.min.js"></script>
        <!-- Custom scroll for sidebars,tables and etc. -->
        <script src="assets/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
        <!-- Resize text area in most pages -->
        <script src="assets/plugins/forms/autosize/jquery.autosize.js"></script>
        <!-- Proivde quick search for many widgets -->
        <script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
        <!-- Bootbox confirm dialog for reset postion on panels -->
        <script src="assets/plugins/ui/bootbox/bootbox.js"></script>
        <!-- Other plugins ( load only nessesary plugins for every page) -->
        <script src="assets/plugins/charts/flot/jquery.flot.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.pie.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.resize.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.time.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.growraf.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.categories.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.stack.js"></script>
        <script src="assets/plugins/charts/flot/jquery.flot.tooltip.min.js"></script>
        <script src="assets/plugins/charts/flot/date.js"></script>
        <script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
        <script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
        <script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
        <script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
        <script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
        <script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
        <script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
        <script src="assets/plugins/ui/weather/skyicons.js"></script>
        <script src="assets/plugins/ui/notify/jquery.gritter.js"></script>
        <script src="assets/plugins/ui/calendar/fullcalendar.js"></script>
        <script src="assets/js/jquery.sprFlat.js"></script>
        <script src="assets/js/app.js"></script>
        <script src="assets/js/pages/dashboard.js"></script>
    </body>
</html>
