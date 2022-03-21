package xiaofeng.cryptography;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import xiaofeng.core.EnumHelper;
import xiaofeng.cryptography.Enum.CipherEncryptType;
import xiaofeng.cryptography.Enum.RSAEnum;

/**
 * RSA加密类
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
public class RSACrypto extends CipherEncrypt {
	/**
	 * 无参构造器
	 */
	public RSACrypto() {
		super(CipherEncryptType.RSA_ECB_OAEPWITHSHA_1ANDMGF1PADDING);
	}

	/**
	 * 设置参数
	 * 
	 * @param rsa 加密模式
	 */
	public RSACrypto(RSAEnum rsa) {
		this(rsa, Charset.forName("UTF-8"), SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param rsa     加密模式
	 * @param charset 编码
	 */
	public RSACrypto(RSAEnum rsa, Charset charset) {
		this(rsa, charset, SecretKeyType.Key);
	}

	/**
	 * 设置参数
	 * 
	 * @param rsa           加密模式
	 * @param charset       编码
	 * @param secretKeyType 密钥当key用还是当种子用
	 */
	public RSACrypto(RSAEnum rsa, Charset charset, SecretKeyType secretKeyType) {
		super(EnumHelper.GetEnumValue(CipherEncryptType.class, a -> a.getEncryptType() == rsa.getEncryptType())
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
			Cipher cipher = Cipher.getInstance(this.getEncryptType().getEncryptType());
			KeyPair key = this.GetKey(slatKey);
			KeyFactory factory = KeyFactory.getInstance(this.getEncryptType().getAlgorithm());
			if (mode == Cipher.ENCRYPT_MODE) {
				RSAPublicKey pubKey = (RSAPublicKey) factory
						.generatePublic(new X509EncodedKeySpec(key.getPublic().getEncoded()));
				cipher.init(mode, pubKey);
			} else {
				RSAPrivateKey pubKey = (RSAPrivateKey) factory
						.generatePrivate(new PKCS8EncodedKeySpec(key.getPrivate().getEncoded()));
				cipher.init(Cipher.DECRYPT_MODE, pubKey);
			}
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取 key
	 * 
	 * @key 密钥
	 */
	protected KeyPair GetKey(String key) {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(this.getEncryptType().getAlgorithm());
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(key.getBytes());
			keyPairGenerator.initialize(this.getEncryptType().getKeyLength(), random);
			return keyPairGenerator.generateKeyPair();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
