package com.sugar.infrastructure.utils;

import java.security.MessageDigest;
import java.util.Formatter;

/**
 * Created by zhanghongqun on 2020/7/8.
 */
public class WXSignUtils {

    public static String sign(String value) {
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(value.getBytes("UTF-8"));
            return byteToHex(crypt.digest());

        } catch (Exception e) {
            return null;
        }
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
