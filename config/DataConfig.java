package xiaofeng.config;

import java.util.HashMap;
import java.util.Map;

import xiaofeng.annotations.*;
import xiaofeng.data.*;

/**
 * 数据库配置
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
@ConfigFile(FileName = "Config/DataBase.json", CacheKey = "FAYELF_DataConfig", Timeout = 0, configFormat = ConfigFormat.Json)
public class DataConfig extends ConfigSet<DataConfig> {
	/**
	 * 无参构造器
	 */
	public DataConfig() {
		this.Data = new HashMap<>();
		ConnectionConfig config = new ConnectionConfig();
		config.setConnectionString(
				"jdbc:mysql://127.0.0.1:3306/springboot_fayelf?characterEncoding=UTF-8&useSSL=FALSE&serverTimezone=UTC");
		config.setUserName("root");
		config.setPassword("root");
		config.setProviderType(DbProviderType.MySQL);
		this.Data.put("FayElf.Cube.CMS", config);
	}

	/**
	 * 数据库配置
	 */
	@Description(value = "数据库配置")
	public Map<String, ConnectionConfig> Data = new HashMap<>();
}