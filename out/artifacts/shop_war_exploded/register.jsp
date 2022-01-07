<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"  content=""/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>用户注册</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css"/>
		<script type="text/javascript" src="js/check.js"></script>
		<style type="text/css">
			body{
				margin: 0 auto;
			}
			.carousel-inner .item img{
				width:100%;
				height:300px;
			}
			.container .row div{
				/* position:relative;
                float:left; */
			}
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>
	<body>
			<!--
            	时间：2015-12-30
            	描述：菜单栏-->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="img/logo2.png"  alt=""/>
				</div>
				<div class="col-md-5">
					<img src="img/header.png"  alt=""/>
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<li><a href="login.jsp">登录</a></li>
						<li><a href="register.jsp">注册</a></li>
						<li><a href="cart.htm">购物车</a></li>
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
							<form class="navbar-form navbar-right" role="search" action="" method="post">
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

<div class="container" style="width:100%;background:url('image/regist_bg.jpg');">
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>用户注册</font>USER REGISTER
		<form class="form-horizontal" style="margin-top:5px;" action="registerServlet" method="post" onsubmit="return checkAll()">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label" >用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" onblur="checkUsername()" onkeyup="checkUsername()">
			    </div>
				 <span id="span_username"></span>
			  </div>
			   <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码" onblur="checkPassword()" onkeyup="checkPassword()">
			    </div>
				   <span id="span_password"></span>
			  </div>
			   <div class="form-group">
			    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="请输入确认密码" onblur="checkConfirmPassword()" onkeyup="checkConfirmPassword()">
			    </div>
				   <span id="span_confirmPassword"></span>
			  </div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="telephone" id="phone" placeholder="请输入联系电话" onblur="checkPhone()" onkeyup="checkPhone()">
				</div>
				<span id="span_phone"></span>
			</div>
			  <div class="form-group">
			    <label for="email" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="email" name="email" placeholder="Email" onkeyup="checkEmail()" onblur="checkEmail()">
			    </div>
				  <span id="span_email"></span>
			  </div>
			 <div class="form-group">
			    <label for="name" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" onblur="checkName()" onkeyup="checkName()">
			    </div>
				 <span id="span_name"></span>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
				  <label class="radio-inline">
					  <input type="radio" name="sex" id="inlineRadio1" value="男" required="required"> 男
				  </label>
				  <label class="radio-inline">
					  <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
				  </label>
			  </div>
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control" id="date" name="birthday" required="required">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="code" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" required="required" id="code" name="code">
			    </div>
			    <div class="col-sm-2">
			    <img src="${pageContext.request.contextPath}/image/captcha.html" alt=""/>
			    </div>
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      	<input type="submit"  width="100" value="注册" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
					<span id="span_form" style="display: inline-block"></span>
			    </div>
			  </div>
			</form>
	</div>
	
<%--	<div class="col-md-2"></div>--%>
  
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
<script type="text/javascript">

</script>
</html>




