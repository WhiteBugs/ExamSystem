
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>在线考试</title>
    <link href="/ExamSystem/css/main.css" rel="stylesheet" type="text/css" />
	<link href="/ExamSystem/css/iconfont.css" rel="stylesheet" type="text/css" />
	<link href="/ExamSystem/css/test.css" rel="stylesheet" type="text/css" />
	<style>
		.hasBeenAnswer {
			background: #5d9cec;
			color:#fff;
		}
	</style>

</head>
<body>

	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="nr_left">
					<div class="jumbotron">
						<h3 class="block-center">考试名称</h3>
						</div>
						<div>
							<div id="section-1" class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">考前必看</h3>
								</div>
								<ul>
									<li>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante. Vestibulum id metus ac nisl bibendum scelerisque non non purus. Suspendisse varius nibh non aliquet sagittis. In tincidunt orci sit amet elementum </p>
										<p>vestibulum. Vivamus fermentum in arcu in aliquam. Quisque aliquam porta odio in fringilla. Vivamus nisl leo, blandit at bibendum eu, tristique eget risus. Integer aliquet quam ut elit suscipit, id interdum neque porttitor. Integer faucibus ligula.</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante. Vestibulum id metus ac nisl bibendum scelerisque non non purus. Suspendisse varius nibh non aliquet sagittis. In tincidunt orci sit amet elementum </p>
										<p>vestibulum. Vivamus fermentum in arcu in aliquam. Quisque aliquam porta odio in fringilla. Vivamus nisl leo, blandit at bibendum eu, tristique eget risus. Integer aliquet quam ut elit suscipit, id interdum neque porttitor. Integer faucibus ligula.</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante. Vestibulum id metus ac nisl bibendum scelerisque non non purus. Suspendisse varius nibh non aliquet sagittis. In tincidunt orci sit amet elementum </p>
										<p>vestibulum. Vivamus fermentum in arcu in aliquam. Quisque aliquam porta odio in fringilla. Vivamus nisl leo, blandit at bibendum eu, tristique eget risus. Integer aliquet quam ut elit suscipit, id interdum neque porttitor. Integer faucibus ligula.</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante. Vestibulum id metus ac nisl bibendum scelerisque non non purus. Suspendisse varius nibh non aliquet sagittis. In tincidunt orci sit amet elementum </p>
										<p>vestibulum. Vivamus fermentum in arcu in aliquam. Quisque aliquam porta odio in fringilla. Vivamus nisl leo, blandit at bibendum eu, tristique eget risus. Integer aliquet quam ut elit suscipit, id interdum neque porttitor. Integer faucibus ligula.</p>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="test">
					    <ul>
					       <li><a href="/ExamSystem/teacher/editTest/addChoiceQuestion">添加单选题</a></li>
					       <li><a href="#">添加多选题</a></li>
					       <li><a href="#">添加判断题</a></li>
					       <li><a href="/ExamSystem/teacher/editTest/addBlankFillingQuestion">添加填空题</a></li>
					       <li><a href="/ExamSystem/teacher/editTest/addEassyQuestion">添加简答题</a></li>
					    </ul>
						<form action="" method="post">
						    <#if choiceQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">${choiceQuestions?size}</i><span>题，</span><span>合计</span><i class="content_fs">60</i><span>分</span>
									</p>
								</div>
							</div> 
							<div class="test_content_nr">
								<ul>
								<#list choiceQuestions as choiceQuestion>
									<li id="qu_0_${choiceQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${choiceQuestion_index+1}</i><span>(1分)</span><font>${choiceQuestion.title}</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editTest?type=choiceQuestion&id=${choiceQuestion.choiceQuestionId }">编辑试题</a></button>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="0_answer_${choiceQuestion_index+1}_option_1"/>
													<label for="0_answer_${choiceQuestion_index+1}_option_1">
														A.
														<p class="ue" style="display: inline;">${choiceQuestion.choice1}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="0_answer_${choiceQuestion_index+1}_option_2" />
													<label for="0_answer_${choiceQuestion_index+1}_option_2">
														B.
														<p class="ue" style="display: inline;">${choiceQuestion.choice2}</p>
													</label>
												</li>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1"
													id="0_answer_${choiceQuestion_index+1}_option_3" />
													<label for="0_answer_${choiceQuestion_index+1}_option_3">
														C.
														<p class="ue" style="display: inline;">${choiceQuestion.choice3}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1"
													id="0_answer_${choiceQuestion_index+1}_option_4" />
													<label for="0_answer_${choiceQuestion_index+1}_option_4">
														D.
														<p class="ue" style="display: inline;">${choiceQuestion.choice4}</p>
													</label>
												</li> 
											</ul>
											<div>
												answer:    ${choiceQuestion.answer}
											</div>
										</div>
									</li>
									</#list>
								</ul>
							</div>
							</#if>
							<#if duoxuanti??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题，</span><span>合计</span><i class="content_fs">30</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
									<li id="qu_1_0">
										<div class="test_content_nr_tt">
											<i>1</i><span>(1分)</span><font>以下属于南方电网员工职业操守中明文规定的有()</font><b class="icon iconfont"></b>
										</div>

										<div class="test_content_nr_main">
											<ul>
												
												<li class="option">


													<input type="checkbox" class="radioOrCheck" name="answer1"
													id="1_answer_1_option_1"
													/>

													<label for="1_answer_1_option_1">
														A.
														<p class="ue" style="display: inline;">热爱祖国、热爱南网、热爱岗位</p>
													</label>
												</li>
												
												<li class="option">


													<input type="checkbox" class="radioOrCheck" name="answer1"
													id="1_answer_1_option_2"
													/>

													<label for="1_answer_1_option_2">
														B.
														<p class="ue" style="display: inline;">遵纪守法、忠于职守、令行禁止</p>
													</label>
												</li>
												
												<li class="option">


													<input type="checkbox" class="radioOrCheck" name="answer1"
													id="1_answer_1_option_3"
													/>

													<label for="1_answer_1_option_3">
														C.
														<p class="ue" style="display: inline;">客户至上、诚实守信、优质服务</p>
													</label>
												</li>
												
												<li class="option">


													<input type="checkbox" class="radioOrCheck" name="answer1"
													id="1_answer_1_option_4"
													/>

													<label for="1_answer_1_option_4">
														D.
														<p class="ue" style="display: inline;">公平竞争、互相监督、服从监管</p>
													</label>
												</li>
												
											</ul>
										</div>
									</li>

								</ul>
							</div>
							</#if>
							<#if panduanti??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>判断题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题，</span><span>共计</span><i class="content_fs">30</i><span>分</span>
									</p>
								</div>
							</div>
							<dir class="test_content_nr">
								<ul>
									<li id="qu_1_0">
										<div class="test_content_nr_tt">
											<i>1</i><span>(1分)</span><font>以下属于南方电网员工职业操守中明文规定的有()</font><b class="icon iconfont"></b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="1_answer_1_option_1"/>
													<label for="1_answer_1_option_1">
														<p class="ue" style="display: inline;">对</p>
													</label>
												</li>

												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="1_answer_1_option_2"/>
													<label for="1_answer_1_option_2">
														<p class="ue" style="display: inline;">错</p>
													</label>
												</li>
											</ul>
										</div>
									</li>
								</ul>
							</dir>
							</#if>
							<#if blankFillingQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>填空题</h2>
									<p>
										<span>共</span><i class="content_lit"></i><span>题，</span><span>共计</span><i class="content_fs"></i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list blankFillingQuestions as blankFillingQuestion>
									<li id="qu_3_${blankFillingQuestion_index}">
										<div class="test_content_nr_tt">
											<i>1</i><span>(1分)</span><font>${blankFillingQuestion.title}</font><b class="icon iconfont"></b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="1_answer_1_option_1"/>
													<label for="1_answer_1_option_1">
														<p class="ue" style="display: inline;">对</p>
													</label>
												</li>

												<li class="option">
													<input type="radio" class="radioOrCheck" name="answer1" id="1_answer_1_option_2"/>
													<label for="1_answer_1_option_2">
														<p class="ue" style="display: inline;">错</p>
													</label>
												</li>
											</ul>
										</div>
									</li>
									</#list>
								</ul>
							</div>
							</#if>
							<#if eassyQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>简答题</h2>
									<p>
										<span>共</span><i class="content_lit">${eassyQuestions?size}</i><span>题，</span><span>共计</span><i class="content_fs"></i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list eassyQuestions as eassyQuestion>
									<li id="qu_4_${eassyQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${eassyQuestion_index+1}</i><span>(1分)</span><font>${eassyQuestion.title}</font><b class="icon iconfont"></b>
										</div>
										<div class="test_content_nr_main">
											<i>${eassyQuestion.answer }</i>
										</div>
									</li>
									</#list>
								</ul>
							</div>
							</#if>
						</form>
					</div>

				</div>
				<div class="nr_right">
					<div class="nr_rt_main">
						<div class="rt_nr1">
							<div class="rt_nr1_title">
								<h1>
									<i class="icon iconfont">图片</i>答题卡
								</h1>
								<p class="test_time">
									<i class="icon iconfont">图片</i><b class="alt-1">01:40</b>
								</p>
							</div>
                            <#if choiceQuestions??>
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">${choiceQuestions?size}</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
                                        <#list choiceQuestions as choiceQuestion>
										<li><a href="#qu_0_${choiceQuestion_index}">${choiceQuestion_index+1}</a></li>
										</#list>
									</ul>
								</div>
							</div>
							</#if>
							<#if duoxuanti??>
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>

										<li><a href="#qu_1_0">1</a></li>

										<li><a href="#qu_1_29">30</a></li>

									</ul>
								</div>
							</div>
							</#if>
							<#if panduanti??>
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>判断题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
									</ul>
								</div>
							</div>
							</#if>
							<#if blankFillingQuestions??>
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>填空题</h2>
									<p>
										<span>共</span><i class="content_lit">${blankFillingQuestions?size}</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										<#list blankFillingQuestions as blankFillingQuestion>
										<li><a href="#qu_3_${blankFillingQuestion_index}">${blankFillingQuestion_index+1}</a></li>
										</#list>
									</ul>
								</div>
							</div>
							</#if>
							<#if eassyQuestions??>
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>简答题</h2>
									<p>
										<span>共</span><i class="content_lit">${eassyQuestions?size}</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										<#list eassyQuestions as eassyQuestion>
										<li><a href="#qu_3_${eassyQuestion_index}">${eassyQuestion_index+1}</a></li>
										</#list>
									</ul>
								</div>
							</div>
							</#if>

						</div>

					</div>
				</div>
				</div>
				<!--nr end-->
				<div class="foot"></div>
			</div>

			<script src="js/jquery-1.11.3.min.js"></script>
			<script src="js/jquery.easy-pie-chart.js"></script>
			<!--时间js-->
			<script src="js/jquery.countdown.js"></script>
			<script>
				window.jQuery(function($) {
					"use strict";

					$('time').countDown({
						with_separators : false
					});
					$('.alt-1').countDown({
						css_class : 'countdown-alt-1'
					});
					$('.alt-2').countDown({
						css_class : 'countdown-alt-2'
					});

				});


				$(function() {
					$('li.option label').click(function() {
						debugger;
			var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
			var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
			// 设置已答题
			if(!cardLi.hasClass('hasBeenAnswer')){
				cardLi.addClass('hasBeenAnswer');
			}
			
		});
				});
			</script>

			<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
				<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
			</div>
		</body>
		</html>
