package Others_Enum;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * StringTokenizer实现了Enumeration接口
 * 作用和String类下的split()方法类似，但是不支持正则表达式
 * split()方法的应用可查看     package Map-->Map_Demo_04
 * 
 * StringTokenizer(String str,String delim) 
 * str 目标字符串
 * delim 用于区分的分隔符
 */
public class Demo_02 {
	public static void main(String[] args) {
		String emailStr = "okabe@sina.com;okabe@sohu.com;okabe@163.com";
		StringTokenizer token = new StringTokenizer(emailStr, ";");
		while(token.hasMoreTokens()) {
			System.out.println(token.nextElement());
		}
	}
}
