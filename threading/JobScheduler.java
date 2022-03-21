package xiaofeng.threading;

import java.util.*;
import java.util.concurrent.*;

import xiaofeng.core.DateTime;
import xiaofeng.core.StringHelper;
import xiaofeng.log.LogHelper;

/**
 * 调度器操作类
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
public class JobScheduler implements IJobScheduler {
	public JobScheduler(String name) {
		this.Name = name;
	}

	static {

	}
	/**
	 * 调度器集合
	 */
	private static final ConcurrentMap<String, JobScheduler> Schedulers = new ConcurrentHashMap<String, JobScheduler>();
	/**
	 * 调度器名称
	 */
	private String Name = "Default";
	/**
	 * 间隔时长 单位为毫秒
	 */
	private int Period = 1 * 60 * 60 * 1000;
	/**
	 * 作业列表
	 */
	private List<IJob> JobList = new ArrayList<>();
	/**
	 * 主线程
	 */
	private Thread MainThread;
	/**
	 * 单例
	 */
	private static JobScheduler instance;

	/**
	 * 单例
	 */
	public static synchronized JobScheduler getDefault() {
		if (instance == null)
			instance = createScheduler("Default");
		return instance;
	}

	/**
	 * 创建高度器
	 * 
	 * @param name 调度名称
	 */
	public static synchronized JobScheduler createScheduler(String name) {
		if (Schedulers.containsKey(name))
			return Schedulers.get(name);
		JobScheduler sc = new JobScheduler(name);
		Schedulers.put(name, sc);
		LogHelper.info("启动调度器:" + name);
		return sc;
	}

	/**
	 * 添加作业
	 * 
	 * @param job 作业
	 */
	public void put(IJob job) {
		if (job == null || this.JobList.contains(job))
			return;

	}

	/**
	 * 移除作业
	 * 
	 * @param job 作业
	 */
	public void remove(IJob job) {
		if (job == null || !this.JobList.contains(job))
			return;
	}

	/**
	 * 唤醒处理
	 */
	public void wake() {

	}

	/**
	 * 执行作业
	 * 
	 * @param state 数据
	 */
	private void execute(Object state) {

	}

	/**
	 * 执行成功后执行
	 * 
	 * @param job 作业
	 */
	private void success(IJob job) {
		job.addMessage(StringHelper.format("执行作业[{0}]成功.[{1}]", job.getName(),
				DateTime.now().toString("yyyy-MM-dd HH:mm:ss.fff")));
		job.addSuccessCount();
		if (job.getTimerType() == TimerType.Once || job.isDestroy()
				|| (job.getMaxCount() > -1 && job.count() >= job.getMaxCount())) {
			job.stop();
			this.JobList.remove(job);
			return;
		}
	}

	/**
	 * 执行失败后执行
	 * 
	 * @param job 作业
	 */
	private void failure(IJob job) {
		job.addMessage(StringHelper.format("执行作业[{0}]失败.[{1}]", job.getName(),
				DateTime.now().toString("yyyy-MM-dd HH:mm:ss.fff")));
		job.addFailureCount();
		if (job.getTimerType() == TimerType.Once || job.isDestroy()
				|| (job.getMaxCount() > -1 && job.count() >= job.getMaxCount())) {
			job.stop();
			this.JobList.remove(job);
			return;
		}
	}

	/**
	 * 获取离当前值最接近的索引
	 * 
	 * @param arr 数组
	 * @param val 值
	 * @return 获取离当前值最接近的索引
	 */
	private int getIndex(int[] arr, int val) {
		int Index = -1, Val = -1;
		if (arr == null || arr.length == 0)
			return Index;
		for (int i = 0; i < arr.length; i++) {
			int v = arr[i] - val;
			if (v >= 0 && v <= Val) {
				Index = i;
				Val = v;
			}
		}
		return Index == -1 ? 0 : Index;
	}

}