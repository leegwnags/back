package conditions;

import java.util.Scanner;

public class RSPGame {

	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		// 1. 컴퓨터가 랜덤으로 가위바위보 선택
		// 2. 나도 가위바위보를 입력
		// 3. 승무패 결과 출력
		System.out.println("가위바위보 게임 시작 > ");
		int com = (int) (Math.floor(Math.random() * 3));
		System.out.println("컴퓨터가 결정을 완료하였습니다");
		System.out.println("가위 바위 보 중 한개를 선택하세요 > ");
		Scanner sc = new Scanner(System.in);
		int my = sc.nextInt();

		if (my == com) {
			System.out.println("무승부");
		} else if (my == 0) {
			System.out.println(com == 1 ? "패" : "승");
		} else if (my == 1) {
			System.out.println(com == 0 ? "승" : "패");
		} else if (my == 2) {
			System.out.println(com == 0 ? "패" : "승");
		}
	}

}
