<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>管理员登陆</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login.css"/>
</head>

<body>

<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <form:form role="form" action="${ctx}/admin/login"
               method="post" id="loginForm" class="form-signin">
        <!-- 自动隐藏提示信息 -->
        <c:if test="${not empty param.errorPwd}">
            <div id="errorPwd" class="alert alert-success">密码错误...</div>
            <!-- 自动隐藏提示信息 -->
            <script type="text/javascript">
                setTimeout(function () {
                    $('#errorPwd').hide('slow');
                }, 5000);
            </script>
        </c:if>
        <!-- 自动隐藏提示信息 -->
        <c:if test="${not empty param.error}">
            <div id="error" class="alert alert-success">管理员未登录或会话失效...</div>
            <!-- 自动隐藏提示信息 -->
            <script type="text/javascript">
                setTimeout(function () {
                    $('#error').hide('slow');
                }, 5000);
            </script>
        </c:if>

        <h2 class="form-signin-heading">管理员登陆</h2>

        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="账号" required autofocus>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="密码" required>
        </div>
        <%--<div class="form-group">
            <label class="checkbox">
                <input type="checkbox" name="remember">自动登陆
            </label>
        </div>--%>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        </div>

    </form:form>
</div>
<!-- /container -->

<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/login.js" type="text/javascript"></script>
</body>
</html>