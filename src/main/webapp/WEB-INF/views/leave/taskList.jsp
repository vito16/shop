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
					<ul class="nav navbar-nav">
						<li><a href="${ctx}/">首页</a></li>
						<li><a href="${ctx}/leave/apply">启动流程</a></li>
						<li class="active"><a href="${ctx}/leave/todo">任务处理</a></li>
						<li><a href="${ctx}/leave/history">历史任务</a></li>
					</ul>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="#"></a>
					</li>
					<li class="dropdown">
						 <a href="#" class="dropdown-toggle" data-toggle="dropdown">你好，Vito<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">账号管理</a>
							</li>
							<li>
								<a href="#">登陆</a>
							</li>
							<li>
								<a href="#">登出</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<div class="col-md-12">
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">${message}</div>
				<!-- 自动隐藏提示信息 -->
				<script type="text/javascript">
					setTimeout(function() {
						$('#message').hide('slow');
					}, 5000);
				</script>
			</c:if>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>假种</th>
						<th>申请时间</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>流程名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${leaveList}" var="leave">
						<c:set var="task" value="${leave.task }" />
						<c:set var="pi" value="${leave.processInstance }" />
						<tr>
							<th>${leave.leaveType}</th>
							<th>${leave.createTime }</th>
							<th>${leave.startDateStr }</th>
							<th>${leave.endDateStr }</th>
							<th>${task.name}</th>
							<th>
								<a href="${ctx}/leave/audit/${leave.leaveID}/true" class="btn btn-link">允许</a>
								<a href="${ctx}/leave/audit/${leave.leaveID}/false" class="btn btn-link">拒绝</a>
							</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="footer text-center">
			<br>
			<p>&copy; Vito16 2013</p>
		</div><!-- /footer -->

	</div><!-- /container -->

	<%@ include file="/common/include-base-js.jsp"%>
</body>
</html>