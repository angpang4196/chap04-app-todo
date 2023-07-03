<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>할 일 작성</title>
</head>
<body>
	<div class="container">
		<div class="mb-2 mt-2">
			<h2># 목표 설정</h2>
		</div>
		<form action="/todos/create-task" method="POST">
			<div class="mb-2">
				<label>날짜</label> <input type="date" name="targetDate"
					class="form-control" />
			</div>
			<div class="mb-2">
				<label>목표</label> <input type="text" name="description"
					class="form-control" />
			</div>
			<div>${msg }</div>
			<button type="submit" class="btn btn-primary">목표 등록</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>