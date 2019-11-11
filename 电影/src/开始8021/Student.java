package 开始8021;

import java.io.Serializable;

public class Student implements Serializable {
	private String number;
	private String name;
	private int chinese;
	private int math;
	private int ecglish;
	public Student(String number, String name, int chinese, int math, int ecglish) {
		super();
		this.number = number;
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.ecglish = ecglish;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEcglish() {
		return ecglish;
	}
	public void setEcglish(int ecglish) {
		this.ecglish = ecglish;
	}
	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", chinese=" + chinese + ", math=" + math + ", ecglish="
				+ ecglish + "]";
	}

}
