<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="ShopMessageServlet">
		<input type="hidden" name="id" value="${commodity.id }">
		<table>
			<tr height="150px">
				<td>
					<img src="image/${commodity.picture }"  height="150px" width="150px">
				</td>
				<td class="zhengwen">
					${commodity.name }<br>
					详情：${commodity.detail }<br>
					价格：${commodity.price }<br>
					库存：${commodity.number }
				</td>
			</tr>
			<tr>
				<td>
					购买数量：
					<input type="text" name="number">
				</td>
				<td>
					<input type="submit" value="购买">
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>