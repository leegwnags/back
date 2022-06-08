package classes_quiz;

class Pet {
	String name = "초코";
	int age = 2;
	String breeds = "푸들";
	
	void sound(String name) {
		System.out.println(name + " 울음 소리");
	}
	
	int getOlder() {
		age++;
		return age;
	}
}

public class A {

	public static void main(String[] args) {
		// a. 클래스 Pet 생성하기
		// b. Pet에 age, name, breeds 멤버 변수 초기화
		// c. Pet에 void sound() 메서드 생성
		// d. Pet에 getOlder() 메서드 생성, age 1씩 증가 후 리턴
		// d. 각 변수 값과 age의 증가를 출력
		
		Pet myPet = new Pet();
		
		System.out.println("이름 : " + myPet.name);
		System.out.println("나이 : " + myPet.age);
		System.out.println("품종 : " + myPet.breeds);
		
		int ageIncrease = myPet.getOlder();
		
		System.out.println("나이 : " + ageIncrease);
		
	}

}
