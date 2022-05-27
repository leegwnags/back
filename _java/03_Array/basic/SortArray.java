package basic;

import java.util.Iterator;

public class SortArray {

	public static void main(String[] args) {
		int[] intArr = new int[12];
		// intArr에 랜덤 정수를 넣고 순차정렬과 역정렬을 구현해 보세요
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int)(Math.floor(Math.random()*100)+1);
		}
		
		// 순차정렬
		for (int i = 0; i < intArr.length-1; i++) {
			for (int j = i+1; j < intArr.length; j++) {
				if (intArr[i] > intArr[j]) {
					int temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
			System.out.print(intArr[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		// 역정렬
		for (int i = 0; i < intArr.length-1; i++) {
			for (int j = i+1; j < intArr.length; j++) {
				if (intArr[i] < intArr[j]) {
					int temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
			System.out.print(intArr[i] + " ");
		}
	}

}
