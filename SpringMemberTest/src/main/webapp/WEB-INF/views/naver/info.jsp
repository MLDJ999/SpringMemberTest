<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>/naver/info.jsp</h1>
		
		${resultVO } <hr>
		
		<h2> 아이디 : ${resultVO.userid }</h2>
		<h2> 비밀번호 : ${resultVO.userpw }</h2>
		<h2> 이름 : ${resultVO.username }</h2>
		<h2> 이메일 : ${resultVO.useremail }</h2>
		<h2> 회원가입일 : ${resultVO.regdate }</h2>
		
		<a href="/naver/main">메인페이지로</a>
		
</body>
</html>