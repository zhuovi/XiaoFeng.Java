package xiaofeng.entity;

import java.util.*;
import java.util.function.*;

/**
 * 脏数据集
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
public class DirtyCollection {
	/**
	 * 构造器
	 */
	public DirtyCollection() {
		this.data = new ArrayList<>();
	}

	/**
	 * 脏数据集合
	 */
	private List<String> data = new ArrayList<>();

	/**
	 * 添加脏数据
	 * 
	 * @param name 脏数据
	 */
	public void add(String name) {
		if (!this.data.contains(name))
			this.data.add(name);
	}

	/**
	 * 移除脏数据
	 * 
	 * @param name 脏数据
	 */
	public void remove(String name) {
		if (this.data.contains(name))
			this.data.remove(name);
	}

	/**
	 * 移除脏数据集合
	 * 
	 * @param coll 脏数据集合
	 */
	public void remove(Collection<String> coll) {
		this.data.removeAll(coll);
	}

	/**
	 * 清空脏数据
	 */
	public void clear() {
		this.data.clear();
	}

	/**
	 * 脏数据数量
	 * 
	 * @return 脏数据数量
	 */
	public int size() {
		return this.data.size();
	}

	/**
	 * 是否有脏数据
	 * 
	 * @return 是否有脏数据 true为有 false 为没有
	 */
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	/**
	 * 是否存在脏数据
	 * 
	 * @param name 脏数据
	 * @return 是否存在 true为存在 false 为不存在
	 */
	public boolean contains(String name) {
		return this.data.contains(name);
	}

	/**
	 * 返回迭代器
	 * 
	 * @return 迭代器
	 */
	public Iterator<String> iterator() {
		return this.data.iterator();
	}

	/**
	 * 遍历
	 * 
	 * @param action lambda方法
	 */
	public void forEach(Consumer<? super String> action) {
		Objects.requireNonNull(action);
		this.data.forEach(action);
	}

	/**
	 * 转换成数组
	 * 
	 * @return 数组
	 */
	public String[] toArray() {
		String[] strs = new String[this.data.size()];
		this.data.toArray(strs);
		return strs;
	}
}