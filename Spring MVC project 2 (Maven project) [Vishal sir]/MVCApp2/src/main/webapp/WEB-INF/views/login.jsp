<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

</head>
<body bgcolor="cornsilk" style="font: 14pt font-family: monospace">
	<h1 style="color: green">${commonHeader}</h1>
	<hr>
	<h3 style="color: green">Login Form</h3>
	<form action="process" method="get">
		<table border="2">
			<tr>
				<th style= "color: blue">Login</th>
				<td style= "color: red" input type="text" name="loginName"></td>
			</tr>
			<tr>
				<th style= "color: blue">Password</th>
				<td style= "color: red" input type="password" name="Password"></td>
			</tr>
			<tr>
				<td colspan="20" input type="submit" name="Enter"></td>
			</tr>
		</table>
	</form>
</body>
</html>