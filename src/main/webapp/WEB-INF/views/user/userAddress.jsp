<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>${title}</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="row br">
        <ul class="nav nav-tabs">
            <li><a href="${ctx}/user/info">个人信息</a></li>
            <li class="active"><a href="#">地址管理</a></li>
            <li><a href="${ctx}/user/security">安全管理</a></li>
        </ul>
    </div>
    <div class="row">
        <c:if test="${not empty successInfo}">
            <div id="successInfo" class="alert alert-success">123123${successInfo}</div>
            <script type="text/javascript">
                setTimeout(function () {
                    $('#successInfo').hide('slow');
                }, 4000);
            </script>
        </c:if>
        <table class="table table-responsive table-striped">
            <thead>
            <tr>
                <td>收件人</td>
                <td>邮编</td>
                <td>电话</td>
                <td>地址</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userAddressList}" var="userAddress">
                <tr pid="${order.id}">
                    <td>${userAddress.consignee}</td>
                    <td>${userAddress.zipcode}</td>
                    <td>${userAddress.phone}</td>
                    <td>${userAddress.address}</td>
                    <td>
                        <a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">删除</a>
                        <a class="btn btn-info btn-xs" href="${ctx}/order/view/${order.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3">
            <form:form id="inputForm" role="form" action="${ctx}/user/userAddress/add"
                       method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">收货人</label>
                    <div class="col-sm-10">
                        <input minlength="6" required class="form-control" type="text" id="consignee" name="consignee"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电话</label>

                    <div class="col-sm-10">
                        <input type="number" required class="form-control" type="text" id="phone" name="phone"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">邮编</label>

                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="zipcode" name="zipcode"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">地址</label>

                    <div class="col-sm-10">
                        <textarea class="form-control" name="note"></textarea>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
<script>
    $(function () {
        alert(${ctx});
    });
</script>
</body>
</html>