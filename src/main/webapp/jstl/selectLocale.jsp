<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp" %>
<script>
	$(document).ready(function(){
		$("#localeSelect").val("${locale}");
		$("#localeSelect").on("change", function(){
			// value 값으로 선택
			$("#frm").submit();
		});
	});
</script>
</head>
<body>

<h2>select locale</h2>
locale : ${locale } <br>

	<form id="frm" action="${cp }/selectLocale" method="post">
	<select id="localeSelect" name="locale">
		<option value="ko"> 한국어</option>
		<option value="en">English</option>
		<option value="ja">日本語</option>
	</select>
	</form>
	
	
	<fmt:setLocale value="${locale}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key = "GREETING"/> <br>
		<fmt:message key = "VISITOR">
			<fmt:param value="brown"/><br>	<%--인자값이 넣어줄 경우 --%>
		</fmt:message>
	</fmt:bundle>
			

</body>
</html>