<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="rela">
	<div class="abs tit fb14">
		<a href="">热门兑换</a>
	</div>
	<div class="box">
		<ul class="ul_hotexc mt">
			<c:forEach var="product" items="${popProductList}" begin='0' end='2'>
				<li>
					<div class="proimg_exchot">
						<a href=""><img src="${product.picUrl}" /></a>
					</div>
					<div class="box_pro01">
						<div class="proname_exchot">
							<a href="">${product.title}</a>
						</div>
						<div class="col01">
							积分：<b>${product.point}分</b>
						</div>
					</div> <span class="clr"></span>
				</li>
			</c:forEach>
		</ul>
		<span class="clr"></span>
	</div>
</div>