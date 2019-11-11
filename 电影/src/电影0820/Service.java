package 电影0820;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Service {
//	*******************************************************************
	// 有两个集合，分别放的是：电影库，售票信息
	public static List<Movie> movies = null;
	public static List<Ticket> tickets = null;

	// 1.读取信息如果没有则初始化数据
	public List<?> getData(String fileName) {
		// 用对象流，序列化流
		InputStream in = null;
		ObjectInputStream ois = null;
		List<?> list = null;
		try {
			in = new FileInputStream(fileName);
			ois = new ObjectInputStream(in);
			// 读取数据，得到的是一个List集合
			list = (List<?>) ois.readObject();
		} catch (FileNotFoundException e) {
			// 文件没有的时候，初始化数据

			if (fileName.equals("Movies.txt")) {
				// 创建5个电影对象
				Movie m1 = new Movie("非常完美", 50, "好看的电影");
				Movie m2 = new Movie("天下无贼", 100, "好看的电影");
				Movie m3 = new Movie("大闹天宫", 70, "好看的电影");
				Movie m4 = new Movie("复仇者联盟", 200, "好看的电影");
				Movie m5 = new Movie("速度与激情", 80, "好看的电影");
				// 将5个电影对象放到集合中
				if (movies == null) {
					movies = new ArrayList<>();
				}
				movies.add(m1);
				movies.add(m2);
				movies.add(m3);
				movies.add(m4);
				movies.add(m5);

				// 将集合放到txt文件中
				System.out.println("444444444444444444444444444");
				setData(movies, fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;

	}

	// 2.写数据的方法
	public void setData(List<?> list, String fileName) {
		// 用序列化输出流，输出数据
		OutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(out);
			// 将集合写到文件中
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 3.这个方法输出座位
	public void print() {
		System.out.println("\t\t" + "屏幕");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {
				System.out.print(i + "-" + j + "  ");
			}
			System.out.println();
		}
	}

	// 4.保存售票信息
	public boolean putTicket(Ticket ticket) {
		tickets = (List<Ticket>) getData("Ticket.txt");
		// 如果tickets为空，则创建一个List集合
		if (tickets == null) {
			tickets = new ArrayList<>();
		}
		// 判断这张票是否已被购买
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getName().equals(ticket.getName()) && tickets.get(i).getTime().equals(ticket.getTime())
					&& tickets.get(i).getNumber().equals(ticket.getNumber())) {
				System.out.println("对不起,出票失败!票已买出！");
				return false;
			}
		}
		// 如果for循环完成，就正常添加售票信息到集合和文件中
		tickets.add(ticket);
		// 将售票信息放到文件中
		setData(tickets, "Ticket.txt");

		return true;
	}

}
