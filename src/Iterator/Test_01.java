package Iterator;

import java.util.*;
/**
 * 
 * @author fukur
 * 测试容器类中的迭代器方法（iterator）
 */
public class Test_01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//通过索引遍历list
		System.out.println("通过索引遍历list");
		for (int i = 0; i < list.size(); i++) { 
			System.out.println(list.get(i));
		}
		
		//通过迭代器遍历list
		System.out.println("通过迭代器遍历list");
		//这里for循环中的两句就是赋值和判断，递增在it_1.next()中
		for(Iterator it_1 = list.iterator();it_1.hasNext();) { 
			String str = (String)it_1.next();
			System.out.println(str);
		}
		
		System.out.println("-------------------------");
		
		Set set = new HashSet();
		
		set.add("Gram");
		set.add("brooklin");	
		//下面两种遍历写法，内里的实现都是一样的
		System.out.println("while写法遍历Set");
		
		Iterator it_1 = set.iterator(); //使用while遍历Set类容器遍历,这里是常见的while写法
		while(it_1.hasNext()) {
			String str = (String)it_1.next(); //需要强转型
			System.out.println(str);
		}
		
		System.out.println();
		
		System.out.println("for写法遍历Set");
		
		for(Iterator it_2 = set.iterator();it_2.hasNext();) { //这里是for的写法(局部变量初始化和判断)
			String str = (String)it_2.next();
			System.out.println(str);
		}
	}
}
