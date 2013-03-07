/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author xtecuan
 */
public final class SecurityToolsBean {

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

    public static String md5Hex(String password) {

        return DigestUtils.md5Hex(password);
    }
}
