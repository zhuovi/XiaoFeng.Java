package xiaofeng.entity;

/**
 * 实体枚举类型
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
public enum ModelType {
	/**
	 * 表
	 */
	Table(1),
	/**
	 * 视图
	 */
	View(2),
	/**
	 * 存储
	 */
	Produce(3),
	/**
	 * 方法
	 */
	Function(4);

	/**
	 * 值
	 */
	private int value;

	/**
	 * 构造器
	 * 
	 * @param val 值
	 */
	ModelType(int val) {
		this.value = val;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return this.value;
	}
}
