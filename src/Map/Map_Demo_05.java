package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 方案：面向对象+分拣存储 1对N的问题
 * @author fukur
 *
 */
public class Map_Demo_05 {
	
	public static void main(String[] args) {
		//1.考试
		List<Student> stulist = exam();
		//2.分析成绩
		Map<String,ClassRoom> map = count(stulist);//list的内容被放入map中
		//3.查看成绩（总分，平均分）
		view(map); //map的内容再经过set提取，使用迭代器进行遍历并查看
	}
	
	/**
	 * 查看每个班的平均分和总分 -->遍历Map
	 */
	public static void view(Map<String,ClassRoom> map) {
		//先将map中的key放进去一个Set类对象中
		Set<String> keys = map.keySet();
		//先获取迭代器对象
		Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext()) { //先判断后获取
			String num = keysIt.next(); //获取key
			ClassRoom room = map.get(num); //通过key获取value
			//查看总分，计算平均分
			double total = room.getTotal(); //在这一句之前，total的值已经被改变了
			double avg = total/room.getStuList().size();
			System.out.println(num+"-->"+total+"-->"+avg);
		}
	}
	
	/**
	 * 统计分析
	 * 1.面向对象
	 * 2.分拣存储
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
		//1.遍历list
		for(Student stu:list) {
			String num = stu.getNum(); //循环遍历获取list中每个学生信息的班级号
			double score = stu.getScore();//循环遍历获取list中每个学生信息的成绩
			//2.分拣，看是否存在该编号的班级。如果不存在，创建班级
			ClassRoom room = map.get(num); //按对应的键获取对应的值，值为ClassRoom类型
			
			if(null==room) { //如果该班级没有被创建
				room = new ClassRoom(num); //创建对应班级
				map.put(num, room);
			}
			
			//已经有东西的话放入学生数据
			room.getStuList().add(stu);//放入被遍历的学生数据
			room.setTotal(room.getTotal()+score); //基于每个不同的key计算总分，改变属性total的值
		}
		return map;
	}
	/**
	 * 模拟输入数据到list中
	 * @return list
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//存放学生成绩（Student类型的对象）
		list.add(new Student("老裴","a",80));
		list.add(new Student("马士兵","a",70));
		list.add(new Student("高淇","b",65));
		list.add(new Student("丛云","c",80));
		list.add(new Student("pray","c",64));
		
		return list;
	}
}
