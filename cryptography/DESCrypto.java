package xiaofeng.cryptography;

import java.nio.charset.Charset;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;
import xiaofeng.cryptography.Enum.DESEnum;

/**
 * DES加密类
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
public class DESCrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public DESCrypto() {
		super(CipherEncryptType.DES_CBC_PKCS5PADDING);
	}

	/**
	 * 设置参数
	 * 
	 * @param des 加密模式
	 */
	public DESCrypto(DESEnum des) {
		this(des, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param des     加密模式
	 * @param charset 编码
	 */
	public DESCrypto(DESEnum des, Charset charset) {
		this(des, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param des           加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public DESCrypto(DESEnum des, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == des.getEncryptType())
				.findFirst().get(), charset, secretKeyType);
	}
}