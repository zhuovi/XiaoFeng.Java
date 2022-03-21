package xiaofeng.threading;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 作业接口
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
public interface IJob {
	/**
	 * 启动作业
	 */
	void start();

	/**
	 * 停止作业
	 */
	void stop();

	/**
	 * 获取数据
	 * 
	 * @return 数据
	 */
	Object getState();

	/**
	 * 设置数据
	 * 
	 * @param state 数据
	 */
	void setState(Object state);

	/**
	 * 获取是否是异步
	 * 
	 * @return 是否是异步
	 */
	boolean isAsync();

	/**
	 * 设置是否是异步
	 * 
	 * @param async 是否是异步
	 */
	void setAsync(boolean async);

	/**
	 * 获取 成功运行次数
	 * 
	 * @return 成功运行次数
	 */
	int getSuccessCount();

	/**
	 * 设置 成功运行次数
	 * 
	 * @param successCount 成功运行次数
	 */
	void setSuccessCount(int successCount);

	/**
	 * 获取失败运行次数
	 * 
	 * @return 失败运行次数
	 */
	int getFailureCount();

	/**
	 * 设置失败运行次数
	 * 
	 * @param failureCount 失败运行次数
	 */
	void setFailureCount(int failureCount);

	/**
	 * 获取运行日志
	 * 
	 * @return 运行日志
	 */
	List<String> getMessage();

	/**
	 * 设置运行日志
	 * 
	 * @param message 运行日志
	 */
	void setMessage(List<String> message);

	/**
	 * 获取作业ID
	 * 
	 * @return 作业ID
	 */
	UUID getID();

	/**
	 * 设置作业ID
	 * 
	 * @param iD 作业ID
	 */
	void setID(UUID iD);

	/**
	 * 获取作业名称
	 * 
	 * @return 作业名称
	 */
	String getName();

	/**
	 * 设置作业名称
	 * 
	 * @param name 作业名称
	 */
	void setName(String name);

	/**
	 * 获取成功运行回调
	 * 
	 * @return 成功运行回调
	 */
	Consumer<IJob> getSuccessCallBack();

	/**
	 * 设置成功运行回调
	 * 
	 * @param successCallBack 成功运行回调
	 */
	void setSuccessCallBack(Consumer<IJob> successCallBack);

	/**
	 * 获取失败运行回调
	 * 
	 * @return 失败运行回调
	 */
	BiConsumer<IJob, Exception> getFailureCallBack();

	/**
	 * 设置失败运行回调
	 * 
	 * @param failureCallBack 失败运行回调
	 */
	void setFailureCallBack(BiConsumer<IJob, Exception> failureCallBack);

	/**
	 * 获取最后一次运行时间
	 * 
	 * @return 最后一次运行时间
	 */
	Timestamp getLastTime();

	/**
	 * 设置最后一次运行时间
	 * 
	 * @param lastTime 最后一次运行时间
	 */
	void setLastTime(Timestamp lastTime);

	/**
	 * 获取下次运行时间
	 * 
	 * @return 下次运行时间
	 */
	Timestamp getNextTime();

	/**
	 * 设置下次运行时间
	 * 
	 * @param nextTime 下次运行时间
	 */
	void setNextTime(Timestamp nextTime);

	/**
	 * 获取是否调用中
	 * 
	 * @return 是否调用中
	 */
	boolean isCalling();

	/**
	 * 设置是否调用中
	 * 
	 * @param calling 是否调用中
	 */
	void setCalling(boolean calling);

	/**
	 * 获取开始运行时间
	 * 
	 * @return 开始运行时间
	 */
	Timestamp getStartTime();

	/**
	 * 设置开始运行时间
	 * 
	 * @param startTime 开始运行时间
	 */
	void setStartTime(Timestamp startTime);

	/**
	 * 获取最大运行次数
	 * 
	 * @return 最大运行次数
	 */
	int getMaxCount();

	/**
	 * 设置最大运行次数
	 * 
	 * @param maxCount 最大运行次数
	 */
	void setMaxCount(int maxCount);

	/**
	 * 获取过期时间
	 * 
	 * @return 过期时间
	 */
	Timestamp getExpireTime();

	/**
	 * 设置过期时间
	 * 
	 * @param expireTime 过期时间
	 */
	void setExpireTime(Timestamp expireTime);

	/**
	 * 获取运行完是否销毁
	 * 
	 * @return 运行完是否销毁
	 */
	boolean isDestroy();

	/**
	 * 设置运行完是否销毁
	 * 
	 * @param destroy 运行完是否销毁
	 */
	void setDestroy(boolean destroy);

	/**
	 * 获取定时器类型
	 * 
	 * @return 定时器类型
	 */
	TimerType getTimerType();

	/**
	 * 设置定时器类型
	 * 
	 * @param timerType 定时器类型
	 */
	void setTimerType(TimerType timerType);

	/**
	 * 获取时间
	 * 
	 * @return 时间
	 */
	Time getTime();

	/**
	 * 设置时间
	 * 
	 * @param time 时间
	 */
	void setTime(Time time);

	/**
	 * 获取间隔时长
	 * 
	 * @return 间隔时长
	 */
	int getPeriod();

	/**
	 * 设置间隔时长
	 * 
	 * @param period 间隔时长
	 */
	void setPeriod(int period);

	/**
	 * 获取是几号还是周几
	 * 
	 * @return 是几号还是周几
	 */
	int[] getDayOrWeekOrHour();

	/**
	 * 设置是几号还是周几
	 * 
	 * @param dayOrWeekOrHour 是几号还是周几
	 */
	void setDayOrWeekOrHour(int[] dayOrWeekOrHour);

	/**
	 * 获取运行次数
	 * 
	 * @return 返回运行次数
	 */
	int count();

	/**
	 * 添加运行日志
	 * 
	 * @param message 运行日志
	 */
	void addMessage(String message);

	/**
	 * 自动增加1个成功数
	 */
	void addSuccessCount();

	/**
	 * 自动增加1个失败运行次数
	 */
	void addFailureCount();

}
