package xiaofeng.config;

/**
 * 配置文件枚举
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
public enum ConfigFormat {
	/**
	 * JSON
	 */
	Json(0),
	/**
	 * XML
	 */
	Xml(1);

	/**
	 * 值
	 */
	private int Value = 0;

	/**
	 * 设置值
	 * 
	 * @param value 值
	 */
	ConfigFormat(int value) {
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
}