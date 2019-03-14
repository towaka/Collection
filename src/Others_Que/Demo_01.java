package Others_Que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 * @author fukur
 *
 */
public class Demo_01 {
	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		
		//模拟排队情况
		for (int i = 0; i < 10; i++) {
			//匿名内部类无法访问i这个局部变量，所以将其传给另一个final变量
			final int num = i;
			que.offer(new Request() {
				@Override
				public void Depoist() {
					// TODO Auto-generated method stub
					System.out.println("第"+(num+1)+"个人，办理存款业务。存款额度为："+(Math.random()*10000));
					}
				}
			);	
		}
		dealwith(que);
	}
	
	//处理存款业务
	public static void dealwith(Queue<Request> que) {
		Request req = null;
		while(null!=(req=que.poll())) {//当队列不为空，并且队列内的元素实现了Request接口时
			//.poll()就是获取当前队列的元素 get同时remove掉
			//这条语句的意思是只要que队列不为空就执行deposit
			req.Depoist();
		}
	}
}

interface Request{
	//存款方法
	void Depoist();
}