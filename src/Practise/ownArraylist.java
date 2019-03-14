package Practise;

public class ownArraylist {	
	
	//变量和数组
	private Object[] elementData;
	
	int size;
	
	//各种方法
	public ownArraylist() { //构造方法1
		this(10);//------↓
	}
	
	public ownArraylist(int initialCapacity) { //构造方法2，指定原数组大小
		if(initialCapacity<0)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		elementData = new Object[initialCapacity];
	}
	
	public int size() {//不让外人直接调用并改变size的值，所以设立此方法
		return this.size; 
	}
	
	public boolean isEmpty() {
		return size==0; //原理简单
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
	
	public void ensureCapacity() {
		if(size==elementData.length) {
			Object[] newArray = new Object[size*2+1]; //新建一个数组，大小是原数组size*2+1
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //将原数组所有内容复制去新数组
			elementData = newArray;//把新数组的地址赋给elementData
		}
	}
	
	
	public void add(Object obj) {
		//数组扩容和数据的拷贝
		ensureCapacity();
		elementData[size] = obj;
		size++;
	}
	
	public void add(int index,Object obj) {
		RangeCheck(index);//索引检查
		ensureCapacity();//数组容量检查
		System.arraycopy(elementData, index, elementData, index+1, size-index);//原有成员向后移位，挪位置
		elementData[index] = obj; //放进去
		size++; //大小随之变化
	}
	
	public Object get(int index) {
		RangeCheck(index);
		return elementData[index];	
	}
	
	public void remove(int index) { //形参的值是“索引值”
		//删除指定位置的对象
		RangeCheck(index);
		int numMoved = size-index-1; //需要移动的成员的数量
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index, 
					         numMoved);
		}
		--size;//数组size减一
		elementData[size] = null; //成员往前移动后，数组最后一个位置置空

	}
	
	public void remove(Object obj) {
		for(int i=0;i<size();i++) {
			if(get(i).equals(obj)) { //调用数组中每个对象的equals方法
				remove(i);
			}
			break; //必须要break，不然循环将继续下去，把所有和形参内容相同的对象都删除掉
		}
		
	}
	
	public Object set(int index,Object obj) {
		RangeCheck(index);
		
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue; //返回旧值是为了防止触发垃圾清理机制
	}
	
	public static void main(String[] args) {
		ownArraylist list = new ownArraylist(3);
		list.add(333);
		list.add(333);
		list.add("333a");
		list.add("333c");
		list.add("334d");
		list.add(333);
		list.add(333);
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(4);
		
		System.out.println();
		System.out.println("//删除一个成员后");
		System.out.println();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}


//显示结果：
//7
//333
//333
//333a
//333c
//334d
//333
//333
//
//删除一个成员后
//
//333
//333
//333a
//333c
//333
//333

	