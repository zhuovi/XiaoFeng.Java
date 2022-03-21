package xiaofeng.data;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import xiaofeng.core.ArrayHelper;
import xiaofeng.core.StringHelper;

/**
 * 通用数据库操作类
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
public class DataHelper {
	/**
	 * 设置数据库配置
	 * 
	 * @param config 数据库配置
	 */
	public DataHelper(ConnectionConfig config) {
		this.setConfig(config);
	}

	/**
	 * 设置数据库类型及数据库连接串
	 * 
	 * @param providerType     数据库驱动类型
	 * @param connectionString 数据库连接串
	 */
	public DataHelper(DbProviderType providerType, String connectionString) {
		this.config = new ConnectionConfig(providerType, connectionString);
	}

	/**
	 * 设置数据库类型及数据库连接串 帐号 密码
	 * 
	 * @param providerType     数据库驱动类型
	 * @param connectionString 数据库连接串
	 * @param username         数据库帐号
	 * @param password         数据库密码
	 */
	public DataHelper(DbProviderType providerType, String connectionString, String username, String password) {
		this.config = new ConnectionConfig(providerType, connectionString, username, password);
	}

	/**
	 * 数据库配置
	 */
	private ConnectionConfig config;
	/**
	 * 数据库连接对象
	 */
	private Connection DbConn;
	/**
	 * @SQL语句对象
	 */
	private Statement DbStatement;

	/**
	 * 获取数据库配置
	 * 
	 * @return 数据库配置
	 */
	public ConnectionConfig getConfig() {
		return config;
	}

	/**
	 * 设置数据库配置
	 * @param config 数据库配置
	 */
	public void setConfig(ConnectionConfig config) {
		this.config = config;
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return 数据库连接对象
	 */
	public boolean openConnection() {
		try {
			Class.forName(this.config.getProviderType().getDriver());
			if ((this.config.getUserName() == null) && (this.config.getPassword() == null)) {
				DbConn = DriverManager.getConnection(this.config.getConnectionString());
			} else {
				DbConn = DriverManager.getConnection(this.config.getConnectionString(), this.config.getUserName(),
						this.config.getPassword());
			}
			this.DbConn.setTransactionIsolation(this.config.getIsolationLevel());
			this.DbConn.setAutoCommit(!this.config.getIsTransaction());
			DbStatement = DbConn.createStatement();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * 关闭数据库连接对象
	 */
	public void closeConnection() {
		try {
			if (this.DbStatement != null && !this.DbStatement.isClosed())
				this.DbStatement.close();
			if (this.DbConn != null && !this.DbConn.isClosed())
				this.DbConn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 提交事务
	 */
	public void commit() {
		if (this.config.getIsTransaction())
			try {
				this.DbConn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * 回滚事务
	 */
	public void rollback() {
		if (this.config.getIsTransaction())
			try {
				this.DbConn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * 执行SQL语句
	 * 
	 * @param sql SQL语句
	 * @return 是否执行成功
	 */
	public boolean ExecuteNonQuery(String sql) {
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			boolean flag = this.DbStatement.executeUpdate(sql) > 0;
			this.commit();
			return flag;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			this.rollback();
			return false;
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * 执行SQL语句
	 * 
	 * @param sql        SQL语句
	 * @param parameters 参数
	 * @return 是否执行成功
	 */
	public boolean ExecuteNonQuery(String sql, Object[] parameters) {
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			PreparedStatement ps = this.DbConn.prepareStatement(sql);
			if (!StringHelper.IsNullOrEmpty(parameters) && parameters.length > 0) {
				this.SetPreparedStatementParam(ps, parameters);
			}
			boolean flag = ps.executeUpdate() > 0;
			this.commit();
			return flag;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			this.rollback();
			return false;
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * 获取首行
	 * 
	 * @param sql SQL语句
	 * @return 首行首列
	 */
	@SuppressWarnings("null")
	public Object ExecuteScalar(String sql) {
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			ResultSet rs = this.DbStatement.executeQuery(sql);
			this.commit();
			if (rs == null && rs.next())
				return null;
			return rs.getObject(0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			this.rollback();
			return null;
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * 获取首行
	 * 
	 * @param sql        SQL语句
	 * @param parameters 参数
	 * @return 首行首列
	 */
	@SuppressWarnings("null")
	public Object ExecuteScalar(String sql, Object[] parameters) {
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			PreparedStatement ps = this.DbConn.prepareStatement(sql);
			if (!StringHelper.IsNullOrEmpty(parameters) && parameters.length > 0) {
				this.SetPreparedStatementParam(ps, parameters);
			}
			ResultSet rs = ps.executeQuery();
			this.commit();
			if (rs == null && rs.next())
				return null;
			return rs.getObject(0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			this.rollback();
			return null;
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * 获取数据列表
	 * 
	 * @param <T> 类型
	 * @param sql SQL语句
	 * @param c   对象类型
	 * @return 数据列表
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> ToList(String sql, Class<T> c) {
		List<T> list = new ArrayList<T>();
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			ResultSet rs = this.DbStatement.executeQuery(sql);
			while (rs.next()) {
				try {
					T obj = (T) this.ToObject(rs, c);
					if (obj != null)
						list.add(obj);
					// System.out.println(xiaofeng.json.JsonHelper.toJson(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return list;
	}

	/**
	 * 获取数据列表
	 * 
	 * @param <T>        类型
	 * @param sql        SQL语句
	 * @param parameters 参数
	 * @param c          对象类型
	 * @return 数据列表
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> ToList(String sql, Object[] parameters, Class<T> c) {
		List<T> list = new ArrayList<T>();
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			PreparedStatement ps = this.DbConn.prepareStatement(sql);
			if (!StringHelper.IsNullOrEmpty(parameters) && parameters.length > 0) {
				this.SetPreparedStatementParam(ps, parameters);
			}
			ResultSet rs = ps.executeQuery();
			this.commit();
			if (rs == null)
				return null;
			while (rs.next()) {
				try {
					T obj = (T) this.ToObject(rs, c);
					if (obj != null)
						list.add(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return list;
	}

	/**
	 * 执行存储过程
	 * 
	 * @param procedureName 存储过程名称
	 * @param parameters    参数
	 * @param out           输出参数
	 * @return 执行存储过程是否成功
	 */
	public boolean CallProcedure(String procedureName, Object[] parameters, Integer[] out) {
		try {
			if (this.DbConn == null || this.DbConn.isClosed() || this.DbStatement.isClosed())
				this.openConnection();
			CallableStatement cs = this.DbConn.prepareCall(procedureName);
			if (!StringHelper.IsNullOrEmpty(parameters) && parameters.length > 0) {
				this.SetPreparedStatementParam(cs, parameters);
			}
			int len = parameters.length;
			if (out != null && out.length > 0) {
				for (int i = 0; i < out.length; i++) {
					cs.registerOutParameter(len + i + 1, out[i]);
				}
			}
			return cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * 设置PreparedStatement参数
	 * 
	 * @param ps         PreparedStatement
	 * @param parameters 参数值
	 * @throws SQLException SQL异常
	 */
	public void SetPreparedStatementParam(PreparedStatement ps, Object[] parameters) throws SQLException {
		if (ps == null || parameters == null || parameters.length == 0)
			return;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		for (int i = 0; i < parameters.length; i++) {
			Object param = parameters[i];
			if (param instanceof Integer) {
				int paramValue = ((Integer) param).intValue();
				ps.setInt(i + 1, paramValue);
			} else if (param instanceof Float) {
				float paramValue = ((Float) param).floatValue();
				ps.setFloat(i + 1, paramValue);
			} else if (param instanceof Timestamp) {
				Timestamp paramValue = (Timestamp) param;
				ps.setTimestamp(i + 1, paramValue);
			} else if (param instanceof Double) {
				double paramValue = ((Double) param).doubleValue();
				ps.setDouble(i + 1, paramValue);
			} else if (param instanceof Date) {
				ps.setString(i + 1, format.format((Date) param));
			} else if (param instanceof Long) {
				long paramValue = ((Long) param).longValue();
				ps.setLong(i + 1, paramValue);
			} else if (param instanceof String) {
				ps.setString(i + 1, (String) param);
			} else
				ps.setObject(i + 1, param);

		}
	}

	/**
	 * 数据填充对象
	 * 
	 * @param <T> 类型
	 * @param rs  数据行集
	 * @param c   数据对象类型
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T ToObject(ResultSet rs, Class<?> c) {
		try {
			T obj = (T) c.getDeclaredConstructor().newInstance();
			Method[] ms = c.getMethods();
			ResultSetMetaData rd = rs.getMetaData();
			for (int i = 0; i < rd.getColumnCount(); i++) {
				String columnName = rd.getColumnName(i + 1);
				String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
				String columnTypeName = rd.getColumnTypeName(i + 1);
				Method method = null;
				switch (columnTypeName) {
				case "LONGVARCHAR":
				case "LONGNVARCHAR":
				case "VARCHAR":
				case "CHAR":
					try {
						method = c.getMethod(methodName, String.class);
						if (method != null) {
							method.invoke(obj, rs.getString(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "TINYINT":
				case "INTEGER":
				case "SMALLINT":
				case "INT":
					try {
						method = c.getMethod(methodName, int.class);
						if (method != null) {
							method.invoke(obj, rs.getInt(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "BIGINT":
					try {
						method = c.getMethod(methodName, long.class);
						if (method != null) {
							method.invoke(obj, rs.getLong(columnName));
						}
					} catch (NoSuchMethodException ex) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "TIME":
					try {
						method = c.getMethod(methodName, Time.class);
						if (method != null) {
							method.invoke(obj, rs.getTime(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "DATE":
					try {
						method = c.getMethod(methodName, Date.class);
						if (method != null) {
							method.invoke(obj, rs.getDate(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "TIMESTAMP":
					try {
						method = c.getMethod(methodName, Timestamp.class);
						if (method != null) {
							method.invoke(obj, rs.getTimestamp(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "DECIMAL":
					try {
						method = c.getMethod(methodName, BigDecimal.class);
						if (method != null) {
							method.invoke(obj, rs.getBigDecimal(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "REAL":
				case "FLOAT":
					try {
						method = c.getMethod(methodName, float.class);
						if (method != null) {
							method.invoke(obj, rs.getFloat(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "DOUBLE":
				case "NUMERIC":
					try {
						method = c.getMethod(methodName, double.class);
						if (method != null) {
							method.invoke(obj, rs.getDouble(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				case "BOOL":
				case "BOOLEAN":
				case "BIT":
					try {
						method = c.getMethod(methodName, boolean.class);
						if (method != null) {
							method.invoke(obj, rs.getBoolean(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				default:
					try {
						method = c.getMethod(methodName, Object.class);
						if (method != null) {
							method.invoke(obj, rs.getObject(columnName));
						}
					} catch (NoSuchMethodException e) {
						Method m = ArrayHelper.Find(ms, a -> {
							return a.getName().equalsIgnoreCase(methodName);
						});
						if (m != null)
							m.invoke(obj, rs.getObject(columnName));
					}
					break;
				}
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}
}