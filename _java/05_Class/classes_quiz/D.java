package classes_quiz;

class Student {
	String name;
	int clas;
	int number;
	double korean;
	double english;
	double math;
	
	double getTotal() {
		return korean + english + math;
	}
	
	double getAvg(double total) {
		return total / 3;
	}
	
}

public class D {

	public static void main(String[] args) {
		Student Lee = new Student();
		Lee.name = "이광수";
		Lee.clas = 2;
		Lee.number = 11;
		Lee.korean = 65;
		Lee.english = 82;
		Lee.math = 77;
		
		double total = Lee.getTotal();
		double average = Lee.getAvg(total);

		System.out.println("이름 : " + Lee.name);
		System.out.println("반 : " + Lee.clas);
		System.out.println("번호 : " + Lee.number);
		System.out.println("국어점수 : " + Lee.korean);
		System.out.println("영어점수 : " + Lee.english);
		System.out.println("수학점수 : " + Lee.math);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		
	}

}
