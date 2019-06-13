<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmtTimeZone</title>
</head>
<body>
<h2>timeZone</h2>
<c:set var="dt" value="<%= new Date() %>"></c:set>
dt : <fmt:formatDate value="${dt }" type="both"/> <br>

<h3>setTimeZone</h3>
<fmt:setTimeZone value="Poland" var="pol"/>
dt(Poland) : <fmt:formatDate value="${dt }" timeZone="${pol }" type="both"/> <br>

<h3>timeZone</h3>
<fmt:timeZone value="Poland">
dt(Poland) : <fmt:formatDate value="${dt }" timeZone="${pol }" type="both"/> <br>
</fmt:timeZone>
</body>
</html>