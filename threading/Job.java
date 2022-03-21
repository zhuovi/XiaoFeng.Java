package xiaofeng.threading;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 作业操作类
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
public class Job implements IJob {
	/**
	 * 当前调度
	 */
	private IJobScheduler Scheduler;
	/**
	 * 数据
	 */
	private Object State = null;
	/**
	 * 是否是异步
	 */
	private boolean Async = true;
	/**
	 * 成功运行次数
	 */
	private int SuccessCount = 0;
	/**
	 * 失败运行次数
	 */
	private int FailureCount = 0;
	/**
	 * 运行日志
	 */
	private List<String> Message = new ArrayList<>();
	/**
	 * 作业ID
	 */
	private UUID ID = UUID.randomUUID();
	/**
	 * 作业名称
	 */
	private String Name;
	/**
	 * 运行成功回调
	 */
	private Consumer<IJob> SuccessCallBack;
	/**
	 * 运行失败回调
	 */
	private BiConsumer<IJob, Exception> FailureCallBack;
	/**
	 * 最后一次运行时间
	 */
	private Timestamp LastTime;
	/**
	 * 下次运行时间
	 */
	private Timestamp NextTime;
	/**
	 * 是否调用中
	 */
	private boolean Calling;
	/**
	 * 开始运行时间
	 */
	private Timestamp StartTime;
	/**
	 * 最大运行次数
	 */
	private int MaxCount = -1;
	/**
	 * 过期时间
	 */
	private Timestamp ExpireTime;
	/**
	 * 运行完是否销毁
	 */
	private boolean Destroy;
	/**
	 * 定时器类型
	 */
	private TimerType timerType;
	/**
	 * 时间
	 */
	private Time time;
	/**
	 * 间隔时长 单位为毫秒
	 */
	private int Period;
	/**
	 * 是几号还是周几
	 */
	private int[] DayOrWeekOrHour;

	/**
	 * 获取当前调度
	 * 
	 * @return 当前调度
	 */
	public IJobScheduler getScheduler() {
		if (Scheduler == null)
			Scheduler = JobScheduler.getDefault();
		return Scheduler;
	}

	/**
	 * 设置当前调度
	 * 
	 * @param scheduler 当前调度
	 */
	public void setScheduler(IJobScheduler scheduler) {
		Scheduler = scheduler;
	}

	/**
	 * 获取数据
	 * 
	 * @return 数据
	 */
	@Override
	public Object getState() {
		return State;
	}

	/**
	 * 设置数据
	 * 
	 * @param state 数据
	 */
	@Override
	public void setState(Object state) {
		State = state;
	}

	/**
	 * 获取是否是异步
	 * 
	 * @return 是否是异步
	 */
	@Override
	public boolean isAsync() {
		return Async;
	}

	/**
	 * 设置是否是异步
	 * 
	 * @param async 是否是异步
	 */
	@Override
	public void setAsync(boolean async) {
		Async = async;
	}

	/**
	 * 获取 成功运行次数
	 * 
	 * @return 成功运行次数
	 */
	@Override
	public int getSuccessCount() {
		return SuccessCount;
	}

	/**
	 * 设置 成功运行次数
	 * 
	 * @param successCount 成功运行次数
	 */
	@Override
	public void setSuccessCount(int successCount) {
		SuccessCount = successCount;
	}

	/**
	 * 自动增加1个成功数
	 */
	@Override
	public void addSuccessCount() {
		this.SuccessCount++;
	}

	/**
	 * 获取失败运行次数
	 * 
	 * @return 失败运行次数
	 */
	@Override
	public int getFailureCount() {
		return FailureCount;
	}

	/**
	 * 设置失败运行次数
	 * 
	 * @param failureCount 失败运行次数
	 */
	@Override
	public void setFailureCount(int failureCount) {
		FailureCount = failureCount;
	}

	/**
	 * 自动增加1个失败运行次数
	 */
	@Override
	public void addFailureCount() {
		this.FailureCount++;
	}

	/**
	 * 获取运行日志
	 * 
	 * @return 运行日志
	 */
	@Override
	public List<String> getMessage() {
		return Message;
	}

	/**
	 * 设置运行日志
	 * 
	 * @param message 运行日志
	 */
	@Override
	public void setMessage(List<String> message) {
		Message = message;
	}

	/**
	 * 添加运行日志
	 * 
	 * @param message 运行日志
	 */
	@Override
	public void addMessage(String message) {
		this.Message.add(message);
	}

	/**
	 * 获取作业ID
	 * 
	 * @return 作业ID
	 */
	@Override
	public UUID getID() {
		return ID;
	}

	/**
	 * 设置作业ID
	 * 
	 * @param iD 作业ID
	 */
	@Override
	public void setID(UUID iD) {
		ID = iD;
	}

	/**
	 * 获取作业名称
	 * 
	 * @return 作业名称
	 */
	@Override
	public String getName() {
		return Name;
	}

	/**
	 * 设置作业名称
	 * 
	 * @param name 作业名称
	 */
	@Override
	public void setName(String name) {
		Name = name;
	}

	/**
	 * 获取成功运行回调
	 * 
	 * @return 成功运行回调
	 */
	@Override
	public Consumer<IJob> getSuccessCallBack() {
		return SuccessCallBack;
	}

