//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class VIewServlet
// */
//@WebServlet("/ViewServlet")
//public class ViewServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter printWriter=response.getWriter();
//		
//		printWriter.print("<head>");
//		printWriter.print("<link href='css/bootstrap.min.css'rel='stylesheet'>");
//		printWriter.print("</head>");
//		printWriter.print("<body>");
//		printWriter.print("<a href='index.html'class='btn btn-info'role='button'>Add Student</a>");
//		printWriter.print("<h1>Student Table</h1>");
//		List<Student>list=StudentSQL.getAllStudents();
//		printWriter.print("<table border='1'width='100%'");
//		printWriter.print("<tr><th>Id</th><th>Name</th>"+"<th>Password</th><th>Email</th>"+"<th>Country</th><th>Edit</th><th>Delete</th></tr>");
//		printWriter.print("");
//		for(Student student:list) {
//			printWriter.print("<td><a href='UpdateServlet?id=" + student.getId()+"'>edit</a></td>"+student.getName()+"</td><td>"+student.getPassword()+"</td><td>"+student.getEmail()
//			+"</td><td>"+student.getCountry()+"</td><td><a href='UpdateServlet?id=" + student.getId()
//			+"'>edit</a></td> <td><a href='DeleteServlet?id="+student.getId()+"'>delete</a></td></tr>");
//		}
//		printWriter.print("</table>");
//		printWriter.print("</body>");
//	
//	}
//
//	
//
//}
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        printWriter.print("<head>");
        printWriter.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
        printWriter.print("</head>");
        printWriter.print("<body>");
        printWriter.print("<a href='index.html' class='btn btn-info' role='button'>Add Student</a>");
        printWriter.print("<h1>Student Table</h1>");
        
        List<Student> list = StudentSQL.getAllStudents();
        printWriter.print("<table class='table table-bordered'>");
        printWriter.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");

        for (Student student : list) {
            printWriter.print("<tr>");
            printWriter.print("<td>" + student.getId() + "</td>");
            printWriter.print("<td>" + student.getName() + "</td>");
            // عرض كلمة المرور على هيئة نقاط
            printWriter.print("<td><input type='password' value='" + student.getPassword() + "' readonly /></td>");
            printWriter.print("<td>" + student.getEmail() + "</td>");
            printWriter.print("<td>" + student.getCountry() + "</td>");
            printWriter.print("<td><a href='UpdateServlet?id=" + student.getId() + "' class='btn btn-warning'>Edit</a></td>");
            printWriter.print("<td><a href='DeleteServlet?id=" + student.getId() + "' class='btn btn-danger'>Delete</a></td>");
            printWriter.print("</tr>");
        }
        printWriter.print("</table>");
        printWriter.print("</body>");
    }
}
