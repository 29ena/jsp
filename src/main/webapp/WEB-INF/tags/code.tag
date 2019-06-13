<%@tag import="kr.or.ddit.prod.dao.IProdDao"%>
<%@tag import="kr.or.ddit.prod.dao.ProdDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="code" required="true"%>

<%	
	IProdDao prodDao = new ProdDao();
	jspContext.setAttribute("prodList", prodDao.prodList(code));
%>
<select>
	<c:forEach items="${prodList }" var="prod">
		<option value="${prod.prod_id }">${prod.prod_name }</option>
	</c:forEach>
</select>












