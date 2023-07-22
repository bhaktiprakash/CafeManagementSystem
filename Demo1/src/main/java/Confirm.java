

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm() {
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
		int i;
		int[] qun= {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(i=0;i<request.getParameterValues("quantity").length;i++)
			qun[i]=Integer.parseInt(request.getParameterValues("quantity")[i]);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","bhakti","1234");
			if(con!=null){
				System.out.println("Connected..");
			}
			String qry;
            Statement smt = con.createStatement();
            for(i=0;i<qun.length;i++){    
            	qry="UPDATE CAFEORDER SET QUANTITY="+qun[i]+" WHERE SL="+i+"";
            	smt.executeUpdate(qry);
            	qry="UPDATE CAFEORDER SET PRICE=PRICE*"+qun[i]+" WHERE SL="+i+"";
            	smt.executeUpdate(qry);
            }
            response.sendRedirect("bill.jsp");
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
