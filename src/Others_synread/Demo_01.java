package Others_synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections管理和同步容器类
 * synchronizedList()
 * synchronizedMap()
 * synchronizedSet()
 * @author fukur
 * 
 */
public class Demo_01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//list可以同步
		//这样以来这个list就线程安全了
		List<String> synList = Collections.synchronizedList(list);
	}
	
}
