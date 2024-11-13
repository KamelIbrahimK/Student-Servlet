

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Student student=new Student();
		student.setName(name);
		student.setPassword(password);
		student.setEmail(email);
		student.setCountry(country);
		
		int num=StudentSQL.save(student);
		if (num > 0) {
		    printWriter.println("<h2>Saved Successfully!</h2>");
		    request.getRequestDispatcher("index.html").include(request, response);
		} else {
		    printWriter.println("<h2>Sorry Not Saved :(</h2>");
		    printWriter.println("<form action='SaveServlet' method='post'>");
		    printWriter.println("Name: <input type='text' name='name' value='" + name + "' required/><br/>");
		    printWriter.println("Password: <input type='password' name='password' value='' required/><br/>"); // Ensure empty on error
		    printWriter.println("Email: <input type='email' name='email' value='' required/><br/>"); // Ensure empty on error
		    printWriter.println("Country: <input type='text' name='country' value='" + country + "' required/><br/>");
		    printWriter.println("<input type='submit' value='Save'/>");
		    printWriter.println("</form>");
		}
	}

}
