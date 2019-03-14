package Practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) {
//		Random r = new Random();
//		List<Hero> heros = new ArrayList<Hero>();
//		for (int i = 0; i < 10; i++) {
//			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
//		}
//
//		System.out.println("初始化集合后的数据 (最后一个数据重复)：");
//		System.out.println(heros);
//
//		// 传统方式
//		Collections.sort(heros, new Comparator<Hero>() {
//			@Override
//			public int compare(Hero o1, Hero o2) {
//				return (int) (o2.hp - o1.hp);
//			}
//		});
//
//		Hero hero = heros.get(2);
//		System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.name);
//		
//		heros
//		.stream()
//		.filter(h -> h.hp > 100 && h.damage < 50)
//		.forEach(h -> System.out.println(h.name));
//
//		// 聚合方式
//		String name = heros.stream().sorted((h1, h2) -> h1.hp > h2.hp ? -1 : 1).skip(2).map(h -> h.getName())
//				.findFirst().get();
//
//		Float hp = heros.stream().sorted((h1, h2) -> h1.hp > h2.hp ? -1 : 1).skip(2).map(h -> h.getHp()).findFirst()
//				.get();
//
//		System.out.println("通过聚合操作找出来的hp第三高的英雄HP是:" + hp);

		List<Hero> heroes = new ArrayList<Hero>();

		// 放5个Hero进入容器
		for (int i = 0; i < 5; i++) {
			heroes.add(new Hero("hero name " + i));
		}

		// 第三种，增强型for循环
		System.out.println("--------增强型for循环-------");
		for (Hero h : heroes) {
			System.out.println(h);
		}
		System.out.println(heroes);

		System.out.println();
		System.out.println();
		System.out.println();

		Set<Integer> numbers = new HashSet<>();
		while (numbers.size() < 50) {
			int i = (int) (Math.random() * 10000);
			numbers.add(i);
		}
		System.out.println("得到50个不重复随机数：");

		int Numcount = 0;

		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			Integer number = (Integer) iterator.next();
			if (!(((Numcount + 1) % 10) == 0)) {
				if (Numcount == 0) {
					System.out.print("[" + number + ",");
					Numcount++;
				} else {
					System.out.print(number + ",");
					Numcount++;
				}
			} else {
				System.out.print(number + "]");
				Numcount = 0;
				System.out.print("\n");
			}

		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> temp = new HashMap<>();
		map.put("adc", "物理英雄");
		map.put("apc", "魔法英雄");
		map.put("t", "坦克");

		System.out.println("初始化后的Map:");
		System.out.println(map);
		Set<String> keys = map.keySet();

		for (String key : keys) {
			String value = map.get(key);
			temp.put(value, key);
		}
		map.clear();
		map.putAll(temp);

		System.out.println("反转后的Map:");
		System.out.println(map);
		
		int a = 2;
		int b = 3;
		a+=b;
		
		System.out.println(a);

	}

}
