package xiaofeng.cryptography;

import java.nio.charset.Charset;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;
import xiaofeng.cryptography.Enum.HMACEnum;

/**
 * HMAC加密类
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
public class HMACCrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public HMACCrypto() {
		super(CipherEncryptType.HMACSHA256);
	}

	/**
	 * 设置参数
	 * 
	 * @param hmac 加密模式
	 */
	public HMACCrypto(HMACEnum hmac) {
		this(hmac, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param hmac    加密模式
	 * @param charset 编码
	 */
	public HMACCrypto(HMACEnum hmac, Charset charset) {
		this(hmac, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param hmac          加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public HMACCrypto(HMACEnum hmac, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == hmac.getEncryptType())
				.findFirst().get(), charset, secretKeyType);
	}

	/**
	 * 加密解密方法
	 * 
	 * @param data      字符串
	 * @param slatKey   密钥
	 * @param vectorKey 偏移量
	 * @param mode      模式 1加密 2 解密
	 * @return 字符串
	 */
	@Override
	protected byte[] encode(byte[] data, String slatKey, String vectorKey, int mode) {
		try {
			SecretKey secretKey = new SecretKeySpec(slatKey.getBytes(this.getCharset()),
					this.getEncryptType().getEncryptType());
			// 生成一个指定 Mac 算法 的 Mac 对象
			Mac mac = Mac.getInstance(this.getEncryptType().getEncryptType());
			// 用给定密钥初始化 Mac 对象
			mac.init(secretKey);
			return mac.doFinal(data);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}