package Map;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private String num;
	private List<Student> stuList;
	private double total;
	
	public ClassRoom() {
		stuList = new ArrayList<Student>();
	}
	
	public ClassRoom(String num) {
		this();
		this.num = num;
	}

	public ClassRoom(String num, List<Student> stuList, double total) {
		super();
		this.num = num;
		this.stuList = stuList;
		this.total = total;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
