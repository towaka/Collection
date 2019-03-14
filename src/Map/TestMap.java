package Map;

import java.util.HashMap;

import Practise.HeroNode.Hero;

public class TestMap {
	public static void main(String[] args) {
		HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
	    
	    heroMap.put("gareen", new Hero("gareen1"));
	    System.out.println(heroMap);
	     
	    //key为gareen已经有value了，再以gareen作为key放入数据，会导致原英雄，被覆盖
	    //不会增加新的元素到Map中
	    heroMap.put("gareen", new Hero("gareen2"));
	    System.out.println(heroMap);
	     
	    //清空map
	    heroMap.clear();
	    Hero gareen = new Hero("gareen");
	     
	    //同一个对象可以作为值插入到map中，只要对应的key不一样
	    heroMap.put("hero1", gareen);
	    heroMap.put("hero2", gareen);
	     
	    System.out.println(heroMap);
	}
}
