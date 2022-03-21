package xiaofeng.config;

import java.util.HashMap;
import java.util.Map;

import xiaofeng.annotations.ConfigFile;
import xiaofeng.annotations.Description;

/**
 * 上传配置操作类
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
@ConfigFile(FileName = "Config/Upload.json", CacheKey = "FAYELF_UPLOADCONFIG", configFormat = ConfigFormat.Json, Timeout = 0)
public class Upload extends ConfigSet<Upload> {
	/**
	 * 无参构造器
	 */
	public Upload() {
		super();
		UploadData ud = new UploadData();
		ud.setExt("html,htm,txt,xml,json,jpg,jpeg,gif,bmp,png,rar,zip,7z,doc,xls,ppt,pdf,wmv,wma,flv,mp3,mp4,wpeg,swf");
		ud.setPath("other");
		this.Default = ud;
		this.Data = new HashMap<String, UploadData>();
		UploadData image = new UploadData();
		image.setPath("image");
		image.setExt("jpg,jpeg,gif,bmp,png");
		this.Data.put("image", image);
		UploadData file = new UploadData();
		file.setPath("attach");
		file.setExt("html,htm,txt,xml,json,rar,zip,7z,doc,ppt,pdf");
		this.Data.put("attach", file);
		UploadData video = new UploadData();
		video.setPath("video");
		video.setExt("wmv,wma,flv,swf,mp3,mp4,mpeg,wpeg");
		this.Data.put("video", video);
	}

	/**
	 * 是否开启上传
	 */
	@Description(value = "是否开启上传")
	private boolean Open = false;
	/**
	 * 是否检查木马
	 */
	@Description(value = "是否检查木马")
	private boolean CheckTrojan = false;
	/**
	 * 木马特征
	 */
	@Description(value = "木马特征")
	private String TrojanFeature = "request[\\[\\(\\s]|eval|alert|document\\.|response\\.|system|excute|redirect|delete |create |exec |select |update |\\.asp|\\.php|\\.aspx|\\.ashx|\\.jsp|\\.asmx|\\.js| table | file|for\\(|foreach|drop |alter |dbo\\.|sys\\.|<script|\\.getfolder|\\.createfolder|\\.deletefolder|\\.createdirectory|\\.deletedirectory|\\.saveas|wscript\\.shell|script\\.encode|server\\.|\\.createobject|execute|activexobject|language=|echo|<\\?php|iframe";
	/**
	 * 允许上传大小 单位为B 默认为10M
	 */
	@Description(value = "允许上传大小")
	private long MaxLength = 10 * 1024 * 1024;
	/**
	 * 生成文件名格式
	 */
	@Description(value = "生成文件名格式")
	private String FileNameFormat = "ZW_{yyyy}{MM}{dd}{HH}{mm}{ss}{fff}_{rnd4}.{ext}";
	/**
	 * 上传目录
	 */
	@Description(value = "上传目录")
	private String UploadPath = "UpLoadFiles";
	/**
	 * 上传路径是否带域名
	 */
	@Description(value = "上传路径是否带域名")
	private boolean IsDomain = false;
	/**
	 * 域名
	 */
	@Description(value = "域名")
	private String Domain = "";
	/**
	 * 默认上传类型配置
	 */
	@Description(value = "默认上传类型配置")
	private UploadData Default;
	/**
	 * 上传类型配置
	 */
	@Description(value = "上传类型配置")
	private Map<String, UploadData> Data;

	/**
	 * 获取是否开启上传
	 * @return 是否开启上传
	 */
	public boolean isOpen() {
		return Open;
	}

	/**
	 * 设置是否开启上传
	 * @param open 是否开启上传
	 */
	public void setOpen(boolean open) {
		Open = open;
	}

	/**
	 * 获取是否检查木马
	 * @return 是否检查木马
	 */
	public boolean isCheckTrojan() {
		return CheckTrojan;
	}

	/**
	 * 设置是否检查木马
	 * @param checkTrojan 是否检查木马
	 */
	public void setCheckTrojan(boolean checkTrojan) {
		CheckTrojan = checkTrojan;
	}

	/**
	 * 获取木马特征
	 * @return 木马特征
	 */
	public String getTrojanFeature() {
		return TrojanFeature;
	}

	/**
	 * 设置木马特征
	 * @param trojanFeature 木马特征
	 */
	public void setTrojanFeature(String trojanFeature) {
		TrojanFeature = trojanFeature;
	}

	/**
	 * 获取允许上传大小
	 * @return 允许上传大小
	 */
	public long getMaxLength() {
		return MaxLength;
	}

	/**
	 * 设置允许上传大小
	 * @param maxLength 允许上传大小
	 */
	public void setMaxLength(long maxLength) {
		MaxLength = maxLength;
	}

	/**
	 * 获取生成文件名格式
	 * @return 生成文件名格式
	 */
	public String getFileNameFormat() {
		return FileNameFormat;
	}

	/**
	 * 设置生成文件名格式
	 * @param fileNameFormat 生成文件名格式
	 */
	public void setFileNameFormat(String fileNameFormat) {
		FileNameFormat = fileNameFormat;
	}

	/**
	 * 获取上传目录
	 * @return 上传目录
	 */
	public String getUploadPath() {
		return UploadPath;
	}

	/**
	 * 设置上传目录
	 * @param uploadPath 上传目录
	 */
	public void setUploadPath(String uploadPath) {
		UploadPath = uploadPath;
	}

	/**
	 * 获取上传路径是否带域名
	 * @return 上传路径是否带域名
	 */
	public boolean isIsDomain() {
		return IsDomain;
	}

	/**
	 * 设置上传路径是否带域名
	 * @param isDomain 上传路径是否带域名
	 */
	public void setIsDomain(boolean isDomain) {
		IsDomain = isDomain;
	}

	/**
	 * 获取域名
	 * @return 域名
	 */
	public String getDomain() {
		return Domain;
	}

	/**
	 * 设置域名
	 * @param domain 域名
	 */
	public void setDomain(String domain) {
		Domain = domain;
	}

	/**
	 * 获取默认上传类型配置
	 * @return 默认上传类型配置
	 */
	public UploadData getDefault() {
		return Default;
	}

	/**
	 * 设置默认上传类型配置
	 * @param default1 默认上传类型配置
	 */
	public void setDefault(UploadData default1) {
		Default = default1;
	}

	/**
	 * 获取上传类型配置
	 * @return 上传类型配置
	 */
	public Map<String, UploadData> getData() {
		return Data;
	}

	/**
	 * 设置上传类型配置
	 * 
	 * @param data 上传类型配置
	 */
	public void setData(Map<String, UploadData> data) {
		Data = data;
	}
}