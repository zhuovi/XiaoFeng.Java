package xiaofeng.core;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * 字符串操作类
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
public class StringHelper {
	/**
	 * 转换为整型
	 * 
	 * @param value 字符串
	 * @return 整型类型
	 */
	public static int ToInt(String value) {
		return (int) ToCast(value, Integer.class);
	}

	/**
	 * 转换为double
	 * 
	 * @param value 字符串
	 * @return double类型
	 */
	public static double ToDouble(String value) {
		return (double) ToCast(value, double.class);
	}

	/**
	 * 字符串转换成其它类型
	 * 
	 * @param value 字符串
	 * @param c     类型
	 * @return 目标对象
	 */
	public static Object ToCast(String value, Class<?> c) {
		String typeName = c.getSimpleName();
		if (typeName.equalsIgnoreCase("string"))
			return value;
		if (typeName.equalsIgnoreCase("integer") || typeName.equalsIgnoreCase("int"))
			return RegexHelper.IsNumberic(value) ? Integer.parseInt(value) : 0;
		if (typeName.equalsIgnoreCase("long"))
			return RegexHelper.IsNumberic(value) ? Long.parseLong(value) : 0;
		if (typeName.equalsIgnoreCase("double"))
			return RegexHelper.IsFloat(value) ? Double.parseDouble(value) : 0;
		if (typeName.equalsIgnoreCase("float"))
			return RegexHelper.IsFloat(value) ? Float.parseFloat(value) : 0;
		if (typeName.equalsIgnoreCase("byte"))
			return RegexHelper.IsNumberic(value) ? Byte.parseByte(value) : 0;
		if (typeName.equalsIgnoreCase("char"))
			return RegexHelper.IsMatch("^[0-9a-f]$", value) ? value.toCharArray()[0] : 0;
		if (typeName.equalsIgnoreCase("boolean"))
			return RegexHelper.IsNumberic(value) ? Boolean.parseBoolean(value) : 0;
		if (typeName.equalsIgnoreCase("timestamp"))
			return RegexHelper.IsTimestamp(value) ? new Timestamp(Long.parseLong(value)) : 0;
		if (typeName.equalsIgnoreCase("date")) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			try {
				return RegexHelper.IsDateOrTime(value) ? format.parse(value) : new Date(0);
			} catch (ParseException e) {
				e.printStackTrace();
				return new Date(0);
			}
		}
		return null;
	}

	/**
	 * 字符串转换成其它类型
	 * 
	 * @param value 字符串
	 * @param c     类型
	 * @param <T>   类型
	 * @return 目标对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toCast(String value, Class<T> c) {
		return (T) ToCast(value, c);
	}

	/**
	 * 字符从一个编码转换成另一种编码
	 * 
	 * @param value 字符
	 * @param from  原来编码
	 * @param to    新编码
	 * @return 转编码后的字符串
	 */
	public static String ToCharset(String value, String from, String to) {
		if (IsNullOrEmpty(value))
			return null;
		try {
			return new String(value.getBytes(from), to);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 字符从一个编码转换成另一种编码
	 * 
	 * @param value 字符
	 * @param to    新编码
	 * @return 转编码后的字符串
	 */
	public static String ToCharset(String value, String to) {
		if (IsNullOrEmpty(value))
			return null;
		try {
			return new String(value.getBytes(), to);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 移除html标签
	 * 
	 * @param htmlString html内容
	 * @return 移除后的html文本
	 */
	public static String InnerText(String htmlString) {
		if (IsNullOrEmpty(htmlString))
			return null;
		htmlString = htmlString.replaceAll("<!--[\\s\\S]*?-->", "");
		htmlString = htmlString.replaceAll("<script[^>]*>[\\s\\S]*?</\\s*script>", "");
		htmlString = htmlString.replaceAll("<(script|style|textarea)[^>]*>[\\s\\S]*?</\\s*(script|style|textarea)>",
				"");
		htmlString = htmlString.replaceAll(
				"<\\s*(!doctype|table|thead|tbody|tr|td|th|div|blockquote|fieldset|legend|font|i|u|h[1-9]|s|b|m|p|strong|meta|iframe|frame|span|layer|link|html|head|body|title|a|ul|ol|li|dl|dt|dd|img|form|select|input|button|canvas|header|nav|footer|select|option|textarea|em|noscript|section|svg|use|label)(\\s*[^>]*)?>|<\\/\\s*(table|thead|tbody|tr|td|th|div|blockquote|fieldset|legend|font|i|u|h[1-9]|s|b|m|p|strong|meta|iframe|frame|span|layer|link|html|head|body|title|a|ul|ol|li|dl|dt|dd|img|form|select|input|button|canvas|header|nav|footer|select|option|textarea|em|noscript|section|svg|use|label)\\s*>",
				"");
		htmlString = htmlString.replaceAll("[\\r\\n\\t]+", "");
		htmlString = htmlString.replaceAll("&gt;", ">");
		htmlString = htmlString.replaceAll("&lt;", "<");
		htmlString = htmlString.replaceAll("&amp;", "&");
		htmlString = htmlString.replaceAll("&quot;", "\"");
		htmlString = htmlString.replaceAll("&nbsp;", " ");
		htmlString = htmlString.replaceAll("\\s+", " ");
		htmlString = htmlString.replaceAll("&copy;", "©");
		htmlString = htmlString.replaceAll("&reg;", "®");
		return htmlString;
	}

	/**
	 * 截取字符串 一个汉字为两个字符
	 * 
	 * @param value     字符串
	 * @param length    长度
	 * @param endString 结束字符
	 * @return 截取后的字符串
	 */
	public static String SubString(String value, int length, String endString) {
		if (IsNullOrEmpty(value))
			return "";
		value = value.replaceAll("[\\s\\r\\t\\n]+", "");
		if (length <= 0)
			return value;
		if (value.getBytes().length <= length)
			return value;
		int num = 0;
		String str = "";
		for (int i = 0; i < value.length(); i++) {
			String sub = value.substring(i, i + 1);
			num += sub.getBytes().length;
			str += sub;
			if (num >= length)
				break;
		}
		return str + endString;
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param value 字符串
	 * @return true为空 false不为空
	 */
	public static boolean IsNullOrEmpty(String value) {
		return value == null || value.length() == 0;
	}

	/**
	 * 对象是否为空
	 * 
	 * @param value 对象
	 * @return true为空 false不为空
	 */
	public static boolean IsNullOrEmpty(Object value) {
		return ObjectHelper.IsNullOrEmpty(value);
	}

	/**
	 * 指定字符串是否为 null、空还是仅由空白字符组成
	 * 
	 * @param value 是字符串
	 * @return true为空 false不为空
	 */
	public static boolean IsNullOrWhiteSpace(String value) {
		if (!IsNullOrEmpty(value))
			for (int i = 0; i < value.length(); i++)
				if (!Character.isWhitespace(value.charAt(i)))
					return false;
		return true;
	}

	/**
	 * 截取字符串 一个汉字为两个字符
	 * 
	 * @param value  字符串
	 * @param length 长度
	 * @return 截取后的字符串
	 */
	public static String SubString(String value, int length) {
		return SubString(value, length, "...");
	}

	/**
	 * 16进制转字符串
	 * 
	 * @param value    16进制字符串
	 * @param encoding 编码
	 * @return 字符串
	 */
	public static String HexToString(String value, String encoding) {
		if (IsNullOrEmpty(value)) {
			return null;
		}
		value = value.replaceAll("\\s+", "");
		byte[] bs = new byte[value.length() / 2];
		for (int i = 0; i < bs.length; i++) {
			try {
				bs[i] = (byte) (0xff & Integer.parseInt(value.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			value = new String(bs, encoding);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return value;
	}

	/**
	 * 16进制转字符串
	 * 
	 * @param value 16进制字符串
	 * @return 字符串
	 */
	public static String HexToString(String value) {
		return HexToString(value, "UTF-8");
	}

	/**
	 * 字符串转16进制字符串
	 * 
	 * @param value 字符串
	 * @return 16进制字符串
	 */
	public static String StringToHex(String value) {
		String str = "";
		for (int i = 0; i < value.length(); i++) {
			int ch = (int) value.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 字节转16进制是字符串
	 * 
	 * @param bytes 字节
	 * @return 16进制是字符串
	 */
	public static String BytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() < 2)
				sb.append(0);
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * 16进制字符串转字节
	 * 
	 * @param hex 16进制字符串
	 * @return 字节
	 */
	public static byte[] HexToBytes(String hex) {
		int len = hex.length();
		byte[] result;
		if (len % 2 == 1) {
			len++;
			hex = "0" + hex;
		}
		result = new byte[len / 2];
		int j = 0;
		for (int i = 0; i < len; i += 2)
			result[j++] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
		return result;
	}

	/**
	 * 字符串正序排序
	 * 
	 * @param value 字符串
	 * @return 排序后的字符串
	 */
	public static String OrderBy(String value) {
		char[] chars = value.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	/**
	 * 字符串倒序序排序
	 * 
	 * @param value 字符串
	 * @return 排序后的字符串
	 */
	public static String OrderByDescending(String value) {
		StringBuffer sbr = new StringBuffer(OrderBy(value));
		sbr.reverse();
		return sbr.toString();
	}

	/**
	 * 多元符表达式
	 * 
	 * @param <T>          类型
	 * @param colls        集合
	 * @param defaultValue 默认值
	 * @return 有值对象
	 */
	public static <T> T Multivariate(Collection<T> colls, T defaultValue) {
		if (colls.isEmpty())
			return defaultValue;
		Iterator<T> iter = colls.iterator();
		while (iter.hasNext()) {
			T t = iter.next();
			if (!IsNullOrEmpty(t))
				return t;
		}
		return defaultValue;
	}

	/**
	 * 多元符表达式
	 * 
	 * @param <T>          类型
	 * @param ts           集合
	 * @param defaultValue 默认值
	 * @return 有值对象
	 */
	public static <T> T Multivariate(T[] ts, T defaultValue) {
		if (IsNullOrEmpty(ts) || ts.length == 0)
			return defaultValue;
		for (T t : ts) {
			if (!IsNullOrEmpty(t))
				return t;
		}
		return defaultValue;
	}

	/**
	 * 移除开头字符串
	 * 
	 * @param value 字符串
	 * @param regex 字符串
	 * @return 移除后的字符串
	 */
	public static String TrimStart(String value, String regex) {
		return value.replaceAll("^(" + regex + ")+", "");
	}

	/**
	 * 移除结尾字符串
	 * 
	 * @param value 字符串
	 * @param regex 字符串
	 * @return 移除后的字符串
	 */
	public static String TrimEnd(String value, String regex) {
		return value.replaceAll("(" + regex + ")+$", "");
	}

	/**
	 * 移除开头结尾字符串
	 * 
	 * @param value 字符串
	 * @param regex 字符串
	 * @return 移除后的字符串
	 */
	public static String Trim(String value, String regex) {
		return value.replaceAll("(^(" + regex + ")+|(" + regex + ")+$)", "");
	}

	/**
	 * 返回一个新字符串，该字符串通过在此字符串中的字符左侧填充指定的 Unicode 字符来达到指定的总长度，从而使这些字符左对齐。
	 * 
	 * @param value 字符串
	 * @param len   结果字符串中的字符数，等于原始字符数加上任何其他填充字符。
	 * @param ch    Unicode 填充字符。
	 * @return 与此实例等效的一个新字符串，但该字符串为左对齐，因此，在右侧填充所需任意数量的 paddingChar 字符，使长度达到
	 *         totalWidth。 但是，如果 len 小于此实例的长度，则此方法返回对现有实例的引用。 如果 len
	 *         等于此实例的长度，则此方法返回与此实例相同的新字符串。
	 */
	public static String PadLeft(String value, int len, char ch) {
		if (value.length() >= len)
			return value;
		for (int i = value.length(); i < len; i++)
			value = ch + value;
		return value;
	}

	/**
	 * 返回一个新字符串，该字符串通过在此字符串中的字符右侧填充指定的 Unicode 字符来达到指定的总长度，从而使这些字符左对齐。
	 * 
	 * @param value 字符串
	 * @param len   结果字符串中的字符数，等于原始字符数加上任何其他填充字符。
	 * @param ch    Unicode 填充字符。
	 * @return 与此实例等效的一个新字符串，但该字符串为左对齐，因此，在右侧填充所需任意数量的 paddingChar 字符，使长度达到
	 *         totalWidth。 但是，如果 len 小于此实例的长度，则此方法返回对现有实例的引用。 如果 len
	 *         等于此实例的长度，则此方法返回与此实例相同的新字符串。
	 */
	public static String PadRight(String value, int len, char ch) {
		if (value.length() >= len)
			return value;
		for (int i = value.length(); i < len; i++)
			value = value + ch;
		return value;
	}

	/**
	 * 将指定字符串中的一个或多个格式项替换为对应对象的字符串表示形式。 和C#中的String.Format是一样功能
	 * 
	 * @param format 复合格式字符串
	 * @param args   要设置格式的对象
	 * @return format 的副本，其中的一个或多个格式项已替换为 args 的字符串表示形式。
	 */
	public static String format(String format, Object... args) {
		for (int i = 0; i < args.length; i++)
			format = RegexHelper.ReplacePattern(format, "\\{" + i + "\\}", args[i].toString());
		return format;
	}

	/**
	 * 将指定字符串中的一个或多个格式项替换为对应对象的字符串表示形式。 和C#中的String.Format是一样功能
	 * 
	 * @param format 复合格式字符串
	 * @param colls  要设置格式的对象
	 * @return format 的副本，其中的一个或多个格式项已替换为 args 的字符串表示形式。
	 */
	public static String Format(String format, Collection<Object> colls) {
		return format(format, colls.toArray());
	}

	/**
	 * 将指定字符串中的一个或多个格式项替换为对应对象的字符串表示形式。 和C#中的String.Format是一样功能
	 * 
	 * @param format 复合格式字符串
	 * @param map    要设置格式的对象
	 * @return format 的副本，其中的一个或多个格式项已替换为 args 的字符串表示形式。
	 */
	public static String Format(String format, Map<String, Object> map) {
		String[] _format = new String[] { format };
		map.forEach((a, b) -> {
			_format[0] = _format[0].replaceAll("\\{" + a + "\\}", b.toString());
		});
		return _format[0];
	}

	/**
	 * 首字母大写
	 * 
	 * @param value 字符串
	 * @return 返回首字母大写后的字符串
	 */
	public static String firstUpper(String value) {
		if (value.isEmpty())
			return value;
		if (value.length() == 1)
			return value.toUpperCase();
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}
}