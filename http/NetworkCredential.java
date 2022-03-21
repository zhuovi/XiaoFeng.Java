package xiaofeng.http;

import xiaofeng.cryptography.Base64Helper;

/**
 * HTTP请求网络认证对象
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
public class NetworkCredential {
	/**
	 * 无参构造器
	 */
	public NetworkCredential() {
	}

	/**
	 * 设置帐号密码
	 * 
	 * @param userName 帐号
	 * @param password 密码
	 */
	public NetworkCredential(String userName, String password) {
		this(userName, password, "");
	}

	/**
	 * 设置帐号密码域名
	 * 
	 * @param userName 帐号
	 * @param password 密码
	 * @param domain   域名
	 */
	public NetworkCredential(String userName, String password, String domain) {
		this.UserName = userName;
		this.Password = password;
		this.Domain = domain;
	}

	/**
	 * 域名
	 */
	private String Domain;
	/**
	 * 帐号
	 */
	private String UserName;
	/**
	 * 密码
	 */
	private String Password;

	/**
	 * 获取域名
	 * 
	 * @return 域名
	 */
	public String getDomain() {
		return Domain;
	}

	/**
	 * 设置域名
	 * 
	 * @param domain 域名
	 */
	public void setDomain(String domain) {
		Domain = domain;
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
		return this.UserName.isEmpty() && this.Password.isEmpty();
	}

	/**
	 * 转换成字符串
	 * 
	 * @return 转换后的字符串
	 */
	@Override
	public String toString() {
		return "Basic " + Base64Helper.encrypt(this.UserName + ":" + this.Password);
	}
}