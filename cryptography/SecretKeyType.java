package xiaofeng.cryptography;

/**
 * 加密密钥作为密钥还是种子
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
public enum SecretKeyType {
	/**
	 * 种子
	 */
	Seep(0),
	/**
	 * 密钥
	 */
	Key(1);

	/**
	 * 构造器
	 * 
	 * @param value 值
	 */
	SecretKeyType(int value) {
		this.Value = value;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return Value;
	}

	/**
	 * 值
	 */
	private int Value;
}
