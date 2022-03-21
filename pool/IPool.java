package xiaofeng.pool;

public interface IPool<T> {
	T poll();
	boolean put();
	void clear();
}