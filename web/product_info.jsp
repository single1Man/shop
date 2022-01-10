﻿<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品详情</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<style type="text/css">
			body {
				margin-top: 20px;
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
					<img src="img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${username!=null}">
							<li><p>欢迎${username}
							</p></li>
							<li><a href="${pageContext.request.contextPath}/loginOutServlet">退出登录</a></li>
							<li><a href="cart.htm">购物车</a></li>
							<li><a href="favorite.jsp">商品收藏夹</a></li>
						</c:if>
						<c:if test="${username==null}">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.jsp">注册</a></li>
							<li><a href="cart.htm">购物车</a></li>
						</c:if>
					</ol>
				</div>
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
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#">手机数码<span class="sr-only">(current)</span></a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li>
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>


		<div class="container">
			<div class="row">
				<div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
					<a href="./index.jsp">首页&nbsp;&nbsp;&gt;</a>
					<a href="./蔬菜分类.htm">蔬菜&nbsp;&nbsp;&gt;</a>
					<a>无公害蔬菜</a>
				</div>

				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${pageContext.request.contextPath }/${product.pimage}">
					</div>

					<div class="col-md-6">
						<div><strong>${product.pname}</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>编号：${product.pid}</div>
						</div>

						<div style="margin:10px 0 10px 0;">商场价: <strong style="color:#ef0101;">￥：${product.shop_price}</strong> 市场价价： <del>￥${product.market_price}</del>
						</div>

						<div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)" style="background-color: #f07373;">限时抢购</a> </div>

						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							<div style="margin:5px 0 10px 0;">白色</div>
							<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
								<input id="quantity" name="quantity" value="1" maxlength="4" size="10" type="text"> </div>
							<div style="margin:20px 0 10px 0;;text-align: center;">
								<a href="cart.htm">
									<input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="button">
								</a> &nbsp;
								<c:if test="${isCollected==null}">
                                    <c:if test="${username!=null}">
                                        <a href="${pageContext.request.contextPath }/addCollectServlet?username=${username}&pid=${product.pid}">收藏商品</a>
                                    </c:if>
                                    <c:if test="${username==null}">
                                        <a href="login.jsp">请登陆后,收藏商品</a>
                                    </c:if>
								</c:if>
								<c:if test="${isCollected!=null}">
                                    <c:if test="${username==null}">
                                        <a href="login.jsp">请登陆</a>
                                    </c:if>
                                    <c:if test="${username!=null}">
                                        <a href="${pageContext.request.contextPath }/deleteCollectServlet?username=${username}&pid=${product.pid}">取消收藏</a>
                                    </c:if>

								</c:if>
							</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>商品介绍</strong>
					</div>

					<div>
						<img style="height: 500px;width: 930px" src="${pageContext.request.contextPath }/${product.pimage }">
					</div>

					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>商品参数</strong>
					</div>
					<div style="margin-top:10px;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<a>${product.pdesc}</a>
								</tr>
							</tbody>
						</table>
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品评论</strong></th>
								</tr>
								<tr class="warning">
									<th>暂无商品评论信息
										<c:if test="${username==null}">
											<a href="login.jsp">[请登陆后,发表商品评论]</a>
										</c:if>
										<c:if test="${username!=null}">
											<button type="button" id="clickpl">[发表商品评论]</button>
												<div id="opts"></div>
												<div id="showContent"></div>
										</c:if>
									</th>
								</tr>
							</tbody>
						</table>
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品咨询</strong></th>
								</tr>
								<tr class="warning">
									<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="./image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
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
	<script type="module">
		import reg from '/js/gl.js';
		$("#clickpl").click(function() {
			var htm = "";
			htm += "    <div class='row'>";
			htm += "    <div class='form-group'>";
			htm += "    <div class='col-md-4 col-sm-4  col-xs-4'>";
			htm += "    <input type='text' class='form-control number' placeholder='请输入评论' name='content' id='ajaxContent'>";
			htm += "    </div></div>";
			htm += "</div>";
			$('#opts').append(htm);
            $('#ajaxContent').blur(function(){
                $.ajax( {
                    url:'commentServlet?username=${username}&pid=${product.pid}',
                    dataType : "json",
                    data:{
                        content : $(this).val()
                    },
                    type:'post',
                    success:function(data,textStatus) {
						var objs=eval(data);
						var bd="";
						bd+="<table border='2'>";
						bd+="<tr></tr>";
						bd+="<tr>";
						bd+="<th>评论人</th>";
						for (let i=0;i<objs.length;i++){
							bd+="<th>"+objs[i].username+"</th>";
						}
						bd+="<tr></tr>";
						bd+="<tr>";
						bd+="<th>评论内容</th>";
						for (let i=0;i<objs.length;i++){
							objs[i].content=objs[i].content.replace(reg.reg,"***")
							bd+="<th>"+objs[i].content+"</th>";
						}
						bd+="<tr></tr>";
						bd+="<tr>";
						bd+="<th>评论时间</th>";
						for (let i=0;i<objs.length;i++){
							bd+="<th>"+objs[i].date+"</th>";
						}
						bd+="<tr></tr>";
						bd+="</table>";
						$('#showContent').append(bd);
                    }
                });
            })
		});
	</script>
</html>