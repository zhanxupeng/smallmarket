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
	银行卡支付页面：
	<form action="ShoppingServlet" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<input type="hidden" name="number" value="${number }"/>
		<table>
			<tr>
				<td>账号：</td>
				<td>
					<input type="text" name="cardid">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<c:if test="${message !=null }">
			<tr>
				<td colspan="2">
					<p style="color: red">${message }</p>
				</td>
			</c:if>	
			<tr>
				<td colspan="2">
					<input type="submit" value="支付">
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>