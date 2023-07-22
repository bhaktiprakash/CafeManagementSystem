<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Confirmation</title>
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <link rel="stylesheet" href="confirmationg.css" />
    <link rel="stylesheet" href="confirmation.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Gothic A1:wght@500;800&display=swap"
    />
  </head>
  <body>
    <div class="confirmation">
      
      <img class="confirmation-child" alt="" src="pictures/kerker.png" />
      <form action="confirm" method="post">
      <div class="confirmation-item"></div>
      
      <div class="cart"><span>Cart</span>
        <div class="row">
          <table style="width:315%">
              <tr>
                  <th>S.No.</th>
                  <th>Items</th>
                  <th>Quantity</th>
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
            	  <td><input type="text" name="quantity" class="txtbox"></td>
             </tr>
             <% i++;
             	}
                }catch(Exception e) {
       			System.out.println(e);
       		}%> 
          
          </table>
      </div></div>
      <img
        class="trolley-removebg-preview-1-icon"
        alt=""
        src="pictures/trolley.png"
      />
      <button type="submit" class="confirmation-child1">CONFIRM</button>
      </form>
      <div class="menu-removebg-preview-1-parent">
      <img
            class="note"
            alt=""
            src="pictures/note.png"
      />
      </div>
    </div>
  </body>
</html>