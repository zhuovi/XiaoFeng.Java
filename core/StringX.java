package xiaofeng.core;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles.Lookup;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 字符串增强操作类
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
public class StringX {
	/**
	 * 字符串转换StringX
	 * 
	 * @param value 字符串
	 */
	public StringX(String value) {
		this.Value = value;
	}

	/**
	 * 值
	 */
	private String Value;

	/**
	 * 移除开始的字符串
	 * 
	 * @param regex 正则字符串
	 * @return StringX对象
	 */
	public StringX trimStart(String regex) {
		this.Value = StringHelper.TrimStart(this.Value, regex);
		return this;
	}

	/**
	 * 移除结尾的字符串
	 * 
	 * @param regex 正则字符串
	 * @return StringX对象
	 */
	public StringX trimEnd(String regex) {
		this.Value = StringHelper.TrimEnd(this.Value, regex);
		return this;
	}

	/**
	 * 移除开始和结尾的字符串
	 * 
	 * @param regex 正则字符串
	 * @return StringX对象
	 */
	public StringX trim(String regex) {
		this.Value = StringHelper.Trim(this.Value, regex);
		return this;
	}

	/**
	 * 左补一定长度字符串
	 * 
	 * @param totalWidth 总长度
	 * @param ch         替补字符
	 * @return StringX对象
	 */

	public StringX padLeft(int totalWidth, char ch) {
		this.Value = StringHelper.PadLeft(this.Value, totalWidth, ch);
		return this;
	}

	/**
	 * 右补一定长度字符串
	 * 
	 * @param totalWidth 总长度
	 * @param ch         替补字符
	 * @return StringX对象
	 */
	public StringX padRight(int totalWidth, char ch) {
		this.Value = StringHelper.PadRight(this.Value, totalWidth, ch);
		return this;
	}

	/**
	 * 截取字符串
	 * 
	 * @param length    长度
	 * @param endString 结束字符串
	 * @return StringX对象
	 */
	public StringX subString(int length, String endString) {
		this.Value = StringHelper.SubString(this.Value, length, endString);
		return this;
	}

	/**
	 * 格式化字符串
	 * 
	 * @param args 参数集
	 * @return StringX对象
	 */
	public StringX format(Object... args) {
		this.Value = StringHelper.format(this.Value, args);
		return this;
	}

	/**
	 * 替换字符串
	 * 
	 * @param oldChar 原来字符串
	 * @param newChar 新字符串
	 * @return StringX对象
	 */
	public StringX replace(char oldChar, char newChar) {
		this.Value = this.Value.replace(oldChar, newChar);
		return this;
	}

	/**
	 * 替换字符串
	 * 
	 * @param target      目标字符串
	 * @param replacement 替换后字符串
	 * @return StringX对象
	 */
	public StringX replace(CharSequence target, CharSequence replacement) {
		this.Value = this.Value.replace(target, replacement);
		return this;
	}

	/**
	 * 替换所有字符串
	 * 
	 * @param regex       正则字符串
	 * @param replacement 替换后字符串
	 * @return StringX对象
	 */
	public StringX replaceAll(String regex, String replacement) {
		this.Value = this.Value.replaceAll(regex, replacement);
		return this;
	}

	/**
	 * 替换开头字符串
	 * 
	 * @param regex       正则字符串
	 * @param replacement 替换后字符串
	 * @return StringX对象
	 */
	public StringX replaceFirst(String regex, String replacement) {
		this.Value = this.Value.replaceFirst(regex, replacement);
		return this;
	}

	/**
	 * 正则移除字符串
	 * 
	 * @param regex 正则字符串
	 * @return StringX对象
	 */
	public StringX removePattern(String regex) {
		this.Value = this.Value.replaceAll(regex, "");
		return this;
	}

	/**
	 * 字符串重复次数
	 * 
	 * @param count 重复的次数
	 * @return StringX对象
	 */
	public StringX repeat(int count) {
		this.Value = this.Value.repeat(count);
		return this;
	}

