<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>商品管理</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
    <%@ include file="/common/include-base-js.jsp" %>
    <script src="${ctx }/js/product.js" type="text/javascript"></script>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <%@include file="/common/admin-admin-nav.jsp" %>
    <div class="row">
        <table class="table table-striped">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>名称</td>
                    <td>型号</td>
                    <td>编码</td>
                    <td>价格</td>
                    <td>库存</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.result}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.title}</td>
                        <td>${product.model}</td>
                        <td>${product.code}</td>
                        <td>${product.point}</td>
                        <td>${product.stock}</td>
                        <td><a href="${ctx}/admin/product/edit/${product.id}">修改</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-center">
        <tags:pagination page="${page}" paginationSize="${page.pageSize}"/>
    </div>
    <a class="btn btn-primary" href="${ctx}/admin/product/new">添加</a>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
</body>
</html>