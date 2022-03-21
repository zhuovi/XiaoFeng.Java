package xiaofeng.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 文件操作类
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
public class FileHelper {
	/**
	 * 删除目录
	 * 
	 * @param dir 目录
	 * @return 是否删除成功
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				if (!deleteDir(new File(dir, children[i]))) {
					return false;
				}
			}
		}
		return dir.delete();
	}

	/**
	 * 文件或目录是否存在
	 * 
	 * @param path 路径
	 * @return 是否存在
	 */
	public static boolean exits(String path) {
		return new File(path).exists();
	}

	/**
	 * 创建目录
	 * 
	 * @param path 目录路径
	 * @return 是否创建成功
	 */
	public static boolean createDir(String path) {
		File file = new File(path);
		return file.mkdirs();
	}

	/**
	 * 删除文件
	 * 
	 * @param file 文件路径
	 * @return 是否删除成功
	 */
	public static boolean deleteFile(File file) {
		return file.delete();
	}

	/**
	 * 新建File对象 加了文件夹是否存在功能 不存在则创建
	 * 
	 * @param path 文件或文件夹路径
	 * @return File对象
	 */
	public static File newFile(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			if (!file.exists())
				file.mkdirs();
		} else {
			File fParent = file.getParentFile();
			if (fParent != null && !fParent.exists())
				fParent.mkdirs();
		}
		return file;
	}

	/**
	 * 追加文件内容
	 * 
	 * @param filePath 文件路径
	 * @param content  文件内容
	 * @return 是否追加内容成功
	 */
	public static boolean appendFile(String filePath, String content) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(content);
			out.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * 创建文件并且写入内容
	 * 
	 * @param filePath 文件路径
	 * @param content  文件内容
	 * @return 是否创建成功
	 */
	public static boolean createFile(String filePath, String content) {
		File file = new File(filePath);
		if (file.exists())
			file.delete();
		return appendFile(filePath, content);
	}

	/**
	 * 读取文件内容
	 * 
	 * @param filePath 文件路径
	 * @return 文件内容
	 */
	public static String openFile(String filePath) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line;
			String content = "";
			while ((line = in.readLine()) != null) {
				content += line;
			}
			in.close();
			return content;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 获取当前工作目录
	 * 
	 * @return 获取当前工作目录
	 */
	public static String currentDirectory() {
		return System.getProperty("user.dir");
	}

	/**
	 * 获取文件大小
	 * 
	 * @param path 文件路径
	 * @return 文件大小
	 */
	public static double getFileSize(String path) {
		File file = new File(path);
		// return FileUtils.sizeOfDirectory(file);
		if (file.isFile()) {
			return file.exists() ? file.length() : -1;
		}
		if (file.isDirectory()) {
			File[] lists = file.listFiles();
			int m = 0;
			for (File f : lists) {
				if (f.isFile())
					m += f.length();
				else if (f.isDirectory()) {
					m += getFileSize(f.getAbsolutePath());
				}
			}
			return m;
		}
		return -1;
	}

	/**
	 * 字节转相应单位
	 * 
	 * @param size 大小
	 * @return 转换后的字符串
	 */
	public static String convertByte(double size) {
		String[] Units = new String[] { "B", "K", "M", "G", "T", "P" };
		double mod = 1024.0000;
		int i = 0;
		while (size >= mod) {
			size /= mod;
			i++;
		}
		return new DecimalFormat("#.0000").format(size) + Units[i];
	}

	/**
	 * 获取目录的绝对路径
	 * 
	 * @param path 路径
	 * @return 目录的绝对路径
	 */
	public static String getBasePath(String path) {
		File file = new File(path);
		return file.getAbsolutePath();
	}

	/**
	 * 获取当前工作目录
	 * 
	 * @return 获取当前工作目录
	 */
	public static String getBasePath() {
		return currentDirectory();
	}
}