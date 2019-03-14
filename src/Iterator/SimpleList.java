package Iterator;
/**
 * 目标：简单理解迭代器的原理
 * @author fukur
 *
 */
public class SimpleList {
	
	private String[] ele = {"a","b","c"}; //演示需要，这里是写死的
	
	
	private int size = ele.length;
	
	/**
	 * 计数器-->指针，游标
	 */
	private int cursor = -1; //-1是因为数组起始索引为0
	
	/**
	 * 用于判断是否存在下一个对象
	 * @return true or false
	 */
	public boolean hasNext() {
		return cursor+1<size; //必须小于size，等于size的话可能就会有越界提示
	}
	
	/**
	 * 获取下一个对象
	 * @return
	 */
	public String next() {
		cursor++;
		return ele[cursor];
	}
	
	/**
	 * 删除对象
	 */
	public void remove() {
		//移除的本质其实就是用arraycopy方法覆盖掉想删除的对象
		System.arraycopy(ele, cursor+1, ele, cursor, 
				this.size-(cursor+1));
		//size需要相应-1
		this.size--;
		//回退
		this.cursor--;
	}
	
	/**
	 * size作为私有变量需要开个方法去获取其状态，而不是直接引用
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		SimpleList list = new SimpleList();
		
		//使用迭代器的时候，都是先判断后获取
		while(list.hasNext()) {
			System.out.println(list.next()); //这句实际上不仅是打印next的返回值，而且还执行next方法
		}
		
		System.out.println(list.getSize());
	}
}
