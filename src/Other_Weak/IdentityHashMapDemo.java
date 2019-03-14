package Other_Weak;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * IdentityHashMap key比较地址去重
 * @author fukur
 *
 */
public class IdentityHashMapDemo {
	public static void main(String[] args) {
		IdentityHashMap<String,String> map = new IdentityHashMap<String,String>();
		
		//IdentityHashMap此时就是对key进行地址比较并去重
		map.put("okabe", "mad scientist");
		map.put("okabe", "okarin");
		System.out.println(map.size());//1
		map.put(new String("okabe"), "Rintaro");
		map.put(new String("okabe"), "Lintalo");
		System.out.println(map.size());//3
		
		
		Set<String> keys = map.keySet();
		Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			System.out.println(keysIt.next());
		}
		
		System.out.println("遍历打印key和value--------->");
		for(Entry<String, String> entry:map.entrySet()) {
			System.out.println("key:"+entry.getKey()+","+"value:"+entry.getValue());
		}
	}
}
