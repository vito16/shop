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
    <%@include file="/common/header-nav.jsp" %>
	<div class="container">
        <div>
                <div class="form-group">
                    <label>商品名称：</label>${product.title}
                </div>
                <div class="form-group">
                    <label>商品价格：</label>
                </div>
                <div class="form-group">
                    <label>商品简介：</label>
                </div>
        </div>

    </div> <!-- /container -->

    <%@include file="/common/footer.jsp" %>
	<%@ include file="/common/include-base-js.jsp"%>
</body>
</html>