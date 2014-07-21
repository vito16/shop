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
                    <td><a class="btn btn-info btn-xs">查看</a> <a class="btn btn-info btn-xs">修改 <a class="btn btn-info btn-xs">删除</a></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3">
            <form:form id="inputForm" role="form" action="${ctx}/news/add"
                       method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-10">
                        <input minlength="6" required class="form-control" type="text" id="title" name="title"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">内容</label>

                    <div class="col-sm-10">
                        <textarea class="form-control" name="content" id="content"></textarea>
                    </div>
                </div>
                <div class="text-center">
                    <button type="button" id="addAddressBtn" class="btn btn-primary">保存</button>
                </div>
            </form:form>
        </div>

    </div>
    <div class="text-center">
        <tags:pagination page="${page}" paginationSize="${page.pageSize}"/>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
</body>
</html>