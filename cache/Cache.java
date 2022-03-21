package xiaofeng.cache;

/**
 * 缓存操作类
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
public class Cache {
	/**
	 * 缓存Key
	 */
	private String Key;
	/**
	 * 缓存值
	 */
	private Object Value;
	/**
	 * 缓存超时时间
	 */
	private long TimeOut;

	/**
	 * 获取缓存key
	 * 
	 * @return 缓存Key
	 */
	public String getKey() {
		return Key;
	}

	/**
	 * 设置缓存key
	 * 
	 * @param key 缓存Key
	 */
	public void setKey(String key) {
		Key = key;
	}

	/**
	 * 获取缓存值
	 * 
	 * @return 缓存值
	 */
	public Object getValue() {
		return Value;
	}

	/**
	 * 设置缓存值
	 * 
	 * @param value 缓存值
	 */
	public void setValue(Object value) {
		Value = value;
	}

	/**
	 * 获取缓存超时时间
	 * 
	 * @return 缓存超时时间
	 */
	public long getTimeOut() {
		return TimeOut;
	}

	/**
	 * 设置缓存超时时间
	 * 
	 * @param timeOut 缓存超时时间
	 */
	public void setTimeOut(long timeOut) {
		TimeOut = timeOut;
	}
}