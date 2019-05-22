<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringBufferInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
	
		out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
		
		out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
		
		out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
		
		 out.write("application.getInitParameter(\"ADMIN\") : " 
		            + application.getInitParameter("ADMIN") + "<br>");
		
		out.write("application.getRealPath(\"/res/190522.txt\") :" + application.getRealPath("/res/190522.txt")+"<br>");
		
		
		// 파일 내용을 화면에 출력하기.
		
		 BufferedReader reader = new BufferedReader(new FileReader(application.getRealPath("/res/190522.txt")));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine())!= null){
                sb.append(line+"<br>");
                
            }
            out.write("파일 내용 출력 : <br>" + sb.toString());
		
	%>
</body>
</html>