	/**
	 * 设置成功运行回调
	 * 
	 * @param successCallBack 成功运行回调
	 */
	@Override
	public void setSuccessCallBack(Consumer<IJob> successCallBack) {
		SuccessCallBack = successCallBack;
	}

	/**
	 * 获取失败运行回调
	 * 
	 * @return 失败运行回调
	 */
	@Override
	public BiConsumer<IJob, Exception> getFailureCallBack() {
		return FailureCallBack;
	}

	/**
	 * 设置失败运行回调
	 * 
	 * @param failureCallBack 失败运行回调
	 */
	@Override
	public void setFailureCallBack(BiConsumer<IJob, Exception> failureCallBack) {
		FailureCallBack = failureCallBack;
	}

	/**
	 * 获取最后一次运行时间
	 * 
	 * @return 最后一次运行时间
	 */
	@Override
	public Timestamp getLastTime() {
		return LastTime;
	}

	/**
	 * 设置最后一次运行时间
	 * 
	 * @param lastTime 最后一次运行时间
	 */
	@Override
	public void setLastTime(Timestamp lastTime) {
		LastTime = lastTime;
	}

	/**
	 * 获取下次运行时间
	 * 
	 * @return 下次运行时间
	 */
	@Override
	public Timestamp getNextTime() {
		return NextTime;
	}

	/**
	 * 设置下次运行时间
	 * 
	 * @param nextTime 下次运行时间
	 */
	@Override
	public void setNextTime(Timestamp nextTime) {
		NextTime = nextTime;
	}

	/**
	 * 获取是否调用中
	 * 
	 * @return 是否调用中
	 */
	@Override
	public boolean isCalling() {
		return Calling;
	}

	/**
	 * 设置是否调用中
	 * 
	 * @param calling 是否调用中
	 */
	@Override
	public void setCalling(boolean calling) {
		Calling = calling;
	}

	/**
	 * 获取开始运行时间
	 * 
	 * @return 开始运行时间
	 */
	@Override
	public Timestamp getStartTime() {
		return StartTime;
	}

	/**
	 * 设置开始运行时间
	 * 
	 * @param startTime 开始运行时间
	 */
	@Override
	public void setStartTime(Timestamp startTime) {
		StartTime = startTime;
	}

	/**
	 * 获取最大运行次数
	 * 
	 * @return 最大运行次数
	 */
	@Override
	public int getMaxCount() {
		return MaxCount;
	}

	/**
	 * 设置最大运行次数
	 * 
	 * @param maxCount 最大运行次数
	 */
	@Override
	public void setMaxCount(int maxCount) {
		MaxCount = maxCount;
	}

	/**
	 * 获取过期时间
	 * 
	 * @return 过期时间
	 */
	@Override
	public Timestamp getExpireTime() {
		return ExpireTime;
	}

	/**
	 * 设置过期时间
	 * 
	 * @param expireTime 过期时间
	 */
	@Override
	public void setExpireTime(Timestamp expireTime) {
		ExpireTime = expireTime;
	}

	/**
	 * 获取运行完是否销毁
	 * 
	 * @return 运行完是否销毁
	 */
	@Override
	public boolean isDestroy() {
		return Destroy;
	}

	/**
	 * 设置运行完是否销毁
	 * 
	 * @param destroy 运行完是否销毁
	 */
	@Override
	public void setDestroy(boolean destroy) {
		Destroy = destroy;
	}

	/**
	 * 获取定时器类型
	 * 
	 * @return 定时器类型
	 */
	@Override
	public TimerType getTimerType() {
		return timerType;
	}

	/**
	 * 设置定时器类型
	 * 
	 * @param timerType 定时器类型
	 */
	@Override
	public void setTimerType(TimerType timerType) {
		this.timerType = timerType;
	}

	/**
	 * 获取时间
	 * 
	 * @return 时间
	 */
	@Override
	public Time getTime() {
		return time;
	}

	/**
	 * 设置时间
	 * 
	 * @param time 时间
	 */
	@Override
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * 获取间隔时长
	 * 
	 * @return 间隔时长
	 */
	@Override
	public int getPeriod() {
		return Period;
	}

	/**
	 * 设置间隔时长
	 * 
	 * @param period 间隔时长
	 */
	@Override
	public void setPeriod(int period) {
		Period = period;
	}

	/**
	 * 获取是几号还是周几
	 * 
	 * @return 是几号还是周几
	 */
	@Override
	public int[] getDayOrWeekOrHour() {
		return DayOrWeekOrHour;
	}

	/**
	 * 设置是几号还是周几
	 * 
	 * @param dayOrWeekOrHour 是几号还是周几
	 */
	@Override
	public void setDayOrWeekOrHour(int[] dayOrWeekOrHour) {
		DayOrWeekOrHour = dayOrWeekOrHour;
	}

	/**
	 * 获取运行次数
	 * 
	 * @return 返回运行次数
	 */
	@Override
	public int count() {
		return this.getSuccessCount() + this.getFailureCount();
	}

	/**
	 * 启动作业
	 */
	@Override
	public void start() {

	}

	/**
	 * 停止作业
	 */
	@Override
	public void stop() {

	}
}