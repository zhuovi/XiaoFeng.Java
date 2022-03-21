package xiaofeng.cryptography;

import java.nio.charset.Charset;

import xiaofeng.entity.EntityBase;

/**
 * 基础加密类
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
public abstract class BaseCrypto extends EntityBase {
	/**
	 * 默认key
	 */
	protected final String BaseKey = "07092734";
	/**
	 * 默认向量
	 */
	protected final String BaseVectorKey = "07092734";
	/**
	 * 编码
	 */
	protected final Charset Encoding = Charset.forName("UTF-8");
}