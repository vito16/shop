<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>主页</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<div class="container">
    <%@include file="/common/header-nav.jsp" %>
    <div>
        <form:form id="inputForm" role="form" action="${ctx}/product/new"
                   method="post" class="form-horizontal">
            <div class="form-group">
                <label>商品名称：</label>
                <input class="form-control" type="text" id="title" name="title"/>
            </div>
            <div class="form-group">
                <label>商品价格：</label>
                <input class="form-control" type="text" id="point" name="point"/>
            </div>
            <div class="form-group">
                <label>商品简介：</label>
                <textarea class="form-control" name="note"></textarea>
            </div>
            <button type="submit" class="btn btn-default">保存</button>
        </form:form>
    </div>


</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>