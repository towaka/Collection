package List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 
 * @author fukur
 * List容器示例③ LinkedList
 */
public class List_Demo_03 {
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		Emp emp_1 = new Emp("001",26,5000);
		Emp emp_2 = new Emp("002",28,5000);
		
		//addFirst表示把emp_1加在链表的最前面
		LL.addFirst(emp_1);
		//可是下面这句就会把emp_2加在emp_1的前面
		LL.addFirst(emp_2);
		
		for(int i=0;i<LL.size();i++) {
			System.out.println(((Emp)LL.get(i)).getEmpNo());
		}
		
		//显示结果
//		002
//		001
		
		//addLast表示把emp_1加在链表的最后面
		LL.addLast(emp_1);
		//下面这句就会把emp_2顺序加在emp_1的后面
		LL.addLast(emp_2);
				
		for(int i=0;i<LL.size();i++) {
			System.out.println(((Emp)LL.get(i)).getEmpNo());
		}
		
		//显示结果
//		001
//		002

	}
	
}

