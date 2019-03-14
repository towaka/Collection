package Others_Que;
/**
 * 测试自定义堆栈
 * @author fukur
 *
 */
public class Demo_02 {
	public static void main(String[] args) {
		MyStack<String> backHistory = new MyStack<String>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.google.com");
		backHistory.push("www.sogou.com");
		backHistory.push("www.sina.com");
		
		System.out.println("栈大小："+backHistory.size());
		
		//尝试栈遍历
		String item = null;
		while(null!=(item=backHistory.pop())) { //从最后一个进栈的开始获取
			System.out.println(item);
		}
	}
}
