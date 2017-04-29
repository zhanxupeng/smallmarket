<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<table>
		<tr>
			<td>用户名：</td>
			<td>
				${user.name }
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td>
				${user.password }
			</td>
		</tr>
		<tr>
			<td colspan="2">我的订单：</td>
		</tr>
		<c:forEach items="${list }" var="orders">
			<tr>
				<td>
					<img src="image/${orders.picture }"  height="150px" width="150px">
				</td>
				<td>
					${orders.name }
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<a href="updateuser.jsp">修改个人信息</a>
			</td>
		</tr>
	</table>
</center>
</body>
</html>