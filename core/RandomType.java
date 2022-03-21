package xiaofeng.core;

/**
 * 随机类型
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
public enum RandomType {
	/**
	 * 数字
	 */
	Number(1),
	/**
	 * 字母
	 */
	Letter(2),
	/**
	 * 特殊字符
	 */
	Special(4),
	/**
	 * 所有
	 */
	All(7);

	/**
	 * 值
	 */
	private int Value;

	/**
	 * 构造器
	 * 
	 * @param value 值
	 */
	RandomType(int value) {
		this.Value = value;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return this.Value;
	}
}