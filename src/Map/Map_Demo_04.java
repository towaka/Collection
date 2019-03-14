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
 * 4.加入面向对象
 */
public class Map_Demo_04 {
	public static void main(String[] args) {
		//1.分割字符串 ,split是String类下的方法
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2.分拣存储 String对应单词，Integer对应的是出现的次数
		Map<String,Letter> map = new HashMap<String,Letter>();
		for(String key:arr) {
			/*
			//第一次查看是否存在对应的键
			if(!map.containsKey(key)) { //如果不存在对应的单词
				map.put(key, new Letter(key));
			}
			//获取值
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);
			*/
			
			Letter value = map.get(key);
			//第一次查看是否存在对应的键
			if(null==value) { //如果不存在对应的值
				value = new Letter(); //新建Letter类对象
				map.put(key, value); //键值对放置
			}
			value.setCount(value.getCount()+1); //如果值不为空，值+1
			
			//以上两段代码都能实现
		}
		
		//3.查看每个单词出现的个数 遍历
		for(String key:map.keySet()) { //keySet()方法是Set类型的方法，保存某个map里面的键
			Letter value = map.get(key); //按对应的键取对应的值，值为Letter类型对象
			System.out.println(key+"-->"+value.getCount()); //使用Letter类对象的getter方法
		}
		
	}
}
