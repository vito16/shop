<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>主页</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp"%>
<div class="container">
    <div class="row">
        <c:forEach items="${productList}" var="product">
            <c:set var="task" value="${leave.task }"/>
            <c:set var="pi" value="${leave.processInstance }"/>
            <div class="col-lg-4">
                    <img class="img-thumbnail" src="${ctx}/images/product/pc.jpg" style="width: 140px; height: 140px;">
                    <p><a class="btn btn-default" href="${ctx}/product/${product.id}" role="button">${product.title}</a></p>
                <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
            </div>

        </c:forEach>
    </div>
    <div class="center row">
        <ul class="pagination">
            <li><a href="#">«</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">»</a></li>
        </ul>
    </div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp"%>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>