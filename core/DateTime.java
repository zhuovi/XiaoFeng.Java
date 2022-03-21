package xiaofeng.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
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
public class DateTime implements Serializable, Cloneable, Comparable<DateTime> {
	/**
	 * 变量
	 */
	private static DateTime dt;

	/**
	 * 同步实例
	 * 
	 * @return 实例化DateTime对象
	 */
	public static synchronized DateTime instance() {
		if (dt == null)
			dt = new DateTime();
		return dt;
	}

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 738298763101502547L;
	/**
	 * 日期对象
	 */
	private Calendar BaseCalendar = Calendar.getInstance();

	/**
	 * 实例化现在时间对象
	 */
	public DateTime() {
		this(System.currentTimeMillis());
	}

	/**
	 * 转换成时间类型
	 * 
	 * @param value 时间字符串
	 */
	public DateTime(String value) {
		this(DateTime.Parse(value).getTotalMilliseconds());
	}

	/**
	 * 设置时间类型
	 * 
	 * @param ticks 时间戳
	 */
	public DateTime(long ticks) {
		BaseCalendar.setTimeInMillis(ticks);
		this.setYear(BaseCalendar.get(Calendar.YEAR));
		this.setMonth(BaseCalendar.get(Calendar.MONTH));
		this.setDay(BaseCalendar.get(Calendar.DATE));
		this.setHour(BaseCalendar.get(Calendar.HOUR_OF_DAY));
		this.setMinute(BaseCalendar.get(Calendar.MINUTE));
		this.setSecond(BaseCalendar.get(Calendar.SECOND));
		this.setMillisecond(BaseCalendar.get(Calendar.MILLISECOND));
	}

	/**
	 * 设置时间类型
	 * 
	 * @param year  年份
	 * @param month 月份
	 * @param day   日期
	 */
	public DateTime(int year, int month, int day) {
		this(year, month, day, 0, 0, 0, 0);
	}

