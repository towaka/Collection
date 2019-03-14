package Others_pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * 使用Properties读取配置文件
 * 
 * @author fukur
 * 三个主要方法
 * 1.public synchronized void load(InputStream inStream)
 * 2.public synchronized void load(Reader reader)
 * 3.public synchronized void loadFromXML(InputStream in)
 */
public class Demo_03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//绝对路径读取
		pro.load(new FileReader("E:/testfile/db.properties"));
		System.out.println(pro.getProperty("user","test"));
		
		//相对路径读取(项目之下第一层)
		pro.load(new FileReader("db.properties"));
		System.out.println(pro.getProperty("url","test"));
		
		//相对路径读取(项目之下的包的内部)
		pro.load(new FileReader("src/Others_pro/db.properties"));
		System.out.println(pro.getProperty("pwd","test"));
	}
}
