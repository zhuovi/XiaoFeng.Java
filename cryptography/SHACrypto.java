package xiaofeng.cryptography;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import javax.crypto.Cipher;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;
import xiaofeng.cryptography.Enum.SHAEnum;

/**
 * SHA加密类
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
public class SHACrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public SHACrypto() {
		super(CipherEncryptType.SHA256);
	}

	/**
	 * 设置参数
	 * 
	 * @param sha 加密模式
	 */
	public SHACrypto(SHAEnum sha) {
		this(sha, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param sha     加密模式
	 * @param charset 编码
	 */
	public SHACrypto(SHAEnum sha, Charset charset) {
		this(sha, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param sha           加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public SHACrypto(SHAEnum sha, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == sha.getEncryptType())
				.findFirst().get(), charset, secretKeyType);
	}

	@Override
	protected byte[] encode(byte[] data, String slatKey, String vectorKey, int mode) {
		if (mode == Cipher.DECRYPT_MODE)
			return null;
		try {
			byte[] keys = slatKey.getBytes(this.getCharset());
			byte[] vectors = vectorKey.getBytes();
			byte[] datas = new byte[data.length + keys.length + vectors.length];
			System.arraycopy(data, 0, datas, 0, data.length);
			System.arraycopy(keys, 0, datas, data.length, keys.length);
			System.arraycopy(vectors, 0, datas, data.length + keys.length, vectors.length);
			MessageDigest messageDigest = MessageDigest.getInstance(this.getEncryptType().getEncryptType());
			return messageDigest.digest(datas);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}