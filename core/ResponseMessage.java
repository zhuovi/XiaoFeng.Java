package xiaofeng.core;

/**
 * 输出对象操作类
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
public class ResponseMessage<T> {
	/**
	 * 无参构造器
	 */
	public ResponseMessage() {
	}

	/**
	 * 设置输出状态
	 * 
	 * @param status 状态
	 */
	public ResponseMessage(ResponseState status) {
		this.Status = status;
	}

	/**
	 * 设置输出状态及消息
	 * 
	 * @param status  状态
	 * 
	 * @param message 消息
	 */
	public ResponseMessage(ResponseState status, String message) {
		this.Status = status;
		this.Message = message;
	}

	/**
	 * 数据
	 */
	public T Data;
	/**
	 * 消息
	 */
	public String Message;
	/**
	 * 状态
	 */
	public ResponseState Status;
	/**
	 * 输出时间
	 */
	public int Time;
	/**
	 * 状态码
	 */
	public int Code;
	/**
	 * 其它数据
	 */
	public Object Other;
}