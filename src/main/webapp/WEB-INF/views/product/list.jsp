<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>主页</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<div class="container">
    <%@include file="/common/header-nav.jsp" %>
    <div class="row">
        <c:forEach items="${page.result}" var="product">
            <c:set var="task" value="${leave.task }"/>
            <c:set var="pi" value="${leave.processInstance }"/>
            <div class="col-lg-3 text-center">
                <a href="${ctx}/product/${product.id}"><img class="img-thumbnail" src="${ctx}${product.picUrl}"
                                                            style="width: 140px; height: 140px;"></a>

                <p>${product.title}</p>

                <p class="price">${product.point}</p>

                <p>
                    <a class="btn btn-info" href="${ctx}/product/${product.id}" role="button">查看</a>
                    <a class="btn btn-primary" productID="${product.id}" role="button">购买</a>
                </p>
            </div>
        </c:forEach>
    </div>
    <div class="text-center">
        <tags:pagination page="${page}" paginationSize="${page.pageSize}"/>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>