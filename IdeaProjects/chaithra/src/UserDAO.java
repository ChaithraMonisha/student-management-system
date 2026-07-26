import java.sql.*;
public class UserDAO
{
    //signup-hashing password
    //signup-add a new user
    public static boolean signUp(String username, String password)
    {
        //hashing
        String hashedPassword=PasswordUtil.hashPassword(password);
        String sql = "INSERT INTO users(username,password)VALUES(?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ptmt = conn.prepareStatement(sql))
        {
            ptmt.setString(1, username);
            ptmt.setString(2, hashedPassword);//store hash
            ptmt.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            if(e.getMessage().contains("Duplicate entry"))
            {
                System.out.println("User already exists");
            }
            else
            {
                System.out.println("Error"+e.getMessage());
            }
            return false;
        }
    }
//Login - check if username and password match
public static boolean logIn(String username,String password)
{
    String hashedPassword=PasswordUtil.hashPassword(password);//only thing added
    String sql="SELECT * FROM users WHERE username=? AND password=?";
    try(Connection conn=DBConnection.getConnection();
    PreparedStatement ptmt=conn.prepareStatement(sql)) {
        ptmt.setString(1, username);
        ptmt.setString(2, hashedPassword);//hash
        ResultSet rs = ptmt.executeQuery();
        if(rs.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
        catch(SQLException e)
        {
            System.out.println("error"+e.getMessage());
            return false;
        }
    }
}
