package 开始8021;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;




public class Tcpser {
	public static void main(String[] args) throws  Exception {
		ServerSocket ss=new ServerSocket(8000);
		Socket accept = ss.accept();
		InputStream in = accept.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(in);
		List<Student> list = (List<Student>) ois.readObject();
		list.forEach(li->System.out.println(li));
		save(list);
		// 5.关闭资源
		accept.close();
		ss.close();
		/////////////////
		
		
	}
	public static void save(List<Student> list) {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			//System.out.println("11111111");
			os = new FileOutputStream("src/Student.txt");
			oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			//System.out.println("11111111");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void test() {
		
		
	}
}


