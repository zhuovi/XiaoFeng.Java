package xiaofeng.entity;

/**
 * 字段类型
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
public enum FieldDataType {
	/**
	 * 字段
	 */
	Field(0),
	/**
	 * 条件
	 */
	Where(1);

	/**
	 * 构造器
	 * 
	 * @param i 值
	 */
	FieldDataType(int i) {
		this.Value = i;
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