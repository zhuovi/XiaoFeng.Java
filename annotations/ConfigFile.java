package xiaofeng.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import xiaofeng.config.ConfigFormat;

/**
 * 配置注解
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
@Target({ ElementType.TYPE, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigFile {
	/**
	 * 配置文件名
	 * @return 配置文件名
	 */
	public String FileName();

	/**
	 * 超时时间
	 * @return 超时时间
	 */
	public int Timeout() default 0;

	/**
	 * 缓存Key
	 * @return 缓存Key
	 */
	public String CacheKey();

	/**
	 * 配置格式
	 * 
	 * @return 配置格式
	 */
	public ConfigFormat configFormat() default ConfigFormat.Json;
}