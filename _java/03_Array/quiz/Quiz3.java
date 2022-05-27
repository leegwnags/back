package quiz;
import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// 숫자 야구 게임
		Scanner sc = new Scanner(System.in);
		int strike = 0;
		int ball = 0;
		int count = 0;
		int[] com = new int[3];

		// 3개의 숫자 중복되지 않게 추출하기
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.floor(Math.random() * 9) + 1);
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < com.length; i++) {
			System.out.print(com[i] + " ");
		}
		System.out.println();
		System.out.println("정답 생성");

		int[] myNum = new int[3];
		while (true) {
			strike = 0;
			ball = 0;
			System.out.println("숫자 추측하기 > ");
			String myStr = sc.next(); // 숫자를 문자로 받는다
			String[] myStrArr = myStr.split(""); // 입력받은 문자를 배열형식으로
			for (int i = 0; i < myStrArr.length; i++) {
				myNum[i] = Integer.parseInt(myStrArr[i]);
			} // 문자를 숫자로 변환해서 배열로 저장
			count++;

			for (int i = 0; i < com.length; i++) {
				for (int j = 0; j < myNum.length; j++) {
					if (com[i] == myNum[j]) {
						if (i == j) {
							strike++;
						} else {
							ball++;
						}
					}
				}
			}

			if (strike == 3) {
				System.out.printf("정답입니다 %d번 시도만에 정답!", count);
				break;
			} else if (strike == 0 && ball == 0) {
				System.out.println("아웃");
			} else {
				System.out.printf("strike : %d , ball : %d", strike, ball);
				System.out.println();
			}
		}

	}

}