	/**
	 * 格式化字符串
	 * 
	 * @param map 数据集
	 * @return StringX对象
	 */
	public StringX Format(Map<String, Object> map) {
		this.Value = StringHelper.Format(this.Value, map);
		return this;
	}

	/**
	 * 字符串是否为空
	 * 
	 * @return true为空 false 不为空
	 */
	public boolean isEmpty() {
		return this.Value.isEmpty();
	}

	/**
	 * 字符串为空或仅包含空格代码点
	 * 
	 * @return 如果字符串为空或仅包含空格代码点，则返回true，否则返回false。
	 */
	public boolean isBlank() {
		return this.Value.isBlank();
	}

	/**
	 * 获取字符串长度
	 * 
	 * @return 字符串长度
	 */
	public int length() {
		return this.Value.length();
	}

	/**
	 * 转换类型
	 * 
	 * @param c 目标类型
	 * @return 对象
	 */
	public Object ToCast(Class<?> c) {
		return StringHelper.ToCast(this.Value, c);
	}

	/**
	 * 转换类型
	 * 
	 * @param <T> 类型
	 * @param c   目标类型
	 * @return 对象
	 */
	public <T> T toCast(Class<T> c) {
		return StringHelper.toCast(this.Value, c);
	}

	/**
	 * 转小写字符串
	 * 
	 * @return 小写字符串
	 */
	public StringX toLowerCase() {
		this.Value = this.Value.toLowerCase();
		return this;
	}

	/**
	 * 转大写字符串
	 * 
	 * @return 大写字符串
	 */
	public StringX toUpperCase() {
		this.Value = this.Value.toUpperCase();
		return this;
	}

	/**
	 * 字符串第几位字符
	 * 
	 * @param index 索引
	 * @return 字符
	 */
	public char charAt(int index) {
		return this.Value.charAt(index);
	}

	/**
	 * 转成字节流
	 * 
	 * @return 字节流
	 */
	public IntStream chars() {
		return this.Value.chars();
	}

	/**
	 * 与字符串比较大小
	 * 
	 * @param anotherString 字符串
	 * @return 大于返回1 小于返加-1 相等返回0
	 */
	public int compareTo(String anotherString) {
		return this.Value.compareTo(anotherString);
	}

	/**
	 * 不区分大小写与字符串比较大小
	 * 
	 * @param str 字符串
	 * @return 大于返回1 小于返加-1 相等返回0
	 */
	public int compareToIgnoreCase(String str) {
		return this.Value.compareToIgnoreCase(str);
	}

	/**
	 * 返回指定索引处的字符
	 * 
	 * @param index 索引
	 * @return 字符
	 */
	public int codePointAt(int index) {
		return this.Value.codePointAt(index);
	}

	/**
	 * 返回指定索引处前的字符
	 * 
	 * @param index 索引
	 * @return 字符
	 */
	public int codePointBefore(int index) {
		return this.Value.codePointBefore(index);
	}

	/**
	 * 返回返回此字符串的指定文本范围内的Unicode代码点数
	 * 
	 * @param beginIndex 开始索引
	 * @param endIndex   结束索引
	 * @return 字符
	 */
	public int codePointCount(int beginIndex, int endIndex) {
		return this.Value.codePointCount(beginIndex, endIndex);
	}

	/**
	 * 连接字符串
	 * 
	 * @param str 字符串
	 * @return StringX对象
	 */
	public StringX concat(String str) {
		this.Value = this.Value.concat(str);
		return this;
	}

	/**
	 * 是否包含指定的字符串
	 * 
	 * @param s 指定字符串
	 * @return 是否包含
	 */
	public boolean contains(CharSequence s) {
		return this.Value.contains(s);
	}

