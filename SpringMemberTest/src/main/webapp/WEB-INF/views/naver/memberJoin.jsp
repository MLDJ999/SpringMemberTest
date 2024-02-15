<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>/naver/memberJoin.jsp</h1><hr>
	
	<h1>첫 방문을 환영합니다.</h1>
	<fieldset>
		<legend>회원가입</legend>
		<form action="" method = "post">
			아이디 : <input type = "text" name = "userid"><br>
			비밀번호 : <input type = "password" name= "userpw"><br>
			이름 : <input type = "text" name = "username"><br>
			이메일 : <input type = "email" name = "useremail"><br>
			
			<input type = "submit" value = "회원가입">
		</form>
	</fieldset>
</body>
</html>