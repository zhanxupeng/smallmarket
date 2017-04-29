<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="StyleCss.css" type="text/css">
<title>Insert title here</title>
<style>
.biaoti{
	font-family:宋体;
	font-size:42px;
	color:red;
}
.zhengwen{
	font-family:宋体;
	font-size:21px;
	color:black;
}
</style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation"> 
    <div class="container-fluid"> 
    <div>
        <p class="navbar-text navbar-left"><a href="main.jsp">主页</a></p>
        <p class="navbar-text navbar-right"><a href="UserMessageServlet">
         ${user.name }
        </a>&nbsp;&nbsp;</p>
    </div> 
    </div> 
</nav>
<center>
<p class="biaoti">欢迎光临小商场市场</p>
<img src="image/cover.jpg">
<form action="CategorySeachServlet" method="get">
	<table height="100px">
		<tr>
			<td class="zhengwen">宝贝：</td>
			<td>
				<input type="text" name="category" class="zhengwen">
			</td>
			<td>
				<input type="submit" value="搜索" class="zhengwen">
			</td>
		</tr>
	</table>
</form>
</center>










</body>
</html>