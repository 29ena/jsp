<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<font color = "${color }">
<c:forEach begin="1" end="${size == null ? 5 : size }">=</c:forEach>

<%-- 
<c:choose>
	<c:when test="${size eq null}">
		<c:forEach begin="1" end="5">=</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach begin="1" end="${size }">=</c:forEach>
	</c:otherwise>
</c:choose>
 --%>
 
</font>

