<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>商品添加</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <form:form id="inputForm" role="form" action="${ctx}/admin/product/new"
                   method="post" class="form-horizontal" enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-sm-2 control-label">商品名称</label>
                <div class="col-sm-10">
                    <input minlength="6" required class="form-control" type="text" id="title" name="title"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">商品价格</label>

                <div class="col-sm-10">
                    <input type="number" required class="form-control" type="text" id="point" name="point"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">商品编码</label>

                <div class="col-sm-10">
                    <input class="form-control" type="text" id="code" name="code"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">商品型号</label>

                <div class="col-sm-10">
                    <input class="form-control" type="text" id="model" name="model"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">商品库存</label>

                <div class="col-sm-10">
                    <input class="form-control" required type="number" id="stock" name="stock"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="imgFile">封面图片</label>
                <div class="col-sm-10">
                    <input type="file" id="imgFile" name="imgFile">
                    <p class="help-block">图片不能超过1MB.</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">商品简介：</label>

                <div class="col-sm-10">
                    <textarea class="form-control" name="note"></textarea>
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">保存</button>
            </div>
        </form:form>
    </div>
</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/common/bootstrap/js/jqBootstrapValidation.js" type="text/javascript"></script>
<script>
    $(function () { $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); } );
</script>
</body>
</html>