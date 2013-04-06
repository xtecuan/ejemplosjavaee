/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256passwd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author xtecuan
 */
public class SHA256Passwd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        final MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
        final byte bin[] = messageDigest.digest(("welcome1").getBytes());
        System.out.println(Base64.encodeBase64(bin));
    }
}
