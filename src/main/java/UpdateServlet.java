

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Update Student Info</h1>");

        String studntId = request.getParameter("id");
        int id = Integer.parseInt(studntId);
        
        // الحصول على معلومات الطالب من قاعدة البيانات باستخدام ID
        Student student = StudentSQL.getStudentById(id);
        
        printWriter.print("<head>");
        printWriter.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
        printWriter.print("</head>");
        printWriter.print("<body>");
        printWriter.print("<form action='UpdateServlet2' method='post'>");
        printWriter.print("<table>");
        
        // حقل ID مخفي
        printWriter.print("<tr><td><input type='hidden' name='id' value='" + student.getId() + "'/></td></tr>");
        
        // حقول أخرى
        printWriter.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + student.getName() + "'/></td></tr>");
        printWriter.print("<tr><td>Password:</td><td><input type='password' name='password' value='" + student.getPassword() + "'/></td></tr>");
        printWriter.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + student.getEmail() + "'/></td></tr>");
        printWriter.print("<tr><td>Country:</td><td><input type='text' name='country' value='" + student.getCountry() + "'/></td></tr>");
        printWriter.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
        printWriter.print("</table>");
        printWriter.print("</form>");
        printWriter.print("</body>");
    }
}
//@WebServlet("/UpdateServlet")
//public class UpdateServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//	
//    public UpdateServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter printWriter=response.getWriter();
//		printWriter.println("<h1>Update Student Info</h1>");
//		String studntId=request.getParameter("id");
//		int id=Integer.parseInt(studntId);
//		
//		Student student=StudentSQL.getStudentById(id);
//		
//		printWriter.print("<head>");
//		printWriter.print("<link href='css/bootstrap.min.css'rel='stylesheet'>");
//		printWriter.print("</head>");
//		printWriter.print("<body>");
//		printWriter.print("<form action='UpdateServlet2'method='post'>");
//		printWriter.print("<table>");
//		printWriter.print("<tr><td>ID</td><td><input name='id'value="+student.getId()+"/></td></tr>");
//		printWriter.print("<tr><td>Name:</td><td><input type='text' name='name' value="+student.getName()+"/></td></tr>");
//		printWriter.print("<tr><td>Password:</td><td><input type='password' name='password' value="+student.getPassword()+"/></td></tr>");
//		printWriter.print("<tr><td>Email:</td><td><input type='email' name='email' value="+student.getEmail()+"/></td></tr>");
//		printWriter.print("<tr><td>Country:</td><td><input type='text' name='country' value="+student.getCountry()+"/></td></tr>");
//		printWriter.print("</td></tr>");
//		printWriter.print("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
//		printWriter.print("</table>");
//		printWriter.print("</form>");
//		printWriter.print("</body>");
//	}
//
//	
//
//}
//@WebServlet("/UpdateServlet")
//public class UpdateServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<h1>Update Student Info</h1>");
//        
//        
//        String studntId = request.getParameter("id");
//        int id=Integer.parseInt(studntId);
//    	   
//     
//        System.out.println("Received student ID: " + studntId); 
//        
//        if (studntId == null || studntId.isEmpty()) {
//            printWriter.println("<h2>Error: No student ID provided!</h2>");
//            return; // إنهاء العملية إذا لم يتم توفير ID
//        }
//
//        
//        Student student = StudentSQL.getStudentById(id);
//        
//        if (student != null) {
//            // تابع إنشاء النموذج كما هو
//            printWriter.print("<form action='UpdateServlet2' method='post'>");
//            printWriter.print("<input name='id' value='" + student.getId() + "' readonly/>");
//            printWriter.print("<input type='text' name='name' value='" + student.getName() + "'/>");
//            printWriter.print("<input type='password' name='password' value='" + student.getPassword() + "'/>");
//            printWriter.print("<input type='email' name='email' value='" + student.getEmail() + "'/>");
//            printWriter.print("<input type='text' name='country' value='" + student.getCountry() + "'/>");
//            printWriter.print("<input type='submit' value='Update'/>");
//            printWriter.print("</form>");
//        } else {
//            printWriter.println("<h2>Student not found!</h2>");
//        }
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<h1>Update Student Info</h1>");
//        
//        String studntId = request.getParameter("id");
//        System.out.println("Received student ID: " + studntId); 
//
//        // تحقق مما إذا كان studntId فارغًا أو غير موجود
//        if (studntId == null || studntId.isEmpty()) {
//            printWriter.println("<h2>Error: No student ID provided!</h2>");
//            return; // إنهاء العملية إذا لم يتم توفير ID
//        }
//
//        int id;
//        try {
//            id = Integer.parseInt(studntId);
//        } catch (NumberFormatException e) {
//            printWriter.println("<h2>Error: Invalid student ID format!</h2>");
//            return; // إنهاء العملية إذا كان التنسيق غير صحيح
//        }
//
//        // متابعة عملية استرجاع الطالب
//        Student student = StudentSQL.getStudentById(id);
//        
//        if (student != null) {
//        	printWriter.print("<form action='UpdateServlet2' method='post'>");
//          printWriter.print("<input name='id' value='" + student.getId() + "' readonly/>");
//          printWriter.print("<input type='text' name='name' value='" + student.getName() + "'/>");
//          printWriter.print("<input type='password' name='password' value='" + student.getPassword() + "'/>");
//          printWriter.print("<input type='email' name='email' value='" + student.getEmail() + "'/>");
//          printWriter.print("<input type='text' name='country' value='" + student.getCountry() + "'/>");
//          printWriter.print("<input type='submit' value='Update'/>");
//          printWriter.print("</form>");  
//          } else {
//            printWriter.println("<h2>Student not found!</h2>");
//        }
//    }
