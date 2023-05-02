package SV24.NguyenTrungVinh.GHP.Controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginController {
    private static final String adminUsername = "admin";
    private static final String hashPassword = toHexString(getSHA("admin"));

    public static byte[] getSHA(String input)
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
 
        return null;
        
    }
     
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
 
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
    public static boolean loginWithUsernameAndPassword(String username, String password){
        String hash = toHexString(getSHA(password));
        return username.equals(adminUsername) && hash.equals(hashPassword);
    }
}
