package com.joy.java.util.lang;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密解密工具类,依赖shiro-core-1.2.5.jar.
 */
public class DecryptionUtils {

    /**
     * SHA1加密
     * @param decript 源串
     * @return
     */
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * SHA加密
     * @param decript 源串
     * @return
     */
    public static String SHA(String decript) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

	 /** 
     * base64进制加密
     * @param password 
     * @return 
     */ 
    public static String encryptBase64(String password) {
        if(StringUtil.isEmpty(password)){
            throw new RuntimeException("password 不能为空!");
        }
        byte[] bytes = password.getBytes();
        return Base64.encodeToString(bytes);
    } 
    /** 
     * base64进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static String decryptBase64(String cipherText) {
        if(StringUtil.isEmpty(cipherText)){
            throw new RuntimeException("cipherText 不能为空!");
        }
        return Base64.decodeToString(cipherText);
    }

    /** 
     * 16进制加密
     * @param password 
     * @return 
     */ 
    public static String encryptHex(String password) {
        if(StringUtil.isEmpty(password)){
            throw new RuntimeException("password 不能为空!");
        }
        byte[] bytes = password.getBytes();
        return Hex.encodeToString(bytes);
    }

    /** 
     * 16进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static String decryptHex(String cipherText) {
        if(StringUtil.isEmpty(cipherText)){
            throw new RuntimeException("cipherText 不能为空!");
        }
        return new String(Hex.decode(cipherText));
    }

}
