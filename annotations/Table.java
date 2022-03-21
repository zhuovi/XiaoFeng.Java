package xiaofeng.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import xiaofeng.entity.ModelType;

/**
 * 表注解
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
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	/**
	 * 表名
	 * @return 表名
	 */
	public String Name();

	/**
	 * 数据库连接串
	 * @return 数据库连接串
	 */
	public String ConnectionName() default "";

	/**
	 * 模型类型
	 * 
	 * @return 模型类型
	 */
	public ModelType ModelType() default ModelType.Table;
}
