<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증 이메일</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
<div class="container" style="margin-top: 50px">
	<div class="row">
		<div class="form-group has-error">
			<div class="number font-red"> 
				<h1 style="color: black;">인증 절차를 마무리 해주세요.</h1> 
			</div>
			
			<div class="details">
				<h3>회원가입에 사용한 ${member_email }로 인증 이메일이 발송되었습니다.</h3>
				<p>
					<a href="/">[HOME]</a>으로 돌아가기
				</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>