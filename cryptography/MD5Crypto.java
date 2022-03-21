package xiaofeng.cryptography;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Crypto extends BaseCrypto {

	/**
	 * @MD5加密
	 * @param data 明文
	 * @param key  位数 只认 16和32
	 * @return 密文
	 */
	public String Encrypt(String data, String key) {
		String value = Encrypt(data);
		return key == "16" ? value.substring(8, 24) : value;
	}

	/**
	 * @MD5加密
	 * @param data 明文
	 * @return 密文
	 */
	public String Encrypt(String data) {
		return Encrypt(data, Charset.forName("UTF-8"));
	}

	/**
	 * @MD5加密
	 * @param data    明文
	 * @param charset 编码
	 * @return 密文
	 */
	public String Encrypt(String data, Charset charset) {
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance("md5").digest(data.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有这个md5算法！");
		}
		String code = new BigInteger(1, bytes).toString(16);
		for (int i = 0; i < 32 - code.length(); i++)
			code = "0" + code;
		return code;
	}

	/**
	 * @暂不支持解密方法
	 */
	@Deprecated(since = "无解密方法")
	public String Decrypt(String data, String key) {
		return data;
	}

	/**
	 * @暂不支持解密方法
	 * @return 明文
	 */
	@Deprecated(since = "无解密方法")
	public String Decrypt(String data) {
		return data;
	}

	public byte[] Encrypt(byte[] data, byte[] key) {
		try {
			return MessageDigest.getInstance("md5").digest(data);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public byte[] Encrypt(byte[] data) {
		return Encrypt(data, new byte[0]);
	}

	/**
	 * @暂不支持解密方法
	 * @return 明文
	 */
	@Deprecated(since = "无解密方法")
	public byte[] Decrypt(byte[] data, byte[] key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @暂不支持解密方法
	 * @return 明文
	 */
	@Deprecated(since = "无解密方法")
	public byte[] Decrypt(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] Encrypt(byte[] data, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] Decrypt(byte[] data, String key) {
		// TODO Auto-generated method stub
		return null;
	}

}