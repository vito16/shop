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
    <%@ include file="/common/include-base-js.jsp" %>
    <script src="${ctx }/js/userAddress.js" type="text/javascript"></script>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <%@include file="/common/user-admin-nav.jsp" %>
    <div class="row">
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
                <tr addressId="${userAddress.id}">
                    <td>${userAddress.consignee}</td>
                    <td>${userAddress.zipcode}</td>
                    <td>${userAddress.phone}</td>
                    <td>${userAddress.address}</td>
                    <td>
                        <a class="btn btn-info btn-xs delAddresslBtn" addressId="${userAddress.id}">删除</a>
                        <a class="btn btn-info btn-xs editAddresslBtn" addressId="${userAddress.id}">修改</a>
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
                        <textarea class="form-control" name="address" id="address"></textarea>
                    </div>
                </div>
                <div class="text-center">
                    <button type="button" id="addAddressBtn" class="btn btn-primary">保存</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<script>
    $(function(){
        $('#confirm_trigger').scojs_confirm();
    })
</script>
</body>
</html>