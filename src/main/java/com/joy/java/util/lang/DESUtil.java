package com.joy.java.util.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.MessageDigest;

/**
 * DES加密解密辅助类
 */
public class DESUtil {
    protected final static Log logger = LogFactory.getLog(DESUtil.class);
    private final static int ITERATIONS = 20;

    /**
     * DES加密
     * @param key
     * @param plainText 需要进行加密的明文
     * @return String
     * @throws Exception
     */
    public static String encrypt(String key, String plainText) throws Exception {
        // String encryptTxt = "";
        try {
            byte[] salt = new byte[8];
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            for (int i = 0; i < 8; i++) {
                salt[i] = digest[i];
            }
            PBEKeySpec pbeKeySpec = new PBEKeySpec(key.toCharArray());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey skey = keyFactory.generateSecret(pbeKeySpec);
            PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATIONS);
            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
            cipher.init(Cipher.ENCRYPT_MODE, skey, paramSpec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes());
            String saltString = new String(Base64.encode(salt));
            String ciphertextString = new String(Base64.encode(cipherText));
            String finalStr= saltString + ciphertextString;

            return finalStr.replace("\r\n","");
        } catch (Exception e) {
            throw new Exception("Encrypt Text Error:" + e.getMessage(), e);
        }
    }

    /**
     * DES解密
     * @param key
     * @param encryptTxt 需要解密的密文
     * @return String
     * @throws Exception
     */
    public static String decrypt(String key, String encryptTxt) throws Exception {
        int saltLength = 12;
        try {
            String salt = encryptTxt.substring(0, saltLength);
            String ciphertext = encryptTxt.substring(saltLength, encryptTxt.length());
            byte[] saltarray = Base64.decode(salt);
            byte[] ciphertextArray = Base64.decode(ciphertext);
            PBEKeySpec keySpec = new PBEKeySpec(key.toCharArray());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey skey = keyFactory.generateSecret(keySpec);
            PBEParameterSpec paramSpec = new PBEParameterSpec(saltarray, ITERATIONS);
            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
            cipher.init(Cipher.DECRYPT_MODE, skey, paramSpec);
            byte[] plaintextArray = cipher.doFinal(ciphertextArray);
            return new String(plaintextArray);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
