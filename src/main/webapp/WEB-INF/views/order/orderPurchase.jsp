<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>订单确认</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <form:form cssClass="form-horizontal" action="${ctx}/order/ordering" method="post">
        <div class="row">
            <div class="col-sm-6 list-group">
                <c:forEach items="${addressList}" var="address">
                    <a href="#" class="list-group-item addressItem">
                        <h4 class="list-group-item-heading">${address.address}</h4>
                        <p class="list-group-item-text">${address.consignee}</p>
                        <input type="hidden" value="${address.id}"/>
                        <input type="hidden" value="${address.zipcode}"/>
                        <input type="hidden" value="${address.phone}"/>
                    </a>
                </c:forEach>
            </div>
            <div class="col-sm-6">
                <input type="hidden" id="id" name="id"/>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">地址</label>

                    <div class="col-sm-6">
                        <input id="address" class="form-control" type="text" name="address"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="zipcode" class="col-sm-2 control-label">邮编</label>

                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="zipcode" name="zipcode"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">电话</label>

                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="phone" name="phone"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="consignee" class="col-sm-2 control-label">联系人</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="consignee" name="consignee"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>名称</td>
                    <td>型号</td>
                    <td>编码</td>
                    <td>价格</td>
                    <td>数量</td>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row text-right">
                <a class="btn btn-primary" href="${ctx}/cart/">回购物车修改</a>
                <button class="btn btn-primary" type="submit" href="${ctx}/order/ordering/">确认</button>
            </div>
            <div id="delSuccess" class="alert alert-success" style="display: none;">删除成功...</div>
            <div id="delAllSuccess" class="alert alert-success" style="display: none;">购物车清空成功...</div>
        </div>
    </form:form>
</div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/cart.js" type="text/javascript"></script>
</body>
</html>