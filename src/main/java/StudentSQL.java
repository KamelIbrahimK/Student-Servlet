import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentSQL {


//	public static Connection getConnection() {
//	    Connection con = null;
//	    try {
//	        // Load the JDBC driver
//	        Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure to use the correct driver class for your database
//	        // Establish the connection
//	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
//	    } catch (ClassNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return con;    
//	}
//	
//	public static int save(Student s) {
//	    int st = 0;
//	    String sql = "INSERT INTO studentInfo (name, password, email, country) VALUES (?, ?, ?, ?)";
//	    
//	    try (Connection con = StudentSQL.getConnection(); 
//	         PreparedStatement preparedStatement = con.prepareStatement(sql)) {
//	        
//	        preparedStatement.setString(1, s.getName());
//	        preparedStatement.setString(2, s.getPassword());
//	        preparedStatement.setString(3, s.getEmail());
//	        preparedStatement.setString(4, s.getCountry());
//	        
//	        st = preparedStatement.executeUpdate();
//	        
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return st;
//	}
public static Connection getConnection() {
    Connection con = null;
    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure to use the correct driver class for your database
        // Establish the connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return con;
}
public static int save(Student s) {
    int st = 0;
    String sql = "INSERT INTO studentInfo (name, password, email, country) VALUES (?, ?, ?, ?)";
    Connection con = null;

    try {
        con = StudentSQL.getConnection(); // Get the connection

        if (con == null) {
            System.out.println("Failed to establish a database connection.");
            return 0; // Connection failed
        }

        // Debugging output
        System.out.println("Saving student: " + s.getName() + ", " + s.getEmail() + ", " + s.getCountry());

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Set parameters
            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getPassword());
            preparedStatement.setString(3, s.getEmail());
            preparedStatement.setString(4, s.getCountry());

            // Execute the insert
            st = preparedStatement.executeUpdate();
            if (st > 0) {
                System.out.println("Student saved successfully.");
            } else {
                System.out.println("Failed to save student.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception
    } finally {
        // Always close the connection
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return st;
}
	
	
	public static int update(Student s) {
		
		int st=0;
		try {
			String sql = "UPDATE studentInfo SET name=?, password=?, email=?, country=? WHERE id=?";
			Connection con=StudentSQL.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, s.getName());
			preparedStatement.setString(2, s.getPassword());
			preparedStatement.setString(3, s.getEmail());
			preparedStatement.setString(4, s.getCountry());
			preparedStatement.setInt(5, s.getId());
			
			st=preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	
public static int delete(int id) {
		
		int st=0;
		try {
			String sql = "DELETE FROM studentInfo WHERE id=?";
			Connection con=StudentSQL.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			st=preparedStatement.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

public static Student getStudentById(int id) {
	
	Student student=new Student();
	try {
		String sql = "SELECT * FROM studentInfo WHERE id=?";
		Connection con=StudentSQL.getConnection();
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);
		ResultSet resultset=preparedStatement.executeQuery();
		if(resultset.next()) {
			student.setId(resultset.getInt(1));
			student.setName(resultset.getString(2));
			student.setPassword(resultset.getString(3));
			student.setEmail(resultset.getString(4));
			student.setCountry(resultset.getString(5));
		}
	
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return student;
  }

public static List<Student>getAllStudents(){
	List<Student>list=new ArrayList<Student>();
	try {
		String sql = "SELECT * FROM studentInfo";
		Connection con=StudentSQL.getConnection();
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		
		ResultSet resultset=preparedStatement.executeQuery();
		
		while(resultset.next()) {
			Student student=new Student();
			student.setId(resultset.getInt(1));
			student.setName(resultset.getString(2));
			student.setPassword(resultset.getString(3));
			student.setEmail(resultset.getString(4));
			student.setCountry(resultset.getString(5));
			
			list.add(student);
		}
	
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}


	
}
