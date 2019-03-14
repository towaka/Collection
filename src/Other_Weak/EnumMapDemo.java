package Other_Weak;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class EnumMapDemo {
	public static void main(String[] args) {
		EnumMap<Season,String> map = new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏无力");
		map.put(Season.AUTUMN, "秋乏");
		map.put(Season.WINTER, "冬眠");
		
		System.out.println("单独遍历打印key--------->");
		Set<Season> keys = map.keySet();
		Iterator<Season> keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			System.out.println(keysIt.next());
		}
		

		System.out.println("单独遍历打印value--------->");
		for(Season data:map.keySet()) {
			System.out.println(map.get(data));
		}
		
		System.out.println("遍历打印key和value--------->");
		for(Entry<Season, String> entry:map.entrySet()) {
			System.out.println("key:"+entry.getKey()+" , "+"value:"+entry.getValue());
		}
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINTER;
}