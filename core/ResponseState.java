package xiaofeng.core;

/**
 * 响应状态枚举
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
public enum ResponseState {
	/**
	 * 无
	 */
	none(0, "无"),
	/**
	 * 成功
	 */
	success(200, "成功"),
	/**
	 * 出错
	 */
	error(500, "出错"),
	/**
	 * 警告
	 */
	warning(100, "警告");

	/**
	 * 值
	 */
	private int Value;
	/**
	 * 说明
	 */
	private String Description;

	/**
	 * 设置值
	 * 
	 * @param value 值
	 * @param desc  说明
	 */
	ResponseState(int value, String desc) {
		this.Value = value;
		this.Description = desc;
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
	 * 获取说明
	 * 
	 * @return 说明
	 */
	public String getDescription() {
		return Description;
	}
}