package xiaofeng.cryptography.Enum;

/**
 * DES3加密枚举
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
public enum DES3Enum {
	/**
	 * 有向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0, 如{7,0,9,2,7,3,4,0}
	 */
	CBC_NO_PADDING("DESede/CBC/NoPadding", 0),
	/**
	 * 有向量加密模式, 不足8位用余位数补足8位, 如{7,0,9,2,7,3,4,0}
	 */
	CBC_PKCS5PADDING("DESede/CBC/PKCS5Padding", 1),
	/**
	 * 无向量加密模式, 不足8位用0补足8位, 需代码给加密内容添加0
	 */
	ECB_NO_PADDING("DESede/ECB/NoPadding", 2),
	/**
	 * 无向量加密模式, 不足8位用余位数补足8位
	 */
	ECB_PKCS5PADDING("DESede/ECB/PKCS5Padding", 3);

	/**
	 * 构造器
	 * 
	 * @param encryptType 加密类型
	 * @param value       值
	 */
	DES3Enum(String encryptType, int value) {
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