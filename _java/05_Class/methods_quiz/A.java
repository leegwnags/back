package methods_quiz;

public class A {

	public static void main(String[] args) {
		output(10,'#');
	}

	private static void output(int i, char c) {
		//a. 한 줄에 # 10개 출력
		// b. output(10,'#') 메서드를 호출
		// c. 출력문에서 for문을 이용
		
		for (int j = 0; j < i; j++) {
		System.out.print(c);	
		}
		
	}
	
}
