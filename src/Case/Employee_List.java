package Case;

import java.text.*;
import java.util.*;
/**
 * 
 * @author fukur
 * 容器案例练习（Employee类）
 *
 */
public class Employee_List {
	
	public static void main(String[] args)  {
		//一个对象对应一个信息数据
		Employee e001 = new Employee(110, "jack", 3000, "项目部", "2007-10");
		Employee e002 = new Employee(111, "mary", 3500, "财务部", "2006-10");
		Employee e003 = new Employee(112, "pray", 3500, "讲授部", "2008-10");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e001);
		list.add(e002);
		list.add(e003);
		printEmp(list);
	}
	
	public static void printEmp(List<Employee> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getDepartment());
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getSalary());
			System.out.println(list.get(i).getHireDay());
			System.out.println();
		}
	}
}
