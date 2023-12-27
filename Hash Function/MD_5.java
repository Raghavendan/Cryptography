import java.math.BigInteger;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD_5
{
    public static String getMd5Hash(String input)
    {
        try
        {
//static getInstance() method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
//calculating message digest of an input that return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
//converting byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
//converting message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32)
            {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String s = sc.nextLine();
        System.out.println("HashCode Generated for the string is: " + getMd5Hash(s));
    }
}
