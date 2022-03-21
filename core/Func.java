package xiaofeng.core;

/**
 * 委托工具类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-13
 * @since 1.0.0
 * @version 1.0.0
 */
public interface Func {
	/**
	 * 委托
	 * 
	 * @return 是否正确
	 */
	public boolean fun();

	/**
	 * 1个参数委托
	 * 
	 * @param <T> 类型
	 * @param t   对象
	 * @return 类型对象
	 */
	public <T> boolean fun(T t);

	/**
	 * 2两个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @return 类型对象
	 */
	public <T1, T2> boolean fun(T1 t1, T2 t2);

	/**
	 * 3个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3> boolean fun(T1 t1, T2 t2, T3 t3);

	/**
	 * 4个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4);

	/**
	 * 5个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param <T5> 第5个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @param t5   第5个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);

	/**
	 * 6个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param <T5> 第5个类型
	 * @param <T6> 第6个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @param t5   第5个对象
	 * @param t6   第6个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);

	/**
	 * 7个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param <T5> 第5个类型
	 * @param <T6> 第6个类型
	 * @param <T7> 第7个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @param t5   第5个对象
	 * @param t6   第6个对象
	 * @param t7   第7个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);

	/**
	 * 8个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param <T5> 第5个类型
	 * @param <T6> 第6个类型
	 * @param <T7> 第7个类型
	 * @param <T8> 第8个 类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @param t5   第5个对象
	 * @param t6   第6个对象
	 * @param t7   第7个对象
	 * @param t8   第8个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);

	/**
	 * 9个参数委托
	 * 
	 * @param <T1> 第1个类型
	 * @param <T2> 第2个类型
	 * @param <T3> 第3个类型
	 * @param <T4> 第4个类型
	 * @param <T5> 第5个类型
	 * @param <T6> 第6个类型
	 * @param <T7> 第7个类型
	 * @param <T8> 第8个 类型
	 * @param <T9> 第9个类型
	 * @param t1   第1个对象
	 * @param t2   第2个对象
	 * @param t3   第3个对象
	 * @param t4   第4个对象
	 * @param t5   第5个对象
	 * @param t6   第6个对象
	 * @param t7   第7个对象
	 * @param t8   第8个对象
	 * @param t9   第9对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8,
			T9 t9);

	/**
	 * 10个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8,
			T9 t9, T10 t10);

	/**
	 * 11个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7,
			T8 t8, T9 t9, T10 t10, T11 t11);

	/**
	 * 12个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6,
			T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12);

	/**
	 * 13个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5,
			T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13);

	/**
	 * 14个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5,
			T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14);

	/**
	 * 15个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> boolean fun(T1 t1, T2 t2, T3 t3, T4 t4,
			T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15);

	/**
	 * 16个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param <T16> 第16个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @param t16   第16个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> boolean fun(T1 t1, T2 t2, T3 t3,
			T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16);

	/**
	 * 17个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param <T16> 第16个类型
	 * @param <T17> 第17个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @param t16   第16个对象
	 * @param t17   第17个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> boolean fun(T1 t1, T2 t2, T3 t3,
			T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16,
			T17 t17);

	/**
	 * 18个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param <T16> 第16个类型
	 * @param <T17> 第17个类型
	 * @param <T18> 第18个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @param t16   第16个对象
	 * @param t17   第17个对象
	 * @param t18   第18个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> boolean fun(T1 t1, T2 t2,
			T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15,
			T16 t16, T17 t17, T18 t18);

	/**
	 * 19个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param <T16> 第16个类型
	 * @param <T17> 第17个类型
	 * @param <T18> 第18个类型
	 * @param <T19> 第19个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @param t16   第16个对象
	 * @param t17   第17个对象
	 * @param t18   第18个对象
	 * @param t19   第19个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> boolean fun(T1 t1,
			T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14,
			T15 t15, T16 t16, T17 t17, T18 t18, T19 t19);

	/**
	 * 20个参数委托
	 * 
	 * @param <T1>  第1个类型
	 * @param <T2>  第2个类型
	 * @param <T3>  第3个类型
	 * @param <T4>  第4个类型
	 * @param <T5>  第5个类型
	 * @param <T6>  第6个类型
	 * @param <T7>  第7个类型
	 * @param <T8>  第8个 类型
	 * @param <T9>  第9个类型
	 * @param <T10> 第10个类型
	 * @param <T11> 第11个类型
	 * @param <T12> 第12个类型
	 * @param <T13> 第13个类型
	 * @param <T14> 第14个类型
	 * @param <T15> 第15个类型
	 * @param <T16> 第16个类型
	 * @param <T17> 第17个类型
	 * @param <T18> 第18个类型
	 * @param <T19> 第19个类型
	 * @param <T20> 第20个类型
	 * @param t1    第1个对象
	 * @param t2    第2个对象
	 * @param t3    第3个对象
	 * @param t4    第4个对象
	 * @param t5    第5个对象
	 * @param t6    第6个对象
	 * @param t7    第7个对象
	 * @param t8    第8个对象
	 * @param t9    第9个对象
	 * @param t10   第10个对象
	 * @param t11   第11个对象
	 * @param t12   第12个对象
	 * @param t13   第13个对象
	 * @param t14   第14个对象
	 * @param t15   第15个对象
	 * @param t16   第16个对象
	 * @param t17   第17个对象
	 * @param t18   第18个对象
	 * @param t19   第19个对象
	 * @param t20   第20.个对象
	 * @return 类型对象
	 */
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> boolean fun(
			T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14,
			T15 t15, T16 t16, T17 t17, T18 t18, T19 t19, T20 t20);
}