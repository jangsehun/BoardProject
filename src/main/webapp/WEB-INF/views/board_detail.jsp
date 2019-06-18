<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_detail</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

function comment_insert(){
	var comment_content = $("#board_comment_content").val().replace(/\s|/gi,'');
	
	if(comment_content==""){
		alert("댓글을 입력해주세요.");
		$("#board_comment_content").val("");
		$("#board_comment_content").focus();
		return false;
	}
	
	var boardCommentDto = {
			board_no : $("#board_comment_board_no").val(),
			board_comment_group : 0,
			user_id : $("#board_comment_user_id").val(),
			board_comment_content : $("#board_comment_content").val()
	}
	//alert(JSON.stringify(boardCommentDto)); 오브젝트 내용 확인
	
	$.ajax({
		url:"/board_comment_insert",
		type:"post",
		data: boardCommentDto, 
		success:function(boardCommentDto){
			//기존에 댓글이 없었다면 댓글이 없었다는 표시를 위한 엘리먼트 삭제
			if($("#noComments").length){
				$("#noComments").remove();
			}
			alert(boardCommentDto.board_comment_regDate);
			
			var _date = new Date();
			
			_date.setDate(boardCommentDto.board_comment_regDate);
			
			alert(_date);
			
			$("#board_comment_content").val("");
			$("#comment_list").append("<li class='list-group-item'><span>"+boardCommentDto.user_id+"</span><span class='text-muted'> | <small>"+boardCommentDto.board_comment_regDate+"</small></span>"+
										"<div style='white-space : pre-wrap;height: 100%'>"+boardCommentDto.board_comment_content+"</div></li>");
            	/* $("#cleint_no").append("<ontion value='"+value.client_no+"'>");
            	$("tbody").append(
					"<tr>"+
						"<td>"+value.client_name+"</th>"+
						"<td>"+value.menu_title+"</th>"+
						"<td>"+value.menu_price+"</th>"+
					"</tr>"
				); */
		},
		error:function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	return false;
}
</script>
<body>
<input type="hidden" name="category" id="category" value="${boardDto.board_category }">

<div class="container" style="margin-top: 50px">
	
	<div class="header">
		<h2>글보기</h2>
		<hr>
			<ul class="list-group">
			
				<li class="list-group-item">
					<div class="title">
						<h3>${boardDto.board_title }</h3>
					</div>
					
					<div class="row" >
						<div class="col-md-4" style="float: left">
							<span>${boardDto.board_writer } | <small><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${boardDto.board_regDate }"/></small></span>
						</div>
						<div style="float: right">
							<span class="text-muted"><small>조회 ${boardDto.board_views } | 댓글 [  ] | 추천 [  ]</small></span>
						</div>
					</div>
				
				</li>
			<li class="list-group-item">
			
			<div>
				<div id="board_content" style="white-space : pre-wrap;height: 100%">${boardDto.board_content }</div>
			</div>
			</li>
			</ul>
			<div class="row" style="margin-left: 0px; margin-right: 0px">
				<div style="float: left">
					<a href="/board/${boardDto.board_category }" class="btn btn-primary">목록</a>
					<!-- 작성자가 로그인한 유저라면 -->
					<input type="button" class="btn btn-primary" value="수정" onclick="location.href='/board/${boardDto.board_category }/update/${boardDto.board_no}'">
					<input type="button" class="btn btn-primary" value="삭제" onclick="location.href='/board/${boardDto.board_category }/delete/${boardDto.board_no}'">
					<!-- 여기까지 보여주기 -->
				</div>
				<div style="float: right">
					<input type="button" class="btn btn-primary" value="추천">
					<input type="button" class="btn btn-primary" value="비추천">
				</div>
			</div>
			<hr>
			
			<div class="form-group shadow-textarea">
			  	<label>댓글</label>
			  	<form method="post" action="board_comment_insert" onsubmit="return comment_insert();">
			  		<input id="board_comment_board_no" type="hidden" name="board_no" value="${boardDto.board_no }">
			  		<input id="board_comment_user_id" type="hidden" name="user_id" value="tester">
			  		<textarea id="board_comment_content" name="board_comment_content" class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="3" maxlength="1000" placeholder="댓글을 입력해주세요."></textarea>
			  		<input type="submit" class="pull-right btn btn-primary" value="작성">
			  	<br>
			  	</form>
			</div>
			<hr>
			<div>
				
			
				<ul class="list-group" id="comment_list">
					<c:choose>
						<c:when test="${empty boardComment_list}">
							<li class="list-group-item" id="noComments">
								<span>댓글이 없습니다.</span>
							</li>
						</c:when>
						
						<c:otherwise>
							<c:forEach items="${boardComment_list }" var="boardCommentDto">
								<li class="list-group-item"><span>${ boardCommentDto.user_id}</span><span class="text-muted"> | <small>${ boardCommentDto.board_comment_regDate}</small></span>
									<div class="" style="white-space : pre-wrap;height: 100%">${ boardCommentDto.board_comment_content}</div>
								</li>
							</c:forEach>		
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			
			<!-- 
			<table class="table">
				<tr>
					<td><div id="board_writer" class="form-control">${board_dto.board_writer }</div>
				</tr>
				<tr>
					<td><div id="board_title" class="form-control">${board_dto.board_title }</div>
				</tr>
				
				<tr>
					<td><div id="board_content" class="form-control" style="white-space : pre-wrap;height: 100%">${board_dto.board_content }</div>
				</tr>
			</table>
			 -->
	</div>
</div>

</body>
</html>