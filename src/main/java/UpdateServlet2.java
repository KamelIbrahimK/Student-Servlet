

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String studntId = request.getParameter("id");
        if (studntId == null || studntId.isEmpty()) {
            printWriter.println("<h2>Error: No student ID provided!</h2>");
            return; // إنهاء العملية إذا لم يتم توفير ID
        }

        int id = Integer.parseInt(studntId);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPassword(password);
        student.setEmail(email);
        student.setCountry(country);

        int num = StudentSQL.update(student);

        if (num > 0) {
            response.sendRedirect("ViewServlet"); // تأكد من أن الاسم صحيح
        } else {
            printWriter.println("<h2>Sorry, not updated :(</h2>");
        }
    }
}
