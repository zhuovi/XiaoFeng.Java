package xiaofeng.entity;

import java.util.List;

/**
 * 实体基础类接口
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
public interface IEntity<T extends Object> {

	/**
	 * 获取脏数据集合
	 * 
	 * @return 脏数据集合
	 */
	DirtyCollection GetDirtys();

	/**
	 * 添加脏数据
	 * 
	 * @param value 脏数据
	 */
	void AddDirty(String value);

	/**
	 * 设置脏数据
	 * 
	 * @param value 脏数据集合
	 */
	void SetDirtys(DirtyCollection value);

	/**
	 * 清空脏数据
	 */
	void ClearDirtys();

	/**
	 * 移除脏数据
	 * 
	 * @param value 脏数据
	 */
	void RemoveDirty(String value);

	/**
	 * 移除脏数据集合
	 * 
	 * @param list 脏数据集合
	 */
	void RemoveDirty(List<String> list);

	/**
	 * 是否存在脏数据
	 * 
	 * @param value 脏数据
	 * @return true 存在 false 不存在
	 */
	boolean ContainsDirty(String value);

	/**
	 * 插入数据
	 * 
	 * @return true 插入成功 false 插入失败
	 */
	boolean Insert();

	/**
	 * 更新数据
	 * 
	 * @return true 更新成功 false 更新失败
	 */
	boolean Update();

	/**
	 * 删除数据
	 * 
	 * @return true 删除成功 false 删除失败
	 */
	boolean Delete();

	/**
	 * 数据列表
	 * 
	 * @return 数据列表
	 */
	List<T> ToList();

	/**
	 * 获取模型类型
	 * 
	 * @return 模型类型
	 */
	ModelType getModelType();

	/**
	 * 设置模式类型
	 * 
	 * @param modelType 模型类型
	 */
	void setModelType(ModelType modelType);

}