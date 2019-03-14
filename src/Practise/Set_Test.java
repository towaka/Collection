package Practise;

import java.util.HashSet;
import java.util.Set;

/*
 * 测试Set的常用方法
 */
public class Set_Test {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa")); //后者把前者覆盖了
		
		System.out.println(set.size());
		System.out.println(set.contains("aaa"));
	}
	
	
}