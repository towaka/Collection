package Other_Weak;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 引用类型：强、软、弱、虚
 * 
 * 下面代码着重讲解强和弱引用
 * @author fukur
 *
 */
public class RefDemo {
	public static void main(String[] args) {
		testStrong();
		System.out.println("-------------->");
		testWeak();
	}
	
	public static void testStrong() {
		//字符串放在常量池中时， 供共享所用 ，且和C++不同 ，不可更改
		String str = "Dejavu";
		// 弱引用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("GC运行前 = " + wr.get());
		// 断开引用
		str = null;
		// 通知回收
		System.gc();
		System.runFinalization();

		System.out.println("GC运行后 = " + wr.get());
	}
	
	
	public static void testWeak(){
		// 字符串放在堆中
		String str = new String("Dejavu");
		// 弱引用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("GC运行前 = " + wr.get());
		// 断开引用
		str = null;
		// 通知回收
		System.gc();
		System.runFinalization();

		System.out.println("GC运行后 = " + wr.get());
	}
}
