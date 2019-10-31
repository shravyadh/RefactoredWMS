<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.comakeit.wms.controller.*,com.comakeit.wms.bean.*"
	import="javax.servlet.http.HttpServletResponse"
	import="javax.servlet.http.HttpServletRequest" import="java.util.*,java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 25%;
	background-color: #f1f1f1;
	height: 100%;
	position: fixed;
	overflow: auto;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
	background-color: #555;
	color: white;
}

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

input {
	margin-bottom: 10px;
	diplay: block;
}
</style>
<title>Admin operations</title>
</head>
<body>
	<h2>WAREHOUSE MANAGEMENT</h2>
	<h3>
		<%
			Login login = (Login) session.getAttribute("login");
		%>
		Welcome
		<%=login.getUsername()%></h3>
	<div>
		<ul>
			<li><a href="AdminOperations?operation=ViewItems">List Items</a></li>
			<li><a href="adminoperations.jsp?operation=ViewCustomers">Display
					customer details</a></li>
			<li><a href="adminoperations.jsp?operation=add">Add Customer</a></li>
			<li><a href="adminoperations.jsp?operation=deletecustomer">Delete
					Customer</a></li>
			<li><a href="adminoperations.jsp?operation=deleteitem">Delete
					Item</a></li>
			<li><a href="adminoperations.jsp?operation=stock">Add stock</a></li>
			<li><a href="adminoperations.jsp?operation=ViewPurchases">Display
					Purchase Details</a></li>
			<li><a href="AdminOperations?operation=itemorders">Display
					Item Orders</a></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
	</div>

	<%
		String operation = (String) request.getParameter("operation");
		if (operation != null) {
			System.out.println(operation);
			if (operation.equals("add")) {
	%>

	<form name="myForm" action="AdminOperations?operation=add"
		method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			Name:<input type="text" name="name" required><br>
			Contact details:<input type="tel" pattern="^\+{0,2}([\-\. ])?(\(?\d{0,3}\))?([\-\. ])?\(?\d{0,3}\)?([\-\. ])?\d{3}([\-\. ])?\d{4}" name= "phoneno" id="s"
				required><br> Address:<input type="text" name="address"
				required><br> <input type="submit" value="submit"><br>
			<input type="button" value="back" onclick="history.back()">
		</div>
	</form>

	<%
		} else if (operation.equals("ViewItems")) {
	%>

	<form action="AdminOperations?operation=ViewItems" method="post">
	</form>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<table style="width: 80%" id="a">
			<tr>
				<th>Item Name</th>
				<th>Item Price</th>
				<th>Order</th>
			</tr>


			<%
				@SuppressWarnings("unchecked")
						List<Item> items = (List<Item>) session.getAttribute("items");
					 if(items != null){
						for (Item item : items) {
			%>

			<tr>
				<td><%=item.getItem_name()%></td>
				<td><%=item.getItem_price()%></td>
				<td><a
					href="adminoperations.jsp?operation=order&id=<%=item.getItem_code()%>">Order
						Now</a></td>

			</tr>

			<%
				}}else{
				
			%>
			<h3 style="margin-left: 25%; padding: 1px 16px; height: 1000px;">No items to display.</h3>
			<% } %>
		</table>
	</div>

	<%
		} else if (operation.equals("ViewCustomers")) {
	%>

	<form action="AdminOperations?operation=ViewCustomers" method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			Customer Code:<input type="text" name="code" required><br>
			<input type="submit" value="submit">
		</div>
	</form>

	<%
		} else if (operation.equals("viewCustomers")) {
	%>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<table style="width: 80%" id="a">
			<tr>
				<th>Customer Name</th>
				<th>Address</th>
				<th>Phone Number</th>
			</tr>

			<%
				@SuppressWarnings("unchecked")
						List<Customer> customers = (List<Customer>) session.getAttribute("customers");
						System.out.println(customers);
						for (Customer c : customers) {
			%>
			<tr>
				<td><%=c.getCustomer_name()%></td>
				<td><%=c.getAddress()%></td>
				<td><%=c.getPhone_number()%></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>

	<%
	
		} else if (operation.equals("deletecustomer")) {
	%>

	<form action="AdminOperations?operation=deletecustomer" method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

			Customer Name:<input type="text" name="customername" required><br>
			<input type="submit" value="submit">
		</div>
	</form>

	<%
		}

			else if (operation.equals("stock")) {
	%>

	<form action="AdminOperations?operation=stock" method="post">

		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			Item Name:<input type="text" name="item" required><br>
			Quantity:<input type="text" name="quantity" required><br> <br>
			<input type="submit" value="submit">
		</div>
	</form>

	<%
		} else if (operation.equals("order")) {
	%>
	<form
		action="AdminOperations?operation=order&id=<%=Integer.parseInt(request.getParameter("id"))%>"
		method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			Customer Code:<input type="text" name="code" required><br>
			Quantity:<input type="text" name="quantity" required><br> <input
				type="submit" value="submit">
		</div>
	</form>

	<%
		} else if (operation.equals("ViewPurchases")) {
	%>
	<form action="AdminOperations?operation=ViewPurchases" method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
			Date : <input type="date" name="date" max="<%=LocalDate.now().getYear()+1%>-12-31" min="<%=LocalDate.now() %>" required><br> <input
				type="submit" value="submit">

		</div>
	</form>

	<%
		} else if (operation.equals("viewPurchases")) {
	%>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<table style="width: 80%" >
			<tr>
				<th>transaction_id</th>
				<th>date_Of_purchase</th>
				<th>quantity_purchased</th>
				<th>customer_name</th>
				<th>item_code</th>
				<th>total</th>
			</tr>

			<%
				@SuppressWarnings("unchecked")
						List<Purchase> purchases = (List<Purchase>) session.getAttribute("purchases");
						for (Purchase purchase : purchases) {
							
			%>

			<tr>
				<td><%=purchase.getTransaction_id()%></td>
				<td><%=purchase.getDate_Of_purchase()%></td>
				<td><%=purchase.getQuantity_purchased()%></td>
				<td><%=purchase.getCustomer().getCustomer_name()%></td>
				<td><%=purchase.getItem().getItem_name()%></td>
				<td><%=purchase.getTotal()%></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>

	<%
		}
			if (operation.equals("deleteitem")) {
	%>
	<form action="AdminOperations?operation=deleteitem" method="post">
		<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

			Item Name:<input type="text" name="itemname" required><br> <input
				type="submit" value="submit">
		</div>
	</form>

	<%
		}
			if (operation.equals("itemorders")) {
	%>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<table style="width: 80%" id="a">
			<tr>
				<th>date</th>
				<th>merchant_name</th>
				<th>quantity</th>
				<th>item_name</th>
				<th>status</th>
			</tr>

			<%
					@SuppressWarnings("unchecked")
							List<ItemOrder> itemorders = (List<ItemOrder>) session.getAttribute("itemorders");
							for (ItemOrder item : itemorders) {
				%>
			<tr>
				<td><%=item.getDate()%></td>
				<td><%=item.getMerchant_name()%></td>
				<td><%=item.getQuantity()%></td>
				<td><%=item.getItem().getItem_name()%></td>
				<td><%=item.getStatus()%></td>

			</tr>

			<%
					}
				%>
		</table>
	</div>

	<%}} %>
	<script type="text/javascript">

</script>
</body>
</html>