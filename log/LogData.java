package xiaofeng.log;

import xiaofeng.core.DateTime;

/**
 * 日志数据结构
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
public class LogData {
	/**
	 * 无参构造器
	 */
	public LogData() {
		this.CreateTime = DateTime.now();
	}

	/**
	 * 设置日志信息
	 * 
	 * @param message 日志信息
	 */
	public LogData(String message) {
		this(LogType.Info, message);
	}

	/**
	 * 设置日志信息
	 * 
	 * @param logType 日志类型
	 * @param message 日志信息
	 */
	public LogData(LogType logType, String message) {
		this();
		this.logType = logType;
		this.Message = message;
	}

	/**
	 * 错误ID
	 */
	private String ErrorID;
	/**
	 * 方法名
	 */
	private String FunctionName;
	/**
	 * 类名称
	 */
	private String ClassName;
	/**
	 * 错误信息
	 */
	private String Message;
	/**
	 * 错误源
	 */
	private String DataSource;
	/**
	 * 日志类型
	 */
	private LogType logType;
	/**
	 * 错误堆栈
	 */
	private String StackTrace;
	/**
	 * 时间
	 */
	private DateTime CreateTime;

	/**
	 * 获取错误ID
	 * @return 错误ID
	 */
	public String getErrorID() {
		return ErrorID;
	}

	/**
	 * 设置错误ID
	 * @param errorID 错误ID
	 */
	public void setErrorID(String errorID) {
		ErrorID = errorID;
	}

	/**
	 * 获取方法名
	 * @return 方法名
	 */
	public String getFunctionName() {
		return FunctionName;
	}

	/**
	 * 设置方法名
	 * @param functionName 方法名
	 */
	public void setFunctionName(String functionName) {
		FunctionName = functionName;
	}

	/**
	 * 获取类名称
	 * @return 类名称
	 */
	public String getClassName() {
		return ClassName;
	}

	/**
	 * 设置类名称
	 * @param className 类名称
	 */
	public void setClassName(String className) {
		ClassName = className;
	}

	/**
	 * 获取错误信息
	 * @return 错误信息
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * 设置错误信息
	 * @param message 错误信息
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * 获取错误源
	 * @return 错误源
	 */
	public String getDataSource() {
		return DataSource;
	}

	/**
	 * 设置错误源
	 * @param dataSource 错误源
	 */
	public void setDataSource(String dataSource) {
		DataSource = dataSource;
	}

	/**
	 * 获取日志类型
	 * @return 日志类型
	 */
	public LogType getLogType() {
		return logType;
	}

	/**
	 * 设置日志类型
	 * @param logType 日志类型
	 */
	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	/**
	 * 获取错误堆栈
	 * @return 错误堆栈
	 */
	public String getStackTrace() {
		return StackTrace;
	}

	/**
	 * 设置错误堆栈
	 * @param stackTrace 错误堆栈
	 */
	public void setStackTrace(String stackTrace) {
		StackTrace = stackTrace;
	}

	/**
	 * 获取时间
	 * @return 时间
	 */
	public DateTime getCreateTime() {
		return CreateTime;
	}

	/**
	 * 设置时间
	 * @param createTime 时间
	 */
	public void setCreateTime(DateTime createTime) {
		CreateTime = createTime;
	}
}