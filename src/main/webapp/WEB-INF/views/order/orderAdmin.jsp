<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>订单管理</title>
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
                <un:useConstants className="com.vito16.shop.common.Constants" var="constants" />
                <c:forEach items="${page.result}" var="order">
                    <c:set value="0" var="sum" />
                    <tr pid="${order.id}">
                        <td>${order.createTime}</td>
                        <td>${order.orderNumber}</td>
                        <td>${sum}</td>
                        <td>
                            <c:choose>
                                <c:when test="${order.status==0}">等待付款</c:when>
                                <c:when test="${order.status==1}">等待发货</c:when>
                                <c:when test="${order.status==2}">已发货</c:when>
                                <c:when test="${order.status==3}">已取消</c:when>
                            </c:choose>
                        </td>
                        <td>${order.userAddress.consignee}</td>
                        <td>
                            <c:choose>
                                <c:when test="${order.status==0}"><a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">查看</a><a class="btn btn-info btn-xs" href="${ctx}/order/delete/${order.id}">删除</a></c:when>
                                <c:when test="${order.status==1}"><a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">查看</a><a class="btn btn-info btn-xs" href="${ctx}/order/ship/${order.id}">发货</a><a class="btn btn-info btn-xs" href="${ctx}/order/delete/${order.id}">删除</a></c:when>
                                <c:when test="${order.status==2}"><a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">查看</a></c:when>
                                <c:when test="${order.status==3}"><a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">查看</a></c:when>
                            </c:choose>
                        </td>
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