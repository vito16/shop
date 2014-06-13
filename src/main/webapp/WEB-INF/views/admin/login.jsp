<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/global.jsp"%>
<title>管理员登陆</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/include-base-js.jsp"%>
<%@ include file="/common/include-base-styles.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
<script type="text/javascript">
<c:if test="${not empty param.error}">
	alert('用户名或密码错误！！！');
</c:if>
<c:if test="${not empty param.timeout}">
	alert('未登陆或超时！！！');
</c:if>
</script>
</head>

<body>
	<div class="wrap clearfix">
		<img class="mar_logo" src="${ctx}/images/logo1.gif" />
	</div>
	<div class="login">
		<div class="wrap logginbg clearfix">
			<div class="box_login">
				<form:form action="/admin/login" method="POST" commandName="admin">
					<div class="login_lab">管理员：</div>
					<span>--${fns:getConfig('productName')}---</span>
					<form:input cssClass="login_ipt wd10" path="username" value="admin"/>
					<span class="clr"></span>
					<div class="space1"></div>
					<div class="login_lab">密&nbsp;&nbsp;码：</div>
					<form:input cssClass="login_ipt wd10" path="password" value="000000"/>
					<span class="clr"></span>
					<div class="space3"></div>
					<input type="submit" class="sbt_login" value="登录后台" />
				</form:form>
			</div>
		</div>
	</div>
	<div class="martb01 ac">Copyright 2011-2015 渝ICP备09006056号</div>
</body>
</html>
