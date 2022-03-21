package xiaofeng.config;

import xiaofeng.annotations.ConfigFile;
import xiaofeng.annotations.Description;

/**
 * XIAOFENG配置操作类
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
@ConfigFile(FileName = "Config/XiaoFeng.json", CacheKey = "FAYELF_XIAOFENG", configFormat = ConfigFormat.Json, Timeout = 0)
public class Setting extends ConfigSet<Setting> {
	/**
	 * 是否开启调试
	 */
	@Description(value = "是否开启调试")
	private boolean Debug = false;
	/**
	 * 是否开启日志
	 */
	@Description(value = "是否开启日志")
	private boolean Log = false;
	/**
	 * 日志保存路径
	 */
	@Description(value = "日志保存路径")
	private String LogPath = "Logs";
	/**
	 * 数据是否加密
	 */
	@Description(value = "数据是否加密")
	private boolean DataEncrypt = false;
	/**
	 * 加密Key
	 */
	@Description(value = "加密Key")
	private String DataKey = "7092734";
	/**
	 * 是否记录请求日志
	 */
	@Description(value = "是否记录请求日志")
	private boolean ServerLogging;

	/**
	 * 获取是否开启调试
	 * 
	 * @return 开启调试
	 */
	public boolean isDebug() {
		return Debug;
	}

	/**
	 * 设置调试状态
	 * 
	 * @param debug 开启调试
	 */
	public void setDebug(boolean debug) {
		Debug = debug;
	}

	/**
	 * 获取是否开启日志记录
	 * 
	 * @return 开启日志记录
	 */
	public boolean isLog() {
		return Log;
	}

	/**
	 * 设置是否开启日志记录
	 * 
	 * @param log 开启日志记录
	 */
	public void setLog(boolean log) {
		Log = log;
	}

	/**
	 * 获取日志保存路径
	 * 
	 * @return 日志保存路径
	 */
	public String getLogPath() {
		return LogPath;
	}

	/**
	 * 设置日志保存路径
	 * 
	 * @param logPath 日志保存路径
	 */
	public void setLogPath(String logPath) {
		LogPath = logPath;
	}

	/**
	 * 获取数据是否加密
	 * 
	 * @return the 数据是否加密
	 */
	public boolean isDataEncrypt() {
		return DataEncrypt;
	}

	/**
	 * 设置数据是否加密
	 * 
	 * @param dataEncrypt 数据是否加密
	 */
	public void setDataEncrypt(boolean dataEncrypt) {
		DataEncrypt = dataEncrypt;
	}

	/**
	 * 获取加密key
	 * 
	 * @return 加密Key
	 */
	public String getDataKey() {
		return DataKey;
	}

	/**
	 * 设置加密key
	 * 
	 * @param dataKey 加密Key
	 */
	public void setDataKey(String dataKey) {
		DataKey = dataKey;
	}

	/**
	 * 获取是否记录请求日志
	 * 
	 * @return 是否记录请求日志
	 */
	public boolean isServerLogging() {
		return ServerLogging;
	}

	/**
	 * 设置是否记录请求日志
	 * 
	 * @param serverLogging 是否记录请求日志
	 */
	public void setServerLogging(boolean serverLogging) {
		ServerLogging = serverLogging;
	}

}