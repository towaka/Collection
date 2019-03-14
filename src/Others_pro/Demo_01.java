package Others_pro;

import java.util.Properties;

/**
 * Properties 资源配置文件的读写
 * 内部的key和value都只能是字符串
 * 存储和读取：
 * public synchronized Object setProperty(String key, String value)
 * public String getProperty(String key)
 * public String getProperty(String key, String defaultValue)	
 * 
 * 
 * Java Properties类
 * Java中有个比较重要的类Properties（Java.util.Properties），
 * 主要用于读取Java的配置文件，各种语言都有自己所支持的配置文件，配置文件中很多变量是经常改变的，
 * 这样做也是为了方便用户，让用户能够脱离程序本身去修改相关的变量设置。
 * 像Python支持的配置文件是.ini文件，同样，它也有自己读取配置文件的类ConfigParse，
 * 方便程序员或用户通过该类的方法来修改.ini配置文件。
 * 在Java中，其配置文件常为.properties文件，格式为文本文件，
 * 文件的内容的格式是“键=值”的格式，文本注释信息可以用"#"来注释。
 * @author fukur
 * 
 * 继承关系：
 * 
 * java.lang.Object 
 *   ┗ java.util.Dictionary<K,V> 
 *        ┗ java.util.Hashtable<Object,Object> 
 *            ┗ java.util.Properties 
 *
 */
public class Demo_01 {
	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		String url = pro.getProperty("url","test");//key有对应的value就打印出来，没有就打印test
		System.out.println(url);
	}
}
