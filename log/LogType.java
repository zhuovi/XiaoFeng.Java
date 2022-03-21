package xiaofeng.log;

import xiaofeng.annotations.Description;

/**
 * 日志类型枚举
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-12
 * @since 1.0.0
 * @version 1.0.0
 */
public enum LogType {
	/**
	 * 信息
	 */
	@Description("信息")
	Info(0, "信息"),
	/**
	 * 警告
	 */
	@Description("警告")
	Warn(1, "警告"),
	/**
	 * 错误
	 */
	@Description("错误")
	Error(2, "错误"),
	/**
	 * SQL
	 */
	@Description("SQL")
	SQL(3, "SQL"),
	/**
	 * 调试
	 */
	@Description("调试")
	Debug(4, "调试"),
	/**
	 * 任务
	 */
	@Description("任务")
	Task(5, "任务");

	/**
	 * 值
	 */
	private int Value;
	/**
	 * 说明
	 */
	private String Description;

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

	/**
	 * 构造器
	 * 
	 * @param value 值
	 * @param desc  说明
	 */
	LogType(int value, String desc) {
		this.Value = value;
		this.Description = desc;
	}
}