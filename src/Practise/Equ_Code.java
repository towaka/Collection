package Practise;
import java.util.Date;

public class Equ_Code {
	private int id;
	private String name;
	private Date birthday;
	@Override
	
	public int hashCode() {
		final int prime = 31; //31是素数
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //如果是同一个对象
			return true;
		if (obj == null) //如果输入的对象为空
			return false;
		if (getClass() != obj.getClass()) //如果两个对象的类型不一样
			return false;
		Equ_Code other = (Equ_Code) obj;//将输入的对象赋给一个本类临时变量
		if (id != other.id) //如果两者需要被比较的内容物不一样
			return false;
		
		if (name == null) { //如果目标内容物为空
			if (other.name != null) //而此时输入对象的内容物不为空的话
				return false;
		} else if (!name.equals(other.name)) //如果两者不相等
			return false;
		return true;
	}
	
	
}
