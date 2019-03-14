package Practise;
import java.util.*;
/*
 * 自定义实现Map的功能（非完美）
 * 1.提高查询效率
 * Map底层实现：数组+链表
 */
public class ownMap_Adv {
	@SuppressWarnings("rawtypes")
	LinkedList[] arr = new LinkedList[50]; //Map还是由链表容器数组实现
	int size;
	
	public void put(Object key,Object value) {
		//System.out.println(key.hashCode());
		ownEntry entry = new ownEntry(key,value); //建立一个键值对变量
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int location = hash%arr.length; //生成一个整型变量用作索引
		
		if(arr[location]==null) { //如果对应的位置没放东西的话
			LinkedList list = new LinkedList(); //新建一个链表对象
			arr[location] = list; //将其放进对应的位置
			list.add(entry); //再把键值对变量放进去
		}else { //如果对应的位置已经有链表对象了
			LinkedList list = arr[location]; //左右值都是LinkedList类
			for(int i=0;i<list.size();i++) { 
				ownEntry temp = (ownEntry)list.get(i); //逐个提取出并比对
				if(temp.key.equals(key)) { //如果输入的key和已存在的key相同
					temp.value = value; //覆盖对应的值
					return ; //跳出循环
				}
			}
			arr[location].add(entry); //将键值对放进链表数组所包含的某个链表容器里
		}
	}
	
	public Object get(Object key) {
		int location = key.hashCode()%arr.length;
		
		if(arr[location]!=null) {
			LinkedList list = arr[location];
			for(int i=0;i<list.size();i++) {
				ownEntry e = (ownEntry)list.get(i);
				if(e.key.equals(key)) {
					return e.getValue();
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ownMap_Adv om = new ownMap_Adv();
		om.put("jyuni", new Labmen("okabe")); //new一个新的对象
		om.put("daru", new Labmen("hashida"));//new一个新的对象
		Labmen lb = (Labmen) om.get("daru");
		System.out.println(lb.name);
		System.out.println("size="+om.getSize());
	}

	public int getSize() {
		return size;
	}

}


