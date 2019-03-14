package Practise;
import java.util.*;
/*
 * 自定义实现Map的功能（非完美）
 * 存放键值对，根据键对象找到对应的值对象，执行相关操作。键（key）不能重复
 */
public class ownMap {
	ownEntry[] arr = new ownEntry[50]; //Map还是由对象数组实现
	int size;
	
	public void put(Object key,Object value) {
		ownEntry e = new ownEntry(key,value);
		
		for(int i=0;i<size;i++) { //键值对重复的处理
			if(arr[i].getKey().equals(key)) {
				arr[i].value = value;
				return ;
			}
		}
		
		arr[size++] = e;
	}
	
	public Object get(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].getKey().equals(key)) {
				return arr[i].getValue();
			}
		}
		return null;
	}
	
	public void remove(Object key) {
		for(int i=0;i<getSize();i++) {
			if(arr[i].getKey().equals(key)) { //调用数组中每个对象的equals方法
				remove(i);
			}
			break; //必须要break，不然循环将继续下去，把所有和形参内容相同的对象都删除掉
		}
	}
	
	public void remove(int index) { //形参的值是“索引值”
		//删除指定位置的对象
		RangeCheck(index);
		int numMoved = size-index-1; //需要移动的成员的数量
		if(numMoved>0) {
			System.arraycopy(arr, index+1, arr, index, 
					         numMoved);
		}
		--size;//数组size减一
		arr[size] = null; //成员往前移动后，数组最后一个位置置空

	}
	
	public void RangeCheck(int index) { //索引检查
		if(index<0 || index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean containsKey(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object Value) {
		for(int i=0;i<size;i++) {
			if(arr[i].getValue().equals(Value)) {
				return true;
			}
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		ownMap om = new ownMap();
		om.put("jyuni", new Labmen("okabe")); //new一个新的对象
		om.put("daru", new Labmen("hashida"));//new一个新的对象
		Labmen lb = (Labmen) om.get("daru");
		System.out.println(lb.name);
		System.out.println("size="+om.getSize());
		
		
	}
}


class ownEntry{
	Object key;
	Object value;
	
	public ownEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}



class Labmen{
	
	String name;

	public Labmen(String name) {
		super();
		this.name = name;
	}
}