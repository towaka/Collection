package List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author fukur
 * List容器示例① ArrayList
 */
public class List_Demo_01 {
	public static void main(String[] args) {
		List list = new ArrayList(); //ArrayList是List的子类，
		ArrayList al = new ArrayList();
		//可以在List当中放很多不同类型的对象
		list.add("Hello");//add方法的方法参数类型是Object
		list.add(new Date());	
		list.add(1234); //包装类的自动装箱特性
		
		System.out.println("list的大小是："+list.size()); //打印结果为3
		
		
		Clerk cl_1 = new Clerk("宋浩", 28, 5000);
		Clerk cl_2 = new Clerk("唐宁", 28, 5000);
		Clerk cl_3 = new Clerk("陈彤", 25, 4000);
		
		//将Clerk类对象加入到al中
		al.add(cl_1);
		al.add(cl_2);
		al.add(cl_3);//List作为容器，里面放的内容是有序可重复的
		
		//显示al大小
		System.out.println("al的大小是："+al.size()); //打印结果为2
		
		//访问al中的数据
		for(int i=0;i<al.size();i++) {
			Clerk temp = (Clerk) al.get(i); //i是指数组的索引
			System.out.println("第"+(i+1)+"个员工的名字是"+temp.getName());//这里成功显示名字
		}
		

		
		//删除al中的对象
		al.remove(2);
		System.out.println("====删除对象之后====");
		
		//访问al中的数据
		for(int i=0;i<al.size();i++) {
			Clerk temp = (Clerk) al.get(i); //i是指数组的索引
			System.out.println("第"+(i+1)+"个员工的名字是"+temp.getName());//这里成功显示名字
		}
		
		//显示al大小
				System.out.println("al的大小是："+al.size());
		
		//显示结果
//		list的大小是：3
//		al的大小是：3
//		第1个员工的名字是宋浩
//		第2个员工的名字是唐宁
//		第3个员工的名字是陈彤
//		====删除对象之后====
//		第1个员工的名字是宋浩
//		第2个员工的名字是唐宁
//      al的大小是：2
	}
}

class Clerk{
	private String name;
	private int age;
	private float salary;
	
	public Clerk(String name,int age,float salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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