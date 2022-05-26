package quiz;

public class Quiz3 {

	public static void main(String[] args) {
		// Q3. 아래와 같은 출력문을 만들어보세요
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ
		// ABCDEFGHIJKLMNOPQRSTUVWXY
		// ABCDEFGHIJKLMNOPQRSTUVWX
		// ABCDEFGHIJKLMNOPQRSTUVW
		// ABCDEFGHIJKLMNOPQRSTUV
		// ABCDEFGHIJKLMNOPQRSTU
		// ABCDEFGHIJKLMNOPQRST
		// ......
		// ....
		// ...
		// AB
		// A

		String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = str2.length(); i > 0; i--) {
			System.out.println(str2.substring(0, i));
		}

		// supported by 이슬기
		for (char i = 'Z'; i >= 'A'; i--) {
			for (char j = 'A'; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		// supported by 채정임 
		for (int i = 0; i < 26; i++) {
			for (int j = 65; j < (91 - i); j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}
	}
}
