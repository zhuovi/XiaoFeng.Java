package xiaofeng.http;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import xiaofeng.core.RegexHelper;
import xiaofeng.io.FileHelper;

/**
 * HTTP请求类
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
public class HttpHelper {
	/**
	 * 请求网址
	 * 
	 * @param url    网址
	 * @param query  参数或form数据
	 * @param method 请求类型
	 * @return HttpHelper
	 */
	public static HttpHelper connect(String url, String query, HttpMethod method) {
		return new HttpHelper(url, method).Data(query);
	}

	/**
	 * 请求网址GET方法
	 * 
	 * @param url 网址
	 * @return HttpHelper
	 */
	public static HttpHelper get(String url) {
		return new HttpHelper(url, HttpMethod.GET);
	}

	/**
	 * 请求网址POST方法
	 * 
	 * @param url      网址
	 * @param postdata form数据
	 * @return HttpHelper
	 */
	public static HttpHelper post(String url, String postdata) {
		return new HttpHelper(url, HttpMethod.POST).Data(postdata);
	}

	/**
	 * 请求网址POST方法
	 * 
	 * @param url 网址
	 * @param map 数据
	 * @return HttpHelper
	 */
	public static HttpHelper post(String url, Map<String, String> map) {
		return new HttpHelper(url, HttpMethod.POST).Data(map);
	}

	/**
	 * 请求网址HEAD方法
	 * 
	 * @param url 网址
	 * @return HttpHelper
	 */
	public static HttpHelper head(String url) {
		return new HttpHelper(url, HttpMethod.HEAD);
	}

	/**
	 * 下载文件
	 * 
	 * @param url      远程网址
	 * @param filename 本地文件路径
	 * @return 是否下载成功
	 */
	public static boolean downFile(String url, String filename) {
		return get(url).DownloadFile(filename);
	}

	/**
	 * 请求对象
	 */
	private Request HttpRequest;

	/**
	 * 无参构造器
	 */
	public HttpHelper() {
		this.HttpRequest = new Request();
	}

	/**
	 * 设置请求地址
	 * 
	 * @param url 请求地址
	 */
	public HttpHelper(URL url) {
		this();
		this.HttpRequest.Url(url);
	}

	/**
	 * 设置请求地址
	 * 
	 * @param url    请求地址
	 * @param method 请求类型
	 */
	public HttpHelper(String url, HttpMethod method) {
		this(url);
		this.HttpRequest.setMethod(method);
	}

	/**
	 * 设置请求地址
	 * 
	 * @param url 请求地址
	 */
	public HttpHelper(String url) {
		this();
		try {
			this.HttpRequest.Url(new URL(url));
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 设置 User-agent HTTP 标头的值
	 * 
	 * @param userAgent User-agent HTTP 标头的值
	 * @return HttpHelper
	 */
	public HttpHelper UserAgent(String userAgent) {
		this.HttpRequest.setUserAgent(userAgent);
		return this;
	}

	/**
	 * 设置连接超时时长
	 * 
	 * @param timeOut 超时时长 单位为毫秒
	 * @return HttpHelper
	 */
	public HttpHelper TimeOut(int timeOut) {
		this.HttpRequest.setTimeOut(timeOut);
		return this;
	}

	/**
	 * 设置读写数据超时间
	 * 
	 * @param readWriteTimeout 读写数据超时间 单位为毫秒
	 * @return HttpHelper
	 */
	public HttpHelper ReadWriteTimeout(int readWriteTimeout) {
		this.HttpRequest.setReadWriteTimeout(readWriteTimeout);
		return this;
	}

	/**
	 * 设置该值指示是否与 Internet 资源建立持久性连接
	 * 
	 * @param keepAlive 该值指示是否与 Internet 资源建立持久性连接
	 * @return HttpHelper
	 */
	public HttpHelper KeepAlive(boolean keepAlive) {
		this.HttpRequest.setKeepAlive(keepAlive);
		return this;
	}

	/**
	 * 请求是否应跟随重定向响应
	 * 
	 * @param allowAutoRedirect 请求是否应跟随重定向响应
	 * @return HttpHelper
	 */
	public HttpHelper AllowAutoRedirect(boolean allowAutoRedirect) {
		this.HttpRequest.setAllowAutoRedirect(allowAutoRedirect);
		return this;
	}

	/**
	 * 请求将跟随的重定向的最大数目
	 * 
	 * @param maximumAutomaticRedirections 请求将跟随的重定向的最大数目
	 * @return HttpHelper
	 */
	public HttpHelper AllowAutoRedirect(int maximumAutomaticRedirections) {
		this.HttpRequest.setAllowAutoRedirect(true);
		this.HttpRequest.setMaximumAutomaticRedirections(maximumAutomaticRedirections);
		return this;
	}

	/**
	 * 设置 Referer HTTP 标头的值
	 * 
	 * @param referrer HTTP 标头的值
	 * @return HttpHelper
	 */
	public HttpHelper referrer(String referrer) {
		this.HttpRequest.setReferrer(referrer);
		return this;
	}

	/**
	 * 设置请求类型
	 * 
	 * @param method 请求类型
	 * @return HttpHelper
	 */
	public HttpHelper HttpMethod(HttpMethod method) {
		this.HttpRequest.setMethod(method);
		return this;
	}

	/**
	 * 设置请求Header
	 * 
	 * @param key   Header Key
	 * @param value Header Value
	 * @return HttpHelper
	 */
	public HttpHelper Header(String key, String value) {
		this.HttpRequest.setHeader(key, value);
		return this;
	}

	/**
	 * 设置请求Cookie
	 * 
	 * @param key   Cookie Key
	 * @param value Cookie Value
	 * @return HttpHelper
	 */
	public HttpHelper Cookie(String key, String value) {
		this.HttpRequest.setCookie(key, value);
		return this;
	}

	/**
	 * 设置请求编码
	 * 
	 * @param charset 请求编码
	 * @return HttpHelper
	 */
	public HttpHelper Charset(Charset charset) {
		this.HttpRequest.setCharset(charset);
		return this;
	}

	/**
	 * 设置请求编码
	 * 
	 * @param charsetName 请求编码
	 * @return HttpHelper
	 */
	public HttpHelper Charset(String charsetName) {
		if (Charset.isSupported(charsetName))
			this.HttpRequest.setCharset(Charset.forName(charsetName));
		return this;
	}

	/**
	 * 设置ContentType
	 * 
	 * @param contentType ContentType
	 * @return HttpHelper
	 */
	public HttpHelper ContentType(String contentType) {
		this.HttpRequest.setContentType(contentType);
		return this;
	}

	/**
	 * 设置证书
	 * 
	 * @param path     证书路径
	 * @param passWord 证书密码
	 * @return HttpHelper
	 */
	public HttpHelper Cert(String path, String passWord) {
		this.HttpRequest.setCertPath(path);
		this.HttpRequest.setCertPassWord(passWord);
		return this;
	}

	/**
	 * 设置数据 参数或post数据
	 * 
	 * @param key   数据名称
	 * @param value 数据值
	 * @return HttpHelper
	 */
	public HttpHelper Data(String key, String value) {
		this.HttpRequest.setData(key, value);
		return this;
	}

	/**
	 * 设置数据 参数或post数据
	 * 
	 * @param value 数据 参数形式
	 * @return HttpHelper
	 */
	public HttpHelper Data(String value) {
		this.HttpRequest.setData(value);
		return this;
	}

	/**
	 * 设置数据 参数或post数据
	 * 
	 * @param map 数据
	 * @return HttpHelper
	 */
	public HttpHelper Data(Map<String, String> map) {
		this.HttpRequest.setData(map);
		return this;
	}

	/**
	 * 设置网络代理
	 * 
	 * @param proxy 代理
	 * @return HttpHelper
	 */
	public HttpHelper Proxy(HttpProxy proxy) {
		this.HttpRequest.setProxy(proxy);
		return this;
	}

	/**
	 * 设置网络代理
	 * 
	 * @param host 代理地址
	 * @param port 代理端口
	 * @return HttpHelper
	 */
	public HttpHelper Proxy(String host, int port) {
		this.HttpRequest.setProxy(host, port);
		return this;
	}

	/**
	 * 设置网络代理
	 * 
	 * @param host     代理地址
	 * @param port     代理端口
	 * @param userName 代理帐号
	 * @param password 代理密码
	 * @return HttpHelper
	 */
	public HttpHelper Proxy(String host, int port, String userName, String password) {
		this.HttpRequest.setProxy(host, port, userName, password);
		return this;
	}

	/**
	 * 设置请求认证
	 * 
	 * @param credential 认证凭据
	 * @return HttpHelper
	 */
	public HttpHelper Credential(NetworkCredential credential) {
		this.HttpRequest.setCredential(credential);
		return this;
	}

	/**
	 * 设置请求认证
	 * 
	 * @param userName 认证帐号
	 * @param password 认证密码
	 * @return HttpHelper
	 */
	public HttpHelper Credential(String userName, String password) {
		this.HttpRequest.setCredential(userName, password);
		return this;
	}

	/**
	 * 设置请求认证
	 * 
	 * @param userName 认证帐号
	 * @param password 认证密码
	 * @param domain   认证域名
	 * @return HttpHelper
	 */
	public HttpHelper Credential(String userName, String password, String domain) {
		this.HttpRequest.setCredential(userName, password, domain);
		return this;
	}

	/**
	 * 终止请求
	 */
	public void abort() {
		if (this.httpConnection != null)
			this.httpConnection.disconnect();
	}

	/**
	 * HttpURLConnection
	 */
	private HttpURLConnection httpConnection;

	/**
	 * 获取响应
	 * 
	 * @return Response
	 */
	public Response getResponse() {
		if (this.HttpRequest == null || this.HttpRequest.Url == null)
			return null;
		URL url = this.HttpRequest.getUrl();
		if (!RegexHelper.IsMatch(url.getProtocol(), "^https?")) {
			System.out.println("请求网址不正确。");
			return null;
		}
		/**
		 * 设置请求参数
		 */
		this.HttpRequest.setRequestQuery();
		/**
		 * 创建请求连接
		 */
		HttpURLConnection conn = this.httpConnection = this.HttpRequest.getUrl().getProtocol().equalsIgnoreCase("http")
				? this.HttpRequest.createConnection()
				: this.HttpRequest.createConnections();
		try {
			/**
			 * 打开通讯连接
			 */
			conn.connect();
			/**
			 * 设置FORM数据
			 */
			if (this.HttpRequest.getMethod() == HttpMethod.POST)
				this.HttpRequest.setRequestForm(conn.getOutputStream());

			int status = conn.getResponseCode();

			boolean needsRedirect = false;
			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER) {
					needsRedirect = true;
				} else {
					System.out.println("请求地址:" + this.HttpRequest.getUrl().toString() + ",请求出错。");
				}
			}
			Response res = new Response(this.HttpRequest, conn);
			if (needsRedirect && this.HttpRequest.isAllowAutoRedirect()) {
				if (res.getRedirectCount() > this.HttpRequest.getMaximumAutomaticRedirections())
					return null;
				res.addRedirectCount();
				String Location = res.getHeader("Location");
				res.addRedirectUrl(Location);
				this.HttpRequest.setMethod(HttpMethod.GET);
				this.HttpRequest.clearData();
				this.HttpRequest.Url(new URL(this.HttpRequest.getUrl(), Location));
				this.HttpRequest.clearCookie();
				for (Entry<String, String> cookie : res.getCookies().entrySet()) {
					this.HttpRequest.setCookie(cookie.getKey(), cookie.getValue());
				}
				return getResponse();
			}
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			conn.disconnect();
		}
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param filename 文件本地路径
	 * @return 是否下载成功
	 */
	public boolean DownloadFile(String filename) {
		Response res = getResponse();
		if (res.getStatus() == 200) {
			try {
				FileOutputStream fos = new FileOutputStream(FileHelper.newFile(filename));
				fos.write(res.getBodyBytes());
				if (fos != null)
					fos.close();
				return true;
			} catch (IOException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return false;
	}
}