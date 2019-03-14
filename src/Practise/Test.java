package Practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
//		//初始化集合numbers
//        List<Integer> numbers = new ArrayList<>();
//         
//        for (int i = 0; i < 10; i++) {
//            numbers.add(i);
//        }
//         
//        System.out.println("集合中的数据:");
//        System.out.println(numbers);
//         
//        Collections.reverse(numbers);
//         
//        System.out.println("翻转后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.shuffle(numbers);
//        
//        System.out.println("混淆后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.sort(numbers);
//        
//        System.out.println("排序后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.rotate(numbers,2);
//        
//        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
//        System.out.println(numbers);
//        
//        HashSet<Integer> numberSet1 =new HashSet<Integer>();
//        //HashSet中的数据不是按照插入顺序存放
//        numberSet1.add(88);
//        numberSet1.add(8);
//        numberSet1.add(888);
//          
//        System.out.println(numberSet1);
//        //LinkedHashSet的特性 ：既不重复，又有顺序
//        LinkedHashSet<Integer> numberSet2 =new LinkedHashSet<Integer>();
//        //LinkedHashSet中的数据是按照插入顺序存放
//        numberSet2.add(88);
//        numberSet2.add(8);
//        numberSet2.add(888);
//          
//        System.out.println(numberSet2);
//        TreeSet<Integer> numberSet3 =new TreeSet<Integer>();
//        //TreeSet 中的数据是进行了排序的
//        numberSet3.add(88);
//        numberSet3.add(8);
//        numberSet3.add(888);
//          
//        System.out.println(numberSet3);

//		 HashMap<String,String> map = new HashMap<>();
//	        HashMap<String,String> temp = new HashMap<>();
//	        map.put("adc", "物理英雄");
//	        map.put("apc", "魔法英雄");
//	        map.put("t", "坦克");
//	         
//	        System.out.println("初始化后的Map:");
//	        System.out.println(map);
//	        Set<String> keys = map.keySet();
//	         
//	        for (String key : keys) {
//	            String value = map.get(key);
//	            temp.put(value, key);
//	        }
//	        map.clear();
//	        map.putAll(temp);
//	         
//	        System.out.println("反转后的Map:");
//	        System.out.println(map.toString());

//		Comparator<Integer> c = new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			}
//		};
//
//		Set<Integer> treeSet = new TreeSet<>(c);
//		for (int i = 0; i < 10; i++) {
//			treeSet.add(i);
//		}
//		System.out.println(treeSet);

//		Random r =new Random();
//        List<Hero> heros = new ArrayList<Hero>();
//            
//        for (int i = 0; i < 10; i++) {
//            //通过随机值实例化hero的hp和damage
//            heros.add(new Hero("hero "+ i, r.nextInt(100), r.nextInt(100)));
//        }
//        System.out.println("初始化后的集合：");
//        System.out.println(heros);
//            
//        //直接调用sort会出现编译错误，因为Hero有各种属性
//        //到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
//        //Collections.sort(heros);
//            
//        //引入Comparator，指定比较的算法
//        Comparator<Hero> c = new Comparator<Hero>() {
//            @Override
//            public int compare(Hero h1, Hero h2) {
//                //按照hp进行排序
//                if(h1.hp>=h2.hp)
//                    return 1;  //正数表示h1比h2要大
//                else
//                    return -1;
//            }
//        };
//        Collections.sort(heros,c);
//        System.out.println("按照血量排序后的集合：");
//        System.out.println(heros);

		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}

		System.out.println("初始化集合后的数据 (最后一个数据重复)：");
		System.out.println(heros);

		// 传统方式
		Collections.sort(heros, new Comparator<Hero>() {
			@Override
			public int compare(Hero o1, Hero o2) {
				return (int) (o2.hp - o1.hp);
			}
		});

		Hero hero = heros.get(2);
		System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.name);
		
		heros
		.stream()
		.filter(h -> h.hp > 100 && h.damage < 50)
		.forEach(h -> System.out.println(h.name));

		// 聚合方式
		String name = heros.stream().sorted((h1, h2) -> h1.hp > h2.hp ? -1 : 1).skip(2).map(h -> h.getName())
				.findFirst().get();

		Float hp = heros.stream().sorted((h1, h2) -> h1.hp > h2.hp ? -1 : 1).skip(2).map(h -> h.getHp()).findFirst()
				.get();

		System.out.println("通过聚合操作找出来的hp第三高的英雄HP是:" + hp);

	}
}
