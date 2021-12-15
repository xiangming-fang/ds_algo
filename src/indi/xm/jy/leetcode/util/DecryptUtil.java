package indi.xm.jy.leetcode.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author yixiong.zhang
 */
public class DecryptUtil {

	private static String KEY_64 = "51jobKey";
	private static String IV_64 = "CRMDEVIV";

	/**
	 * DES 解密
	 */
	public static String decrypt(String data, String sKey) throws Exception {
		if (data == null) {
			return null;
		}
		// 秘钥和偏移量（c#那边刚好选的是秘钥的长度）
		byte[] key = sKey.getBytes(US_ASCII);
		byte[] iv = sKey.getBytes(US_ASCII);

		// c#那边将String做了次转换
		byte[] digest = new byte[data.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = data.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = skf.generateSecret(dks);
		// c#默认是用的CBC模式，java这边需要设置
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] decryptedData = cipher.doFinal(digest);
		return new String(decryptedData, UTF_8);
	}

	/**
	 * crm加密
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String source) throws Exception {
		byte[] byKey = KEY_64.getBytes(StandardCharsets.US_ASCII);
		byte[] byIV = IV_64.getBytes(StandardCharsets.US_ASCII);

		DESKeySpec dks = new DESKeySpec(byKey);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = skf.generateSecret(dks);
		// c#默认是用的CBC模式，java这边需要设置
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(byIV);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] bytes = cipher.doFinal(source.getBytes());
		return new String(Base64.getEncoder().encode(bytes));
	}

	public static void main(String[] args) throws Exception {
		System.out.println(DecryptUtil.decrypt("2EAEA3617EE7A0DE06710A5987AB7803", "EHireA.T"));
	}

}