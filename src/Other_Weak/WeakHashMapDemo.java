package Other_Weak;


import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * WeakHashMap key为弱类型 gc运行会被即时回收
 * @author fukur
 *
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
		//如果希望程序在运行过程中，自动清理那些占用内存且情况允许被清理掉的变量时，
		//就可以使用WeakHashMap
		WeakHashMap<String,String> map = new WeakHashMap<String,String>();
		//测试数据 前三个是常量池对象，不会被回收
		map.put("okabe", "mad scientist");
		map.put("mayuri", "mayushi");
		map.put("daru", "super hacker");
		//最后一个是堆里的对象
		map.put(new String("rukako"), "kensei");
		
		System.gc();
		System.runFinalization();
		
		System.out.println("大小 = "+map.size()+"\n");
		
		System.out.println("单独遍历打印key--------->");
		Set<String> keys = map.keySet();
		Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			System.out.println(keysIt.next());
		}
		

		System.out.println("单独遍历打印value--------->");
		for(String data:map.keySet()) {
			System.out.println(map.get(data));
		}
		
		System.out.println("遍历打印key和value--------->");
		for(Entry<String, String> entry:map.entrySet()) {
			System.out.println("key:"+entry.getKey()+","+"value:"+entry.getValue());
		}
	}
}
