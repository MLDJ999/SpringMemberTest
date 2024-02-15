<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/naver/main.jsp</h1>
	
	<!-- 로그인 정보가 없는경우 다시 로그인페이지로 이동(JSTL) -->
	<c:if test="${empty sessionScope.id }">
		<c:redirect url="/naver/login"/>
	</c:if>
	
	
	<!-- 로그인한 사용자의 아이디를 출력(세션정보) -->
	${id }님 환영합니다 <hr>
	${sessionScope.id }님 환영합니다 <hr>
	
	<input type="button" value="로그아웃" onclick=" location.href='/naver/logout'; ">
	<a href="javascript:location.href='/naver/logout';">로그아웃</a>
	
	
	<hr>
	<h3><a href="/naver/info">회원정보 조회</a></h3>
	
	<hr>
	<h3><a href="/naver/update">회원정보 수정</a></h3>
	
	<hr>
	<h3><a href = "/naver/delete">회원정보 삭제</a></h3>
	
	<c:if test="${!empty id && id.equals('admin')}">
		<hr>
		<h3><a href = "/naver/list">회원정보 목록(list-관리자)</a></h3>
	</c:if>
	
	
	
	
	
	
	
	

</body>
</html>