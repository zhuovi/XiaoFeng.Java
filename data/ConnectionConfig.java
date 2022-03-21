package xiaofeng.data;

import java.sql.*;

import xiaofeng.annotations.Description;

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
public class ConnectionConfig {

	/**
	 * 无参构造器
	 */
	public ConnectionConfig() {
		this.ProviderType = DbProviderType.MySQL;
	}

	/**
	 * 设置数据库类型及数据库连接串
	 * 
	 * @param providerType     数据库驱动类型
	 * @param connectionString 数据库连接串
	 */
	public ConnectionConfig(DbProviderType providerType, String connectionString) {
		this.ProviderType = providerType;
		this.ConnectionString = connectionString;
	}

	/**
	 * 设置数据库类型及数据库连接串 帐号 密码
	 * 
	 * @param providerType     数据库驱动类型
	 * @param connectionString 数据库连接串
	 * @param username         数据库帐号
	 * @param password         数据库密码
	 */
	public ConnectionConfig(DbProviderType providerType, String connectionString, String username, String password) {
		this.ProviderType = providerType;
		this.ConnectionString = connectionString;
		this.UserName = username;
		this.Password = password;
	}

	/**
	 * 数据库类型
	 */
	@Description(value = "数据库类型")
	private DbProviderType ProviderType = DbProviderType.MySQL;
	/**
	 * 数据库连接串
	 */
	@Description(value = "数据库连接串")
	private String ConnectionString = "";
	/**
	 * 数据库帐号
	 */
	@Description(value = "数据库帐号")
	private String UserName = "";
	/**
	 * 数据库密码
	 */
	@Description(value = "数据库密码")
	private String Password = "";
	/**
	 * 是否启用事务
	 */
	@Description(value = "是否启用事务")
	private boolean IsTransaction = true;
	/**
	 * 执行超时时长 单位为毫秒
	 */
	@Description(value = "执行超时时长")
	private int CommandTimeOut = 30000;
	/**
	 * 缓存类型
	 */
	@Description(value = "缓存类型")
	private DbCacheType CacheType = DbCacheType.NO;
	/**
	 * 缓存时长 单位为秒 0为永久缓存
	 */
	@Description(value = "缓存时长")
	private int CacheTimeOut = 0;
	/**
	 * 缓存目录
	 */
	@Description(value = "缓存目录")
	private String CachePath = "cachetemp";
	/**
	 * 事务级别
	 */
	@Description(value = "事务级别")
	private int IsolationLevel = Connection.TRANSACTION_SERIALIZABLE;

	/**
	 * 获取数据库帐号
	 * 
	 * @return 数据库帐号
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * 设置数据库帐号
	 * 
	 * @param userName 数据库帐号
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * 获取数据库帐号
	 * 
	 * @return 数据库帐号
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * 设置数据库密码
	 * 
	 * @param password 数据库密码
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * 获取数据库类型
	 * @return 数据库类型
	 */
	public DbProviderType getProviderType() {
		return ProviderType;
	}

	/**
	 * 设置数据库类型
	 * 
	 * @param providerType 数据库类型
	 */
	public void setProviderType(DbProviderType providerType) {
		ProviderType = providerType;
	}

	/**
	 * 获取数据库连接串
	 * @return 数据库连接串
	 */
	public String getConnectionString() {
		return ConnectionString;
	}

	/**
	 * 设置数据库连接串
	 * 
	 * @param connectionString 数据库连接串
	 */
	public void setConnectionString(String connectionString) {
		ConnectionString = connectionString;
	}

	/**
	 * 获取是否启用事务
	 * @return 是否启用事务
	 */
	public boolean getIsTransaction() {
		return IsTransaction;
	}

	/**
	 * 设置是否启用事务
	 * 
	 * @param isTransaction 是否启用事务
	 */
	public void setIsTransaction(boolean isTransaction) {
		IsTransaction = isTransaction;
	}

	/**
	 * 获取执行超时时长
	 * @return 执行超时时长
	 */
	public int getCommandTimeOut() {
		return CommandTimeOut;
	}

	/**
	 * 设置执行超时时长
	 * 
	 * @param commandTimeOut 执行超时时长
	 */
	public void setCommandTimeOut(int commandTimeOut) {
		CommandTimeOut = commandTimeOut;
	}

	/**
	 * 获取缓存类型
	 * @return 缓存类型
	 */
	public DbCacheType getCacheType() {
		return CacheType;
	}

	/**
	 * 设置缓存类型
	 * 
	 * @param cacheType 缓存类型
	 */
	public void setCacheType(DbCacheType cacheType) {
		CacheType = cacheType;
	}

	/**
	 * 获取缓存时长
	 * @return 缓存时长
	 */
	public int getCacheTimeOut() {
		return CacheTimeOut;
	}

	/**
	 * 设置缓存时长
	 * 
	 * @param cacheTimeOut 缓存时长
	 */
	public void setCacheTimeOut(int cacheTimeOut) {
		CacheTimeOut = cacheTimeOut;
	}

	/**
	 * 获取缓存目录
	 * @return 缓存目录
	 */
	public String getCachePath() {
		return CachePath;
	}

	/**
	 * 设置缓存目录
	 * 
	 * @param cachePath 缓存目录
	 */
	public void setCachePath(String cachePath) {
		CachePath = cachePath;
	}

	/**
	 * 获取事务级别
	 * 
	 * @return 事务级别
	 */
	public int getIsolationLevel() {
		return IsolationLevel;
	}

	/**
	 * 设置事务级别
	 * 
	 * @param isolationLevel 事务级别
	 */
	public void setIsolationLevel(int isolationLevel) {
		IsolationLevel = isolationLevel;
	}

}