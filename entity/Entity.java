package xiaofeng.entity;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import xiaofeng.annotations.Column;
import xiaofeng.annotations.Table;
import xiaofeng.config.DataConfig;
import xiaofeng.data.ConnectionConfig;
import xiaofeng.data.DataHelper;

/**
 * 实体基础类
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
public abstract class Entity<T> extends EntityBase implements IEntity<T> {
	/**
	 * 构造器
	 */
	public Entity() {
		@SuppressWarnings("unchecked")
		Class<T> childType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		Table table = childType.getAnnotation(Table.class);
		if (table != null) {
			this.TableName = table.Name();
			String ConnName = table.ConnectionName();
			this.Config = DataConfig.Current(DataConfig.class).Data.get(ConnName);
		} else {
			this.TableName = childType.getSimpleName();
		}
		this.MapFields = new HashMap<String, Column>();
		for (Field f : childType.getDeclaredFields()) {
			Column column = f.getDeclaredAnnotation(Column.class);
			if (column != null) {
				this.MapFields.put(column.Name(), column);
			}
		}
	}

	/**
	 * 表名
	 */
	@JsonIgnore
	public String TableName;
	/**
	 * 数据库连接对象
	 */
	@JsonIgnore
	public ConnectionConfig Config;
	/**
	 * 所有列
	 */
	@JsonIgnore
	public Map<String, Column> MapFields;
	/**
	 * 表类型
	 */
	@JsonProperty(value = "ModelType")
	public ModelType modelType = ModelType.Table;

	/**
	 * @return 模型类型
	 */
	@Override
	public ModelType getModelType() {
		return modelType;
	}

	/**
	 * 数据库操作对象
	 */
	private DataHelper dataHelper;

	/**
	 * 获取数据库操作对象
	 * 
	 * @return 数据库操作对象
	 */
	public DataHelper getDataHelper() {
		if (this.dataHelper == null)
			this.dataHelper = new DataHelper(this.Config);
		return this.dataHelper;
	}

	/**
	 * @param modelType 模型类型
	 */
	@Override
	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	/**
	 * 脏数据
	 */
	private DirtyCollection Dirtys = new DirtyCollection();

	/**
	 * 获取脏数据集合
	 * 
	 * @return 脏数据集合
	 */
	@Override
	public DirtyCollection GetDirtys() {
		return this.Dirtys;
	}

	/**
	 * 添加脏数据
	 * 
	 * @param value 脏数据
	 */
	@Override
	public void AddDirty(String value) {
		if (value.isEmpty())
			return;
		if (!this.Dirtys.contains(value))
			this.Dirtys.add(value);
	}

	/**
	 * 设置脏数据
	 * 
	 * @param value 脏数据集合
	 */
	@Override
	public void SetDirtys(DirtyCollection value) {
		if (value.isEmpty())
			return;
		this.Dirtys = value;
	}

	/**
	 * 清空脏数据
	 */
	@Override
	public void ClearDirtys() {
		this.Dirtys.clear();
	}

	/**
	 * 移除脏数据
	 * 
	 * @param value 脏数据
	 */
	@Override
	public void RemoveDirty(String value) {
		if (this.Dirtys.contains(value))
			this.Dirtys.remove(value);
	}

	/**
	 * 移除脏数据集合
	 * 
	 * @param list 脏数据集合
	 */
	@Override
	public void RemoveDirty(List<String> list) {
		this.Dirtys.remove(list);
	}

	/**
	 * 是否存在脏数据
	 * 
	 * @param value 脏数据
	 * @return true 存在 false 不存在
	 */
	@Override
	public boolean ContainsDirty(String value) {
		return this.Dirtys.contains(value);
	}

	/**
	 * 获取主键
	 * 
	 * @return 主键
	 */
	public String GetPrimaryKey() {
		List<Column> list = this.MapFields.values().stream().filter(a -> a.PrimaryKey()).collect(Collectors.toList());
		Iterator<Column> iterator = list.iterator();
		if (list == null || !iterator.hasNext() || list.size() == 0)
			return null;
		return iterator.next().Name();
		/*
		 * for (Column column : this.MapFields.values()) if (column.PrimaryKey()) return
		 * column.Name(); return "";
		 */
	}

	/**
	 * 获取列
	 * 
	 * @param key 列名
	 * @return 列配置
	 */
	public Column GetColumn(String key) {
		if (this.MapFields.containsKey(key))
			return this.MapFields.get(key);
		return null;
	}

	/**
	 * 插入数据
	 * 
	 * @return true 插入成功 false 插入失败
	 */
	@Override
	public boolean Insert() {
		if (this.Dirtys.isEmpty())
			return false;
		String SqlString = "insert into " + this.TableName;
		String Fields = "(";
		String Values = "(";
		Object[] values = new Object[this.Dirtys.size()];
		int i = 0;
		for (String a : this.Dirtys.toArray()) {
			Fields += a + ",";
			Values += "?,";
			values[i++] = this.Get(a);
		}
		SqlString += Fields.replaceAll(",$", ")") + " values " + Values.replaceAll(",$", ")");
		return this.getDataHelper().ExecuteNonQuery(SqlString, values);
	}

	/**
	 * 更新数据
	 * 
	 * @return true 更新成功 false 更新失败
	 */
	@Override
	public boolean Update() {
		if (this.Dirtys.isEmpty())
			return false;
		String SqlString = "update " + this.TableName;
		String Fields = "set ";
		String Where = "";
		Object[] values = new Object[this.Dirtys.size()];
		HashSet<String> PrimaryKeys = new HashSet<String>();
		int i = 0;
		for (String a : this.Dirtys.toArray()) {
			Column column = this.GetColumn(a);
			if (a == null)
				continue;
			if (column.PrimaryKey()) {
				PrimaryKeys.add(a);
				// Where += (StringHelper.IsNullOrEmpty(Where) ? " where " : " and ") + a +
				// "=?";
			} else {
				Fields += a + " = ?,";
				values[i++] = this.Get(a);
			}
		}
		if (PrimaryKeys.size() == 0) {
			PrimaryKeys.add(this.GetPrimaryKey());
		}
		if (PrimaryKeys.size() > 0) {
			// Where
		}
		Fields = Fields.replaceAll(",$", "");
		SqlString += Fields + Where;
		return this.getDataHelper().ExecuteNonQuery(SqlString, values);
	}

	/**
	 * 删除数据
	 * 
	 * @return true 删除成功 false 删除失败
	 */
	@Override
	public boolean Delete() {
		return true;
	}

	/**
	 * 数据列表
	 * 
	 * @return 数据列表
	 */
	@Override
	public List<T> ToList() {
		List<T> list = new ArrayList<>();

		return list;
	}
}