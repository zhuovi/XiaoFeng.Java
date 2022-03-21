package xiaofeng.cryptography;

/**
 * 加密工具类
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
public class EncryptUtil {
	/**
	 * MD加密
	 */
	public final static ICryptography MD = new MDCrypto();
	/**
	 * SHA加密
	 */
	public final static ICryptography SHA = new SHACrypto();
	/**
	 * AES加密
	 */
	public final static ICryptography AES = new AESCrypto();
	/**
	 * DES加密
	 */
	public final static ICryptography DES = new DESCrypto();
	/**
	 * DES3加密
	 */
	public final static ICryptography DES3 = new DES3Crypto();
	/**
	 * HMAC加密
	 */
	public final static ICryptography HMAC = new HMACCrypto();
	/**
	 * RSA加密
	 */
	public final static ICryptography RSA = new RSACrypto();
}