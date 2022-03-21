package xiaofeng.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 随机数操作类
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
public class RandomHelper {
	/**
	 * 初始化参数
	 */
	public RandomHelper() {
		this.RandomType = xiaofeng.core.RandomType.Number;
		this.IsRepeat = true;
		this.Min = 0;
		this.Max = 100;
		this.Count = 1;
		this.Length = 4;
		long num = new Date().getTime();
		this.random = new Random(((int) (((long) num) & 0xffffffffL)) | ((int) (num >> 32)));
	}

	/**
	 * 实例化随机对象
	 * 
	 * @return 随机对象
	 */
	private static RandomHelper instance() {
		return new RandomHelper();
	}

	/**
	 * 字符串集
	 */
	private final String SpecialChars = "`~!@#$%^&*()_+-=;':\"\",./?\\|{}[]";
	/**
	 * 字符串集
	 */
	private final String LetterChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * 字符串集
	 */
	private final String NumberChars = "0123456789";
	/**
	 * 最小值
	 */
	public int Min;
	/**
	 * 最大值
	 */
	public int Max;
	/**
	 * 随机类型
	 */
	public RandomType RandomType;
	/**
	 * 字符串长度
	 */
	public int Length;
	/**
	 * 是否重复
	 */
	public Boolean IsRepeat;
	/**
	 * 生成个数
	 */
	public int Count;
	/**
	 * 随机种子
	 */
	private Random random = new Random(new Date().getTime());

	/**
	 * 生成区间数字
	 * 
	 * @param min 最小数
	 * @param max 最大数
	 * @return 返回一个随机的区间数字
	 */
	public int getRandom(int min, int max) {
		if (min > max)
			return 0;
		else if (min == max)
			return min;
		return this.random.nextInt(max + 1 - min) + min;
	}

	/**
	 * 生成一组随机数字
	 * 
	 * @param min    最小数
	 * @param max    最大数
	 * @param count  个数
	 * @param repeat 是否重否
	 * @return 返回组随机数字
	 */
	public List<Integer> getRandoms(int min, int max, int count, boolean repeat) {
		List<Integer> list = new ArrayList<Integer>();
		if (count <= 0)
			return list;
		if (min > max)
			return list;
		else if (min == max) {
			list.add(min);
			return list;
		}
		if (!repeat && max - min < count)
			count = max - min;
		for (int i = 0; i < count; i++) {
			int Rand = this.getRandom(min, max);
			while (!repeat && list.contains(Rand)) {
				Rand = this.getRandom(min, max);
			}
			list.add(Rand);
		}
		return list;
	}

	/**
	 * 生成一组随机数字
	 * 
	 * @param min   最小数
	 * @param max   最大数
	 * @param count 个数
	 * @return 返回组随机数字
	 */
	public List<Integer> getRandoms(int min, int max, int count) {
		return this.getRandoms(min, max, count, true);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length     长度
	 * @param randomType 随机类型
	 * @param repeat     是否重复
	 * @return 返回随机字符串
	 */
	public String getRandom(int length, RandomType randomType, boolean repeat) {
		if (length <= 0)
			return "";
		String s = "", _Chars = "";
		switch (randomType.getValue()) {
		case 1:
			_Chars = NumberChars;
			break;
		case 2:
			_Chars = LetterChars;
			break;
		case 3:
			_Chars = NumberChars + LetterChars;
			break;
		case 4:
			_Chars = SpecialChars;
			break;
		case 5:
			_Chars = NumberChars + SpecialChars;
			break;
		case 6:
			_Chars = LetterChars + SpecialChars;
			break;
		case 7:
			_Chars = NumberChars + LetterChars + SpecialChars;
			break;
		}
		int _Length = _Chars.length();
		for (int i = 0; i < length; i++) {
			char _Char = _Chars.toCharArray()[this.getRandom(0, _Length - 1)];
			if (!repeat) {
				_Chars = _Chars.replaceAll("" + _Char, "");
				_Length--;
				if (_Length == 0)
					break;
			}
			s += _Char;
		}
		return s;
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length     长度
	 * @param randomType 随机类型
	 * @return 返回随机字符串
	 */
	public String getRandom(int length, RandomType randomType) {
		return this.getRandom(length, randomType, true);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length 长度
	 * @return 返回随机字符串
	 */
	public String getRandom(int length) {
		return this.getRandom(length, xiaofeng.core.RandomType.All, true);
	}

	/**
	 * 生成区间数字
	 * 
	 * @param min 最小数
	 * @param max 最大数
	 * @return 返回一个随机的区间数字
	 */
	public static int GetRandom(int min, int max) {
		return instance().getRandom(min, max);
	}

	/**
	 * 生成一组随机数字
	 * 
	 * @param min    最小数
	 * @param max    最大数
	 * @param count  个数
	 * @param repeat 是否重否
	 * @return 返回组随机数字
	 */
	public static List<Integer> GetRandoms(int min, int max, int count, boolean repeat) {
		return instance().getRandoms(min, max, count, repeat);
	}

	/**
	 * 生成一组随机数字
	 * 
	 * @param min   最小数
	 * @param max   最大数
	 * @param count 个数
	 * @return 返回组随机数字
	 */
	public static List<Integer> GetRandoms(int min, int max, int count) {
		return instance().getRandoms(min, max, count);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length     长度
	 * @param randomType 随机类型
	 * @param repeat     是否重复
	 * @return 返回随机字符串
	 */
	public static String GetRandom(int length, RandomType randomType, boolean repeat) {
		return instance().getRandom(length, randomType, repeat);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length     长度
	 * @param randomType 随机类型
	 * @return 返回随机字符串
	 */
	public String GetRandom(int length, RandomType randomType) {
		return instance().getRandom(length, randomType, true);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length 长度
	 * @return 返回随机字符串
	 */
	public String GetRandom(int length) {
		return instance().getRandom(length, xiaofeng.core.RandomType.All, true);
	}
}