package 电影0820;

import java.util.List;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Service ser = new Service();
		// 1.输出座位
		ser.print();
		// 初始化数据
		Service.movies = (List<Movie>) ser.getData("Movies.txt");
		boolean flag = true;
		while (flag) {
			System.out.println("今日播放电影如下：");
			if (Service.movies == null) {
				Service.movies = (List<Movie>) ser.getData("Movies.txt");
			}
			// 输出电影的列表
			for (int i = 0; i < Service.movies.size(); i++) {
				System.out.println(i + " " + Service.movies.get(i).getName());
			}
			System.out.println("请选择：1、购买电影票  2.退出系统");
			String str = sc.next();
			if (str.equals("1")) {
				getTiceket(ser);
			} else if(str.equals("2")) {
				flag = false;
			}else {
				System.out.println("输入有误，请重新选择？");
			}

		}
	}

	private static void getTiceket(Service ser) {

		System.out.println("请选择你要看的电影编号：");

		int movieNumber = sc.nextInt();
		System.out.println("请输入电影播放时间：以xx:xx的格式");
		String time = sc.next();
		System.out.println("请输入您所要购买的票的类型：1.普通票   2.学生票   3.赠送票");
		int type = sc.nextInt();
		System.out.println("请输入您所需要的折扣：1到9的整数");
		int price = (int) (Service.movies.get(movieNumber).getPrice() * sc.nextInt() * 0.1);
		System.out.println("请输入您所需要的座位号：以排-列的形式");
		String number = sc.next();
		Ticket ticket = new Ticket(Service.movies.get(movieNumber).getName(), time, price + "", number,
				(type == 1) ? "普通票" : (type == 2) ? "学生票" : "赠送票");
		// 将售票的对象放到记事本
		boolean b = ser.putTicket(ticket);
		if (b) {
			System.out.println("	       ***************************\n		 陶陶影院 (" + ticket.getType()
					+ ")\n	       ---------------------------\r\n" + "		 电影名：" + ticket.getName() + "	\r\n"
					+ "		 时间：" + ticket.getTime() + "	\r\n" + "		 座位号：" + ticket.getNumber() + "	\r\n"
					+ "		 价格： " + ticket.getPrice() + "	\r\n" + "	       ***************************");

		}
		System.out.println("请选择：1.继续购票   2.查询已售票  3.放回上一层 4.直接退出系统");
		String in = sc.next();
		switch (in) {
		case "2":
			List<?> data = ser.getData("Ticket.txt");
			data.forEach(li -> System.out.println(li));
			break;
		case "4":
			System.exit(0);
			break;

		}
	}

}
