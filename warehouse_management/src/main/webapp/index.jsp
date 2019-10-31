<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>WAREHOUSE MANAGEMENT</h2>
	<form action="controller?operation=validate" method="POST">
		<table style="width: 100%">
			<tr>
				<th>Username:<input type="text" id="user" name="username"
					onkeyup="func()" placeholder="username" required></th>
			</tr>
			<tr>
				<th>Password:<input type="password" name="password"
					placeholder="password" required></th>
			</tr>
			<tr>
				<th><input type="submit" value="submit"><input
					type="button" value="back" onclick="history.back()"></th>
			</tr>
			<tr>
				<th></th>
			</tr>

		</table>

	</form>
	<script type="text/javascript">
	var a="<%= "hello"%>"
	</script>
</body>
</html>