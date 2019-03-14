package List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * 
 * @author fukur
 * List容器示例② ArrayList
 */
public class List_Demo_02 {
	public static void main(String[] args) throws Exception{
		EmpManage em = new EmpManage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("请选择你要进行的操作：");
			System.out.println("1.表示添加一名雇员");
			System.out.println("2.查找一个雇员");
			System.out.println("3.修改一个雇员的工资");
			System.out.println("4.删除一个雇员");
			System.out.println("5.退出系统");
			
			String funcType = br.readLine();

	
			if(funcType.equals("1")) {
				System.out.println("\n请输入编号");
				String empNo = br.readLine();
				System.out.println("请输入年龄");
				int empAge = Integer.parseInt(br.readLine());
				System.out.println("请输入工资");
				float empSalary = Float.parseFloat(br.readLine());
				
				//运用三个输入的数据初始化一个Emp类对象
				Emp emp = new Emp(empNo, empAge, empSalary);
				//添加进去管理类EmpManage中
				em.addEmp(emp);
			}
			else if(funcType.equals("2")) {
				System.out.println("\n请输入编号");
				String empNo = br.readLine();
				em.showInfo(empNo);
			}
			else if(funcType.equals("3")) {
				System.out.println("\n请输入员工编号");
				String empNo = br.readLine();
				System.out.println("\n请输入期望的工资数");
				float newSalary = Float.parseFloat(br.readLine());
				em.updateSalary(empNo, newSalary);
				System.out.println("以下显示修改后的员工信息");
				em.showInfo(empNo);
			}
			else if(funcType.equals("4")) {
				System.out.println("\n请输入员工编号");
				String empNo = br.readLine();
				em.delEmpNo(empNo);
			}
			else if(funcType.equals("5")) {
				System.exit(0);//非零值代表非正常退出5
			}
			
		}
	}
}

class EmpManage{
	private ArrayList al = null;
	
	public EmpManage() {
		al = new ArrayList();
	}
	//加入员工信息
	public void addEmp(Emp emp) {
		al.add(emp);
	}
	//删除某个员工的信息
	public void delEmpNo(String empNo) {
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			//比较编号
			if(emp.getEmpNo().equals(empNo)) {
				al.remove(i);
			}
		}
	}
	//显示员工的相关信息
	public void showInfo(String empNo) {
		//遍历整个al
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			//比较编号
			if(emp.getEmpNo().equals(empNo)) {
				System.out.println("找到员工，他的信息：");
				System.out.println("编号："+emp.getEmpNo());
				System.out.println("年龄："+emp.getAge());
				System.out.println("工资："+emp.getSalary());
			}
		}
	}
	//修改工资
	public void updateSalary(String empNo,float newsalary) {
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			//比较编号
			if(emp.getEmpNo().equals(empNo)) {
				emp.setSalary(newsalary); //修改薪水
			}
		}
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