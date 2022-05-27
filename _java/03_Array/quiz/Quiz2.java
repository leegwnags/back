package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 테스트에 참여할 인원수를 입력하세요 > 3
		// 1번째 사람의 이름을 입력하세요 >
		// 1번째 사람의 국어점수 입력 >
		// 1번째 사람의 영어점수 입력 >
		// 1번째 사람의 수학점수 입력 >
		// ......
		// 3번째 사람의 수학점수 입력 >

		// 이름 국어 영어 수학 총점 평균
		// aaa 88 99 87 ? ?
		// ......

		Scanner sc = new Scanner(System.in);
		System.out.println("테스트에 참여할 인원수를 입력하세요 > ");
		int member = sc.nextInt();
		String[] name = new String[member];
		int[] ko = new int[member];
		int[] en = new int[member];
		int[] math = new int[member];
		int[] total = new int[member];
		double[] average = new double[member];
		DecimalFormat df = new DecimalFormat("#.##"); // 소수점 몇째 자리까지 출력할지

		for (int i = 0; i < member; i++) {
			System.out.println(i + 1 + "번째 사람의 이름을 입력하세요 > ");
			name[i] = sc.next();

			System.out.println(i + 1 + "번째 사람의 국어점수 입력 > ");
			ko[i] = sc.nextInt();

			System.out.println(i + 1 + "번째 사람의 영어점수 입력 > ");
			en[i] = sc.nextInt();

			System.out.println(i + 1 + "번째 사람의 수학점수 입력 > ");
			math[i] = sc.nextInt();

			total[i] = ko[i] + en[i] + math[i];
			average[i] = ((double) total[i] / 3);
			// average[i] = Math.round((double)total[i] / 3);
		}

		System.out.print("이름\t국어\t영어\t수학\t총점\t평균\t순위");
		System.out.println();

		for (int i = 0; i < member; i++) {
			System.out.print(name[i] + "\t" + ko[i] + "\t" + en[i] + "\t" + math[i] + "\t" + total[i] + "\t"
					+ df.format(average[i]) + "\t");
			// df.format(average[i]) => #.## 형태(소수점 둘째 자리)로 출력
			
			// 순위 출력하기
			int rank =1;
			for (int r = 0; r < total.length; r++) {
				if (total[i] < total[r]) {
					rank++; 
				}
			}
			System.out.println(rank);
		}

	}

}
