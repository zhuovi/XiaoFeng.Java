package xiaofeng.cryptography.Enum;

/**
 * SHA加密枚举
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
public enum SHAEnum {
	/**
	 * SHA-1
	 */
	SHA1("SHA-1", 0),
	/**
	 * SHA-224
	 */
	SHA224("SHA-224", 1),
	/**
	 * SHA-256
	 */
	SHA256("SHA-256", 2),
	/**
	 * SHA-384
	 */
	SHA384("SHA-384", 3),
	/**
	 * SHA-512
	 */
	SHA512("SHA-512", 4);

	/**
	 * 构造器
	 * 
	 * @param encryptType 加密类型
	 * @param value       值
	 */
	SHAEnum(String encryptType, int value) {
		this.EncryptType = encryptType;
		this.Value = value;
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
	 * 获取加密类型
	 * 
	 * @return 加密类型
	 */
	public String getEncryptType() {
		return EncryptType;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return Value;
	}
}