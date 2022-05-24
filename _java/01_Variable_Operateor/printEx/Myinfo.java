package printEx;

import java.util.Scanner;

public class Myinfo {
	public static void main(String[] args) {
		String name = "Lee";
		int age = 28;
		float height = 167.3f;
		double weight = 70.3;
		char blood = 'A';
		boolean vachine = true; // 1bit
		long asset = 2148000000L;
		String description = "현재는 Smart Java 수업중";

		Scanner sc = new Scanner(System.in);

		// 정보 입력 안내
		// 입력 받은 정보를 변수에 저장
		System.out.println("이름을 입력하세요 > ");
		name = sc.nextLine(); // 뉴 라인 입력 됨 : 마지막 입력에 사용금지

		System.out.println("나이를 입력하세요 > ");
		age = sc.nextInt();

		System.out.println("키를 입력하세요 > ");
		weight = sc.nextFloat();

		System.out.println("몸무게를 입력하세요 > ");
		height = sc.nextFloat();

		System.out.println("혈액형을 입력하세요 > ");
		blood = sc.next().charAt(0);

		System.out.println("백신 접종 여부를 입력하세요 > ");
		vachine = sc.nextBoolean();

		System.out.println("자산을 입력하세요 > ");
		asset = sc.nextLong();

		System.out.println("부가정보를 입력하세요 > ");
		description = sc.next(); // 뉴 라인 입력 안됨

		// 문자 : %s , 정수 : %d , 실수 : %f
		System.out.printf("이름 : %s\n나이 : %d\n키 : %f\n몸무게 : %f\n혈액형 : %s\n백신 접종 여부 : %s\n자산 : %d\n부가정보 : %s", name, age,
				height, weight, blood, vachine, asset, description);
	}

}
