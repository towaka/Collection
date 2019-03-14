package Map;
/**
 * javabean 存储数据 指包含getter和setter的类
 * @author fukur
 *
 */
public class Letter {
	private String name;
	private int count;
	//alt+/
	public Letter() {
	}
	
	public Letter(String name) {
		this.name = name;
	} 
	//alt+shift+s --> o
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
