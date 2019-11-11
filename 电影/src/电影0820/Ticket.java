package 电影0820;

import java.io.Serializable;

/**
 * 售票类
 * 
 * @author Administrator
 *
 */
public class Ticket implements Serializable {
	private String name;// 电影名字
	private String time;// 播放时间
	private String price;// 价格
	private String number;// 座位号
	private String type;// 电影票的类型
	// 全参构造

	public Ticket(String name, String time, String price, String number, String type) {
		super();
		this.name = name;
		this.time = time;
		this.price = price;
		this.number = number;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "电影名字:" + name + ", 播放时间:" + time + ", 价格:" + price + ", 座位号:" + number + ", 票类型:" + type;
	}

}
