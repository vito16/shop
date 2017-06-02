<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>公告管理</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <%@ include file="/common/include-base-js.jsp" %>
    <script src="${ctx }/js/news.js" type="text/javascript"></script>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <%@include file="/common/admin-admin-nav.jsp" %>
    <div class="row">
        <div id="addNewsSuccess" style="display: none" class="alert alert-success">添加成功</div>
        <table class="table table-responsive table-striped">
                <thead>
                <tr>
                    <td>日期</td>
                    <td>公告标题</td>
                    <td>操作</td>
                </tr>
                </thead>
            <tbody>
            <c:forEach items="${page.result}" var="news">
                <tr pid="${news.id}">
                    <td>${news.createTime}</td>
                    <td>${news.title}</td>
                    <td><a class="btn btn-info btn-xs" href="${ctx}/admin/news/${order.id}">查看</a> <a class="btn btn-info btn-xs del-news-btn">修改</a> <a class="btn btn-info btn-xs del-news-btn">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-center">
        <tags:pagination page="${page}" paginationSize="${page.pageSize}"/>
    </div>
    <a class="btn btn-primary" href="${ctx}/admin/news/new">添加</a>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
</body>
</html>