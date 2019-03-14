package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Practise.HeroNode.Hero;

public class TestMap2 {
	public static void main(String[] args) {
		List<Hero> hlist = new ArrayList<Hero>();
		long start = 0;
		long end = 0;
		int count = 0;
		System.out.println("初始化开始");
		for (long i = 0L; i < 3000000L; i++) {
			hlist.add(new Hero("Hero-" + (int) (Math.random() * 8999 + 1000)));
		}

		// 名字作为key
		// 名字相同的hero，放在一个List中，作为value
		HashMap<String, List<Hero>> heroMap = new HashMap<String, List<Hero>>();
		for (Hero h : hlist) {
			// 先按照英雄名字在Map里寻找对应的key，然后返回其对应的list
			List<Hero> list = heroMap.get(h.name);
			//key对应的list如果不存在的话就创建一个
			if (list == null) {
				list = new ArrayList<>();
				heroMap.put(h.name, list);//并进行配对
			}
			list.add(h);//将同名的英雄放在一个list中，这个list可以通过对应的英雄名字作为key在Map中寻找
		}

		System.out.println("------for each循环------");
		{

			start = System.currentTimeMillis();
			for (Hero h : hlist) {
				if (h.name.equals("Hero-5555")) {
					count++;
				}
			}
			end = System.currentTimeMillis();
			System.out.println("名字为Hero-5555的对象的总数为" + count + ",总共花的时间是" + (end - start));
		}

		System.out.println("------Map查找------");
		{
			List<Hero> list = null;
			start = System.currentTimeMillis();
			list = heroMap.get("Hero-5555");
			end = System.currentTimeMillis();
			System.out.println("名字为Hero-5555的对象的总数为" + list.size() + ",总共花的时间是" + (end - start));
		}

	}
}
