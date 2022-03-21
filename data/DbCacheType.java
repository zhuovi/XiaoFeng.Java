package xiaofeng.data;

/**
 * 数据库缓存类型
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
public enum DbCacheType {
	/**
	 * 不缓存
	 */
	NO(0),
	/**
	 * 内存存储
	 */
	Memory(1),
	/**
	 * 磁盘存储
	 */
	Disk(2),
	/**
	 * Redis存储
	 */
	Redis(3);

	/**
	 * 存储值
	 */
	private int Value = 0;

	/**
	 * 设置值
	 * 
	 * @param value 值
	 */
	DbCacheType(int value) {
		this.Value = value;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return this.Value;
	}
}
