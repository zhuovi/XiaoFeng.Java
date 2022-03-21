package xiaofeng.cryptography;

import java.nio.charset.Charset;

import xiaofeng.cryptography.Enum.CipherEncryptType;

/**
 * 通用加密接口
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-11
 * @since 1.0.0
 * @version 1.0.0
 */
public interface ICryptography {
	/**
	 * 加密方法
	 * 
	 * @param data      明文
	 * @param key       密钥
	 * @param vectorKey 偏移量
	 * @return 加密后的字符串
	 */
	String Encrypt(String data, String key, String vectorKey);

	/**
	 * 加密方法
	 * 
	 * @param data 明文
	 * @param key  密钥
	 * @return 加密后的字符串
	 */
	String Encrypt(String data, String key);

	/**
	 * 加密方法
	 * 
	 * @param data      字节
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字节
	 */
	byte[] Encrypt(byte[] data, String slatKey, String vectorKey);

	/**
	 * 加密方法
	 * 
	 * @param data 明文
	 * @param key  密钥
	 * @return 加密后的字节
	 */
	byte[] Encrypt(byte[] data, String key);

	/**
	 * 加密方法
	 * 
	 * @param data 明文
	 * @return 加密后的字符串
	 */
	String Encrypt(String data);

	/**
	 * 加密方法
	 * 
	 * @param data 明文
	 * @return 加密后的字节
	 */
	byte[] Encrypt(byte[] data);

	/**
	 * 解密方法
	 * 
	 * @param data      密文
	 * @param key       密钥
	 * @param vectorKey 偏移量
	 * @return 解密后的字符串
	 */
	String Decrypt(String data, String key, String vectorKey);

	/**
	 * 解密方法
	 * 
	 * @param data 密文
	 * @param key  密钥
	 * @return 解密后的字符串
	 */
	String Decrypt(String data, String key);

	/**
	 * 解密方法
	 * 
	 * @param data      字节
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字节
	 */
	byte[] Decrypt(byte[] data, String slatKey, String vectorKey);

	/**
	 * 解密方法
	 * 
	 * @param data 密文
	 * @param key  密钥
	 * @return 解密后的字节
	 */
	byte[] Decrypt(byte[] data, String key);

	/**
	 * 解密方法
	 * 
	 * @param data 密文
	 * @return 解密后的字符串
	 */
	String Decrypt(String data);

	/**
	 * 解密方法
	 * 
	 * @param data 密文
	 * @return 解密后的字节
	 */
	byte[] Decrypt(byte[] data);

	/**
	 * 设置编码
	 * 
	 * @param charset 编码
	 */
	void setCharset(Charset charset);

	/**
	 * 设置密钥类型
	 * @param secretKeyType 密钥类型
	 */
	void setSecretKeyType(SecretKeyType secretKeyType);

	/**
	 * 设置加密模式
	 * 
	 * @param encryptType 加密模式
	 */
	void setEncryptType(CipherEncryptType encryptType);

}