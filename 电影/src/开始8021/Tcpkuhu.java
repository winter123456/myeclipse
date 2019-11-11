package 开始8021;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tcpkuhu {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 8000);
		// 2.用Socket对象获得输出流
		OutputStream out = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		// 3.写数据
		// 创建一个List集合，集合里面放的是Student对象
		List<Student> list = new ArrayList<>();
		// 创建三个Student对象
		Student stu1 = new Student("S001", "李四", 12, 34, 55);
		Student stu2 = new Student("S002", "王五", 12, 34, 55);
		Student stu3 = new Student("S003", "赵六", 12, 34, 55);
		// 将三个对象放到集合中
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		// 将集合输出
		//oos.writeObject(list);
		// 4.关闭资源
		socket.close();
		test();
		
	}
    public static void test() {
    	System.out.println("数据已初始化请选择你的操作：1向服务器请求操作，2退出程序");
		Scanner ca=new Scanner(System.in);
		switch(ca.next()) {
		case"1":
			
			break;
		case"2":
			
			break;
			default :
				System.out.println("输入有误");
				test();
				break;
		
		}
    }
}
