package Map;

import java.util.*;
import java.util.Iterator;

/**
 * @author fukur
 * HashMap演示
 */

public class Map_Demo_02 {
	
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		HashMap hm = new HashMap();
		//放入对象
		ht.put(null, null);
		hm.put(null, null);
		//看起来编译器没报语法错误，然而测试后
		System.out.println("测试Hashtable->"+ht.get(null));
		System.out.println("测试HashMap->"+hm.get(null));
		
		//显示结果1.Hashtable出错了，Hashtable不能放空值
//		Exception in thread "main" java.lang.NullPointerException
//		at java.util.Hashtable.put(Unknown Source)
//		at Map.Map_Demo_02.main(Map_Demo_02.java:16)
		
		//显示结果2.
//		测试HashMap->null
	}
	
}

