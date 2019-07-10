<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/commonPage/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_update</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<style>
textarea {min-height: 50px;}
</style>
<script type="text/javascript">
function resize(obj){
	obj.style.height = "1px";
	obj.style.height = (12+obj.scrollHeight)+"px";
	
}

//유효성 검사
function check_form(){
	var inputForm_title = $("#title").val().replace(/\s|/gi,'');
	var inputForm_content = $("#content").val().replace(/\s|/gi,'');
	
	if($("#writer").val()==""){
		alert("작성자를 입력해주세요.");
		$("#writer").focus();
		return false;
	}
	
	if(inputForm_title==""){
		alert("제목을 입력해주세요.");
		$("#title").val("");
		$("#title").focus();
		return false;
	}
	
	if(inputForm_content==""){
		alert("내용을 입력해주세요.");
		$("#content").val("");
		$("#content").focus();
		return false;
	}
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
<input type="hidden" name="category" id="category" value="${category }">
<div class="container" style="margin-top: 50px">
	<div class="form">
		<h2>글수정</h2>
		<form method="post" action="/board/update" onsubmit="return check_form();">
			<input type="hidden" name="category" value="${boardDto.board_category }">
			<input type="hidden" name="board_no" value="${boardDto.board_no }">
			<table class="table">
				<tr>
					<td><input id="writer" name="board_writer" type="text" class="form-control" placeholder="${boardDto.board_writer }" readonly="readonly" value="${boardDto.board_writer }"></td>
				</tr>
				<tr>
					<td><input id="title" name="board_title" type="text" class="form-control" placeholder="제목" maxlength="50" value="${boardDto.board_title }"></td>
				</tr>
				<tr>
					<td><textarea id="content" name="board_content" class="form-control" placeholder="내용" onkeydown="resize(this)">${boardDto.board_content }</textarea>
				</tr>
			</table>
			<a href="/board/${boardDto.board_category }/${boardDto.board_no}" class="btn btn-primary">취소</a>
			<input type="submit" class="btn btn-primary" value="완료">
		</form>
	</div>
</div>
</body>
</html>