package xiaofeng.http;

import java.net.*;
import java.nio.charset.Charset;

/**
 * http请求基础类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-11
 * @param <T> 对象
 * @since 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public class HttpBase<T extends HttpBase> {
	/**
	 * 无参构造器
	 */
	public HttpBase() {

	}

	/**
	 * 请求网址
	 */
	protected URL Url;
	/**
	 * 请求类型
	 */
	private HttpMethod Method;
	/**
	 * 编码
	 */
	private Charset charset = Charset.forName("UTF-8");

	/**
	 * 获取请求网址
	 * 
	 * @return 请求网址
	 */
	public URL getUrl() {
		return Url;
	}

	/**
	 * 获取对象
	 * 
	 * @param url URL
	 * @return 请求对象
	 */
	@SuppressWarnings("unchecked")
	public T Url(URL url) {
		Url = url;
		return (T) this;
	}

	/**
	 * 获取请求类型
	 * 
	 * @return 请求类型
	 */
	public HttpMethod getMethod() {
		return Method;
	}

	/**
	 * 设置请求类型
	 * 
	 * @param method 请求类型
	 * @return 请求对象
	 */
	@SuppressWarnings("unchecked")
	public T setMethod(HttpMethod method) {
		Method = method;
		return (T) this;
	}

	/**
	 * 获取请求编码
	 * 
	 * @return 编码
	 */
	public Charset getCharset() {
		return charset;
	}

	/**
	 * 设置请求编码
	 * 
	 * @param charset 编码
	 */
	public void setCharset(Charset charset) {
		this.charset = charset;
	}

}