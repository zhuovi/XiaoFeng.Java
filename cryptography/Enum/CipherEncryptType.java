package xiaofeng.cryptography.Enum;

/**
 * 通用加密枚举
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
public enum CipherEncryptType {
	/**
	 * 有向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0, 如{7,0,9,2,7,3,4,0}
	 */
	AES_CBC_NOPADDING("AES/CBC/NoPadding", 0, "AES", 16, 16, "CBC", "NOPADDING"),
	/**
	 * 有向量加密模式, 不足8位用余位数补足8位, 如{7,0,9,2,7,3,4,1} 余数 8-8%7=1;
	 */
	AES_CBC_PKCS5PADDING("AES/CBC/PKCS5Padding", 1, "AES", 16, 16, "CBC", "PKCS5PADDING"),
	/**
	 * 无向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0
	 */
	AES_ECB_NOPADDING("AES/ECB/NoPadding", 2, "AES", 16, 16, "ECB", "NOPADDING"),
	/**
	 * 无向量加密模式, 不足8位用余位数补足8位
	 */
	AES_ECB_PKCS5PADDING("AES/ECB/PKCS5Padding", 3, "AES", 16, 16, "ECB", "PKCS5PADDING"),
	/**
	 * 有向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0, 如{7,0,9,2,7,3,4,0}
	 */
	DES_CBC_NOPADDING("DES/CBC/NoPadding", 4, "DES", 8, 8, "CBC", "NOPADDING"),
	/**
	 * 有向量加密模式, 不足8位用余位数补足8位, 如{7,0,9,2,7,3,4,1} 余数 8-8%7=1;
	 */
	DES_CBC_PKCS5PADDING("DES/CBC/PKCS5Padding", 5, "DES", 8, 8, "CBC", "PKCS5PADDING"),
	/**
	 * 无向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0
	 */
	DES_ECB_NOPADDING("DES/ECB/NoPadding", 6, "DES", 8, 8, "ECB", "NOPADDING"),
	/**
	 * 无向量加密模式, 不足8位用余位数补足8位
	 */
	DES_ECB_PKCS5PADDING("DES/ECB/PKCS5Padding", 7, "DES", 8, 8, "ECB", "PKCS5PADDING"),
	/**
	 * 有向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0, 如{7,0,9,2,7,3,4,0}
	 */
	DESede_CBC_NOPADDING("DESede/CBC/NoPadding", 8, "DESede", 24, 8, "CBC", "NOPADDING"),
	/**
	 * 有向量加密模式, 不足8位用余位数补足8位, 如{7,0,9,2,7,3,4,1} 余数 8-8%7=1;
	 */
	DESede_CBC_PKCS5PADDING("DESede/CBC/PKCS5Padding", 9, "DESede", 24, 8, "CBC", "PKCS5PADDING"),
	/**
	 * 无向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0
	 */
	DESede_ECB_NOPADDING("DESede/ECB/NoPadding", 10, "DESede", 24, 8, "ECB", "NOPADDING"),
	/**
	 * 无向量加密模式, 不足8位用余位数补足8位
	 */
	DESede_ECB_PKCS5PADDING("DESede/ECB/PKCS5Padding", 11, "DESede", 24, 8, "ECB", "PKCS5PADDING"),
	/**
	 * 无向量加密模式, PKCS1Padding模式填充
	 */
	RSA_ECB_PKCS1PADDING("RSA/ECB/PKCS1Padding", 12, "RSA", 2048, 1024, "ECB", "PKCS1PADDING"),
	/**
	 * 无向量加密模式, SHA-1摘要 + MGF1方式填充
	 */
	RSA_ECB_OAEPWITHSHA_1ANDMGF1PADDING("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", 13, "RSA", 2048, 1024, "ECB",
			"1ANDMGF1PADDING"),
	/**
	 * 无向量加密模式, SHA-256摘要 + MGF1方式填充
	 */
	RSA_ECB_OAEPWITHSHA_256ANDMGF1PADDING("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 14, "RSA", 2048, 1024, "ECB",
			"256ANDMGF1PADDING"),
	/**
	 * SHA-1
	 */
	SHA1("SHA-1", 15, "SHA", 0, 0, "", "1"),
	/**
	 * SHA-224
	 */
	SHA224("SHA-224", 16, "SHA", 0, 0, "", "224"),
	/**
	 * SHA-256
	 */
	SHA256("SHA-256", 17, "SHA", 0, 0, "", "256"),
	/**
	 * SHA-384
	 */
	SHA384("SHA-384", 18, "SHA", 0, 0, "", "354"),
	/**
	 * SHA-512
	 */
	SHA512("SHA-512", 19, "SHA", 0, 0, "", "512"),
	/**
	 * MD2
	 */
	MD2("MD2", 20, "MD", 0, 0, "", "2"),
	/**
	 * MD5
	 */
	MD5("MD5", 21, "MD", 0, 0, "", "5"),
	/**
	 * HMACSHA1
	 */
	HMACSHA1("HmacSHA1", 22, "HMAC", 1, 0, "", "1"),
	/**
	 * HMACSHA224
	 */
	HMACSHA224("HmacSHA224", 23, "HMAC", 1, 0, "", "224"),
	/**
	 * HMACSHA256
	 */
	HMACSHA256("HmacSHA256", 24, "HMAC", 1, 0, "", "256"),
	/**
	 * HMACSHA384
	 */
	HMACSHA384("HmacSHA384", 25, "HMAC", 1, 0, "", "384"),
	/**
	 * HMACSHA512
	 */
	HMACSHA512("HmacSHA512", 26, "HMAC", 1, 0, "", "512");

	/**
	 * 构造器
	 * 
	 * @param encryptType  加密类型
	 * @param value        值
	 * @param algorithm    算法
	 * @param keyLength    密钥长度
	 * @param vectorLength 偏移量长度
	 * @param vectorMode   向量模式
	 * @param fillMode     填充模式
	 */
	CipherEncryptType(String encryptType, int value, String algorithm, int keyLength, int vectorLength,
			String vectorMode, String fillMode) {
		this.EncryptType = encryptType;
		this.Value = value;
		this.Algorithm = algorithm;
		this.KeyLength = keyLength;
		this.VectorLength = vectorLength;
		this.VectorMode = vectorMode;
		this.FillMode = fillMode;
	}

	/**
	 * 值
	 */
	private int Value;
	/**
	 * 加密类型
	 */
	private String EncryptType;
	/**
	 * 算法
	 */
	private String Algorithm;
	/**
	 * 密钥长度
	 */
	private int KeyLength;
	/**
	 * 偏移量长度
	 */
	private int VectorLength;
	/**
	 * 向量模式
	 */
	private String VectorMode;
	/**
	 * 填充模式
	 */
	private String FillMode;

	/**
	 * 获取加密类型
	 * 
	 * @return 加密类型
	 */
	public String getEncryptType() {
		return EncryptType;
	}

	/**
	 * 获取值
	 * @return 值
	 */
	public int getValue() {
		return Value;
	}

	/**
	 * 获取算法名称
	 * @return 算法名称
	 */
	public String getAlgorithm() {
		return Algorithm;
	}

	/**
	 * 获取密钥长度
	 * @return 密钥长度
	 */
	public int getKeyLength() {
		return KeyLength;
	}

	/**
	 * 获取偏移量长度
	 * @return 偏移量长度
	 */
	public int getVectorLength() {
		return VectorLength;
	}

	/**
	 * @return 向量模式
	 */
	public String getVectorMode() {
		return VectorMode;
	}

	/**
	 * @return 填充模式
	 */
	public String getFillMode() {
		return FillMode;
	}

}