	/**
	 * 将此字符串与指定的StringBuffer进行比较。 当且仅当此String表示与指定的StringBuffer相同的字符序列时，结果为true。
	 * 
	 * @param sb 字符串
	 * @return 是否相同
	 */
	public boolean contentEquals(StringBuffer sb) {
		return this.Value.contentEquals(sb);
	}

	/**
	 * 将此字符串与指定的StringBuffer进行比较。 当且仅当此String表示与指定的StringBuffer相同的字符序列时，结果为true。
	 * 
	 * @param cs 字符串
	 * @return 是否相同
	 */
	public boolean contentEquals(CharSequence cs) {
		return this.Value.contentEquals(cs);
	}

	/**
	 * 字符串前缀是否包含指定字符串
	 * 
	 * @param prefix 指定字符串
	 * @return 是否包含
	 */
	public boolean startsWith(String prefix) {
		return this.Value.startsWith(prefix);
	}

	/**
	 * 字符串指定索引处开始是否包含指定字符串
	 * 
	 * @param prefix  指定字符串
	 * @param toffset 指定索引
	 * @return 是否包含
	 */
	public boolean startsWith(String prefix, int toffset) {
		return this.Value.startsWith(prefix, toffset);
	}

	/**
	 * 字符串后缀是否包含指定字符串
	 * 
	 * @param suffix 指定字符串
	 * @return 是否包含
	 */
	public boolean endsWith(String suffix) {
		return this.Value.endsWith(suffix);
	}

	/**
	 * 和对象比较是否相等
	 * 
	 * @param anObject 对象
	 * @return 是否相等
	 */
	public boolean equals(Object anObject) {
		return this.Value.equals(anObject);
	}

	/**
	 * 不区分大小写和字符串比较是否相等
	 * 
	 * @param anotherString 字符串
	 * @return 是否相等
	 */
	public boolean equalsIgnoreCase(String anotherString) {
		return this.Value.equalsIgnoreCase(anotherString);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param args 参数集合
	 * @return StringX对象
	 */
	public StringX formatted(Object... args) {
		this.Value = this.Value.formatted(args);
		return this;
	}

	/**
	 * 获取当前字节组
	 * 
	 * @return 字节流
	 */
	public byte[] getBytes() {
		return this.Value.getBytes();
	}

	/**
	 * 获取当前字节组
	 * 
	 * @param charset 编码
	 * @throws UnsupportedEncodingException 编码不对时抛出异常
	 * @return 字节流
	 */
	public byte[] getBytes(String charset) throws UnsupportedEncodingException {
		if (!Charset.isSupported(charset))
			charset = "utf-8";
		return this.Value.getBytes(charset);
	}

	/**
	 * 获取当前字节组
	 * 
	 * @param charset 编码
	 * @return 字节流
	 */
	public byte[] getBytes(Charset charset) {
		return this.Value.getBytes(charset);
	}

	/**
	 * 获取字符集
	 * 
	 * @param srcBegin 源字符串开始
	 * @param srcEnd   源字符串结束
	 * @param dstBegin 目标字符串开始
	 * @return 字符集
	 */
	public char[] getChars(int srcBegin, int srcEnd, int dstBegin) {
		char[] dst = new char[srcEnd - srcBegin + dstBegin];
		this.Value.getChars(srcBegin, srcEnd, dst, dstBegin);
		return dst;
	}

	/**
	 * 格式化字符串
	 * 
	 * @param n 空位数
	 * @return StringX对象
	 */
	public StringX indent(int n) {
		this.Value = this.Value.indent(n);
		return this;
	}

	/**
	 * 返回字符串对象的规范表示。
	 * 
	 * @param n 位数
	 * @return StringX对象
	 */
	public StringX intern(int n) {
		this.Value = this.Value.intern();
		return this;
	}

	/**
	 * 从字符串结尾开始查找指定字符串
	 * 
	 * @param str 指定字符串
	 * @return 所在索引
	 */
	public int lastIndexOf(String str) {
		return this.Value.lastIndexOf(str);
	}

	/**
	 * 从字符串结尾开始查找指定字符
	 * 
	 * @param ch 指定字符
	 * @return 所在索引
	 */
	public int lastIndexOf(int ch) {
		return this.Value.lastIndexOf(ch);
	}

	/**
	 * 从字符串指定索引处开始查找指定字符
	 * 
	 * @param ch        指定字符
	 * @param fromindex 开始索引处查找
	 * @return 所在索引
	 */
	public int lastIndexOf(int ch, int fromindex) {
		return this.Value.lastIndexOf(ch, fromindex);
	}

	/**
	 * 从字符串指定索引处开始查找指定字符串
	 * 
	 * @param str       指定字符串
	 * @param fromindex 开始索引处查找
	 * @return 所在索引
	 */
	public int lastIndexOf(String str, int fromindex) {
		return this.Value.lastIndexOf(str, fromindex);
	}

	/**
	 * 从此字符串中提取的行流，以行终止符分隔。
	 * 
	 * @return 返回从此字符串中提取的行流，以行终止符分隔。
	 */
	public Stream<String> lines() {
		return this.Value.lines();
	}

	/**
	 * 当前字符串是否匹配指定正则字符串
	 * 
	 * @param regex 正则字符串
	 * @return 是否匹配
	 */
	public boolean matches(String regex) {
		return this.Value.matches(regex);
	}

	/**
	 * 当前字符串区域是否匹配指定字符串
	 * 
	 * @param toffset 字符串开始索引
	 * @param other   指定字符串
	 * @param ooffset 指定字符串开始索引
	 * @param len     指定字符串长度
	 * @return 是否匹配
	 */
	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return this.Value.regionMatches(toffset, other, ooffset, len);
	}

