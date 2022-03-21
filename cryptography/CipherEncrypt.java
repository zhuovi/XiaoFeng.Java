package xiaofeng.cryptography;

import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import xiaofeng.core.StringHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;

/**
 * 通用加密类
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
public class CipherEncrypt extends BaseCrypto implements ICryptography {

	/**
	 * 无参构造器
	 */
	public CipherEncrypt() {
		this(CipherEncryptType.AES_CBC_NOPADDING, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param encryptType 加密模式
	 */
	public CipherEncrypt(CipherEncryptType encryptType) {
		this(encryptType, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param encryptType 加密模式
	 * @param charset     编码
	 */
	public CipherEncrypt(CipherEncryptType encryptType, Charset charset) {
		this(encryptType, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param encryptType   加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public CipherEncrypt(CipherEncryptType encryptType, Charset charset, SecretKeyType secretKeyType) {
		this.EncryptType = encryptType;
		this.charset = charset;
	}

	/**
	 * 编码
	 */
	private Charset charset;
	/**
	 * 加密模式
	 */
	private CipherEncryptType EncryptType;
	/**
	 * 密钥类型
	 */
	private SecretKeyType secretKeyType;

	/**
	 * 设置密钥类型
	 * 
	 * @param secretKeyType 密钥类型
	 */
	@Override
	public void setSecretKeyType(SecretKeyType secretKeyType) {
		this.secretKeyType = secretKeyType;
	}

	/**
	 * 加密方法
	 * 
	 * @param data 字符串
	 * @return 字符串
	 */
	@Override
	public String Encrypt(String data) {
		return this.Encrypt(data, this.BaseKey);
	}

	/**
	 * 加密方法
	 * 
	 * @param data    字符串
	 * @param slatKey 密钥
	 * @return 字符串
	 */
	@Override
	public String Encrypt(String data, String slatKey) {
		return this.Encrypt(data, slatKey, this.BaseVectorKey);
	}

	/**
	 * 加密方法
	 * 
	 * @param data      字符串
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字符串
	 */
	@Override
	public String Encrypt(String data, String slatKey, String vectorKey) {
		return Base64Helper.encode(this.Encrypt(data.getBytes(this.charset), slatKey, vectorKey));
	}

	/**
	 * 加密方法
	 * 
	 * @param data 字节
	 * @return 字节
	 */
	@Override
	public byte[] Encrypt(byte[] data) {
		return this.Encrypt(data, this.BaseKey);
	}

	/**
	 * 加密方法
	 * 
	 * @param data    字节
	 * @param slatKey 密钥
	 * @return 字节
	 */
	@Override
	public byte[] Encrypt(byte[] data, String slatKey) {
		return this.Encrypt(data, slatKey, this.BaseVectorKey);
	}

	/**
	 * 加密方法
	 * 
	 * @param data      字节
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字节
	 */
	@Override
	public byte[] Encrypt(byte[] data, String slatKey, String vectorKey) {
		return this.encode(data, slatKey, vectorKey, Cipher.ENCRYPT_MODE);
	}

	/**
	 * 解密方法
	 * 
	 * @param data 字符串
	 * @return 字符串
	 */
	@Override
	public String Decrypt(String data) {
		return this.Decrypt(data, this.BaseKey);
	}

	/**
	 * 解密方法
	 * 
	 * @param data    字符串
	 * @param slatKey 密钥
	 * @return 字符串
	 */
	@Override
	public String Decrypt(String data, String slatKey) {
		return this.Decrypt(data, slatKey, this.BaseVectorKey);
	}

	/**
	 * 解密方法
	 * 
	 * @param data      字符串
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字符串
	 */
	@Override
	public String Decrypt(String data, String slatKey, String vectorKey) {
		byte[] datas = this.Decrypt(Base64Helper.decode(data), slatKey, vectorKey);
		return (datas == null || datas.length == 0) ? "" : new String(datas);
	}

	/**
	 * 解密方法
	 * 
	 * @param data 字节
	 * @return 字节
	 */
	@Override
	public byte[] Decrypt(byte[] data) {
		return this.encode(data, this.BaseKey, this.BaseVectorKey, Cipher.DECRYPT_MODE);
	}

	/**
	 * 解密方法
	 * 
	 * @param data    字节
	 * @param slatKey 密钥
	 * @return 字节
	 */
	@Override
	public byte[] Decrypt(byte[] data, String slatKey) {
		return this.encode(data, slatKey, this.BaseVectorKey, Cipher.DECRYPT_MODE);
	}

	/**
	 * 解密方法
	 * 
	 * @param data      字节
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @return 字节
	 */
	@Override
	public byte[] Decrypt(byte[] data, String slatKey, String vectorKey) {
		return this.encode(data, slatKey, vectorKey, Cipher.DECRYPT_MODE);
	}

	/**
	 * 加密解密方法
	 * 
	 * @param data      字符串
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @param mode      模式 1加密 2 解密
	 * @return 字符串
	 */
	protected byte[] encode(byte[] data, String slatKey, String vectorKey, int mode) {
		if (data == null || data.length == 0)
			return null;
		try {
			Cipher cipher = Cipher.getInstance(this.EncryptType.getEncryptType());
			SecretKey secretKey = this.getKey(slatKey);
			if (this.EncryptType.getFillMode() == "NOPADDING") {
				int blockSize = cipher.getBlockSize();
				int datalen = data.length;
				if (datalen % blockSize != 0)
					datalen = datalen + (blockSize - datalen % blockSize);
				byte[] datas = new byte[datalen];
				System.arraycopy(data, 0, datas, 0, data.length);
				data = datas;
			}
			if (this.EncryptType.getVectorMode() == "CBC") {
				IvParameterSpec iv = this.getVector(vectorKey);
				cipher.init(mode, secretKey, iv);
			} else {
				cipher.init(mode, secretKey);
			}
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取key
	 * 
	 * @param key
	 * @return 符合规则的key
	 */
	protected SecretKey getKey(String key) {
		int len = this.EncryptType.getKeyLength();
		if (StringHelper.IsNullOrEmpty(key))
			key = this.BaseKey;
		int keylen = key.length();
		if (keylen < len)
			key = StringHelper.PadRight(key, len, '0');
		else if (keylen > len)
			key = key.substring(0, len);
		if (this.secretKeyType == SecretKeyType.Key)
			return new SecretKeySpec(key.getBytes(this.charset), this.EncryptType.getAlgorithm());
		else {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				random.setSeed(key.getBytes(this.charset));
				kgen.init(len, random);
				return kgen.generateKey();
			} catch (Exception ex) {
				ex.printStackTrace();
				return new SecretKeySpec(key.getBytes(this.charset), this.EncryptType.getAlgorithm());
			}
		}
	}

	/**
	 * 获取偏移量
	 * 
	 * @param vector 偏移量
	 * @return 符合规则的偏移量
	 */
	protected IvParameterSpec getVector(String vector) {
		int len = this.EncryptType.getVectorLength();
		if (StringHelper.IsNullOrEmpty(vector))
			vector = this.BaseVectorKey;
		int vectorlen = vector.length();
		if (vectorlen < len)
			vector = StringHelper.PadRight(vector, len, '0');
		else if (vectorlen > len)
			vector = vector.substring(0, len);
		if (secretKeyType == SecretKeyType.Key)
			return new IvParameterSpec(vector.getBytes(this.charset));
		else {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("DES");
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				random.setSeed(vector.getBytes(this.charset));
				kgen.init(len, random);
				return new IvParameterSpec(kgen.generateKey().getEncoded());
			} catch (Exception ex) {
				ex.printStackTrace();
				return new IvParameterSpec(vector.getBytes(this.charset));
			}
		}
	}

	/**
	 * 获取加密械
	 * 
	 * @return 加密模式
	 */
	public CipherEncryptType getEncryptType() {
		return EncryptType;
	}

	/**
	 * 设置加密模式
	 * 
	 * @param encryptType 加密模式
	 */
	@Override
	public void setEncryptType(CipherEncryptType encryptType) {
		EncryptType = encryptType;
	}

	/**
	 * 获取编码
	 * 
	 * @return 编码
	 */
	public Charset getCharset() {
		return charset;
	}

	/**
	 * 设置编码
	 * 
	 * @param charset 编码
	 */
	@Override
	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	/**
	 * 获取密钥类型
	 * 
	 * @return 密钥类型
	 */
	public SecretKeyType getSecretKeyType() {
		return secretKeyType;
	}
}