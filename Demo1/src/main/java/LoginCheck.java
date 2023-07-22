

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email=request.getParameter("email");
			String pass=request.getParameter("password");
			response.getWriter().append(email+" "+pass);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","bhakti","1234");
			if(con!=null){
				System.out.println("Connected..");
			}
            String qry = "SELECT * FROM user1";
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery(qry);
            while(rs.next()){
            	String email1=rs.getString("email");
            	String pass1=rs.getString("password");
            	if(email.equals(email1) && pass.equals(pass1))
            		response.sendRedirect("Menu.html");
            	else if(email.equals(email1)) {
            		response.setContentType("text/html"); 
            		PrintWriter out = response.getWriter(); 
            		out.println("<script type=\"text/javascript\">"); 
            		out.println("alert('Incorrect Password');"); 
            		out.println("location='index.html';"); 
            		out.println("</script>"); 
            	}else {
            		response.setContentType("text/html"); 
            		PrintWriter out = response.getWriter(); 
            		out.println("<script type=\"text/javascript\">"); 
            		out.println("alert('Incorrect Email');"); 
            		out.println("location='index.html';"); 
            		out.println("</script>"); 
            	}
            }
		}catch(Exception ee) {
			System.out.println(ee);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
