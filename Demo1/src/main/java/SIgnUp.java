

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

/**
 * Servlet implementation class SIgnUp
 */
@WebServlet("/signup")
public class SIgnUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try{
			String name=request.getParameter("name");
			long mob=Long.parseLong(request.getParameter("mobile"));
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","bhakti","1234");
			//PrintWriter out = response.getWriter();
			if(con!=null){
				System.out.println("Connected...");
			}
			else
				System.out.println("Not connected...");
            String qry = "INSERT INTO user1 VALUES('"+name+"',"+mob+",'"+email+"','"+pass+"')";
            Statement smt = con.createStatement();
            int i = smt.executeUpdate(qry);
            System.out.print(i+"\n");
            if(i>0){
                response.sendRedirect("signupsuccess.html");
            }
			con.close();
		}catch(Exception ee){
			System.out.println(ee);
		}
	}
}
