<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/global.jsp"%>
<title>主页</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/include-base-styles.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
	<div class="container">
		<div class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Vito16</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${ctx}/">首页</a></li>
						<li><a href="${ctx}/product/">商品</a></li>
						<li><a href="${ctx}/news/">公告</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${not empty login_user}">
	          				<li class="dropdown">
							    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
							      	我的账号
							    </a>
							    <ul class="dropdown-menu">
							      	<li><a href="#">设置</a></li>
						            <li><a href="#">登陆</a></li>
						            <li><a href="#">登出</a></li>
							    </ul>
							  </li>
						</c:if>
						<c:if test="${empty login_user}">
								<li><a href="${ctx}/user/login">登陆</a></li>
								<li><a href="${ctx}/user/reg">注册</a></li>
						</c:if>
					</ul>
				</div><!--/.nav-collapse -->
      	</div>
        <div>
            <form:form id="inputForm" role="form" action="${ctx}/product/new"
                       method="post" class="form-horizontal">
                <div class="form-group">
                    <label>商品名称：</label>
                    <input class="form-control" type="text" id="title" name="title" />
                </div>
                <div class="form-group">
                    <label>商品价格：</label>
                    <input class="form-control" type="text" id="point" name="point" />
                </div>
                <div class="form-group">
                    <label>商品简介：</label>
                    <textarea class="form-control" name="note"></textarea>
                </div>
                <button type="submit" class="btn btn-default">保存</button>
            </form:form>
        </div>

	  
	  <div class="footer text-center">
      	<br>
        <p>&copy; Company 2014</p>
      </div> <!-- /footer -->
      
    </div> <!-- /container -->
	
	<%@ include file="/common/include-base-js.jsp"%>
</body>
</html>