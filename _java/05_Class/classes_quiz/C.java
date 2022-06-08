package classes_quiz;

class Ex03 {
	double base = 5.0;
	double height = 3.5;

	double getArea() {
		return (base * height) / 2;
	}

	double getHypotenuse() {
		return Math.sqrt((base * base) + (height * height));
	}
	
	double getPerimeter(double Hypotenuse) {
		return base + height + Hypotenuse;
	}
}

public class C {

	public static void main(String[] args) {
		Ex03 ob = new Ex03();
		System.out.printf("삼각형의 넓이 : %.2f\n" , ob.getArea());
		System.out.printf("삼각형의 빗변의 길이 : %.2f\n" , ob.getHypotenuse());
		System.out.printf("삼각형의 둘레길이 : %.2f\n" , ob.getPerimeter(ob.getHypotenuse()));
		// printf("%.2f") => 소수점 2자리까지만 출력
	}

}
