package Others_pro;

import java.io.IOException;
import java.util.Properties;

/**
 * 使用类路径读取配置文件
 * bin文件夹
 * @author fukur
 *
 */
public class Demo_04 {
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		//类相对路径读取 ,"/"号代表bin目录
		//"/"让程序从类文件的位置往上追溯找到bin目录
		pro.load(Demo_04.class.getResourceAsStream("/Others_pro/db.properties"));
		System.out.println(pro.getProperty("user","test"));
		
		//类加载器读取，""（空）也是代表bin目录
		//而下面这句里，开头没有"/"号
		pro.load(Thread.currentThread().
				getContextClassLoader().getResourceAsStream("Others_pro/db.properties"));//开头没有"/"号
		System.out.println(pro.getProperty("pwd","test"));
	}
}
