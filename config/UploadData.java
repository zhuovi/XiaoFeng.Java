package xiaofeng.config;

import xiaofeng.annotations.Description;

/**
 * 上传类型配置
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
public class UploadData {
	/**
	 * 存放文件夹名
	 */
	@Description(value = "存放文件夹名")
	private String Path;
	/**
	 * 文件后缀名 多个用逗号隔开
	 */
	@Description(value = "文件后缀名")
	private String Ext;

	/**
	 * 获取存放文件夹名
	 * 
	 * @return 存放文件夹名
	 */
	public String getPath() {
		return Path;
	}

	/**
	 * 设置存放文件夹名
	 * 
	 * @param path 存放文件夹名
	 */
	public void setPath(String path) {
		Path = path;
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @return 文件后缀名
	 */
	public String getExt() {
		return Ext;
	}

	/**
	 * 设置文件后缀名
	 * 
	 * @param ext 文件后缀名
	 */
	public void setExt(String ext) {
		Ext = ext;
	}
}