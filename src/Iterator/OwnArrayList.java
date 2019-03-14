package Iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：使用泛型，可以操作多个类型
 * 方法：加入泛型
 * 深入：
 * 1.使用内部类实现迭代器
 * 2.使用Iterator 实现foreach迭代
 * @author fukur
 *
 */
public class OwnArrayList<E> implements java.lang.Iterable<E>{
	
	private Object[] ele = new Object[5]; //泛型和数组是不可直接结合使用的，在这个泛型类中，这里只能改成Object类型的数组
	
	
	private int size = 0;
	

	/**
	 * 顺序添加对象进入容器的方法
	 * @param str
	 */
	public void add(E element) {
		if(this.size==ele.length) {
			ele = Arrays.copyOf(ele, ele.length+5);
		}
		ele[size++] = element;
	}
	
	/**
	 * size作为私有变量需要开个方法去获取其状态，而不是直接引用
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	public Iterator<E> iterator() {
		//方法内部类
		class MyIterator implements Iterator<E>{ 
			/**
			 * 计数器-->指针，游标
			 */
			private int cursor = -1; 
			
			
			/**
			 * 用于判断是否存在下一个对象
			 * @return true or false
			 */
			public boolean hasNext() {
				return cursor+1<size; 
			}
			/**
			 * 获取下一个对象
			 * @return
			 */
			public E next() {
				cursor++;
				return (E) ele[cursor];
			}
			/**
			 * 删除对象
			 */
			public void remove() {
				//移除的本质其实就是用arraycopy方法覆盖掉想删除的对象
				System.arraycopy(ele, cursor+1, ele, cursor, 
						/*DeepList.this.*/size-(cursor+1));
				//size需要相应-1
				/*DeepList.this.*/size--;
				//回退
				this.cursor--;
			}
		}
		return new MyIterator();
	}
	
	public Iterator iterator_3() {
		return null;
	}
	
	public static void main(String[] args) {
		OwnArrayList<Integer> list_1 =  new OwnArrayList<Integer>();
		list_1.add(1);	
		list_1.add(2);
		
		for(Integer i:list_1) {
			System.out.println(i);
		}
		
		System.out.println("----------------------->");
		
		OwnArrayList<String> list_2 =  new OwnArrayList<String>();
		list_2.add("马云");
		list_2.add("block");
		
		System.out.println("for each循环");
		for(String i:list_2) {
			System.out.println(i);
		}
		
		System.out.println();
		System.out.println();
		
	    System.out.println("迭代器遍历");
		Iterator<String> it = list_2.iterator();
		while(it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}
	}

}

