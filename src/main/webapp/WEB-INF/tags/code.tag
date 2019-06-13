<%@tag import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@tag import="kr.or.ddit.prod.dao.ProdDao"%>
<%@tag import="kr.or.ddit.prod.dao.IProdDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="java.sql.DriverManager" %>
<%@ tag import="java.sql.Connection" %>
<%@ tag import="java.sql.ResultSet" %>
<%@ tag import="java.sql.PreparedStatement" %>
<%@ attribute name = "code" required="true" %>

code : ${code } <br>
<% 
	String code = (String)jspContext.getAttribute("code");
	IProdDao prodDao = new ProdDao();
	jspContext.setAttribute("prodList", prodDao.prodList(code));
%>


 



