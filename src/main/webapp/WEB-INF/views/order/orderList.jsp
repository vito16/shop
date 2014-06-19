<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>订单列表</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="row">
        <table class="table table-responsive table-striped">
                <thead>
                <tr>
                    <td>订单日期</td>
                    <td>订单编号</td>
                    <td>订单金额</td>
                    <td>订单状态</td>
                    <td>收件人</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="order">
                    <c:set value="0" var="sum" />
                    <tr pid="${order.id}">
                        <td>${order.createTime}</td>
                        <td>${order.orderNumber}</td>
                        <c:forEach items="${order.orderItems}" var="item">
                            <c:set value="${sum + (item.quantity*item.product.point)}" var="sum" />
                        </c:forEach>
                        <td>${sum}</td>
                        <td>${order.status}</td>
                        <td>${order.userAddress.consignee}</td>
                        <td><a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">查看</a></td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
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