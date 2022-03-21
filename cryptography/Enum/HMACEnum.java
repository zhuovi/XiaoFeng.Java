package xiaofeng.cryptography.Enum;

/**
 * HMAC加密枚举
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
public enum HMACEnum {
	/**
	 * HMACSHA1
	 */
	HMACSHA1("HmacSHA1", 0),
	/**
	 * HMACSHA224
	 */
	HMACSHA224("HmacSHA224", 1),
	/**
	 * HMACSHA256
	 */
	HMACSHA256("HmacSHA256", 2),
	/**
	 * HMACSHA384
	 */
	HMACSHA384("HmacSHA384", 3),
	/**
	 * HMACSHA512
	 */
	HMACSHA512("HmacSHA512", 4);

	/**
	 * 值
	 */
	private int Value;
	/**
	 * 加密类型
	 */
	private String EncryptType;

	/**
	 * 构造器
	 * 
	 * @param encryptType 加密类型
	 * @param value       值
	 */
	HMACEnum(String encryptType, int value) {
		this.EncryptType = encryptType;
		this.Value = value;
	}

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