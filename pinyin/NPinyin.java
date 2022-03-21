package xiaofeng.pinyin;

import java.util.*;
import java.util.Map.Entry;

import xiaofeng.core.StringHelper;

/**
 * 汉字拼音操作类
 * 
 * @author Author : Jacky<br>
 *         Company : 魔法精灵<br>
 *         QQ:7092734<br>
 *         Email : jacky@fayelf.com<br>
 *         Site : http://www.fayelf.com<br>
 *         Create Time : 2020-08-14
 * @since 1.0.0
 * @version 1.0.0
 */
public class NPinyin {
	/**
	 * 包含例外词组读音的键/值对的组合
	 */
	public static final Map<String, String> PhraseSpecial;
	/**
	 * 初始化静态变量
	 */
	static {
		PhraseSpecial = new HashMap<>();
		PhraseSpecial.put("重庆", "chong qing");
		PhraseSpecial.put("银行", "yin hang");
		PhraseSpecial.put("了解", "liao jie");
		PhraseSpecial.put("行家", "hang jia");
		PhraseSpecial.put("便宜", "pian yi");
		PhraseSpecial.put("提防", "di fang");
		PhraseSpecial.put("人参", "ren shen");
		PhraseSpecial.put("朝夕", "zhao xi");
		PhraseSpecial.put("省亲", "xing qin");
		PhraseSpecial.put("西藏", "xi zang");
		PhraseSpecial.put("宝藏", "bao zang");
		PhraseSpecial.put("藏府", "zang fu");
		PhraseSpecial.put("藏族", "zang zu");
		PhraseSpecial.put("藏獒", "zang ao");
		PhraseSpecial.put("弹射", "tan she");
		PhraseSpecial.put("弹跳", "tan tiao");
		PhraseSpecial.put("弹拨", "tan bo");
		PhraseSpecial.put("弹指", "tan zhi");
		PhraseSpecial.put("弹琴", "tan qin");
		PhraseSpecial.put("弹奏", "tan zhou");
		PhraseSpecial.put("弹冠相庆", "tan guan xiang qing");
		PhraseSpecial.put("伎俩", "ji liang");
		PhraseSpecial.put("堡垒", "bao lei");
		PhraseSpecial.put("城堡", "cheng bao");
		PhraseSpecial.put("桥头堡", "qiao tou bao");
		PhraseSpecial.put("星宿", "xing xiu");
	}

	/**
	 * 取文本索引值
	 * 
	 * @param ch 字符
	 * @return 文本索引值
	 */
	private static short getHashIndex(char ch) {
		return (short) ((int) ch % PyCode.codes.length);
	}

	/**
	 * 获取拼音
	 * 
	 * @param text 字符串
	 * @return 返回汉字拼音字符串
	 */
	public static String getPinyin(String text) {
		return getPinyin(text, false);
	}

	/**
	 * 获取拼音
	 * 
	 * @param text       字符串
	 * @param firstUpper 拼音首字母是否大写
	 * @return 返回汉字拼音字符串
	 */
	public static String getPinyin(String text, Boolean firstUpper) {
		text = text.trim();
		for (Entry<String, String> entry : PhraseSpecial.entrySet())
			text = text.replaceAll(entry.getKey(), entry.getValue());

		StringBuilder sbPinyin = new StringBuilder();
		for (int i = 0; i < text.length(); ++i) {
			String py = getPinyin(text.charAt(i));
			if (py != "")
				sbPinyin.append(firstUpper ? StringHelper.firstUpper(py) : py);
			sbPinyin.append(" ");
		}
		text = sbPinyin.toString();
		for (Entry<String, String> entry : PhraseSpecial.entrySet())
			text = text.replaceAll(entry.getValue().replace("", " "), " " + entry.getValue() + " ");
		return text;
	}

	/**
	 * 获取拼音
	 * 
	 * @param ch 字符
	 * @return 返回汉字拼音字符串
	 */
	public static String getPinyin(char ch) {
		short hash = getHashIndex(ch);
		for (int i = 0; i < PyHash.hashes[hash].length; ++i) {
			short index = PyHash.hashes[hash][i];
			int pos = PyCode.codes[index].indexOf(ch, 7);
			if (pos != -1)
				return PyCode.codes[index].substring(0, 6).trim();
		}
		return String.valueOf(ch);
	}

	/**
	 * 获取拼音首字母
	 * 
	 * @param text 字符串
	 * @return 返回汉字拼音首字母字符串
	 */
	public static String getFirstLetter(String text) {
		StringBuilder chars = new StringBuilder();
		for (int i = 0; i < text.length(); ++i) {
			String py = getPinyin(text.charAt(i));
			if (py != "")
				chars.append(py.charAt(0));
		}
		return chars.toString().toUpperCase();
	}
}