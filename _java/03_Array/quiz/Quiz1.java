package quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// 24절기 맞추기 게임
		String[] seasonal = {
			"입춘", "우수", "경칩", "춘분",
			"청명", "곡우", "입하",
			"소만", "망종", "하지", "소서", "대서",
			"입추", "처서", "백로", "추분",
			"한로", "상강", "입동",
			"소설", "대설", "동지", "소한", "대한"
		};
		// ? 번째 절기는 무엇입니까 >
		// 정답 or 오답입니다 > 정답은 ? 
		// 정답을 맞출 때까지 몇 번 시도했는지 출력
		
		Scanner sc = new Scanner(System.in);
		int ranNum = (int) (Math.floor(Math.random()*24)+1);
		int count = 0;
		System.out.println(ranNum + "번째 절기는 무엇입니까?");
		String myAnswer = sc.next();
		while (true) {
			if (seasonal[ranNum-1].equals(myAnswer)) {
				count++;
				System.out.println("정답입니다 > 정답은 " + seasonal[ranNum-1]);
				System.out.println("시도횟수 = " + count);
				break;
			}else {
				count++;
				System.out.println("오답입니다");
				myAnswer = sc.next();
			}
		}
	}

}
