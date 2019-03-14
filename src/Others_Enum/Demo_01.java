package Others_Enum;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector较为古老
 *(1)Enumeration的使用
 * @author fukur
 * 1.判断 hasMoreElements()方法
 * 2.获取 nextElement()方法
 *
 *(2)Vector的elements()方法
 *
 */
public class Demo_01 {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("C");
		vector.add("JAVA");
		vector.add("PYTHON");
		vector.add("PERL");
		
		//遍历Vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}
}
