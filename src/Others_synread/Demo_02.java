package Others_synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读设置，将容器设置为只读不写
 * @author fukur
 *
 * emptyXxxx()  空的不可变的集合
 * 1.emptyList()
 *   emptyMap()
 *   emptySet()
 *   
 * singletonXxx()  一个元素不可变的集合
 * 1.singletonList()
 *   singletonMap()
 *   singletonSet()
 *   
 * unmodifiableXxx()  不可变容器
 * 1.unmodifiableList()
 *   unmodifiableMap()
 *   unmodifiableSet()
 */
public class Demo_02 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("okarin", "okabe");
		map.put("mayushi", "mayuri");
		map.put("daru", "itaru");
		map.put("rukako", "rukagun");
		
		//讲map设置成只读
		Map<String,String> temp = Collections.unmodifiableMap(map);  
		
		//编译报错
		//Exception in thread "main" java.lang.UnsupportedOperationException
//		temp.put("moeka", "shinning finger");
//		System.out.println(temp);
//		
//		System.out.println(temp.size());

		
		//一个元素的容器测试
		List<String> list = Collections.singletonList(new String("kurisu"));
		//编译报错
		//Exception in thread "main" java.lang.UnsupportedOperationException
		//list.add("maho"); 只能包含一个元素的容器，后续添加无用
		System.out.println(list); //[kurisu]
	}
	
	public static Set<String> operator(Set<String> set){
		if(null==set) {
			//外部获取避免提示NullPointerException异常警告
			return Collections.EMPTY_SET;
		}
		return set;
		
	}
}
