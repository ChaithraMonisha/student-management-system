import java.sql.*;
public class DBConnection {
    private static final String URL="jdbc:mysql://localhost:3307/student_management";
    private static final String USER="root";
    private final static  String PASSWORD="Chai80@80";
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

