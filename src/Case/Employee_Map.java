package Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author fukur
 * 容器案例练习（Employee类）
 *
 */
public class Employee_Map {
	public static void main(String[] args) {
		//一个Map对象代表一个信息数据
		Map map_01 = new HashMap();
		map_01.put("id", "0301");
		map_01.put("name", "高淇");
		map_01.put("salary", "3000");
		map_01.put("department", "项目部");
		map_01.put("hireDay", "2007-10");
		
		Map map_02 = new HashMap();
		map_02.put("id", "0302");
		map_02.put("name", "jack");
		map_02.put("salary", "3500");
		map_02.put("department", "财务部");
		map_02.put("hireDay", "2007-6");
		
		Map map_03 = new HashMap();
		map_03.put("id", "0303");
		map_03.put("name", "mary");
		map_03.put("salary", "5000");
		map_03.put("department", "事业部");
		map_03.put("hireDay", "2008-10");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map_01);
		list.add(map_02);
		list.add(map_03);
		printEmpName(list);
	}
	
	public static void printEmpName(List<Map> list) {
		for (int i = 0; i < list.size(); i++) {
			Map tempMap = list.get(i);
			System.out.println(tempMap.get("name"));
		}
	}
}
