package Iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：深入 理解迭代器的原理 -->一个容器可创建多个迭代器
 * 方法：使用了内部类（成员内部类、方法内部类、匿名内部类）
 * 深入：
 * 1.使用内部类实现迭代器
 * 2.使用Iterator 实现foreach迭代
 * @author fukur
 *
 */
public class DeepList implements java.lang.Iterable{
	
	private String[] ele = new String[5];
	
	
	private int size = 0;
	
	
	private class MyIterator implements Iterator{ //成员内部类
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
					/*DeepList.this.*/size-(cursor+1));
			//size需要相应-1
			/*DeepList.this.*/size--;
			//回退
			this.cursor--;
		}
	}
	/**
	 * 顺序添加对象进入容器的方法
	 * @param str
	 */
	public void add(String str) {
		if(this.size == ele.length) {
			ele = Arrays.copyOf(ele, ele.length+5);
		}
		ele[size++] = str;
	}
	
	/**
	 * size作为私有变量需要开个方法去获取其状态，而不是直接引用
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 一个list集合能够使用for each需要实现Iterable接口，这里是实现了Iterable的iterator方法
	 */
	public Iterator iterator() { 
		return new MyIterator();
	}
	/**
	 * 这里是使用了方法内部类
	 * @return
	 */
	public Iterator iterator_2() {
		//方法内部类
		class MyIterator implements Iterator{ 
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
			 * @return ele[cursor]
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
						/*DeepList.this.*/size-(cursor+1));
				//size需要相应-1
				/*DeepList.this.*/size--;
				//回退
				this.cursor--;
			}
		}
		return new MyIterator();
	}
	/**
	 * 匿名内部类
	 * 创建Iterator迭代器接口实现类的对象
	 * @return
	 */
	public Iterator iterator_3() {
		return new MyIterator() { //匿名内部类
			                      //创建Iterator迭代器接口实现类的对象
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
							/*DeepList.this.*/size-(cursor+1));
					//size需要相应-1
					/*DeepList.this.*/size--;
					//回退
					this.cursor--;
				}
		}; //记住分号符!!!
	}
	
	public static void main(String[] args) {
		DeepList list = new DeepList();
		list.add("ko-1");
		list.add("Come on");
		list.add("rainbow");
		list.add("八神");
		list.add("tsukishirube");
		
		Iterator it = list.iterator();
		
		System.out.println("成员内部类-------------->");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\"for each\"循环-------------->");//使用for each也需要
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		
		System.out.println("方法内部类-------------->");
		
		it = list.iterator_2();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("匿名内部类-------------->");
		
		it = list.iterator_3();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("size = "+list.getSize());
		
	}

}

