
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
						<h3 class="block-center">${exam.examName }</h3>
						</div>
						<div>
							<div id="section-1" class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">考前必看</h3>
								</div>
								<ul>
									<li>
										<p>1. 考生只准携带必身份证、学生证进入考场,不得携带其他物品；</p>
										<p>2. 考生提前10分钟到指定教室指定座位号调试计算机至考试页面，并核验屏幕上显示的姓名、学号等信息。 </p>
										<p>3. 监考人员宣布考试正式开始后，迟到15分钟以上的考生不得进入考场；</p>
										<p>4. 考试过程中如出现死机或系统错误等，应立刻停止操作，举手与监考员联系。</p>
										<p>5. 考生在考场内必须保持安静，严格遵守考场纪律，自觉服从监考员管理，对于违反考场规定、不服从监考员管理和舞弊者，按违反考场规定处理；</p>  
										<p>6.考生离开考场后，不准在考场附近逗留和交谈；</p>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="test">
					    <ul>
					       <li><a href="/ExamSystem/teacher/editQuestion/addQuestion?type=choiceQuestion&&examId=${exam.examId }">添加单选题</a></li>
					       <li><a href="/ExamSystem/teacher/editQuestion/addQuestion?type=multipleChoiceQuestion&&examId=${exam.examId }">添加多选题</a></li>
					       <li><a href="/ExamSystem/teacher/editQuestion/addQuestion?type=trueFalseQuestion&&examId=${exam.examId }">添加判断题</a></li>
					       <li><a href="/ExamSystem/teacher/editQuestion/addQuestion?type=blankFillingQuestion&&examId=${exam.examId }">添加填空题</a></li>
					       <li><a href="/ExamSystem/teacher/editQuestion/addQuestion?type=eassyQuestion&&examId=${exam.examId }">添加简答题</a></li>
					    </ul>
						<form action="/ExamSystem/teacher/exam/editExam/commit?examId=${exam.examId }" method="post">
						    <div class="test_title">
			                     <font><input type="submit" value="生成试卷"></font>
	                        </div>
						    <#if choiceQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									分值
									<select name="choiceScore">
						                <option value="1">1</option>
						                <option value="2">2</option>
						                <option value="3">3</option>
						                <option value="4">4</option>
						                <option value="5">5</option>
						            </select>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list choiceQuestions as choiceQuestion>
									<li id="qu_0_${choiceQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${choiceQuestion_index+1}</i><span>(1分)</span><font>${choiceQuestion.title}</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editQuestion?type=choiceQuestion&id=${choiceQuestion.choiceQuestionId }">编辑试题</a></button>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="choiceQuestionAnswer" id="0_answer_${choiceQuestion_index+1}_option_1" value="A"/>
													<label for="0_answer_${choiceQuestion_index+1}_option_1">
														A.
														<p class="ue" style="display: inline;">${choiceQuestion.choice1}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="radio" class="radioOrCheck" name="choiceQuestionAnswer" id="0_answer_${choiceQuestion_index+1}_option_2" value="B"/>
													<label for="0_answer_${choiceQuestion_index+1}_option_2">
														B.
														<p class="ue" style="display: inline;">${choiceQuestion.choice2}</p>
													</label>
												</li>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="choiceQuestionAnswer" id="0_answer_${choiceQuestion_index+1}_option_3" value="C"/>
													<label for="0_answer_${choiceQuestion_index+1}_option_3">
														C.
														<p class="ue" style="display: inline;">${choiceQuestion.choice3}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="radio" class="radioOrCheck" name="choiceQuestionAnswer" id="0_answer_${choiceQuestion_index+1}_option_4" value="D"/>
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
							<#if multipleChoiceQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>多选题</h2>
									分值
									<select name="multipleScore">
						                <option value="1">1</option>
						                <option value="2">2</option>
						                <option value="3">3</option>
						                <option value="4">4</option>
						                <option value="5">5</option>
						            </select>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list multipleChoiceQuestions as multipleChoiceQuestion>
									<li id="qu_1_${multipleChoiceQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${multipleChoiceQuestion_index+1 }</i><span>(1分)</span><font>${multipleChoiceQuestion.title }</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editQuestion?type=multipleChoiceQuestion&id=${multipleChoiceQuestion.multipleChoiceQuestionId}">编辑试题</a></button>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer" id="1_answer_${multipleChoiceQuestion_index}_option_1" value="A"/>
													<label for="1_answer_${multipleChoiceQuestion_index}_option_1">
														A.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice1 }</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer" id="1_answer_${multipleChoiceQuestion_index}_option_2" value="B"/>
													<label for="1_answer_${multipleChoiceQuestion_index}_option_2">
														B.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice2}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer" id="1_answer_${multipleChoiceQuestion_index}_option_3" value="C" />
													<label for="1_answer_${multipleChoiceQuestion_index}_option_3">
														C.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice3}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer" id="1_answer_${multipleChoiceQuestion_index}_option_4" value="D"/>
													<label for="1_answer_${multipleChoiceQuestion_index}_option_4">
														D.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice4}</p>
													</label>
												</li>
											</ul>
										</div>
									</li>
                                </#list>
								</ul>
							</div>
							</#if>
							<#if trueFalseQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>判断题</h2>
									分值
									<select name="tfScore">
						                <option value="1">1</option>
						                <option value="2">2</option>
						                <option value="3">3</option>
						                <option value="4">4</option>
						                <option value="5">5</option>
						            </select>
								</div>
							</div>
							<dir class="test_content_nr">
								<ul>
								<#list trueFalseQuestions as trueFalseQuestion>
									<li id="qu_2_${trueFalseQuestion_index }">
										<div class="test_content_nr_tt">
											<i>${trueFalseQuestion_index+1 }</i><span>(1分)</span><font>${trueFalseQuestion.title}</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editQuestion?type=trueFalseQuestion&id=${trueFalseQuestion.trueFalseQuestionId}">编辑试题</a></button>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="radio" class="radioOrCheck" name="trueFalseAnswer" id="1_answer_1_option_1" value="true"/>
													<label for="1_answer_1_option_1">
														<p class="ue" style="display: inline;">对</p>
													</label>
												</li>

												<li class="option">
													<input type="radio" class="radioOrCheck" name="trueFalseAnswer" id="1_answer_1_option_2" value="false"/>
													<label for="1_answer_1_option_2">
														<p class="ue" style="display: inline;">错</p>
													</label>
												</li>
											</ul>
										</div>
									</li>
								</#list>
								</ul>
							</dir>
							</#if>
							<#if blankFillingQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>填空题</h2>
									分值
									<select name="blankScore">
						                <option value="1">1</option>
						                <option value="2">2</option>
						                <option value="3">3</option>
						                <option value="4">4</option>
						                <option value="5">5</option>
						            </select>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list blankFillingQuestions as blankFillingQuestion>
									<li id="qu_3_${blankFillingQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${blankFillingQuestion_index+1 }</i><span>(1分)</span><font>${blankFillingQuestion.title}</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editQuestion?type=blankFillingQuestion&id=${blankFillingQuestion.blankFillingQuestionId}">编辑试题</a></button>
										</div>
										<div class="test_content_nr_main">
											答案:
											<#list blankFillingQuestion.answers as answer>
											  ${answer_index+1 }.${answer.answer}   
											</#list>
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
									分值
									<select name="eassyScore">
						                <option value="1">1</option>
						                <option value="2">2</option>
						                <option value="3">3</option>
						                <option value="4">4</option>
						                <option value="5">5</option>
						                <option value="6">6</option>
						                <option value="7">7</option>
						                <option value="8">8</option>
						                <option value="9">9</option>
						                <option value="10">10</option>
						            </select>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list eassyQuestions as eassyQuestion>
									<li id="qu_4_${eassyQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${eassyQuestion_index+1}</i><span>(1分)</span><font>${eassyQuestion.title}</font><b class="icon iconfont"></b>
											<button><a href="/ExamSystem/teacher/editQuestion?type=eassyQuestion&id=${eassyQuestion.eassyQuestionId}">编辑试题</a></button>
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
									<i class="icon iconfont">图片</i><b class="alt-1">${time}</b>
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

			<script src="/ExamSystem/js/jquery-1.11.3.min.js"></script>
			<script src="/ExamSystem/js/jquery.easy-pie-chart.js"></script>
			<!--时间js-->
			<script src="/ExamSystem/js/jquery.countdown.js"></script>
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
