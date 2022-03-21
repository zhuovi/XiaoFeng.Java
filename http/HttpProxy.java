package xiaofeng.http;

/**
 * HTTP请求代理认证对象
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
public class HttpProxy {
	/**
	 * 无参构造器
	 */
	public HttpProxy() {
	}

	/**
	 * 设置Http代理
	 * 
	 * @param host Host
	 * @param port 端口
	 */
	public HttpProxy(String host, int port) {
		this(host, port, "", "");
	}

	/**
	 * 设置Http代理
	 * 
	 * @param host     Host
	 * @param port     端口
	 * @param userName 帐号
	 * @param password 密码
	 */
	public HttpProxy(String host, int port, String userName, String password) {
		this.Host = host;
		this.Port = port;
		this.UserName = userName;
		this.Password = password;
	}

	/**
	 * Host
	 */
	private String Host;
	/**
	 * 端口
	 */
	private int Port;
	/**
	 * 帐号
	 */
	private String UserName;
	/**
	 * 密码
	 */
	private String Password;

	/**
	 * 获取Host
	 * 
	 * @return Host
	 */
	public String getHost() {
		return Host;
	}

	/**
	 * 设置Host
	 * 
	 * @param host Host
	 */
	public void setHost(String host) {
		Host = host;
	}

	/**
	 * 获取端口
	 * 
	 * @return 端口
	 */
	public int getPort() {
		return Port;
	}

	/**
	 * 设置端口
	 * 
	 * @param port 端口
	 */
	public void setPort(int port) {
		Port = port;
	}

	/**
	 * 获取帐号
	 * 
	 * @return 帐号
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * 设置帐号
	 * 
	 * @param userName 帐号
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * 获取密码
	 * 
	 * @return 密码
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password 密码
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * 是否这空
	 * 
	 * @return true为空 false不为空
	 */
	public boolean isEmpty() {
		return this.Host.isEmpty();
	}
}