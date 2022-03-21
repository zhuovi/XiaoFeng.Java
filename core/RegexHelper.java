package xiaofeng.core;

import java.util.*;
import java.util.regex.*;

/**
 * 正则表达式操作类
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
public class RegexHelper {

	/**
	 * 编译一个正则表达式
	 * 
	 * @param regex      正则表达式
	 * @param ignoreCase 模式
	 * @return 正则表达式
	 */
	public static Pattern compile(String regex, Integer ignoreCase) {
		return ignoreCase == 0 ? Pattern.compile(regex) : Pattern.compile(regex, ignoreCase);
	}

	/**
	 * 编译一个正则表达式
	 * 
	 * @param regex 正则表达式
	 * @return 正则表达式
	 */
	public static Pattern compile(String regex) {
		return compile(regex, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 获取 matcher
	 * 
	 * @param regex      正则表达式
	 * @param input      字符串
	 * @param ignoreCase 是否区分大小写
	 * @return Matcher
	 */
	public static Matcher Matcher(String input, String regex, Integer ignoreCase) {
		return compile(regex, ignoreCase).matcher(input);
	}

	/**
	 * 获取 matcher
	 * 
	 * @param input 字符串
	 * @param regex 正则表达式
	 * @return Matcher
	 */
	public static Matcher Matcher(String input, String regex) {
		return Matcher(input, regex, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 提取符合模式的数据
	 * 
	 * @param input 字符串
	 * @param regex 正则表达式
	 * @return 返回所有匹配数据
	 */
	public static List<String> Match(String input, String regex) {
		List<String> data = new ArrayList<>();
		Matcher ms = Matcher(input, regex);
		while (ms.find()) {
			data.add(ms.group("a"));
		}
		return data;
	}

	/**
	 * 提取符合模式的数据
	 * 
	 * @param input 字符串
	 * @param regex 正则表达式
	 * @return 返回所有匹配数据
	 */
	public static String match(String input, String regex) {
		List<String> data = Match(input, regex);
		if (data == null || data.size() == 0)
			return null;
		return data.get(0);
	}

	/**
	 * 提取符合模式的数据
	 * 
	 * @param input 字符串
	 * @param regex 正则表达式
	 * @return 返回所有匹配数据
	 */
	public static List<Map<String, String>> Matches(String input, String regex) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Matcher ms = Matcher(input, regex);
		while (ms.find()) {
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i <= ms.groupCount(); i++) {
				map.put("" + i, ms.group(i));
			}
			list.add(map);
		}
		return list;
	}
	/**
	 * 提取符合模式的数据
	 * 
	 * @param input 字符串
	 * @param regex 正则表达式
	 * @return 返回所匹配数据
	 */
	public static Map<String, String> Matchs(String input, String regex) {
		List<Map<String, String>> list = Matches(input, regex);
		if (list == null)
			return null;
		Iterator<Map<String, String>> iter = list.iterator();
		if (!list.iterator().hasNext())
			return null;
		return iter.next();
	}

	/**
	 * 字符串匹配模式
	 * 
	 * @param input      字符串
	 * @param regex      正则表达式
	 * @param ignoreCase 模式
	 * @return 是否匹配
	 */
	public static boolean IsMatch(String input, String regex, Integer ignoreCase) {
		if (regex == null)
			return true;
		if (input == null)
			return false;
		return Matcher(input, regex, ignoreCase).matches();
	}

	/**
	 * 正则替换
	 * 
	 * @param input       字符串
	 * @param regex       正则原字符串
	 * @param replacement 替换后的字符串
	 * @param ignoreCase  是否区分大小写
	 * @return 替换后的字符串
	 */
	public static String ReplacePattern(String input, String regex, String replacement, int ignoreCase) {
		return Matcher(input, regex, ignoreCase).replaceAll(replacement);
	}

	/**
	 * 正则替换
	 * 
	 * @param input       字符串
	 * @param regex       正则原字符串
	 * @param replacement 替换后的字符串
	 * @return 替换后的字符串
	 */
	public static String ReplacePattern(String input, String regex, String replacement) {
		return ReplacePattern(input, regex, replacement, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 正则移除
	 * 
	 * @param input      字符串
	 * @param regex      正则原字符串
	 * @param ignoreCase 是否区分大小写
	 * @return 移除后的字符串
	 */
	public static String RemovePattern(String input, String regex, int ignoreCase) {
		return ReplacePattern(input, regex, "", ignoreCase);
	}

	/**
	 * 正则移除
	 * 
	 * @param input 字符串
	 * @param regex 正则原字符串
	 * @return 移除后的字符串
	 */
	public static String RemovePattern(String input, String regex) {
		return RemovePattern(input, regex, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 字符串匹配模式
	 * 
	 * @param regex 正则表达式
	 * @param input 字符串
	 * @return 是否匹配
	 */
	public static boolean IsMatch(String input, String regex) {
		return IsMatch(input, regex, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * 是否是中文
	 * 
	 * @param input 字符串
	 * @return 是否是中文
	 */
	public static boolean IsChinese(String input) {
		return IsMatch(input, CHINESE);
	}

	/**
	 * 是否是字母
	 * 
	 * @param input 字符串
	 * @return 是否是字母
	 */
	public static boolean IsLetter(String input) {
		return IsMatch(input, LETTER);
	}

	/**
	 * 是否是FTP
	 * 
	 * @param input 字符串
	 * @return 是否是FTP
	 */
	public static boolean IsFtp(String input) {
		return IsMatch(input, FTP);
	}

	/**
	 * 是否是HTTP
	 * 
	 * @param input 字符串
	 * @return 是否是HTTP
	 */
	public static boolean IsHttp(String input) {
		return IsMatch(input, HTTP);
	}

	/**
	 * 是否是GUID
	 * 
	 * @param input 字符串
	 * @return 是否是GUID
	 */
	public static boolean IsGuid(String input) {
		return IsMatch(input, GUID);
	}

	/**
	 * 是否是EMAIL
	 * 
	 * @param input 字符串
	 * @return 是否是EMAIL
	 */
	public static boolean IsEmail(String input) {
		return IsMatch(input, EMAIL);
	}

	/**
	 * 是否是NUMBERIC
	 * 
	 * @param input 字符串
	 * @return 是否是NUMBERIC
	 */
	public static boolean IsNumberic(String input) {
		return IsMatch(input, NUMBERIC);
	}

	/**
	 * 是否是FLOAT
	 * 
	 * @param input 字符串
	 * @return 是否是FLOAT
	 */
	public static boolean IsFloat(String input) {
		return IsMatch(input, FLOAT);
	}

	/**
	 * 是否是TEL
	 * 
	 * @param input 字符串
	 * @return 是否是TEL
	 */
	public static boolean IsTel(String input) {
		return IsMatch(input, TEL);
	}

	/**
	 * 是否是PHONE
	 * 
	 * @param input 字符串
	 * @return 是否是PHONE
	 */
	public static boolean IsPhone(String input) {
		return IsMatch(input, PHONE);
	}

	/**
	 * 是否是DATE
	 * 
	 * @param input 字符串
	 * @return 是否是DATE
	 */
	public static boolean IsDate(String input) {
		return IsMatch(input, DATE);
	}

	/**
	 * 是否是TIME
	 * 
	 * @param input 字符串
	 * @return 是否是TIME
	 */
	public static boolean IsTime(String input) {
		return IsMatch(input, TIME);
	}

	/**
	 * 是否是DATETIME
	 * 
	 * @param input 字符串
	 * @return 是否是DATETIME
	 */
	public static boolean IsDateTime(String input) {
		return IsMatch(input, DATETIME);
	}

	/**
	 * 是否是DATEORTIME
	 * 
	 * @param input 字符串
	 * @return 是否是DATEORTIME
	 */
	public static boolean IsDateOrTime(String input) {
		return IsMatch(input, DATEORTIME);
	}

	/**
	 * 是否是IPV4
	 * 
	 * @param input 字符串
	 * @return 是否是IPV4
	 */
	public static boolean IsIPV4(String input) {
		return IsMatch(input, IPV4);
	}

	/**
	 * 是否是BOOLEAN
	 * 
	 * @param input 字符串
	 * @return 是否是BOOLEAN
	 */
	public static boolean IsBoolean(String input) {
		return IsMatch(input, BOOLEAN);
	}

	/**
	 * 是否是参数
	 * 
	 * @param input 字符串
	 * @return 是否是参数
	 */
	public static boolean IsQuery(String input) {
		return IsMatch(input, QUERY);
	}

	/**
	 * 是否是JSON
	 * 
	 * @param input 字符串
	 * @return 是否是JSON
	 */
	public static boolean IsJson(String input) {
		return IsMatch(input, JSON);
	}

	/**
	 * 是否是时间戳
	 * 
	 * @param input 字符串
	 * @return 是否是时间戳
	 */
	public static boolean IsTimestamp(String input) {
		return IsMatch(input, TIMESTAMP);
	}

	/**
	 * 中文汉字正则表达式
	 */
	public static final String CHINESE = "^[\\u4e00-\\u9fa5？，“”‘’。、；：]+$";
	/**
	 * 字母正则表达式
	 */
	public static final String LETTER = "^[a-zA-Z]+$";
	/**
	 * FTP正则表达式
	 */
	public static final String FTP = "^ftp:\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#\\s\\.\\(\\)\\[\\]\\*]*[\\w\\-\\@?^=%&amp;/~\\+#])$";
	/**
	 * HTTP正则表达式
	 */
	public static final String HTTP = "^http(s)?:\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#\\s\\.\\(\\)\\[\\]\\*]*[\\w\\-\\@?^=%&amp;/~\\+#])$";
	/**
	 * GUID正则表达式
	 */
	public static final String GUID = "^[a-z0-9]{8}(-?)[a-z0-9]{4}\\14[a-z0-9]{3}\\1[a-z0-9]{4}\\1[a-z0-9]{12}$";
	/**
	 * EMAIL正则表达式
	 */
	public static final String EMAIL = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/**
	 * 数字正则表达式
	 */
	public static final String NUMBERIC = "^(\\+|-)?\\d+$";
	/**
	 * 浮点正则表达式
	 */
	public static final String FLOAT = "^(\\+|-)?\\d+([.]\\d+)?$";
	/**
	 * 电话正则表达式
	 */
	public static final String TEL = "^([+0]?(86[-/]?)?)?(((0\\d{2,3})|\\d{2,3})[-/]?)?[1-9]\\d{6,7}$";
	/**
	 * 手机号正则表达式
	 */
	public static final String PHONE = "^([+0]?(86[-/]?)?)?1[3456789]\\d{9}$";
	/**
	 * 日期正则表达式
	 */
	public static final String DATE = "^((\\d{2}|\\d{4})(-|\\/)(\\d{1,2})\\3(\\d{1,2})|((\\d{2}|\\d{4})年(\\d{1,2})月(\\d{1,2})日))$";
	/**
	 * 时间正则表达式
	 */
	public static final String TIME = "^\\d{1,2}\\:\\d{1,2}(\\:\\d{1,2}(\\.\\d+)?)?$";
	/**
	 * 日期时间正则表达式
	 */
	public static final String DATETIME = "^(((\\d{2}|\\d{4})(-|\\/)(\\d{1,2})\\4(\\d{1,2})(\\s+|T)\\d{1,2}\\:\\d{1,2}(\\:\\d{1,2}(\\.\\d+)?)?Z?)|((\\d{2}|\\d{4})年(\\d{1,2})月(\\d{1,2})日(\\s*)\\d{1,2}(时|点)\\d{1,2}分(\\d{1,2}秒)?))$";
	/**
	 * 日期或时间正则表达式
	 */
	public static final String DATEORTIME = "^((\\d{2}|\\d{4})(-|\\/)(\\d{1,2})\\3(\\d{1,2})|((\\d{2}|\\d{4})年(\\d{1,2})月(\\d{1,2})日))((\\s*|T)((\\d{1,2}\\:\\d{1,2}(\\:\\d{1,2}(\\.\\d+)?)?Z?)|(\\d{1,2}(时|点)\\d{1,2}分(\\d{1,2}秒)?)))?$";
	/**
	 * IPV4正则表达式
	 */
	public static final String IPV4 = "^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}$";
	/**
	 * BOOLEAN正则表达式
	 */
	public static final String BOOLEAN = "^(true|false)$";
	/**
	 * 参数正则表达式
	 */
	public static final String QUERY = "^([^=&]+=[^&]*&?)*$";
	/**
	 * JSON正则表达式
	 */
	public static final String JSON = "^(({[\\s\\S]+})|(\\[[\\s\\S]+\\]))$";
	/**
	 * 时间戳正则表达式
	 **/
	public static final String TIMESTAMP = "^1\\d{9,12}$";
}