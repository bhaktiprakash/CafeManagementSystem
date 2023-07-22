

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try{
			int i;
			String items[]=request.getParameterValues("checked");
			int[] price= {0,0,0,0,0,0,0,0,0,0,0,0,0,0}; 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","bhakti","1234");
			if(con!=null){
				System.out.println("Connected..");
			}
		//	System.out.println(items.length);
			String qry = "SELECT * FROM MENU";
        	Statement smt = con.createStatement();

            for(i=0;i<items.length;i++) {
                ResultSet rs = smt.executeQuery(qry);
            	while(rs.next()) {
            		String itm=rs.getString("ITEM");
            		int pr=rs.getInt("PRICE");
            		//System.out.println(itm+pr);
            		if(items[i].equals(itm) ) {
            			price[i]=pr;
            		}
            	}
            }
            for(i=0;i<items.length;i++) {
            	qry="INSERT INTO cafeorder VALUES("+i+",'"+items[i]+"',NULL,"+price[i]+")";
            	smt.executeUpdate(qry);
            }
            response.sendRedirect("Confirmation.jsp");
		}catch(Exception ee) {
			System.out.println(ee);
		}
	}
}
