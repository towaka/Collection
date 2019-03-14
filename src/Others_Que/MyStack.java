package Others_Que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现自定义堆栈
 * 1.弹栈
 * 2.压栈
 * 3.获取头一个元素
 * @author fukur
 *
 * @param <E>
 */
public class MyStack<E> {
	private Deque<E> container = new ArrayDeque<E>();
	
	private int capacity;

	public MyStack(int capacity) {
		super();
		this.capacity = capacity;
	}

	
	//压栈
	public boolean push(E e) {
		if(container.size()+1>capacity) {
			return false;
		}
		return container.add(e);
	}
	
	//弹栈
	public E pop() {
		return container.pollLast(); //从最后一个进栈的开始获取
	}
	
	//获取
	public E peek() {
		return container.peekLast();
	}
	
	public int size() {
		return this.container.size();
	}
	
	
}
