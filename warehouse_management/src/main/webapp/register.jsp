<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.comakeit.wms.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%Customer customer=(Customer)session.getAttribute("customer"); %>
<body>
<h1>Registration Successful! :). Your id is <%=customer.getCustomer_code() %></h1>
</body>
</html>