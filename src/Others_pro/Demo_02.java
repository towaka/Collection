package Others_pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 使用Properties类讲内容输出到具体文件-->资源配置文件
 * 文件内容跟文件后缀没有关系，只用于区分读取的软件
 * 好处：结合java环境下的反射功能，可以自由动态切换不同的数据库，不需要大幅更改代码
 * @author fukur
 * 按后缀区分
 *   .properties
 * 1.store(OutputStream out, String comments) 
 *   store(Writer writer, String comments) 
 *   .xml
 * 2.storeToXML(OutputStream os, String comment) ---UTF-8字符集
 *   storeToXML(OutputStream os, String comment, String encoding) 
 */
public class Demo_02 { //这里抛出一个以上的异常
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties pro = new Properties();
		// 存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//存储到e:/testfile 这里是绝对路径
//		pro.store(new FileOutputStream(new File("e:/testfile/db.properties")), "db配置");//编译成功
//		pro.storeToXML(new FileOutputStream(new File("e:/testfile/db.xml")), "db配置");//编译成功
		
		//尝试使用相对路径（配置文件存储在项目文件目录之下）
		pro.store(new FileOutputStream(new File("db.properties")), "db配置");//编译成功
		pro.storeToXML(new FileOutputStream(new File("db.xml")), "db配置");//编译成功
		
		//尝试使用相对路径（配置文件存储在项目文件src目录之下）
		pro.store(new FileOutputStream(new File("src/db.properties")), "db配置");// 编译成功
		pro.storeToXML(new FileOutputStream(new File("src/db.xml")), "db配置");// 编译成功
		
		//尝试使用相对路径（配置文件存储在项目文件src/package name目录之下）
		pro.store(new FileOutputStream(new File("src/Others_pro/db.properties")), "db配置");// 编译成功
		pro.storeToXML(new FileOutputStream(new File("src/Others_pro/db.xml")), "db配置");// 编译成功
		
	}
}
