package xiaofeng.entity;

/**
 * 字段对象操作类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-13
 * @since 1.0.0
 * @version 1.0.0
 */
public class FieldData {
	/**
	 * 无参构造器
	 */
	public FieldData() {

	}

	/**
	 * 设置字段名称
	 * 
	 * @param name 字段名称
	 */
	public FieldData(String name) {

	}

	/**
	 * 获取字段名称
	 * 
	 * @return 字段名称
	 */
	public String getName() {
		return Name;
	}

	/**
	 * 设置字段名称
	 * 
	 * @param name 字段名称
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * 获取字段类型
	 * 
	 * @return 字段类型
	 */
	public FieldDataType getFieldType() {
		return FieldType;
	}

	/**
	 * 设置字段类型
	 * 
	 * @param fieldType 字段类型
	 */
	public void setFieldType(FieldDataType fieldType) {
		FieldType = fieldType;
	}

	/**
	 * 获取值
	 * 
	 * @return 值
	 */
	public Object getValue() {
		return Value;
	}

	/**
	 * 设置值
	 * 
	 * @param value 值
	 */
	public void setValue(Object value) {
		Value = value;
	}

	/**
	 * 字段名称
	 */
	private String Name;
	/**
	 * 字段类型
	 */
	private FieldDataType FieldType = FieldDataType.Field;
	/**
	 * 字段值
	 */
	private Object Value;
}