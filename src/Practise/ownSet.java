package Practise;

import java.util.HashMap;

/*
 * 自定义自己的Hashset
 * 
 */
public class ownSet {
	HashMap map;
	private int size;
	
	private static final Object PRESENT = new Object();
	
	public int size() {
		return map.size();
	}
	
	public ownSet() {
		map = new HashMap(); //set的不可重复的特点就是利用了map的键对象的不可重复
	}
	
	public void add(Object obj) {
		map.put(obj, PRESENT);
	}
	
	public void remove(Object obj) {
		
	}
	
	public static void main(String[] args) {
		ownSet s = new ownSet();
		s.add("aaa");
		s.add(new String("aaa"));
		s.add("kevin");
		
		System.out.println(s.size());
	}
}
