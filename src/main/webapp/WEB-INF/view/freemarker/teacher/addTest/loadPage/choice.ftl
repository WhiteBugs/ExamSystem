<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <title>添加试题</title>
   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel">
		<form class="" action="addChoice">
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
			
		</form>
	</div>
</body>
</html>