	/**
	 * 当前字符串区域是否匹配指定字符串
	 * 
	 * @param ignoreCase 是否区分大小
	 * @param toffset    字符串开始索引
	 * @param other      指定字符串
	 * @param ooffset    指定字符串开始索引
	 * @param len        指定字符串长度
	 * @return 是否匹配
	 */
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return this.Value.regionMatches(toffset, other, ooffset, len);
	}

	/**
	 * 当前字符串区域是否匹配指定StringX字符串
	 * 
	 * @param toffset 字符串开始索引
	 * @param other   指定StringX字符串
	 * @param ooffset 指定字符串开始索引
	 * @param len     指定字符串长度
	 * @return 是否匹配
	 */
	public boolean regionMatches(int toffset, StringX other, int ooffset, int len) {
		return this.regionMatches(toffset, other.toString(), ooffset, len);
	}

	/**
	 * 当前字符串区域是否匹配指定StringX字符串
	 * 
	 * @param ignoreCase 是否区分大小
	 * @param toffset    字符串开始索引
	 * @param other      指定StringX字符串
	 * @param ooffset    指定字符串开始索引
	 * @param len        指定字符串长度
	 * @return 是否匹配
	 */
	public boolean regionMatches(boolean ignoreCase, int toffset, StringX other, int ooffset, int len) {
		return this.regionMatches(ignoreCase, toffset, other.toString(), ooffset, len);
	}

	/**
	 * 将此实例解析为常量Desc，其结果就是实例本身。
	 * 
	 * @param lookup 是否被忽略
	 * @return StringX对象
	 */
	public StringX resolveConstantDesc(Lookup lookup) {
		this.Value = this.Value.resolveConstantDesc(lookup);
		return this;
	}

	/**
	 * 指定正则字符串把当前字符串拆分成数组
	 * 
	 * @param regex 正则字符串
	 * @return 数组
	 */
	public String[] split(String regex) {
		return this.Value.split(regex);
	}

	/**
	 * 指定正则字符串把当前字符串拆分成数组
	 * 
	 * @param regex 正则字符串
	 * @param limit 数组长度
	 * @return 数组
	 */
	public String[] split(String regex, int limit) {
		return this.Value.split(regex, limit);
	}
}