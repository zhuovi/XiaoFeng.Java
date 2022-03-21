package xiaofeng.log;

import java.io.IOException;

/**
 * 写日志线程
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
public class LogThread implements Runnable {
	/**
	 * 日志操作对象
	 */
	private Logger logger;

	/**
	 * 设置日志操作对象
	 * 
	 * @param log 日志操作对象
	 */
	public LogThread(Logger log) {
		this.logger = log;
	}

	/**
	 * 线程启动方法
	 */
	@Override
	public void run() {
		try {
			logger.writeLog();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
