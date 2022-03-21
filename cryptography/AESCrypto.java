package xiaofeng.cryptography;

import java.nio.charset.Charset;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.*;

/**
 * AES加密类
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
public class AESCrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public AESCrypto() {
		super(CipherEncryptType.AES_CBC_PKCS5PADDING);
	}

	/**
	 * 设置参数
	 * 
	 * @param aes 加密模式
	 */
	public AESCrypto(AESEnum aes) {
		this(aes, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param aes     加密模式
	 * @param charset 编码
	 */
	public AESCrypto(AESEnum aes, Charset charset) {
		this(aes, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param aes           加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public AESCrypto(AESEnum aes, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == aes.getEncryptType())
				.findFirst().get(), charset, secretKeyType);
	}
}