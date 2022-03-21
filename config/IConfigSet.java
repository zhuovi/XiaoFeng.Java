package xiaofeng.config;

/**
 * 配置操作类接口
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
public interface IConfigSet<T> {

	/**
	 * 保存文件
	 **/
	void save();

	/**
	 * 获取对象
	 * 
	 * @param reload 是否重载
	 * @return 对象
	 */
	T get(boolean reload);

	/**
	 * 打开文件
	 * 
	 * @param path 路径
	 * @return 返回文件内容
	 */
	String OpenFile(String path);
}