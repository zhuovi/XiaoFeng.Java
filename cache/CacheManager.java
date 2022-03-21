package xiaofeng.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import xiaofeng.core.StringHelper;

/**
 * 缓存管理者
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
public class CacheManager {
	/**
	 * 缓存数据
	 */
	private static final ConcurrentMap<String, Cache> Data = new ConcurrentHashMap<>();
	/**
	 * 命中缓存统计
	 */
	private static final ConcurrentMap<String, Long> HitCounts = new ConcurrentHashMap<>();

	/**
	 * 单实例构造方法
	 */
	private CacheManager() {
		super();
	}

	/**
	 * 获取缓存命中数据
	 * 
	 * @return 获取缓存命中数据
	 */
	public synchronized static Map<String, Long> hits() {
		return (Map<String, Long>) HitCounts;
	}

	/**
	 * 获取缓存
	 * 
	 * @param key 缓存key
	 * @return 缓存值
	 */
	public synchronized static Cache get(String key) {
		if (!contains(key))
			return null;
		Cache data = Data.getOrDefault(key, null);
		if (data == null)
			return null;
		long timeOut = System.currentTimeMillis();
		if (data.getTimeOut() > timeOut || data.getTimeOut() == 0) {
			long hits = HitCounts.get(key);
			HitCounts.put(key, ++hits);
		} else
			remove(key);
		return data;
	}

	/**
	 * 设置缓存
	 * 
	 * @param cache 缓存
	 */
	public synchronized static void put(Cache cache) {
		if (StringHelper.IsNullOrEmpty(cache))
			return;
		if (cache.getTimeOut() <= System.currentTimeMillis())
			return;
		if (StringHelper.IsNullOrEmpty(cache.getKey()))
			return;
		Data.put(cache.getKey(), cache);
		HitCounts.put(cache.getKey(), 0L);
	}

	/**
	 * 设置缓存
	 * 
	 * @param key     缓存key
	 * @param value   缓存值
	 * @param timeOut 超时时长 单位为毫秒
	 */
	public synchronized static void put(String key, Object value, long timeOut) {
		if (StringHelper.IsNullOrEmpty(key))
			return;
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setValue(value);
		cache.setTimeOut(timeOut + System.currentTimeMillis());
		Data.put(key, cache);
		HitCounts.put(key, 0L);
	}

	/**
	 * 缓存数量
	 * 
	 * @return 缓存数量
	 */
	public synchronized static long size() {
		return Data.keySet().size();
	}

	/**
	 * 所有缓存key
	 * 
	 * @return 所有缓存key
	 */
	public synchronized static List<String> keys() {
		ArrayList<String> list = new ArrayList<>();
		Data.entrySet().forEach(a -> {
			list.add(a.getKey());
		});
		return list;
	}

	/**
	 * 缓存是否存在
	 * 
	 * @param key 缓存 key
	 * @return true为存在 false为不存在
	 */
	public synchronized static boolean contains(String key) {
		return Data.containsKey(key);
	}

	/**
	 * 移除缓存
	 * 
	 * @param key 缓存key
	 */

	public synchronized static void remove(String key) {
		Data.remove(key);
		HitCounts.remove(key);
	}

	/**
	 * 清空所有缓存
	 */
	public synchronized static void clear() {
		Data.clear();
		HitCounts.clear();
	}
}