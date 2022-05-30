package creation;

public class Quiz {

	public static void main(String[] args) {
		// 랜덤으로 정수 5개를 배열에 담는 메서드
		// 그 배열을 전달 받아 평균 연산하는 메서드
		// 정수 5개와 연산 결과를 출력하는 메서드
		// main 메서드에는 어떠한 연산식도 있으면 안 됨
		// 메서드간 데이터 전달 및 호출만 있어야 함

		int[] ranNumArr = madeRanNums();
		double average = calAverage(ranNumArr);
		printResult(ranNumArr, average);
		
	}

	private static void printResult(int[] rn, double av) {
		System.out.println("5개의 랜덤 정수 > ");
		for (int i : rn) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("5개의 랜덤 정수 평균 값 : " + av);
		
	}

	private static double calAverage(int[] rnArr) {
		int total = 0;
		for (int i = 0; i < rnArr.length; i++) {
			total += rnArr[i];
		}
		double av = ((double) total / rnArr.length);
		
		return av;
	}

	private static int[] madeRanNums() {
		int[] rnArr = new int[5];
		for (int i = 0; i < rnArr.length; i++) {
			rnArr[i] = (int) ((Math.random() * 100) + 1);
		}
		return rnArr;
	}

}
