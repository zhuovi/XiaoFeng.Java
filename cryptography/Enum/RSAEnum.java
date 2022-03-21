package xiaofeng.cryptography.Enum;

/**
 * RSA加密枚举
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
public enum RSAEnum {
	/**
	 * 无向量加密模式, PKCS1Padding模式填充
	 */
	ECB_PKCS1PADDING("RSA/ECB/PKCS1Padding", 0),
	/**
	 * 无向量加密模式, SHA-1摘要 + MGF1方式填充
	 */
	ECB_OAEP_WITH_SHA1_AND_MGF_1PADDING("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", 1),
	/**
	 * 无向量加密模式, SHA-256摘要 + MGF1方式填充
	 */
	ECB_OAEP_WITH_SHA256_AND_MGF_1PADDING("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 2);

	/**
	 * 构造器
	 * 
	 * @param encryptType 加密类型
	 * @param value       值
	 */
	RSAEnum(String encryptType, int value) {
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