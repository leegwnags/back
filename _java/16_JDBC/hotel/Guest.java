package hotel;

public class Guest {
	private String name;
	private String tel;
	private int age;
	private int gen;
	private String rno;
	public Guest(String name, String tel, int age, int gen, String rno) {
		this.name = name;
		this.tel = tel;
		this.age = age;
		this.gen = gen;
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGen() {
		return gen;
	}
	public void setGen(int gen) {
		this.gen = gen;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	@Override
	public String toString() {
		return "Guest [name=" + name + ", tel=" + tel + ", age=" + age + ", gen=" + gen + ", rno=" + rno + "]";
	}
	
	
}
