package xiaofeng.core;

/**
 * 时间间隔操作类
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
public class StopWatch {
	/**
	 * 获取执行时长
	 * 
	 * @param func 方法
	 * @return 执行时长 单位为毫秒
	 */
	public static long getTime(Runnable func) {
		long start = System.currentTimeMillis();
		func.run();
		return System.currentTimeMillis() - start;
	}
}