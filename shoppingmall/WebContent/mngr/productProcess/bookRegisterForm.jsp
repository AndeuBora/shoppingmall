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
<script src="http://code.jquery.com/jquery-latest.js" ></script>
<script type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.id }">
<meta http-equiv="Refresh" content="0;url=/shoppingmall/mngr/managerMain"> 
</c:if>
</body>
</html>