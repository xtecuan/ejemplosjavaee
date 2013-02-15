/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb.facade.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author xtecuan
 */
@Stateless
public class SecurityToolsBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static String encryptPassword(String password)
            throws NoSuchAlgorithmException {

        MessageDigest messageDigest =
                MessageDigest.getInstance("MD5");
        byte[] bs;
        messageDigest.reset();
        bs = messageDigest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bs.length; i++) {
            String hexVal = Integer.toHexString(0xFF & bs[i]);
            if (hexVal.length() == 1) {
                stringBuilder.append("0");
            }

            stringBuilder.append(hexVal);
        }

        return stringBuilder.toString();
    }

    public String md5Hex(String password) {

        return DigestUtils.md5Hex(password);
    }
}
