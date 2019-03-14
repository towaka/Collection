package Map;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author fukur
 * HashMap演示
 */

public class Map_Demo_01 {
	
	public static void main(String[] args) {
		//创建一个HashMap对象
		HashMap hm = new HashMap();
		
		Emp emp_01 = new Emp("011",28,5600);
		Emp emp_02 = new Emp("056",29,6000);
		Emp emp_03 = new Emp("048",29,5000);
		
		//将员工放进HashMap
		hm.put("011", emp_01);
		hm.put("056", emp_02);
		//hm.put("056", emp_03);//这一句会把上一句录入的对象覆盖掉，记住key值是唯一的！！
		hm.put("048", emp_03);
		
		//尝试查找
		if(hm.containsKey("056")) {
			System.out.println("有该名员工");
			//如果有的话，那该如何取出呢（一个键<-->一个值）
			Emp temp = (Emp)hm.get("056");
			System.out.println("工资："+temp.getSalary());		
		}
		else {
			System.out.println("没有该名员工");
		}
		
		//尝试便利HashMap中所有的key和value
//		for(int i=0;i<hm.size();i++) {
//			用for循环是错的
//		}
		
		System.out.println("----------美丽分割线---------"+"\n");
		
		Iterator it = hm.keySet().iterator();
		//hasNext()返回一个boolean值
		while(it.hasNext()) {
			//取出key值
			String key = it.next().toString();
			//通过key取出value
			Emp temp = (Emp)hm.get(key);
			System.out.println("编号："+temp.getEmpNo());
			System.out.println("年龄："+temp.getAge()+"\n");
		}
		
		//显示结果
//		有该名员工
//		工资：6000.0
//		----------美丽分割线---------
//
//		编号：011
//		年龄：28
//
//		编号：056
//		年龄：29
//
//		编号：048
//		年龄：29

	}
	
	public void findEmp(String empNo) {
		
	}
	
}

class Emp{
	private String empNo;
	private int age;
	private float salary;
	
	public Emp(String empNo,int age,float salary){
		this.empNo=empNo;
		this.age=age;
		this.salary=salary;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}