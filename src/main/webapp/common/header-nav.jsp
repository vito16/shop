<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">小小商店</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${ctx}/">首页</a></li>
                <li><a href="${ctx}/product/">商品</a></li>
                <li><a href="${ctx}/news/">公告</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${not empty login_user}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    ${login_user.username}
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${ctx}/user/profile">个人设置</a></li>
                                <li><a href="${ctx}/user/logout">登出</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:when test="${not empty login_admin}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    ${login_admin.username}
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${ctx}/admin/product">后台管理</a></li>
                                <li><a href="${ctx}/admin/logout">登出</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${ctx}/user/login">登陆</a></li>
                        <li><a href="${ctx}/user/reg">注册</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="navbar-form navbar-right" role="cart">
                <a href="${ctx}/cart/" class="btn btn-info">购物车</a>
            </form>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>