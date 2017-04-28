<!-- 보라 811 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/shoppingmall/css/style.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="bookregist.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.id }">
		<meta http-equiv="Refresh"
			content="0;url=/shoppingmall/mngr/managerMain.do">
	</c:if>

	<div id="listHeader">
		<button id="bookMain">관리자 메인으로</button>
		<button id="bookList">목록으로</button>
	</div>

	<form id="upform1" action="/shoppingmall/mg/bookRegisterPro.do"
		method="post" enctype="multipart/form-data">
		<div id="bookRegistForm" class="box">
			<ul>
				<li><label>분류 선택<select id="book_kind" name="book_kind">
							<option value="100">문학</option>
							<option value="200">외국어</option>
							<option value="300">컴퓨터</option>
					</select></label></li>
				<li><label>제목<input type="text" size="50"
						maxlength="50" id="book_title" name="book_title" placeholder="제목"></label></li>
				<li><label>가격<input type="text" size="10" maxlength="9"
						id="book_price" name="book_price" placeholder="가격">원
				</label></li>
				<li><label>수량<input type="number" size="10"
						maxlength="5" id="book_count" name="book_count" placeholder="수량">권
				</label></li>
				<li><label>저자<input type="text" size="20"
						maxlength="30" id="author" name="author" placeholder="저자">
				</label></li>
				<li><label>출판사<input type="text" size="20"
						maxlength="30" id="publishing_com" name="publishing_com"
						placeholder="출판사">
				</label></li>
				<li><label>출판일</label>
					<div id="publishing_date">
						<jsp:useBean id="nowTime" class="java.util.Date" />
						<fmt:formatDate value="${nowTime }" var="nowTimeStr"
							pattern="yyyy-MM-dd" />
						<fmt:parseNumber var="lastYear" type="NUMBER"
							value="${nowTimeStr.toString().substring(0,4) }" />
						<select name="publishing_year">
							<c:forEach var="i" begin="2010" end="${lastYear }">
								<option value="${i }">${i }</option>
							</c:forEach>
						</select>년 <select name="publishing_month">
							<c:forEach var="i" begin="1" end="12">
								<option value="${i }">${i }</option>
							</c:forEach>
						</select>월 <select name="publishing_day">
							<c:forEach var="i" begin="1" end="31">
								<option value="${i }">${i }</option>
							</c:forEach>
						</select>일
					</div></li>
				<li><label>책 이미지<input type="file" id="book_image"
						name="book_image"></label></li>
				<li><label>내용<textarea rows="13" cols="50"
							id="book_content" name="book_content"></textarea></label></li>
				<li><label>할인율<input type="text" id="discount_rate"
						name="discount_rate" maxlength="2" placeholder="10" size="5"></label></li>
				<li class="label2"><input type="submit" value="★책등록★"
					id="registBook"></li>
			</ul>
		</div>
	</form>
</body>
</html>