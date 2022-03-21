package xiaofeng.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 列注解
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
@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	/**
	 * 字段名称
	 * 
	 * @return 字段名称
	 **/
	public String Name() default "";

	/**
	 * 字段类型
	 * 
	 * @return 字段类型
	 */
	public String FieldType() default "varchar";

	/**
	 * 字段类型长度
	 * @return 字段类型长度
	 */
	public int Length() default 0;

	/**
	 * 字段说明
	 * @return 字段说明
	 */
	public String Description() default "";

	/**
	 * 字段默认值
	 * @return 字段默认值
	 */
	public String DefaultValue() default "";

	/**
	 * 是否是主键
	 * @return 是否是主键
	 */
	public boolean PrimaryKey() default false;

	/**
	 * 是否为空
	 * @return 是否为空
	 */
	public boolean IsNullable() default true;

	/**
	 * 是否是唯一
	 * @return 是否是唯一
	 */
	public boolean IsUnique() default false;

	/**
	 * 是否是自增长列
	 * @return 是否是自增长列
	 */
	public boolean AutoIncrement() default false;

	/**
	 * 自增长步数
	 * @return  自增长步数
	 */
	public int AutoIncrementStep() default 1;

	/**
	 * 自增长种子
	 * @return 自增长种子
	 */
	public long AutoIncrementSeed() default 1;

	/**
	 * 是否是索引
	 * @return 是否是索引
	 */
	public boolean IsIndex() default false;

	/**
	 * 小数点位数
	 * 
	 * @return 小数点位数
	 */
	public int Digit() default 0;
}