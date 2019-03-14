package Map;

public class Student {
	private String name;
	private String num;
	private double score;
	
	public Student() {
		super();
	}

	public Student(String name, String num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
	
}
