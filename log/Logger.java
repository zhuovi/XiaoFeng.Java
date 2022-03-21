package xiaofeng.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

import xiaofeng.config.Setting;
import xiaofeng.core.DateTime;
import xiaofeng.core.StringHelper;
import xiaofeng.io.FileHelper;

/**
 * 日志记录器操作类
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
public class Logger {
	/**
	 * 无参构造器
	 */
	public Logger() {

	}

	/**
	 * 设置路径
	 * 
	 * @param path 路径
	 */
	public Logger(String path) {
		this(path, "");
	}

	/**
	 * 日志对象队列
	 */
	private static ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	/**
	 * 设置路径及文件名
	 * 
	 * @param path     路径
	 * @param filename 文件名
	 */
	public Logger(String path, String filename) {
		this.Path = path;
		this.FileName = filename;
	}

	/**
	 * 路径
	 */
	private String Path;
	/**
	 * 文件名
	 */
	private String FileName;
	/**
	 * 一个日志文件大小
	 */
	private long MaxContentLength = 10 * 1024 * 1024;
	/**
	 * 队列
	 */
	private LinkedBlockingQueue<LogData> queue = new LinkedBlockingQueue<LogData>();

	/**
	 * 获取路径
	 * 
	 * @return 路径
	 */
	public String getPath() {
		return Path;
	}

	/**
	 * 设置路径
	 * 
	 * @param path 路径
	 */
	public void setPath(String path) {
		Path = path;
	}

	/**
	 * 获取文件名
	 * 
	 * @return 文件名
	 */
	public String getFileName() {
		return FileName;
	}

	/**
	 * 设置文件名
	 * 
	 * @param fileName 文件名
	 */
	public void setFileName(String fileName) {
		FileName = fileName;
	}

	/**
	 * 获取一个日志文件大小
	 * 
	 * @return 一个日志文件大小
	 */
	public long getMaxContentLength() {
		return MaxContentLength;
	}

	/**
	 * 设置一个日志文件大小
	 * 
	 * @param maxContentLength 一个日志文件大小
	 */
	public void setMaxContentLength(long maxContentLength) {
		MaxContentLength = maxContentLength;
	}

	/**
	 * 获取文件名称
	 * 
	 * @param logType 日志类型
	 * @param add     文件名是否加1
	 * @return 日志文件路径
	 */
	public synchronized String GetFileName(LogType logType, boolean add) {
		String path = "";
		if (StringHelper.IsNullOrEmpty(this.getPath())) {
			Setting setting = Setting.Current(Setting.class);
			path += setting.getLogPath();
		} else {
			path += this.getPath();
		}
		path += File.separator + logType.name().toLowerCase() + File.separator;
		if (StringHelper.IsNullOrEmpty(this.FileName)) {
			String curDate = DateTime.now().toString("yyyy-MM-dd");
			path += curDate;
			if (map.containsKey(curDate)) {
				int val = map.get(curDate);
				if (add) {
					map.put(curDate, ++val);
				}
				path += val == 0 ? "" : ("-" + val);
			} else {
				map.clear();
				map.put(curDate, 0);
			}
			path += ".log";
		} else
			path += this.FileName;
		return path;
	}

	/**
	 * 写日志文件
	 * 
	 * @param logData 日志对象
	 * @throws IOException 写文件抛出异常
	 */
	public synchronized void writeFile(LogData logData) throws IOException {
		if (logData == null)
			return;
		String path = this.GetFileName(logData.getLogType(), false);
		File file = FileHelper.newFile(path);
		while (file.length() >= this.getMaxContentLength()) {
			file = FileHelper.newFile(this.GetFileName(logData.getLogType(), true));
		}
		FileOutputStream fos = new FileOutputStream(file, true);
		StringBuffer sb = new StringBuffer();
		String doubleLine = "=".repeat(60);
		// String singleLine = "-".repeat(100);
		if (file.length() == 0) {
			sb.append(doubleLine + "\n");
			sb.append("\t应用日志文件  v1.0\n");
			sb.append(doubleLine + "\n");
			sb.append("\t公司 : 魔法精灵(www.fayelf.com)\n");
			sb.append("\t作者 : jacky\n");
			sb.append("\tQQ : 7092734\n");
			sb.append("\tEmail : jacky@fayelf.com\n");
			sb.append("\t创建时间 : " + DateTime.now().toLongDateString() + "\n");
		}
		sb.append(doubleLine + "\n");
		sb.append("时间 : [" + logData.getCreateTime().toLongDateString() + "]\t类型 : [" + logData.getLogType().name()
				+ "]-" + logData.getLogType().getDescription());
		sb.append("\t线程 : " + Thread.currentThread().getName() + "[ID:" + Thread.currentThread().getId() + "]");
		if (!StringHelper.IsNullOrEmpty(logData.getErrorID()))
			sb.append("\tID : " + logData.getErrorID());
		sb.append("\n");
		sb.append(doubleLine + "\n");
		if (!StringHelper.IsNullOrEmpty(logData.getFunctionName())
				|| !StringHelper.IsNullOrEmpty(logData.getClassName())
				|| !StringHelper.IsNullOrEmpty(logData.getDataSource())) {
			if (!StringHelper.IsNullOrEmpty(logData.getDataSource()))
				sb.append("数据源 : " + logData.getDataSource() + "\n");
			if (!StringHelper.IsNullOrEmpty(logData.getFunctionName()))
				sb.append("方法名称 : " + logData.getFunctionName() + "\n");
			if (!StringHelper.IsNullOrEmpty(logData.getClassName()))
				sb.append("类名称 : " + logData.getClassName() + "\n");
		}
		if (!StringHelper.IsNullOrEmpty(logData.getMessage())) {
			// sb.append(singleLine + "\n");
			sb.append("日志信息 : " + logData.getMessage() + "\n");
		}
		if (!StringHelper.IsNullOrEmpty(logData.getStackTrace())) {
			// sb.append(singleLine + "\n");
			sb.append("堆栈 : " + logData.getStackTrace() + "\n");
		}
		fos.write(sb.toString().getBytes(Charset.forName("utf-8")));
		fos.flush();
		fos.close();
	}

	/**
	 * 写日志文件
	 * 
	 * @param logData 日志对象
	 * @throws InterruptedException 抛出异常
	 */
	public synchronized void write(LogData logData) throws InterruptedException {
		this.queue.put(logData);
		this.notify();
	}

	/**
	 * 写日志文件
	 * 
	 * @throws InterruptedException 操作中断抛出异常
	 * @throws IOException          写文件抛出异常
	 */
	public synchronized void writeLog() throws InterruptedException, IOException {
		while (true) {
			if (this.queue.isEmpty())
				this.wait();
			this.writeFile(this.queue.poll());
		}
	}
}