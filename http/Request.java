package xiaofeng.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import xiaofeng.core.StringHelper;
import xiaofeng.cryptography.Base64Helper;

/**
 * HTTP请求Request对象
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
public class Request extends HttpBase<Request> {
	/**
	 * 无参构造器
	 */
	public Request() {
		this.Data = new LinkedHashMap<String, String>();
		this.Headers = new LinkedHashMap<String, String>();
		this.Cookies = new LinkedHashMap<String, String>();
		super.setMethod(HttpMethod.GET);
		this.setHeader("Accept-Encoding", "gzip");
	}

	/**
	 * 超时时长 单位为毫秒
	 */
	private int TimeOut = 30 * 1000;
	/**
	 * 设置 User-agent HTTP 标头的值。
	 */
	private String UserAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36";
	/**
	 * 读写数据超时间
	 */
	private int ReadWriteTimeout = 30 * 1000;
	/**
	 * 请求标头值 默认为text/html, application/xhtml+xml
	 */
	private String Accept = "text/html, application/xhtml+xml, */*";
	/**
	 * 请求是否应跟随重定向响应
	 */
	private boolean AllowAutoRedirect = true;
	/**
	 * 请求将跟随的重定向的最大数目
	 */
	private int MaximumAutomaticRedirections = 5;
	/**
	 * 该值指示是否与 Internet 资源建立持久性连接。
	 */
	private boolean KeepAlive = true;
	/**
	 * 设置 Referer HTTP 标头的值。
	 */
	private String Referrer;
	/**
	 * 请求内容类型
	 */
	private String ContentType = "";
	/**
	 * 最大连接数
	 */
	private int Connectionlimit = 1024;
	/**
	 * 证书路径
	 */
	private String CertPath;
	/**
	 * 证书密码
	 */
	private String CertPassWord;
	/**
	 * @请求数据 参数或form值
	 */
	private Map<String, String> Data;
	/**
	 * 请求头集合
	 */
	private Map<String, String> Headers;
	/**
	 * 请求COOKIE 集合
	 */
	private Map<String, String> Cookies;
	/**
	 * 网络代理
	 */
	private HttpProxy Proxy;
	/**
	 * 网络认证
	 */
	private NetworkCredential Credential;

	/**
	 * 获取超时时长
	 * 
	 * @return 超时时长
	 */
	public int getTimeOut() {
		return TimeOut;
	}

	/**
	 * 设置超时时长
	 * 
	 * @param timeOut 超时时长
	 */
	public void setTimeOut(int timeOut) {
		TimeOut = timeOut;
	}

	/**
	 * 获取User-Agent标头
	 * 
	 * @return User-Agent标头
	 */
	public String getUserAgent() {
		return UserAgent;
	}

	/**
	 * 设置User-Agent标头
	 * 
	 * @param userAgent User-Agent标头
	 */
	public void setUserAgent(String userAgent) {
		UserAgent = userAgent;
	}

	/**
	 * 获取读写数据超时间
	 * 
	 * @return 读写数据超时间
	 */
	public int getReadWriteTimeout() {
		return ReadWriteTimeout;
	}

	/**
	 * 设置读写数据超时间
	 * 
	 * @param readWriteTimeout 读写数据超时间
	 */
	public void setReadWriteTimeout(int readWriteTimeout) {
		ReadWriteTimeout = readWriteTimeout;
	}

	/**
	 * 获取Accept标头
	 * 
	 * @return Accept标头
	 */
	public String getAccept() {
		return Accept;
	}

	/**
	 * 设置Accept标头
	 * 
	 * @param accept Accept标头
	 */
	public void setAccept(String accept) {
		Accept = accept;
	}

	/**
	 * 获取请求是否应跟随重定向响应
	 * 
	 * @return 请求是否应跟随重定向响应
	 */
	public boolean isAllowAutoRedirect() {
		return AllowAutoRedirect;
	}

	/**
	 * 设置请求是否应跟随重定向响应
	 * 
	 * @param allowAutoRedirect 请求是否应跟随重定向响应
	 */
	public void setAllowAutoRedirect(boolean allowAutoRedirect) {
		AllowAutoRedirect = allowAutoRedirect;
	}

	/**
	 * 获取请求将跟随的重定向的最大数目
	 * 
	 * @return 请求将跟随的重定向的最大数目
	 */
	public int getMaximumAutomaticRedirections() {
		return MaximumAutomaticRedirections;
	}

	/**
	 * 设置请求将跟随的重定向的最大数目
	 * 
	 * @param maximumAutomaticRedirections 请求将跟随的重定向的最大数目
	 */
	public void setMaximumAutomaticRedirections(int maximumAutomaticRedirections) {
		MaximumAutomaticRedirections = maximumAutomaticRedirections;
	}

	/**
	 * 获取该值指示是否与 Internet 资源建立持久性连接
	 * 
	 * @return 该值指示是否与 Internet 资源建立持久性连接
	 */
	public boolean isKeepAlive() {
		return KeepAlive;
	}

	/**
	 * 设置该值指示是否与 Internet 资源建立持久性连接
	 * 
	 * @param keepAlive 该值指示是否与 Internet 资源建立持久性连接
	 */
	public void setKeepAlive(boolean keepAlive) {
		KeepAlive = keepAlive;
	}

	/**
	 * 获取Referer HTTP 标头的值
	 * 
	 * @return Referer HTTP 标头的值
	 */
	public String getReferrer() {
		return Referrer;
	}

	/**
	 * 设置Referer HTTP 标头的值
	 * 
	 * @param referrer Referer HTTP 标头的值
	 */
	public void setReferrer(String referrer) {
		Referrer = referrer;
	}

	/**
	 * 获取内容类型
	 * 
	 * @return 内容类型
	 */
	public String getContentType() {
		return ContentType;
	}

	/**
	 * 设置内容类型
	 * 
	 * @param contentType 内容类型
	 */
	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	/**
	 * 获取最大连接数
	 * 
	 * @return 最大连接数
	 */
	public int getConnectionlimit() {
		return Connectionlimit;
	}

	/**
	 * 设置最大连接数
	 * 
	 * @param connectionlimit 最大连接数
	 */
	public void setConnectionlimit(int connectionlimit) {
		Connectionlimit = connectionlimit;
	}

	/**
	 * 获取证书路径
	 * 
	 * @return 证书路径
	 */
	public String getCertPath() {
		return CertPath;
	}

	/**
	 * 设置证书路径
	 * 
	 * @param certPath 证书路径
	 */
	public void setCertPath(String certPath) {
		CertPath = certPath;
	}

	/**
	 * 获取证书密码
	 * 
	 * @return 证书密码
	 */
	public String getCertPassWord() {
		return CertPassWord;
	}

	/**
	 * 设置证书密码
	 * 
	 * @param certPassWord 证书密码
	 */
	public void setCertPassWord(String certPassWord) {
		CertPassWord = certPassWord;
	}

	/**
	 * 获取参数或post数据
	 * 
	 * @return 参数或post数据
	 */
	public Map<String, String> getData() {
		return Data;
	}

	/**
	 * 设置数据 参数或post数据
	 * 
	 * @param data 参数或post数据
	 */
	public void setData(Map<String, String> data) {
		Data = data;
	}

	/**
	 * 设置数据
	 * 
	 * @param key   名称
	 * @param value 值
	 */
	public void setData(String key, String value) {
		this.Data.put(key, value);
	}

	/**
	 * 设置数据
	 * 
	 * @param value 参数形式
	 */
	public void setData(String value) {
		for (String kv : value.split("&")) {
			String[] kval = kv.split("=");
			this.Data.put(kval[0], kval[1]);
		}
	}

	/**
	 * 清空数据
	 */
	public void clearData() {
		this.Data.clear();
	}

	/**
	 * 获取请求头
	 * 
	 * @return 请求头
	 */
	public Map<String, String> getHeaders() {
		return Headers;
	}

	/**
	 * 设置请求头
	 * 
	 * @param headers 请求头
	 */
	public void setHeaders(Map<String, String> headers) {
		Headers = headers;
	}

	/**
	 * 获取请求cookie
	 * 
	 * @return 请求cookie
	 */
	public Map<String, String> getCookies() {
		return Cookies;
	}

	/**
	 * 设置请求cookie
	 * 
	 * @param cookies 请求cookie
	 */
	public void setCookies(Map<String, String> cookies) {
		Cookies = cookies;
	}

	/**
	 * 是否存在Header
	 * 
	 * @param key Header名称
	 * @return 是否存在
	 */
	public boolean hasHeader(String key) {
		return this.Headers.containsKey(key);
	}

	/**
	 * 移除Header
	 * 
	 * @param key Header名称
	 */
	public void removeHeader(String key) {
		this.Headers.remove(key);
	}

	/**
	 * 获取Header
	 * 
	 * @param key Header名称
	 * @return Header值
	 */
	public String getHeader(String key) {
		return this.Headers.get(key);
	}

	/**
	 * 清空Header
	 */
	public void clearHeader() {
		this.Headers.clear();
	}

	/**
	 * 设置Header
	 * 
	 * @param key   Header名称
	 * @param value Header值
	 */
	public void setHeader(String key, String value) {
		this.Headers.put(key, value);
	}

	/**
	 * 是否存在Cookie
	 * 
	 * @param key Cookie名称
	 * @return 是否存在
	 */
	public boolean hasCookie(String key) {
		return this.Cookies.containsKey(key);
	}

	/**
	 * 移除Cookie
	 * 
	 * @param key Cookie名称
	 */
	public void removeCookie(String key) {
		this.Cookies.remove(key);
	}

	/**
	 * 获取Cookie
	 * 
	 * @param key Cookie名称
	 * @return Header值
	 */
	public String getCookie(String key) {
		return this.Cookies.get(key);
	}

	/**
	 * 设置Cookie
	 * 
	 * @param key   Cookie名称
	 * @param value Cookie值
	 */
	public void setCookie(String key, String value) {
		this.Cookies.put(key, value);
	}

	/**
	 * 清空Cookie
	 */
	public void clearCookie() {
		this.Cookies.clear();
	}
	/**
	 * 获取网络代理
	 * 
	 * @return 网络代理
	 */
	public HttpProxy getProxy() {
		return Proxy;
	}

	/**
	 * 设置网络代理
	 * 
	 * @param proxy 网络代理
	 */
	public void setProxy(HttpProxy proxy) {
		Proxy = proxy;
	}

	/**
	 * 设置网络代理
	 * 
	 * @param host Host
	 * @param port 端口
	 */
	public void setProxy(String host, int port) {
		this.Proxy = new HttpProxy(host, port);
	}

	/**
	 * 设置网络代理
	 * 
	 * @param host     Host
	 * @param port     端口
	 * @param userName 帐号
	 * @param password 密码
	 */
	public void setProxy(String host, int port, String userName, String password) {
		this.Proxy = new HttpProxy(host, port, userName, password);
	}

	/**
	 * 获取网络认证
	 * 
	 * @return 网络认证
	 */
	public NetworkCredential getCredential() {
		return Credential;
	}

	/**
	 * 设置网络认证
	 * 
	 * @param credential 网络认证
	 */
	public void setCredential(NetworkCredential credential) {
		Credential = credential;
	}

	/**
	 * 设置网络认证
	 * 
	 * @param userName 帐号
	 * @param password 密码
	 */
	public void setCredential(String userName, String password) {
		this.Credential = new NetworkCredential(userName, password);
	}

	/**
	 * 设置网络认证
	 * 
	 * @param userName 帐号
	 * @param password 密码
	 * @param domain   域名
	 */
	public void setCredential(String userName, String password, String domain) {
		this.Credential = new NetworkCredential(userName, password, domain);
	}

	/**
	 * 创建请求连接对象
	 * 
	 * @return 请求连接对象
	 */
	public HttpURLConnection createConnection() {
		try {
			HttpURLConnection conn = (HttpURLConnection) this.getUrl().openConnection();
			conn.setRequestMethod(this.getMethod().name());
			conn.setInstanceFollowRedirects(this.isAllowAutoRedirect());
			conn.setConnectTimeout(this.getTimeOut());
			conn.setReadTimeout(this.getReadWriteTimeout());
			conn.setDoInput(true);
			if (this.getMethod() == HttpMethod.POST) {
				conn.setDoOutput(true);
				if (StringHelper.IsNullOrEmpty(this.getContentType()))
					this.setContentType("application/x-www-form-urlencoded");
			} else {
				if (StringHelper.IsNullOrEmpty(this.getContentType()))
					this.setContentType("text/html");
			}
			if (this.getCookies().size() > 0) {
				conn.addRequestProperty("Cookie", this.getRequestCookieString());
			}
			conn.addRequestProperty("User-Agent", this.getUserAgent());
			conn.addRequestProperty("Content-Type", this.getContentType()
					+ (StringHelper.IsNullOrEmpty(this.getCharset()) ? "" : (";charset=" + this.getCharset().name())));
			conn.addRequestProperty("Referer", this.getReferrer());
			if (this.getProxy() != null && !this.getProxy().isEmpty()) {
				conn.addRequestProperty("http.proxySet", "true");
				conn.addRequestProperty("http.proxyHost", this.getProxy().getHost());
				conn.addRequestProperty("http.proxyPort", "" + this.getProxy().getPort());
				if (!this.getProxy().getUserName().isEmpty()) {
					conn.setRequestProperty("Proxy-Authorization", "Basic " + Base64Helper
							.encrypt(this.getProxy().getUserName() + ":" + this.getProxy().getPassword()));
				}
			}
			if (this.getCredential() != null && !this.getCredential().isEmpty()) {
				conn.setRequestProperty("Authorization", this.getCredential().toString());
			}
			for (Map.Entry<String, String> header : this.getHeaders().entrySet()) {
				conn.addRequestProperty(header.getKey(), header.getValue());
			}
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 创建请求连接对象SSL
	 * 
	 * @return 请求连接对象SSL
	 */
	public HttpsURLConnection createConnections() {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) this.getUrl().openConnection();
			SSLContext sslContext = SSLContext.getInstance("SSL");
			TrustManager[] tm = { new TrustManager() };
			// 初始化
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 获取SSLSocketFactory对象
			SSLSocketFactory sf = sslContext.getSocketFactory();
			conn.setSSLSocketFactory(sf);
			conn.setRequestMethod(this.getMethod().name());
			conn.setInstanceFollowRedirects(this.isAllowAutoRedirect());
			conn.setConnectTimeout(this.getTimeOut());
			conn.setReadTimeout(this.getReadWriteTimeout());
			conn.setDoInput(true);
			if (this.getMethod() == HttpMethod.POST) {
				conn.setDoOutput(true);
				if (StringHelper.IsNullOrEmpty(this.getContentType()))
					this.setContentType("application/x-www-form-urlencoded");
			} else {
				if (StringHelper.IsNullOrEmpty(this.getContentType()))
					this.setContentType("text/html");
			}
			if (this.getCookies().size() > 0) {
				conn.addRequestProperty("Cookie", this.getRequestCookieString());
			}
			conn.addRequestProperty("User-Agent", this.getUserAgent());
			conn.addRequestProperty("Content-Type", this.getContentType()
					+ (StringHelper.IsNullOrEmpty(this.getCharset()) ? "" : (";charset=" + this.getCharset().name())));
			conn.addRequestProperty("Referer", this.getReferrer());
			if (this.getProxy() != null && !this.getProxy().isEmpty()) {
				conn.addRequestProperty("https.proxySet", "true");
				conn.addRequestProperty("https.proxyHost", this.getProxy().getHost());
				conn.addRequestProperty("https.proxyPort", "" + this.getProxy().getPort());
				if (!this.getProxy().getUserName().isEmpty()) {
					conn.setRequestProperty("Proxy-Authorization", "Basic " + Base64Helper
							.encrypt(this.getProxy().getUserName() + ":" + this.getProxy().getPassword()));
				}
			}
			if (this.getCredential() != null && !this.getCredential().isEmpty()) {
				conn.setRequestProperty("Authorization", this.getCredential().toString());
			}
			for (Map.Entry<String, String> header : this.getHeaders().entrySet()) {
				conn.addRequestProperty(header.getKey(), header.getValue());
			}
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取Cookie字符串
	 * 
	 * @return Cookie字符串
	 */
	public String getRequestCookieString() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> cookie : this.getCookies().entrySet()) {
			if (!first) {
				sb.append(";");
			} else {
				first = false;
			}
			sb.append(cookie.getKey()).append('=').append(cookie.getValue());
		}
		return sb.toString();
	}

	/**
	 * 设置请求参数
	 */
	public void setRequestQuery() {
		if (super.getMethod() == HttpMethod.GET) {
			if (this.Data != null && this.Data.size() > 0) {
				String url = this.getUrl().toString();
				boolean flag = url.indexOf('?') > -1;
				for (Entry<String, String> kvalue : this.Data.entrySet()) {
					if (!flag) {
						url += "?";
						flag = false;
					} else
						url += "&";
					url += URLEncoder.encode(kvalue.getKey(), this.getCharset()) + "="
							+ URLEncoder.encode(kvalue.getValue(), this.getCharset());
				}
				try {
					this.Url(new URL(url));
				} catch (MalformedURLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 设置请求form
	 * 
	 * @param outputStream 输出流
	 */
	public void setRequestForm(OutputStream outputStream) {
		if (this.getMethod() == HttpMethod.POST) {
			if (this.Data != null && this.Data.size() > 0)
				try {
					OutputStreamWriter writer = new OutputStreamWriter(outputStream, this.getCharset());
					boolean flag = true;
					for (Entry<String, String> kvalue : this.Data.entrySet()) {
						if (flag)
							flag = false;
						else
							writer.append('&');
						writer.append(URLEncoder.encode(kvalue.getKey(), this.getCharset()));
						writer.append('=');
						writer.append(URLEncoder.encode(kvalue.getValue(), this.getCharset()));
					}
					writer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}
}