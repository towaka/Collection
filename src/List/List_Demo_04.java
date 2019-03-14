package List;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author fukur
 * 实现自己的容器类
 */
public class List_Demo_04 {
	private Object[] elementData;
	
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public List_Demo_04() {
		this(10);
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	private void EnsureCapacity() { //数组扩容和拷贝
		if(size==elementData.length) {
			Object[] newArray = new Object[size+5];	
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
	}
	
	public void RangeCheck(int index) {
		if(index<0 || index>=getSize()) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(Object obj) { //添加对象进入容器的方法
		EnsureCapacity();
		elementData[size++] = obj;//先赋值，后自增
	}
	
	public void add(int index,Object obj) { //添加对象进入容器指定位置的方法
		RangeCheck(index); //检查索引是否在范围之内
		EnsureCapacity(); //确保空间足够添加后来的对象
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index] = obj;
		size++;
	}
	
	public Object get(int index) { //根据下标获得容器内的对象
		RangeCheck(index);
		return elementData[index];
	}
	
	public Object set(int index,Object obj) {
		RangeCheck(index);
		
		Object oldValue = (Object) elementData[index];
		elementData[index] = obj;
		return oldValue; 
	}
	
	public void remove(int index) {
		RangeCheck(index);
		//删除指定位置的对象
		int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work ，先赋值后减量
	}
	
	public void remove(Object obj) {
		for(int i=0;i<getSize();i++) {
			if(get(i).equals(obj))
				remove(i);//通过索引删除对象
			break;
		}
		
	}
	
	
	
	public List_Demo_04(int initialCapacity)  {
		if(initialCapacity<0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}
	
	
	//主函数
	public static void main(String[] args) {
		List_Demo_04 arl = new List_Demo_04(3);
		arl.add("333");
		arl.add("God of War");
		arl.add(45);
		arl.add(45);
		arl.add(45);
		arl.add(1, "to be or not to be");
		System.out.println(arl.getSize());
		
		for(int i=0;i<arl.size;i++) {
			System.out.println(arl.get(i));
		}
	}


	
	
}
