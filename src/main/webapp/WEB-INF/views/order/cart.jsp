<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>购物车</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>名称</td>
                <td>型号</td>
                <td>编码</td>
                <td>价格</td>
                <td>数量</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.cart}" var="cartItem">
                <c:set var="ci" value="${cartItem.value}"></c:set>
                <tr pid="${ci.product.id}">
                    <td>${ci.product.title}</td>
                    <td>${ci.product.model}</td>
                    <td>${ci.product.code}</td>
                    <td>${ci.product.point}</td>
                    <td>${ci.total}</td>
                    <td><a class="btn btn-info delBtn" productid="${ci.product.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="delSuccess" class="alert alert-success">删除成功...</div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <a class="btn btn-primary" href="${ctx}/product/">继续购买</a>
        </div>
        <div class="col-md-6 text-right">
            <a class="btn btn-success" href="${ctx}/product/">结账</a>
        </div>
    </div>
</div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/cart.js" type="text/javascript"></script>
</body>
</html>