package xiaofeng.data;

import xiaofeng.annotations.Description;

/**
 * 数据库驱动类型
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
public enum DbProviderType {
	/**
	 * MySQL
	 */
	@Description("MySQL")
	MySQL("com.mysql.jdbc.Driver", 0),
	/**
	 * MySQL8.0
	 */
	@Description("MySQL80")
	MySQL80("com.mysql.cj.jdbc.Driver", 5),
	/**
	 * SqlServer
	 */
	@Description("SqlServer")
	SqlServer("com.microsoft.jdbc.sqlserver.SQLServerDriver", 1),
	/**
	 * ODBC
	 */
	@Description("ODBC")
	ODBC("sun.jdbc.odbc.JdbcOdbcDriver", 2),
	/**
	 * Oracle
	 */
	@Description("Oracle")
	Oracle("oracle.jdbc.driver.OracleDriver", 3),
	/**
	 * Sybase
	 */
	@Description("Sybase")
	Sybase("com.sybase.jdbc.SybDriver", 4),
	/**
	 * SQLite
	 */
	@Description("SQLite")
	SQLite("org.sqlite.JDBC", 6);

	/**
	 * 默认驱动
	 */
	private String Driver = "org.gjt.mm.mysql.Driver";
	/**
	 * 驱动值
	 */
	private int Value = 0;

	/**
	 * 构造器
	 * 
	 * @param driver 驱动
	 * @param value  值
	 */
	DbProviderType(String driver, int value) {
		this.Driver = driver;
		this.Value = value;
	}

	/**
	 * 获取驱动名称
	 * 
	 * @return 驱动名称
	 */
	public String getDriver() {
		return this.Driver;
	}

	/**
	 * 获取驱动值
	 * 
	 * @return 值
	 */
	public int getValue() {
		return this.Value;
	}
}
