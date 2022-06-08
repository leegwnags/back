package methods_quiz;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// a. 피보나치 수열 출력
		// b. 확인하고 싶은 수열의 자리수(정수) 입력 받기
		// c. 수열 계산하는 메서드는 int fibo(int n)
		
		Scanner sc = new Scanner(System.in);
		System.out.println("알고싶은 자릿수 값 > ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print(fibo(i) + " ");
		}

	}

	private static int fibo(int i) {
		if (i == 0 || i == 1) {
			return 1;
		} else {
			return fibo(i-2) + fibo(i-1);
		}
	}

}
