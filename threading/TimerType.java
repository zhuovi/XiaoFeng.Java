package xiaofeng.threading;

import xiaofeng.annotations.Description;

/**
 * 定时器类型枚举
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-14
 * @since 1.0.0
 * @version 1.0.0
 */
public enum TimerType {
	/**
	 * 一次
	 */
	@Description("一次")
	Once(0, "一次"),
	/**
	 * 每小时
	 */
	@Description("每小时")
	Hour(1, "每小时"),
	/**
	 * 每天
	 */
	@Description("每天")
	Day(2, "每天"),
	/**
	 * 每周
	 */
	@Description("每周")
	Week(3, "每周"),
	/**
	 * 每月
	 */
	@Description("每月")
	Month(4, "每月"),
	/**
	 * 每年
	 */
	@Description("每年")
	Year(5, "每年"),
	/**
	 * 间隔
	 */
	@Description("间隔")
	Interval(6, "间隔");

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
	 * @param value       值
	 * @param description 说明
	 */
	TimerType(int value, String description) {
		this.Value = value;
		this.Description = description;
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