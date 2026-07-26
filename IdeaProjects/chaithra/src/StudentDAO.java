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
            System.out.println("student added successfully");
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
                System.out.println("Marks updated successfully");
            }
            else
            {
                System.out.println("no student found with that roll number");
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
            System.out.println("Student record deleted successfully");
        }
        else
        {
            System.out.println("roll number not found");
        }
       }
    catch(SQLException e)
        {
            System.out.println("Error"+e.getMessage());
        }
    }
}