import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class PasswordUtil {
    public static String hashPassword(String password)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());//to bytes
            //bytes to hex string
            StringBuilder sb = new StringBuilder();
            {
                for (byte b : hashedBytes) {
                    sb.append(String.format("%x", b));
                }
                return sb.toString();
            }
        }
            catch(NoSuchAlgorithmException e)
            {
                throw new RuntimeException("hashing algorithm not found"+e.getMessage());
            }
        }
    }
