<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 관리</title>
</head>
<body>
	<div>
	<h1>로그인</h1>
		<div>
			<form action="/auth-task" method="POST">
				<input type="text" name="id" autocomplete="off" required/>
				<input type="password" name="pass" required/>
				<button type="submit">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>