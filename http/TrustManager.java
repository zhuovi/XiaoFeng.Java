package xiaofeng.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * HTTP请求SSL类
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
public class TrustManager implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {

	/**
	 * 服务器证书信任
	 * 
	 * @param certs 证书集
	 * @return 是否信任
	 */
	public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
		return true;
	}

	/**
	 * 客户端证书信任
	 * 
	 * @param certs 证书集
	 * @return 是否信任
	 */
	public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
		return true;
	}

	/**
	 * 检验客户端证书信任
	 * 
	 * @param arg0 证书集
	 * @param arg1 标识
	 * @throws CertificateException 证书抛出异常
	 */
	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		return;
	}

	/**
	 * 检验服务端证书信任
	 * 
	 * @param arg0 证书集
	 * @param arg1 标识
	 * @throws CertificateException 证书抛出异常
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		return;
	}

	/**
	 * 获取授权用户证书
	 * 
	 * @return 证书集合
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}