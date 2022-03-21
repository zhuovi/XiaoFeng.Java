package xiaofeng.threading;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import xiaofeng.core.DateTime;
import xiaofeng.core.RegexHelper;
import xiaofeng.core.StringHelper;

/**
 * 时间操作类
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
public class Time {
	/**
	 * 设置时间
	 * 
	 * @param hour   小时
	 * @param minute 分钟
	 * @param second 秒
	 */
	public Time(int hour, int minute, int second) {
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	/**
	 * 设置时间
	 * 
	 * @param time 时间字符串 格式为12:13:34
	 */
	public Time(String time) {
		if (RegexHelper.IsMatch(time, "^\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
			Map<String, String> maps = RegexHelper.Matchs(time,
					"^(?<hour>\\d{1,2}):(?<minute>\\d{1,2}):(?<second>\\d{1,2})$");
			this.setHour(StringHelper.toCast(maps.get("1"), Integer.class));
			this.setMinute(StringHelper.toCast(maps.get("2"), Integer.class));
			this.setSecond(StringHelper.toCast(maps.get("3"), Integer.class));
		}
	}

	/**
	 * 设置时间
	 * 
	 * @param dateTime 时间
	 */
	public Time(DateTime dateTime) {
		this(dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
	}

	/**
	 * 设置时间
	 * 
	 * @param time 时间
	 */
	public Time(Time time) {
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	/**
	 * 时
	 */
	private int Hour;
	/**
	 * 分
	 */
	private int Minute;
	/**
	 * 秒
	 */
	private int Second;

	/**
	 * 获取时
	 * 
	 * @return 时
	 */
	public int getHour() {
		return Hour;
	}

	/**
	 * 设置时
	 * 
	 * @param hour 时
	 */
	public void setHour(int hour) {
		if (hour >= 24)
			this.Hour = hour % 24;
		else
			this.Hour = hour;
	}

	/**
	 * 获取分
	 * 
	 * @return 分
	 */
	public int getMinute() {
		return Minute;
	}

	/**
	 * 设置分
	 * 
	 * @param minute 分
	 */
	public void setMinute(int minute) {
		if (minute >= 60) {
			int hours = minute / 60;
			this.Minute = minute % 60;
			this.Hour += hours;
		} else
			this.Minute = minute;
	}

	/**
	 * 获取秒
	 * 
	 * @return 秒
	 */
	public int getSecond() {
		return Second;
	}

	/**
	 * 设置秒
	 * 
	 * @param second 秒
	 */
	public void setSecond(int second) {
		if (second >= 60) {
			int minutes = second / 60;
			this.Second = second % 60;
			this.Minute += minutes;
		} else
			this.Second = second;
	}

	/**
	 * 总秒数
	 */
	@JsonIgnore
	public int getSeconds() {
		return this.Hour * 60 * 60 + this.Minute * 60 + this.Second;
	}

	/**
	 * 添加小时
	 * 
	 * @param hour 小时
	 */
	public void AddHours(int hour) {
		if (hour == 0)
			return;
		this.setHour(this.getHour() + hour);
	}

	/**
	 * 添加分钟
	 * 
	 * @param minute 分钟
	 */
	public void AddMinutes(int minute) {
		if (minute == 0)
			return;
		this.setMinute(this.getMinute() + minute);
	}

	/**
	 * 添加秒
	 * 
	 * @param second 秒
	 */
	public void AddSeconds(int second) {
		if (second == 0)
			return;
		this.setSecond(this.getSecond() + second);
	}

	/**
	 * 返回字符串
	 * 
	 * @return 返回字符串
	 */
	@Override
	public String toString() {
		return StringHelper.PadLeft(String.valueOf(this.Hour), 2, '0') + ":"
				+ StringHelper.PadLeft(String.valueOf(this.Minute), 2, '0') + ":"
				+ StringHelper.PadLeft(String.valueOf(this.Second), 2, '0');
	}

	/**
	 * 比较大小
	 * 
	 * @param time 时间
	 * @return 小于零 此实例小于 time。 零 此实例等于 time。 大于零 此实例大于 time
	 */
	public int compareTo(Time time) {
		if (time == null)
			return 1;
		return this.getSeconds() == time.getSeconds() ? 0 : this.getSeconds() > time.getSeconds() ? 1 : -1;
	}
}