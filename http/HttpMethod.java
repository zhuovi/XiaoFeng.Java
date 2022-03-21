package xiaofeng.http;

/**
 * 请求类型
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
public enum HttpMethod {
	/**
	 * GET
	 */
	GET(0),
	/**
	 * POST
	 */
	POST(1),
	/**
	 * HEAD
	 */
	HEAD(2),
	/**
	 * PUT
	 */
	PUT(3),
	/**
	 * DELETE
	 */
	DELETE(4),
	/**
	 * OPTIONS
	 */
	OPTIONS(5),
	/**
	 * CONNECT
	 */
	CONNECT(6),
	/**
	 * TRACE
	 */
	TRACE(7);

	/**
	 * 构造器
	 * 
	 * @param value 值
	 */
	HttpMethod(int value) {
		this.Value = value;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return Value;
	}

	/**
	 * 值
	 */
	private int Value;
}
