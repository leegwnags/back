package classes_quiz;

public class B {

	public static void main(String[] args) {
		
		madeStars(5);

	}

	private static void madeStars(int n) {
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
