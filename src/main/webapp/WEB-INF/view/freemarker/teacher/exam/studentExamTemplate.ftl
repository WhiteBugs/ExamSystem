
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>考生试卷</title>
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
						<h2 class="block-center">${exam.examName }</h2>
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
						<form action="/ExamSystem/student/exam/commit" method="post">
						   <div class="test_title">
						       <font><input type="submit" name="test_jiaojuan" value="提交修改"></font>
					       </div>
						   <input type="hidden" name="examId" value="${exam.examId }">
						   <input type="hidden" name="studentId" value="${student.studentId }">
						    <#if choiceQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									每题 ${choiceScore }分
									<p>
										<span>共</span><i class="content_lit">${choiceQuestions?size}题</i>
										<input type="hidden" name="choiceQuestionSize" value="${choiceQuestions?size}">
									</p>
								</div>
							</div> 
							<div class="test_content_nr">
								<ul>
								<#list choiceQuestions as choiceQuestion>
									<li id="qu_0_${choiceQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${choiceQuestion_index+1}</i><span>(${choiceScore }分)</span><font>${choiceQuestion.title}</font><b class="icon iconfont"></b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<label for="0_answer_${choiceQuestion_index+1}_option_1">
														A.
														<p class="ue" style="display: inline;">${choiceQuestion.choice1}</p>
													</label>
												</li>
												
												<li class="option">
												     <label for="0_answer_${choiceQuestion_index+1}_option_2">
														B.
														<p class="ue" style="display: inline;">${choiceQuestion.choice2}</p>
													</label>
												</li>
												<li class="option">
													<label for="0_answer_${choiceQuestion_index+1}_option_3">
														C.
														<p class="ue" style="display: inline;">${choiceQuestion.choice3}</p>
													</label>
												</li>
												
												<li class="option">
													<label for="0_answer_${choiceQuestion_index+1}_option_4">
														D.
														<p class="ue" style="display: inline;">${choiceQuestion.choice4}</p>
													</label>
												</li>
												<li class="answer">
												            标准答案：${choiceQuestion.answer }        学生答案：${choiceQuestion.studentAnswer }
												</li>
												<li>
												           得分 ： ${choiceQuestion.studentScore} 
												</li>
											</ul>
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
									每题 ${multipleScore }分
									<p>
										<span>共</span><i class="content_lit">${multipleChoiceQuestion?size }</i><span>题，</span><span>合计</span><i class="content_fs"> ${multipleScore * multipleChoiceQuestion?size }</i><span>分</span>
										<input type="hidden" name="multipleChoiceQuestionSize" value="${multipleChoiceQuestion?size }">
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
								<#list multipleChoiceQuestions as multipleChoiceQuestion>
									<li id="qu_1_${multipleChoiceQuestion_index}">
										<div class="test_content_nr_tt">
											<i>${multipleChoiceQuestion_index+1 }</i><span>(1分)</span><font>${multipleChoiceQuestion.title }</font><b class="icon iconfont"></b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer${multipleChoiceQuestion_index}" id="1_answer_${multipleChoiceQuestion_index}_option_1" value="A"/>
													<label for="1_answer_${multipleChoiceQuestion_index}_option_1">
														A.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice1 }</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer${multipleChoiceQuestion_index}" id="1_answer_${multipleChoiceQuestion_index}_option_2" value="B"/>
													<label for="1_answer_${multipleChoiceQuestion_index}_option_2">
														B.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice2}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer${multipleChoiceQuestion_index}" id="1_answer_${multipleChoiceQuestion_index}_option_3" value="C" />
													<label for="1_answer_${multipleChoiceQuestion_index}_option_3">
														C.
														<p class="ue" style="display: inline;">${multipleChoiceQuestion.choice3}</p>
													</label>
												</li>
												
												<li class="option">
													<input type="checkbox" class="radioOrCheck" name="multipleChoiceAnswer${multipleChoiceQuestion_index}" id="1_answer_${multipleChoiceQuestion_index}_option_4" value="D"/>
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
									每题 ${tfScore }分
									<p>
										<span>共</span><i class="content_lit">${tureFalseQuestions?size }</i><span>题，</span><span>共计</span><i class="content_fs">${tfScore * tureFalseQuestions?size }</i><span>分</span>
										<input type="hidden" name="tureFalseQuestionSize" value="${tureFalseQuestions?size }">
									</p>
								</div>
							</div>
							<dir class="test_content_nr">
								<ul>
								<#list trueFalseQuestions as trueFalseQuestion>
									<li id="qu_2_${trueFalseQuestion_index }">
										<div class="test_content_nr_tt">
											<i>1</i><span>(1分)</span><font>${trueFalseQuestion.title}</font><b class="icon iconfont"></b>
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
									每题 ${blankScore }分
									<p>
										<span>共</span><i class="content_lit">${blankFillingQuestions?size }</i><span>题，</span><span>共计</span><i class="content_fs"> ${blankScore * blankFillingQuestions?size }</i><span>分</span>
										<input type="hidden" name="blankFillingQuestionSize" value="${blankFillingQuestions?size }">
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
									</li>
									<div >
									    答案：<input name="blankQuestionAnswer${blankFillingQuestion_index}">
									</div>
								</#list>
								</ul>
							</div>
							</#if>
							<#if eassyQuestions??>
							<div class="test_content">
								<div class="test_content_title">
									<h2>简答题</h2>
									每题 ${eassyScore }分
									<p>
										<span>共</span><i class="content_lit">${eassyQuestions?size}</i><span>题，</span><span>共计</span><i class="content_fs"> ${eassyScore * eassyQuestions?size}</i><span>分</span>
										<input type="hidden" name="eassyQuestionSize" value="${eassyQuestions?size}">
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
									</li>
									<div >
									    答案 ：<input name="eassyQuestionAnswer${eassyQuestion_index}">
									</div>
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
									<i class="icon iconfont">图片</i><b class="alt-1">${time }</b>
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
			<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
				<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
			</div>
		</body>
		</html>
