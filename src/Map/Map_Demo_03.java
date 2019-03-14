package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用分拣存储的概念 1对N
 * 统计单词出现的次数
 * this is a cat and that is a mice and where is the food
 * @author fukur
 *
 * 思路
 * 1.分割字符串
 * 2.分拣存储
 * 3.按要求查看单词出现的次数
 */
public class Map_Demo_03 {
	
	public static void main(String[] args) {
		//1.以指定的符号分割字符串 ,split是String类下的方法
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2.分拣存储 String对应单词，Integer对应的是出现的次数
		Map<String,Integer> map = new HashMap<String,Integer>();//新建一个容器
		for(String key:arr) {
//			if(!map.containsKey(key)) { //如果尚不存在该单词
//				map.put(key, 1);
//			}else { //已经存在的话
//				map.put(key, map.get(key)+1);
//			}
			
			Integer value = map.get(key);
			if(null==value) {
				map.put(key, 1);
			}else {
				map.put(key, value+1);
			}
			//以上两段代码都能实现
		}
		
		//3.查看每个单词出现的个数
		Set<String> keySet = map.keySet(); //需要使用Set类对象来存储map容器里的key值
		//获取对象
		Iterator<String> it = keySet.iterator(); //迭代器带泛型语法，Set里头也有Iterator方法
		while(it.hasNext()) { //先判断，后获取
			String key = it.next(); //it.next()指的就是每个具体的键
			Integer value = map.get(key); //按键取值
			System.out.println(key+"-->"+value);
		}
	}
}
