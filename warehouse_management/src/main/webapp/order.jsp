<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Placed</title>
</head>
<body>
<%double price=(double)session.getAttribute("price"); %>
<h1>Your total is : <%=price %></h1>
</body>
</html>