package xiaofeng.http;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import xiaofeng.core.RegexHelper;
import xiaofeng.core.StringHelper;

/**
 * HTTP请求类Response响应类
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
public class Response extends HttpBase<Response> {
	/**
	 * 无参构造器
	 */
	public Response() {
		this.RedirectUrl = new ArrayList<>();
		this.Headers = new LinkedHashMap<String, String>();
		this.Cookies = new LinkedHashMap<String, String>();
	}

	/**
	 * 设置请求对象
	 * 
	 * @param request    请求对象
	 * @param connection 连接对象
	 */
	public Response(Request request, HttpURLConnection connection) {
		this();
		this.HttpRequest = request;
		this.Connnection = connection;
		this.GetResponseHeaders();
		this.GetBodyHtml();
	}

	/**
	 * 连接对象
	 */
	private HttpURLConnection Connnection;
	/**
	 * 请求对象
	 */
	private Request HttpRequest;
	/**
	 * 重定向次数
	 */
	private int RedirectCount = 0;
	/**
	 * 重定向中的网址
	 */
	private List<String> RedirectUrl;
	/**
	 * 响应body数据
	 */
	private String Html;
	/**
	 * 响应body字节
	 */
	private byte[] BodyBytes;
	/**
	 * 请求头集合
	 */
	private Map<String, String> Headers;
	/**
	 * 请求COOKIE 集合
	 */
	private Map<String, String> Cookies;
	/**
	 * 内容类型
	 */
	private String ContentType;
	/**
	 * 响应状态
	 */
	private int Status;
	/**
	 * 内容长度
	 */
	private long ContentLength;
	/**
	 * 响应状态名称
	 */
	private String StatusName;

	/**
	 * 获取请求对象
	 * 
	 * @return 请求对象
	 */
	public Request getHttpRequest() {
		return HttpRequest;
	}

	/**
	 * 设置请求对象
	 * 
	 * @param httpRequest 请求对象
	 */
	public void setHttpRequest(Request httpRequest) {
		HttpRequest = httpRequest;
	}

	/**
	 * 获取转向地址次数
	 * 
	 * @return 转向地址次数
	 */
	public int getRedirectCount() {
		return RedirectCount;
	}

	/**
	 * 设置转向地址次数
	 * 
	 * @param redirectCount 转向地址次数
	 */
	public void setRedirectCount(int redirectCount) {
		RedirectCount = redirectCount;
	}

	/**
	 * 增加转向次数
	 */
	public void addRedirectCount() {
		this.RedirectCount++;
	}

	/**
	 * 获取转向地址集合
	 * 
	 * @return 转向地址集合
	 */
	public List<String> getRedirectUrl() {
		return RedirectUrl;
	}

	/**
	 * 设置转向地址集合
	 * 
	 * @param redirectUrl 转向地址集合
	 */
	public void setRedirectUrl(List<String> redirectUrl) {
		RedirectUrl = redirectUrl;
	}

	/**
	 * 添加转换地址
	 * 
	 * @param url 转换地址
	 */
	public void addRedirectUrl(String url) {
		this.RedirectUrl.add(url);
	}

	/**
	 * 获取响应头
	 * 
	 * @return 响应头
	 */
	public Map<String, String> getHeaders() {
		return Headers;
	}

	/**
	 * 设置响应头
	 * 
	 * @param headers 响应头
	 */
	public void setHeaders(Map<String, String> headers) {
		Headers = headers;
	}

	/**
	 * 获取响应cookie
	 * 
	 * @return 响应cookie
	 */
	public Map<String, String> getCookies() {
		return Cookies;
	}

	/**
	 * 设置响应cookie
	 * 
	 * @param cookies 响应cookie
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
	 * 获取请求连接对象
	 * 
	 * @return 请求连接对象
	 */
	public HttpURLConnection getConnnection() {
		return Connnection;
	}

	/**
	 * 设置请求连接对象
	 * 
	 * @param connnection 请求连接对象
	 */
	public void setConnnection(HttpURLConnection connnection) {
		Connnection = connnection;
	}

	/**
	 * 响应内容 获取响应内容
	 * 
	 * @return 响应内容
	 */
	public String getHtml() {
		return Html;
	}

	/**
	 * 设置响应内容
	 * 
	 * @param html 响应内容
	 */
	public void setHtml(String html) {
		Html = html;
	}

	/**
	 * 获取响应body字节
	 * 
	 * @return 响应body字节
	 */
	public byte[] getBodyBytes() {
		return BodyBytes;
	}

	/**
	 * 设置响应body字节
	 * 
	 * @param bodyBytes 响应body字节
	 */
	public void setBodyBytes(byte[] bodyBytes) {
		BodyBytes = bodyBytes;
	}

	/**
	 * 获取响应状态值
	 * 
	 * @return 响应状态值
	 */
	public int getStatus() {
		return Status;
	}

	/**
	 * 设置响应状态值
	 * 
	 * @param status 响应状态值
	 */
	public void setStatus(int status) {
		Status = status;
	}

	/**
	 * 获取响应状态名称
	 * 
	 * @return 响应状态名称
	 */
	public String getStatusName() {
		return StatusName;
	}

	/**
	 * 设置响应状态名称
	 * 
	 * @param statusName 响应状态名称
	 */
	public void setStatusName(String statusName) {
		StatusName = statusName;
	}

	/**
	 * 获取是否成功
	 * 
	 * @return 是否成功
	 */
	public boolean IsOK() {
		return this.Status == 200;
	}

	/**
	 * 获取内容长度
	 * 
	 * @return 内容长度
	 */
	public long getContentLength() {
		return ContentLength;
	}

	/**
	 * 设置内容长度
	 * 
	 * @param contentLength 内容长度
	 */
	public void setContentLength(long contentLength) {
		ContentLength = contentLength;
	}

	/**
	 * 读取数据流
	 */
	private void GetBodyHtml() {
		try {
			InputStream dataStream = null;
			InputStream bodyStream = null;
			HttpURLConnection conn = this.Connnection;
			this.Status = conn.getResponseCode();
			this.StatusName = conn.getResponseMessage();
			this.ContentLength = conn.getContentLengthLong();
			if (this.ContentLength < 0) {
				if (this.hasHeader("Content-Length")) {
					this.ContentLength = StringHelper.toCast(this.getHeader("Content-Length"), Long.class);
				}
			}
			this.Url(conn.getURL());
			try {
				dataStream = conn.getErrorStream() != null ? conn.getErrorStream() : conn.getInputStream();
				bodyStream = this.hasHeader("Content-Encoding")
						&& this.getHeader("Content-Encoding").equalsIgnoreCase("gzip")
								? new BufferedInputStream(new GZIPInputStream(dataStream))
								: new BufferedInputStream(dataStream);
				byte[] buffer = new byte[1024];
				int len = 0;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((len = bodyStream.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				bos.close();
				this.BodyBytes = bos.toByteArray();
				this.Html = new String(this.BodyBytes);
			} catch (IOException ex) {
				ex.printStackTrace();
				this.Html = "";
			} finally {
				if (bodyStream != null) {
					bodyStream.close();
				}
				if (dataStream != null) {
					dataStream.close();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 获取响应Header
	 */
	private void GetResponseHeaders() {
		Map<String, List<String>> maps = this.Connnection.getHeaderFields();
		for (Entry<String, List<String>> entry : maps.entrySet()) {
			String key = entry.getKey();
			if (StringHelper.IsNullOrEmpty(key))
				continue;
			this.setHeader(entry.getKey(), entry.getValue().get(0));
		}
		if (this.hasHeader("Content-Type")) {
			this.ContentType = this.getHeader("Content-Type");
			String charset = RegexHelper.match(this.ContentType, "charset=\\s*\"?(?<a>[^\\s;\"]*)");
			if (StringHelper.IsNullOrEmpty(charset) || !Charset.isSupported(charset))
				super.setCharset(this.HttpRequest.getCharset());
			else
				super.setCharset(Charset.forName(charset));
		}
		if (this.hasHeader("Set-Cookie")) {
			String cookies = this.getHeader("Set-Cookie");
			for (String cookie : cookies.split(";")) {
				String[] KeyValue = cookie.trim().split("=");
				if (KeyValue.length == 2) {
					this.setCookie(KeyValue[0].trim(), KeyValue[1].trim());
				}
			}
		}
	}
}