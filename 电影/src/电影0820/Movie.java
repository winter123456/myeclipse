package 电影0820;

import java.io.Serializable;

/**
 * 电影类
 * @author newuser
 *
 */
public class Movie implements Serializable{
	private String name;//电影的名字***********************************
	private float price;//电影价格
	private String info;//电影简介
	//全参构造器
	public Movie(String name, float price, String info) {
		super();
		this.name = name;
		this.price = price;
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", price=" + price + ", info=" + info + "]";
	}
	
}
