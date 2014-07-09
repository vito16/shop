<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>用户注册</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <c:if test="${not empty error}">
        <div id="error" class="alert alert-success">${error}</div>
        <script type="text/javascript">
            setTimeout(function () {
                $('#error').hide('slow');
            }, 4000);
        </script>
    </c:if>
    <form:form role="form" action="${ctx}/user/reg"
               method="post" id="regForm" class="form-signin">
        <h2 class="form-signin-heading">用户注册</h2>

        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="账号" required autofocus>
        </div>
        <div class="form-group">
            <input type="password"  class="form-control" minlength="6" name="password" placeholder="密码" required>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        </div>

    </form:form>
</div>
<!-- /container -->

<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/login.js" type="text/javascript"></script>
</body>
</html>