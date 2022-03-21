package xiaofeng.log;

/**
 * 日志操作类
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
public class LogHelper {
	/**
	 * 日志操作类
	 */
	private static Logger log = new Logger();
	/**
	 * 写日志线程
	 */
	private static Thread ThreadMain;

	/**
	 * @无参构造器
	 */
	private LogHelper() {

	}

	/**
	 * 记录日志
	 * 
	 * @param logData 日志对象
	 */
	public static void write(LogData logData) {
		if (ThreadMain == null) {
			ThreadMain = new Thread(new LogThread(log), "LogMainThread");
			ThreadMain.start();
		}
		try {
			log.write(logData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 记录日志
	 * 
	 * @param logType 日志类型
	 * @param message 日志消息
	 */
	public static void write(LogType logType, String message) {
		LogData logData = new LogData();
		logData.setLogType(logType);
		logData.setMessage(message);
		write(logData);
	}

	/**
	 * 记录日志
	 * 
	 * @param message 日志消息
	 */
	public static void write(String message) {
		write(LogType.Info, message);
	}

	/**
	 * 记录日志
	 * 
	 * @param ex 错误对象
	 */
	public static void write(Exception ex) {
		write(ex, "");
	}

	/**
	 * 记录消息日志
	 * 
	 * @param message 消息
	 */
	public static void info(String message) {
		write(LogType.Info, message);
	}

	/**
	 * 记录警告日志
	 * 
	 * @param message 消息
	 */
	public static void warn(String message) {
		write(LogType.Warn, message);
	}

	/**
	 * 记录调试日志
	 * 
	 * @param message 消息
	 */
	public static void debug(String message) {
		write(LogType.Debug, message);
		String DoubleLine = "*".repeat(20);
		System.out.println("\n" + DoubleLine + "begin debug info" + DoubleLine + "\n" + message + "\n" + DoubleLine
				+ " end debug info " + DoubleLine);
	}

	/**
	 * 记录错误日志
	 * 
	 * @param ex 错误对象
	 */
	public static void error(Exception ex) {
		error(ex, "");
	}

	/**
	 * 记录错误日志
	 * 
	 * @param ex      错误对象
	 * @param message 消息
	 */
	public static void error(Exception ex, String message) {
		write(ex, message);
	}

	/**
	 * 记录日志
	 * 
	 * @param ex      错误对象
	 * @param message 消息
	 */
	public static void write(Exception ex, String message) {
		LogData logData = new LogData();
		logData.setLogType(LogType.Error);
		logData.setMessage(ex.getMessage() + (message.isEmpty() ? "" : ("[" + message + "]")));
		String stels = "";
		for (StackTraceElement ste : ex.getStackTrace()) {
			stels += ste;
		}
		logData.setStackTrace(stels);
		StackTraceElement trace = ex.getStackTrace()[0];
		if (trace != null) {
			logData.setClassName(trace.getClassName());
			logData.setFunctionName(trace.getMethodName());
			logData.setDataSource(trace.getModuleName());
		}
		write(logData);
	}

}