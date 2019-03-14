package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import Practise.HeroNode.Hero;

public class TestSet {
	public static void main(String[] args) {
		  
		HashSet<Integer> numbers = new HashSet<Integer>();
		 
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);
 
        // Set中的元素排列，不是按照插入顺序
        System.out.println(numbers);
 
        
      //遍历Set可以采用迭代器iterator
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }	
	}
}
