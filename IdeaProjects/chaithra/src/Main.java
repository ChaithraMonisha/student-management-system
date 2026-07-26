import java.sql.*;
public class Main {
    private static final String url = "jdbc:mysql://localhost:3307/mydb";
    private static final String username = "root";
    private static final String password = "Chai80@80";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query="select * from students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("Id" + id);
                System.out.println("Name " + name);
                System.out.println("Age " + age);
                System.out.println("Marks " + marks);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
