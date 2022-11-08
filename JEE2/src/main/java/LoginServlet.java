import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("param1");
		String password=request.getParameter("param2");
		
		if (id.equals("ING2") && password.equals("ING2pw")){
			System.out.println("gg");
			response.sendRedirect("http://localhost:8080/JEE2/successAuthentification.jsp");
		} else{
			System.out.println("rip");
			response.sendRedirect("http://localhost:8080/JEE2/failedAuthentification.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("param1");
		String password=request.getParameter("param2");
		
		if (login == "ING2" && password == "ING2pw"){
			System.out.println("gg");
			//response.sendRedirect("http://localhost:8080/JEE2/successAuthentification.jsp");
			//System.out.println(login);
			//System.out.println(password);
		} else{
			System.out.println("rip");
			//response.sendRedirect("http://localhost:8080/JEE2/failedAuthentification.jsp");
			//System.out.println(login);
			//System.out.println(password);
		}
	}

}
