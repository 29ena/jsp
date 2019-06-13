<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmtDate</title>
</head>
<body>
<h2>formatDate</h2>
<c:set var= "dt" value="<%= new Date() %>" />
dt : ${dt } <br>
dt : <fmt:formatDate value="${dt }" /> <br> <%-- pattern setLocale 무시하고 pattern을 사용하여 만들수 있다. --%>
dt : <fmt:formatDate value="${dt }" pattern="yyyy-MM-dd"/> <br>
dt : <fmt:formatDate value="${dt }" /> <br> 
dt(FULL): <fmt:formatDate value="${dt }" type="date" dateStyle="FULL"/> <br>
dt(MEDIUM) : <fmt:formatDate value="${dt }" type="date" dateStyle="MEDIUM"/> <br>
dt(SHORT) : <fmt:formatDate value="${dt }" type="date" dateStyle="SHORT"/> <br>
dt : <fmt:formatDate value="${dt }" type="time"/> <br>
dt : <fmt:formatDate value="${dt }" type="both"/> <br>

<h3>de</h3>
<fmt:setLocale value="de_DE"/>
dt : <fmt:formatDate value="${dt }" pattern="yyyy/MM/dd"/> <br>

<h2>parseDate (String -> date / 2019.6.13 -> date)</h2>
<fmt:setLocale value="ko_KR"/>

<c:set value="2019.06.13" var="dtStr"/>
dtStr : ${dtStr} <br>
dtStr(pareseDate) : <fmt:parseDate value="${dtStr}" pattern="yyyy.MM.dd"/> <br>

</body>
</html>