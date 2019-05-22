<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
 td{
 	padding : 5px;
 }
</style>
<title>구구단</title>
</head>
<body>
<!-- localhost/jsp/jsp/timesTables.jsp -->
<!-- 9 * 9 단 출력 (2~9단) -->

<%
	String param = request.getParameter("i");
	String param2 =request.getParameter("j");
%>
<table border="1">
	<% for(int i = 1; i <= Integer.parseInt(param); i++){ %>
		<tr>
			<% for(int j =2; j <= Integer.parseInt(param2); j++){%>
				<td><%= i + " * " + j + " = " + i * j %> 
					
				</td>
			<%} %>
		</tr>
	<%} %>
</table>
<table>
<tr>
</tr>
</table>

</body>
</html>