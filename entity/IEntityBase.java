package xiaofeng.entity;

/**
 * 对象基础类接口
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
public interface IEntityBase {

	/**
	 * 根据字段名称获取字段值
	 * 
	 * @param name 字段名称
	 * @return 字段值
	 */
	Object Get(String name);

	/**
	 * 转换成JSON格式
	 * 
	 * @param indented 是否格式化
	 * @return JSON格式内容
	 */
	String toJson(boolean indented);

	/**
	 * 转换成XML格式
	 * 
	 * @param indented 是否格式化
	 * @return XML格式内容
	 */
	String toXml(boolean indented);

}
