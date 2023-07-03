<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>할 일 관리</title>
</head>
<body>
	<div class="container">
		<div class="mt-2 mb-2">
			<h2># This Week's Mission!</h2>
		</div>
		<div>
			<ul class="list-group">
				<c:forEach items="${quests }" var="q">
					<a href="/todos/join?id=${q.id}" style="text-decoration: none"><li class="list-group-item d-flex justify-content-between">
						<span>${q.description }<small>( ~ <fmt:formatDate value="${q.endDate}" /> )</small></span>
						<span class="badge bg-primary">${q.joinCnt }</span>
					</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<c:if test="${param.error eq '1' }">
			<div style="margin : 10px;text-align: center">
				<p style="color: red">이미 중복된 퀘스트이거나 서비스 장애로 요청 처리가 불가합니다.</p>
			</div>
		</c:if>
		<div class="mt-2 mb-2">
			<h2># Things To Do</h2>
		</div>
		<div class="mb-1 text-end">
			<a href="/todos/create" class="btn btn-outline-primary">할 일 등록</a>
		</div>
		<table class="table">
			<thead>
				<tr class="table-light">
					<th># 세부내용</th>
					<th># 달성기한</th>
					<th># 달성여부</th>
					<th># 수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="o" items="${todos }">
					<tr data-todo-id=${o.id }>
					<c:choose>
						<c:when test="${o.done eq '달성' }">
							<td><del>${o.description }</del></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${o.description }"/></td>
						</c:otherwise>
					</c:choose>
						<td> ~ <fmt:formatDate value="${o.targetDate}" /></td>
						<td>${o.done eq '달성' ? '달성' : '미달성'}</td>
						<td>
							<a href="/todos/update?todoId=${o.id }" class="btn btn-success">수정</a>
							<a href="/todos/delete?todoId=${o.id }" class="btn btn-danger">삭제</a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>