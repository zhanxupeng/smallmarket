<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="StyleCss.css" type="text/css">
<title>Insert title here</title>
<style>
.zhengwen{
	font-family:宋体;
	font-size:21px;
	color:black;
}
.biao{
	font-family:宋体;
	font-size:30px;
	color:red;
}
</style>
</head>
<body>
<img src="image/daohang.jpg" width="100%" height="150px"/>
<p class="biao">查询结果：</p>
<center>
	<table>
		<c:forEach items="${list }" var="commodity">
			<tr height="150px">
				<td>
					<img src="image/${commodity.picture }"  height="150px" width="150px">
				</td>
				<td class="zhengwen">
					<a href="CommodityIdSearchServlert?id=${commodity.id }">
					${commodity.name }</a><br>
					详情：${commodity.detail }<br>
					价格：${commodity.price }<br>
					库存：${commodity.number }
				</td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>