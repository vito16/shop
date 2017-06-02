<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>公告详情</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="form-horizontal">
        <div class="row">
            <div class="form-group">
                <label class="col-sm-2 control-label">地址</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.address}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">邮编</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.zipcode}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">电话</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.phone}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">联系人</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.consignee}</p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">创建时间</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.createTime}</p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">付款时间</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.shipTime}</p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">发货时间</label>

                <div class="col-sm-6">
                    <p class="form-control-static">${order.confirmTime}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="page-header">
            <h2>商品详情</h2>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <td>名称</td>
                <td>型号</td>
                <td>编码</td>
                <td>单价</td>
                <td>数量</td>
                <td>总价</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${order.orderItems}" var="orderItem">
                <tr pid="${orderItem.id}">
                    <td><a href="${ctx}/product/${orderItem.product.id}">${orderItem.product.title}</a></td>
                    <td>${orderItem.product.model}</td>
                    <td>${orderItem.product.code}</td>
                    <td>${orderItem.product.point}</td>
                    <td>${orderItem.quantity}</td>
                    <td>${orderItem.product.point*orderItem.quantity}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>