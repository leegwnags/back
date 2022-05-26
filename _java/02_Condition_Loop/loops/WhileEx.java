package loops;

public class WhileEx {

	public static void main(String[] args) {
		// 1부터 20까지 합 구하기 while 이용하기
		
		int i = 1;
		int total = 0;
		while (i < 21) {
			total += i;
			i++;
		}
		System.out.println(total);
		
		// 1부터 100까지 홀수의 합 구하기 do while 이용하기
		
		int j = 1;
		int oddTotal = 0;
		do {
			if (j % 2 == 1) {
				oddTotal += j;
			}
			j++;
		} while (j < 101);
		System.out.println(oddTotal);
	}

}
