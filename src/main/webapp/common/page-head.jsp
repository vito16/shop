<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="fl inl">
		<img src="${ctx}/images/logo.gif">
	</div>
	<div class="fl inl buyinfo">
		<c:if test="${not empty login_user}">
    		您好，${login_user.username}！<a href="user/cart">购物车</a>有<span class="bnum">2</span>件礼品，共计<span
				class="bnum">345</span>积分
		</c:if>
		<c:if test="${empty login_user}">
			<a href="${ctx }/user/login">登陆</a>|<a href="${ctx }/user/reg">注册</a>
		</c:if>
	</div>
	<div class="fr topnav">
		<span class="icorn03"></span><a class="fl ablack" href="">订单管理</a><span
			class="icorn04"></span><a class="fl ablack" href="user/profile">个人信息</a><a
			class="loginout fl" href="">[退出]</a><span class="clr"></span>
	</div>
	<span class="clr"></span>
</div>