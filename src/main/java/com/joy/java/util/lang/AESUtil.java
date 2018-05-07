package com.joy.java.util.lang;

import org.apache.shiro.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Arrays;

/**
 * AES加密解密,需要对原生jdk中的local_policy.jar US_export_policy.jar 进行替换
 */
public class AESUtil {

	static {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}

	/**
	 * aes加密
	 * @param stringToEncode 原文
	 * @param password aes加密密钥
	 * @return String
	 * @throws NullPointerException
     */
	public static String encode(String stringToEncode,String password) throws Exception {
		SecretKeySpec skeySpec = getKey(password);
		byte[] clearText = stringToEncode.getBytes("UTF8");
		final byte[] iv = new byte[16];
		Arrays.fill(iv, (byte) 0x00);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
		String encrypedValue = new String(Base64.encode(cipher.doFinal(clearText)));
		return encrypedValue;
	}

	/**
	 * AES解密
	 * @param stringToEncode 密文
	 * @param password 密码
	 * @return String
	 * @throws Exception
     */
	public static String decode(String stringToEncode,String password) throws Exception {
		SecretKeySpec skeySpec = getKey(password);
		byte[] clearText = Base64.decode(stringToEncode);
		final byte[] iv = new byte[16];
		Arrays.fill(iv, (byte) 0x00);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
		String encrypedValue = new String(cipher.doFinal(clearText), "UTF8");
		return encrypedValue;
	}

	private static SecretKeySpec getKey(String password) throws UnsupportedEncodingException {
		int keyLength = 256;
		byte[] keyBytes = new byte[keyLength / 8];
		Arrays.fill(keyBytes, (byte) 0x0);
		byte[] passwordBytes = password.getBytes("UTF-8");
		int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
		System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
		return key;
	}

}