<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill</title>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	table{
		margin: auto auto;
	}
	h2{
		text-align: center;
	}
</style>
</head>
<body>
	<h2>Silicon Cafe</h2>
	<table style="width:50%">
		<tr>
			<th>Sl.No</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Total Price</th>
		</tr>
	<% 
	try {
		int i=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","bhakti","1234");
		if(con!=null){
			System.out.println("Connected..");
		}
		String qry="SELECT * FROM CAFEORDER";
		Statement smt = con.createStatement();
		ResultSet rs= smt.executeQuery(qry);
		while(rs.next()){
	%>
		<tr>
			<td><%= i+1%></td>
			<td><%= rs.getString("ITEM")%></td>
			<td><%= rs.getString("QUANTITY")%></td>
			<td><%= rs.getString("PRICE")%></td>
		</tr>
	<% 
		i++;
		}
	}catch(Exception e) {
		System.out.println(e);
	}%> 
        </table>
</body>
</html>