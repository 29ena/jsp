<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="rangers" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select>
<c:forTokens items="${rangers }" delims="," var = "ranger">
	<option>${ranger }</option>
</c:forTokens>
</select>