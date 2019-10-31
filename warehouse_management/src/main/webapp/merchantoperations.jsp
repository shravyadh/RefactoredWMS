<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.comakeit.wms.bean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<title>View Orders</title>
</head>
<body>
	<h2>WAREHOUSE MANAGEMENT</h2>
	<h3>
		<%
			Login login = (Login) session.getAttribute("login");
		%>
		Welcome
		<%=login.getUsername()%></h3>
	<form action="MerchantOperation?operation=list" method="post">

		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			<table style="width: 80%" id="a">
				<tr>
					<th>Order Id</th>
					<th>date</th>
					<th>merchant_name</th>
					<th>quantity</th>
					<th>item_code</th>
					<th>status</th>
				</tr>

				<%
					@SuppressWarnings("unchecked")
					List<ItemOrder> itemorders = (List<ItemOrder>) session.getAttribute("itemorders");
					for (ItemOrder item : itemorders) {
				%>
				<tr>
					<td><%=item.getOrderid()%></td>
					<td><%=item.getDate()%></td>
					<td><%=item.getMerchant_name()%></td>
					<td><%=item.getQuantity()%></td>
					<td><%=item.getItem().getItem_code()%></td>
					<td><%=item.getStatus()%></td>
					<% if(!item.getStatus().equals("Accept")&&!item.getStatus().equals("Cancel")){%>
					<td><a
						href="MerchantOperation?operation=accept&id=<%=item.getOrderid()%>&quantity=<%=item.getQuantity()%>&item=<%=item.getItem().getItem_code()%>">Accept</a></td>
					
					<td><a
						href="MerchantOperation?operation=cancel&id=<%=item.getOrderid()%>">Cancel</a></td>
					<%} %>
				</tr>

				<%
					}
				%>
			</table>
		</div>

	</form>

</body>
</html>