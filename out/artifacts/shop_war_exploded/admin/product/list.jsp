<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
	<title>商品列表</title>
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js" type="text/javascript"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">function addProduct(){
	window.location.href = "${pageContext.request.contextPath}/toAddProductServlet";}
</script>
<script type="text/javascript">
	const list = "${pageBean}";
	if(list.length===0){
		location.href="${pageContext.request.contextPath}/productPagingServlet?pageNumber=1";
	}
</script>

<body>
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/productPagingServlet?pageNumber=1" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
						<strong>商品列表</strong>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>
						<button type="button" id="deleteProducts">删除多个</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="4%">是否多选</td>
								<td align="center" width="17%">商品图片</td>
								<td align="center" width="17%">商品名称</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${pageBean.data }" var="product">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
										<input type="checkbox" value="${product.pid }">
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><img width="40" height="45" src="${pageContext.request.contextPath }/${product.pimage }">
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
										${product.pname}
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${product.shop_price}
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
										${product.is_hot==1?"是热门":"不是热门" }
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${ pageContext.request.contextPath }/toEditProductServlet?pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
									</a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${ pageContext.request.contextPath }/deleteProductServlet?pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<c:if test="${pageBean.pageNumber>1}">
									<li >
										<a href="${pageContext.request.contextPath  }/productPagingServlet?pageNumber=${pageBean.pageNumber-1}" aria-label="Previous">
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
										<li  class="active"><a href="${pageContext.request.contextPath  }/productPagingServlet?pageNumber=${i}">${i }</a></li>
									</c:if>
									<c:if test="${pageBean.pageNumber!=i}">
										<li><a href="${pageContext.request.contextPath  }/productPagingServlet?pageNumber=${i}">${i }</a></li>
									</c:if>
								</c:forEach>
								<c:if test="${pageBean.pageNumber<pageBean.totalPage}">
									<li>
										<a href="${pageContext.request.contextPath  }/productPagingServlet?pageNumber=${pageBean.pageNumber+1}" aria-label="Next">
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
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
<script type="text/javascript">
	$("#deleteProducts").click(function(){
		const pids = [];
		const all = $("input[type='checkbox']:checked");
		if(all.length===0){
			alert("请选择需要删除的商品");
			return false;
		}
		if(window.confirm("你是否确定要删除"+all.length+"个商品吗?")){
			for(let i=0; i<all.length; i++){
				const procut = all[i];
				const pid = procut.value;
				pids.push(pid);
			}
			const pidss = pids.join(",");
			//请求后台
			location.href="${pageContext.request.contextPath}/deleteProductsServlet?pids="+pidss;
		}else{
			$("input[type='checkbox']:checked").removeProp("checked")
		}
	});
</script>
</HTML>

