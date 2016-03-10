<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%
    //jquery
    String jqueryVersion = "1.10.2";

    session.setAttribute("jqueryVersion", jqueryVersion);
    pageContext.setAttribute("timeInMillis", System.currentTimeMillis());
%>
<script type="text/javascript">
    var ctx = '<%=request.getContextPath() %>';
</script>