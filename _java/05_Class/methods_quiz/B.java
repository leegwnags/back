package methods_quiz;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		//a. 입력 받은 값을 compute(item, qty, price) 메서드로 처리
		// b. 출력 예)
		// -입력-
		// 품명 : apple
		// 수량 : 10
		// 단가 : 1200
		// -출력-
		// 품명 : apple
		// 금액 : 12000
		
		Scanner sc = new Scanner(System.in);
		System.out.println("품명을 입력해주세요 > ");
		String item = sc.next();
		
		System.out.println("수량을 입력해주세요 > ");
		int qty = sc.nextInt();
		
		System.out.println("단가를 입력해주세요 > ");
		int price = sc.nextInt();
		
		System.out.println("-- 입력 --");
		System.out.println("품명" + item);
		System.out.println("수량" + qty);
		System.out.println("단가" + price);
		
		compute(item, qty, price);
	}

	private static void compute(String item, int qty, int price) {
		System.out.println("-- 출력 --");
		System.out.println("품명" + item);
		System.out.println("가격" + (qty * price));
		
	}

}
