<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/global.jsp"%>
<title>主页</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/include-base-styles.jsp"%>
<%@ include file="/common/include-base-js.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx}/css/index.css" />
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
					<li><a href="${ctx}/">首页</a></li>
					<li class="active"><a href="${ctx}/leave/apply">启动流程</a></li>
					<li><a href="${ctx}/leave/todo">任务处理</a></li>
					<li><a href="${ctx}/leave/history">历史任务</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${not empty login_user}">
						<li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                飞夺
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">设置</a></li>
                                <li><a href="#">登陆</a></li>
                                <li><a href="${ctx}/user/exit">登出</a></li>
                            </ul>
						</li>
					</c:if>
					<c:if test="${empty login_user}">
						<ul class="nav navbar-nav">
							<li><a href="${ctx}/user/login">登陆</a></li>
							<li><a href="${ctx}/user/reg">注册</a></li>
						</ul>
					</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<div class="col-md-6 col-md-offset-3">
			<c:if test="${not empty deploy}">
				<div id="deploy" class="alert alert-success">部署成功</div>
				<!-- 自动隐藏提示信息 -->
				<script type="text/javascript">
					setTimeout(function() {
						$('#deploy').hide('slow');
					}, 5000);
				</script>
			</c:if>
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">流程启动成功</div>
				<!-- 自动隐藏提示信息 -->
				<script type="text/javascript">
					setTimeout(function() {
						$('#message').hide('slow');
					}, 5000);
				</script>
			</c:if>
			<c:if test="${not empty errorMessage}">
				<div id="errorMessage" class="alert alert-success">流程启动失败</div>
				<!-- 自动隐藏提示信息 -->
				<script type="text/javascript">
					setTimeout(function() {
						$('#errorMessage').hide('slow');
					}, 5000);
				</script>
			</c:if>

			<form:form id="inputForm" role="form" action="${ctx}/leave/startProcess"
				method="post" class="form-horizontal">
					<div class="form-group">
					    <label>请假类型：</label>
					    <select id="leaveType" class="form-control" name="leaveType">
									<option>公休</option>
									<option>病假</option>
									<option>调休</option>
									<option>事假</option>
									<option>婚假</option>
						</select>
					  </div>
					  <div class="form-group">
					    <label>开始时间：</label>
					    <input class="form-control" type="text" id="startDate" name="startDate" />
					  </div>
					  <div class="form-group">
					    <label>结束时间：</label>
					    <input class="form-control" type="text" id="endDate" name="endDate" />
					  </div>
					  <div class="form-group">
					    <label>请假原因：</label>
					    <textarea class="form-control" name="reason"></textarea>
					  </div>
			  			<button type="submit" class="btn btn-default">提交申请</button>
                        <a href="${ctx}/leave/deploy">重新部署流程</a>
				</form:form>
			</div>
			<script>
				$(function(){
					$('#startDate,#endDate').datetimepicker({
                        autoclose: true,
					    format: "yyyy-mm-dd",
                        minView:3,
                        todayBtn: true
					}).attr("readonly","readonly");
				})
			</script>
		</div>

		<div class="footer text-center">
			<br>
			<p>&copy; Vito16 2013</p>
		</div><!-- /footer -->

	</div><!-- /container -->

	<%@ include file="/common/include-base-js.jsp"%>
</body>
</html>