package Case;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee { //javabean(指内部逻辑很简单的类)
	private int id;
	private String name;
	private float salary;
	private String department;
	private Date hireDay;
	
	public Employee(int id, String name, float salary, String department, String hireDay) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		
		DateFormat format = new SimpleDateFormat("yyyy-mm"); //制定日期格式
		
		try {
			this.hireDay = format.parse(hireDay); //这个构造器中hireDay参数是String类型的
			//format.parse方法能把hireDay转成String类型进行赋值
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	
	
}