	/**
	 * 设置时间类型
	 * 
	 * @param year   年份
	 * @param month  月份
	 * @param day    日期
	 * @param hour   小时
	 * @param minute 分钟
	 * @param second 秒
	 */
	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		this(year, month, day, hour, minute, second, 0);
	}

	/**
	 * 设置时间类型
	 * 
	 * @param year        年份
	 * @param month       月份
	 * @param day         日期
	 * @param hour        小时
	 * @param minute      分钟
	 * @param second      秒
	 * @param millisecond 毫秒
	 */
	public DateTime(int year, int month, int day, int hour, int minute, int second, int millisecond) {
		this.setYear(year);
		this.setMonth(month - 1);
		this.setDay(day);
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
		this.setMillisecond(millisecond);
	}

	/**
	 * 年
	 */
	private int Year = 0;
	/**
	 * 月份
	 */
	private int Month = 0;
	/**
	 * 日期
	 */
	private int Day = 0;
	/**
	 * 小时
	 */
	private int Hour = 0;
	/**
	 * 分钟
	 */
	private int Minute = 0;
	/**
	 * 秒
	 */
	private int Second = 0;
	/**
	 * 毫秒
	 */
	private int Millisecond = 0;

	/**
	 * 获取年份
	 * 
	 * @return 年份
	 */
	public int getYear() {
		return Year = BaseCalendar.get(Calendar.YEAR);
	}

	/**
	 * 设置年份
	 * 
	 * @param year 年份
	 */
	public void setYear(int year) {
		BaseCalendar.set(Calendar.YEAR, year);
		// Year = BaseCalendar.get(Calendar.YEAR);
	}

	/**
	 * 获取月份
	 * 
	 * @return 月份
	 */
	public int getMonth() {
		return Month = BaseCalendar.get(Calendar.MONTH);
	}

	/**
	 * 设置月份
	 * 
	 * @param month 月份
	 */
	public void setMonth(int month) {
		BaseCalendar.set(Calendar.MONTH, month);
		// Month = BaseCalendar.get(Calendar.MONTH);
	}

	/**
	 * 获取日期
	 * 
	 * @return 日期
	 */
	public int getDay() {
		return Day = BaseCalendar.get(Calendar.DATE);
	}

	/**
	 * 设置日期
	 * 
	 * @param day 日期
	 */
	public void setDay(int day) {
		BaseCalendar.set(Calendar.DATE, day);
		// Day = BaseCalendar.get(Calendar.DATE);
	}

	/**
	 * 获取小时
	 * 
	 * @return 小时
	 */
	public int getHour() {
		return Hour = BaseCalendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 设置小时
	 * 
	 * @param hour 小时
	 */
	public void setHour(int hour) {
		BaseCalendar.set(Calendar.HOUR_OF_DAY, hour);
		// Hour = BaseCalendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取分钟
	 * 
	 * @return 分钟
	 */
	public int getMinute() {
		return Minute = BaseCalendar.get(Calendar.MINUTE);
	}

	/**
	 * 设置分钟
	 * 
	 * @param minute 分钟
	 */
	public void setMinute(int minute) {
		BaseCalendar.set(Calendar.MINUTE, minute);
		// Minute = BaseCalendar.get(Calendar.MINUTE);
	}

	/**
	 * 获取秒数
	 * 
	 * @return 秒数
	 */
	public int getSecond() {
		return Second = BaseCalendar.get(Calendar.SECOND);
	}

	/**
	 * 设置秒数
	 * 
	 * @param second 秒数
	 */
	public void setSecond(int second) {
		BaseCalendar.set(Calendar.SECOND, second);
		// Second = BaseCalendar.get(Calendar.SECOND);
	}

	/**
	 * 获取毫秒
	 * 
	 * @return 毫秒
	 */
	public int getMillisecond() {
		return Millisecond = BaseCalendar.get(Calendar.MILLISECOND);
	}

	/**
	 * 设置毫秒
	 * 
	 * @param millisecond 毫秒
	 */
	public void setMillisecond(int millisecond) {
		BaseCalendar.set(Calendar.MILLISECOND, millisecond);
		// Millisecond = BaseCalendar.get(Calendar.MILLISECOND);
	}

	/**
	 * 添加年数
	 * 
	 * @param value 年数
	 */
	public void AddYears(int value) {
		this.setYear(this.getYear() + value);
	}

	/**
	 * 添加月数
	 * 
	 * @param value 月数
	 */
	public void AddMonths(int value) {
		this.setMonth(this.getMonth() + value);
	}

	/**
	 * 添加天数
	 * 
	 * @param value 天数
	 */
	public void AddDays(int value) {
		this.setDay(this.getDay() + value);
	}

	/**
	 * 添加小时
	 * 
	 * @param value 小时
	 */
	public void AddHours(int value) {
		this.setHour(this.getHour() + value);
	}

	/**
	 * 添加分钟
	 * 
	 * @param value 分钟
	 */
	public void AddMinutes(int value) {
		this.setMinute(this.getMinute() + value);
	}

	/**
	 * 添加秒
	 * 
	 * @param value 秒数
	 */
	public void AddSeconds(int value) {
		this.setSecond(this.getSecond() + value);
	}

	/**
	 * 添加毫秒
	 * 
	 * @param value 毫秒
	 */
	public void AddMilliseconds(int value) {
		this.setMillisecond(this.getMillisecond() + value);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 当前时间
	 */
	public DateTime Now() {
		return new DateTime(System.currentTimeMillis());
	}

	/**
	 * 获取总毫秒数
	 * 
	 * @return 总毫秒数
	 */
	public long getTotalMilliseconds() {
		return BaseCalendar.getTimeInMillis();
	}

	/**
	 * 获取总秒数
	 * 
	 * @return 总秒数
	 */
	public long getTotalSeconds() {
		return this.getTotalMilliseconds() / 1000;
	}

	/**
	 * 获取总分种数
	 * 
	 * @return 总分种数
	 */
	public long getTotalMinutes() {
		return this.getTotalSeconds() / 60;
	}

	/**
	 * 获取总小时数
	 * 
	 * @return 总小时数
	 */
	public long getTotalHours() {
		return this.getTotalMinutes() / 60;
	}

	/**
	 * 一年中的第几天
	 * 
	 * @return 一年中的第几天
	 */
	public int DayOfYear() {
		return BaseCalendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 一月中的第几天
	 * 
	 * @return 一月中的第几天
	 */
	public int DayOfMonth() {
		return BaseCalendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 周几
	 * 
	 * @return 周几
	 */
	public int DayOfWeek() {
		return BaseCalendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 一月中的周几
	 * 
	 * @return 一月中的周几
	 */
	public int DayOfWeekInMonth() {
		return BaseCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}

	/**
	 * 是否是闰年
	 * 
	 * @return 如果是闰年则返回true 反之则为false
	 */
	public boolean IsLeapYear() {
		DateTime dt = new DateTime(this.getYear(), 3, 1);
		dt.AddDays(-1);
		return dt.DayOfMonth() == 29;
	}

	/**
	 * 比较大小
	 * 
	 * @param o 时间参数
	 * @return 比参数大则返回1 相等则返回0 比参数小则返回-1
	 */
	@Override
	public int compareTo(DateTime o) {
		if (o == null)
			return 1;
		long x = this.getTotalMilliseconds();
		long y = o.getTotalMilliseconds();
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
	}

	/**
	 * 转换成指定格式的字符串
	 * 
	 * @param format 格式化串
	 * @return 指定格式的字符串
	 */
	public String toString(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = new Date(this.getTotalMilliseconds());
		return simpleDateFormat.format(date);
	}

	/**
	 * 转换成短时间串
	 * 
	 * @return 短时间串
	 */
	public String toShortDateString() {
		return this.toString("yyyy-MM-dd");
	}

	/**
	 * 转换成长时间串
	 * 
	 * @return 长时间串
	 */
	public String toLongDateString() {
		return this.toString("yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * 转换成Date
	 * 
	 * @return Date
	 */
	public Date toDate() {
		return new Date(this.getTotalMilliseconds());
	}

	/**
	 * 转换成Timestamp
	 * 
	 * @return 转换成TimeStamp
	 */
	public Timestamp toTimeStamp() {
		return new Timestamp(this.getTotalMilliseconds());
	}

	/**
	 * 转换成Calendar
	 * 
	 * @return Calendar
	 */
	public Calendar toCalendar() {
		return BaseCalendar;
	}

	/**
	 * 最大值
	 */
	public static final DateTime MaxValue = new DateTime(9999, 1, 1);
	/**
	 * 最小值
	 */
	public static final DateTime MinValue = new DateTime(1900, 01, 01);
	/**
	 * 起始时间
	 */
	public static final DateTime UnixEpoch = new DateTime(1970, 1, 1, 0, 0, 0);

	/**
	 * 当前时间
	 * 
	 * @return 当前时间
	 */
	public static final DateTime now() {
		return new DateTime(System.currentTimeMillis());
	}

	/**
	 * 字符串转换DateTime
	 * 
	 * @param value 字符串
	 * @return DateTime
	 */
	public static final DateTime Parse(String value) {
		try {
			if(RegexHelper.IsDate(value))value+=" 00:00:00.000";
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date = simpleDateFormat.parse(value);
			return new DateTime(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return new DateTime();
		}
	}

	/**
	 * 是否是闰年
	 * 
	 * @param year 年
	 * @return 如果是闰年则返回true 反之则为false
	 */
	public static final boolean isLeapYear(int year) {
		return new DateTime(year, 1, 1).IsLeapYear();
	}

	/**
	 * 某年某月有多少天
	 * 
	 * @param year  年
	 * @param month 月
	 * @return 有多少天
	 */
	public static final int DaysInMonth(int year, int month) {
		DateTime dt = new DateTime(year, month, 1);
		dt.AddMonths(1);
		dt.AddDays(-1);
		return dt.DayOfMonth();
	}
}