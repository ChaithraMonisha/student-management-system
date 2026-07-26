import java.sql.*;
public class StudentDAO {
    //Create
    public void addStudent(String name, String roll_no, String dept, int marks)
    {
        String sql = "INSERT INTO students(name,roll_no,department,marks) VALUES (?,?,?,?)";
        try
                (Connection conn = DBConnection.getConnection();
                 PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setString(1, name);
            ptmt.setString(2, roll_no);
            ptmt.setString(3, dept);
            ptmt.setInt(4, marks);
            ptmt.executeUpdate();
            System.out.println("Student added Successfully");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    //READ
    public void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("STUDENT DETAILS");
            System.out.printf("%-5s %-20s %-15s %-15s %-10s%n", "ID", "NAME", "ROLL NO", "Department", "Marks");
            System.out.println("---------------------");
            while (rs.next())
            {
                System.out.printf("%-5s %-20s %-15s %-15s %-10s%n",
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("roll_no") ,
                        rs.getString("department"),
                        rs.getInt("marks"));
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    //update
    public void updateMarks(String rollNo,int newMarks)
    {
        String sql="UPDATE students SET marks=? WHERE roll_no=?";
        try (Connection conn=DBConnection.getConnection();
        PreparedStatement ptmt=conn.prepareStatement(sql))
        {
            ptmt.setInt(1, newMarks);
            ptmt.setString(2,rollNo);
            int rows = ptmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Marks Updated Successfully");
            }
            else
            {
                System.out.println("No Student found with that RollNo");
            }
        }
            catch(SQLException e)
            {
                System.out.println("error:"+e.getMessage());
            }
        }
        //Delete
    public void deleteStudent(String rollNo)
    {
        String sql = "DELETE FROM students WHERE roll_no=?";
        try (Connection conn=DBConnection.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql))
        {
            ptmt.setString(1,rollNo);
            int rows = ptmt.executeUpdate();
        if (rows > 0)
        {
            System.out.println("Student Record Deleted Successfully");
        }
        else
        {
            System.out.println("RollNo Not Found");
        }
       }
    catch(SQLException e)
        {
            System.out.println("Error"+e.getMessage());
        }
    }
public void searchStudents(String rollNo) {
    String sql = "SELECT * FROM students WHERE roll_no=?";
    try (Connection conn = DBConnection.getConnection();
            PreparedStatement ptmt = conn.prepareStatement(sql))
    {
        ptmt.setString(1, rollNo);
        ResultSet rs = ptmt.executeQuery();
        if (rs.next())
        {
            System.out.println("------Student found------");
            System.out.println("ID : " + rs.getInt("ID"));
            System.out.println("Name : " + rs.getString("Name"));
            System.out.println("RollNo : "  + rs.getString("Roll_no"));
            System.out.println("Department : " + rs.getString("Department"));
            System.out.println("Marks : " + rs.getInt("Marks"));
        }
        else
        {
            System.out.println("Student not found");
        }
   }
    catch(SQLException e)
    {
        System.out.println("error"+e.getMessage());
    }
}
//Repot Average marks of students
public void averageMarks()
{
    String sql="SELECT AVG(marks) AS average_marks FROM students";
    try(Connection conn=DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql))
    {
        if(rs.next())
        {
            double avg=rs.getDouble("average_marks");
            System.out.println("Average Marks of all students :"+avg);
        }
    }
    catch(SQLException e)
    {
        System.out.println("Error"+e.getMessage());
    }
}
//REPORT-HIGHEST SCORING STUDENT
    public void highestScore()
    {
        String sql="SELECT * FROM students WHERE marks=(SELECT MAX(marks) FROM students)";
        try(Connection conn=DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql))
        {
            while(rs.next())
            {
                System.out.println("=====================Highest marks of student=========================================");
                System.out.println("ID : "+rs.getInt("ID"));
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("RollNo : "+rs.getString("Roll_No"));
                System.out.println("Department : "+rs.getString("Department"));
                System.out.println("Marks : "+rs.getInt("Marks"));
            }
        }
    catch(SQLException e)
    {
        System.out.println("Error"+e.getMessage());
    }

}
}