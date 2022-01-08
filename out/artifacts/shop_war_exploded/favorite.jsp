<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>收藏夹</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <script type="text/javascript">
        const list = "${collects}";
        if(list.length===0){
            location.href="${pageContext.request.contextPath}/findCollectsByUsernameServlet?username=${user.username}";
        }
    </script>
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
<div class="col-md-3" style="padding-top:20px">
    <ol class="list-inline">
        <c:if test="${user!=null}">
            <li><p>欢迎${user.username}
            </p></li>
            <li><a href="${pageContext.request.contextPath}/loginOutServlet">退出登录</a></li>
            <li><a href="cart.htm">购物车</a></li>
            <li><a href="product_list.jsp">首页</a></li>
        </c:if>
        <c:if test="${user==null}">
            <li><a href="login.jsp">登录</a></li>
            <li><a href="register.jsp">注册</a></li>
            <li><a href="cart.htm">购物车</a></li>
            <li><a href="product_list.jsp">首页</a></li>
        </c:if>
    </ol>
    <table>
        <tbody>

                <c:forEach items="${collects}" var="collect">
                <tr>
                    <td>
                        ${collect.productPid}&nbsp;
                    </td>
                    <td>
                         ${collect.productName}
                    </td>
                </tr>
                </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
