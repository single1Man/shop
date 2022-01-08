<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>会员登录</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	<script type="text/javascript">
		const list = "${pageBean}";
		if(list.length===0){
			location.href="${pageContext.request.contextPath}/conditionQueryServlet?pageNumber=1";
		}
	</script>
	<style type="text/css">
		body {
			margin: 0 auto;
			width: 100%;
		}
		.carousel-inner .item img {
			width: 100%;
			height: 300px;
		}
	</style>
</head>

	<body>
		
			<!--
            	时间：2015-12-30
            	描述：菜单栏
            	-->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="img/logo2.png"/>
				</div>
				<div class="col-md-5">
					<img src="img/header.png"/>
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${user!=null}">
							<li><p>欢迎${user.username}
							</p></li>
							<li><a href="${pageContext.request.contextPath}/loginOutServlet">退出登录</a></li>
							<li><a href="cart.htm">购物车</a></li>
							<button data-toggle="modal" data-target="#myModal">${user.username}的优惠卷</button>
						</c:if>
						<c:if test="${user==null}">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.jsp">注册</a></li>
							<li><a href="cart.htm">购物车</a></li>
						</c:if>
					</ol>
				</div>
			</div>
			<%--优惠卷模态框--%>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">优惠卷</h4>
						</div>
						<div class="modal-body">
							<c:forEach items="${coupons}" var="coupon">
								<p>${coupon.coupon}</p>
							</c:forEach>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<form action="conditionQueryServlet" method="post">
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav">
									<li class="active"><a href="#">手机数码<span class="sr-only">(current)</span></a></li>
									<li><a href="#">电脑办公</a></li>
									<li><a href="#">电脑办公</a></li>
									<li><a href="#">电脑办公</a></li>
								</ul>
								<div class="navbar-form navbar-left" >
									<select name="cid" style="margin-top:10px">
										<option value="">--选择已经有的分类--</option>
										<c:forEach items="${allCategory}" var="c">
											<option ${product.cid==c.cid?"selected='selected'":"" } value="${c.cid }">${c.cname }</option>
										</c:forEach>
									</select>
								</div>
								<div class="navbar-form navbar-right" role="search">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Search" name="pname">
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</div>
							</div>
						</form>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>


		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
				</ol>
			</div>
			<c:forEach items="${pageBean.data }" var="product">
				<div class="col-md-2">
					<a href="${pageContext.request.contextPath }/toProductInfoServlet?pid=${product.pid}">
						<img src="${pageContext.request.contextPath }/${product.pimage }" width="170" height="170" style="display: inline-block;">
					</a>
					<p><a href="${pageContext.request.contextPath }/toProductInfoServlet?pid=${product.pid}" style='color:green'>${product.pname}</a></p>
					<p><font color="#FF0000">商城价：&yen;${product.shop_price}</font></p>
				</div>
			</c:forEach>
		</div>
		<!--分页 -->
		<div style="width:380px;margin: 50px auto 0;">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${pageBean.pageNumber>1}">
						<li >
							<a href="${pageContext.request.contextPath  }/conditionQueryServlet?pageNumber=${pageBean.pageNumber-1}&cid=${cid}&pname=${pname}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					<c:if test="${pageBean.pageNumber<=1}">
						<li class="disabled">
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
						<c:if test="${pageBean.pageNumber==i}">
							<li  class="active"><a href="${pageContext.request.contextPath  }/conditionQueryServlet?pageNumber=${i}&cid=${cid}&pname=${pname}">${i }</a></li>
						</c:if>
						<c:if test="${pageBean.pageNumber!=i}">
							<li><a href="${pageContext.request.contextPath  }/conditionQueryServlet?pageNumber=${i}&cid=${cid}&pname=${pname}">${i }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageBean.pageNumber<pageBean.totalPage}">
						<li>
							<a href="${pageContext.request.contextPath  }/conditionQueryServlet?pageNumber=${pageBean.pageNumber+1}&cid=${cid}&pname=${pname}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					<c:if test="${pageBean.pageNumber>=pageBean.totalPage}">
						<li class="disabled">
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
				</ul>
				第${pageBean.pageNumber}/${pageBean.totalPage}页
			</nav>
		</div>
			<!-- 分页结束=======================        -->

			<!--
                   商品浏览记录:
            -->
			<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

				<h4 style="width: 50%;float: left;font: 14px/30px  微软雅黑 ">浏览记录</h4>
				<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
				<div style="clear: both;"></div>

				<div style="overflow: hidden;">

					<ul style="list-style: none;">
						<li style="width: 150px;height: 216px;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
							<img src="products/1/cs10001.jpg" width="130px" height="130px"/></li>
					</ul>

				</div>
			</div>
			<div style="margin-top:50px;">
				<img src="./image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势"/>
			</div>

			<div style="text-align: center;margin-top: 5px;">
				<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 成信大商城 版权所有
		</div>

	</body>

</html>