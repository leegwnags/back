package dataType;

public class NumberMethods {

	public static void main(String[] args) {
		// 반올림
		System.out.println("반올림 : " + Math.round(1024.389));
		// 절대값
		System.out.println("절대값 : " + Math.abs(-1244));
		// 최대값, 최소값
		System.out.println("최대값 : " + Math.max(1234, 1235));
		System.out.println("최소값 : " + Math.min(1234, 1235));
		
		// 실수가 갖을 수 있는 천장값, 바닥값
		System.out.println("천장값 : " + Math.ceil(1234.5567));
		System.out.println("바닥값 : " + Math.floor(1234.5567));
		System.out.println("천장값 : " + Math.ceil(-12345.678));
		System.out.println("바닥값 : " + Math.floor(-12345.678));
		
		// 제곱
		System.out.println("제곱 : " + Math.pow(2, 10));
		// 루트
		System.out.println("루트 : " + Math.sqrt(196));
		// 랜덤
		System.out.println("랜덤 : " + Math.random()); // 0부터 1사이 실수
		System.out.println((int)(Math.floor(Math.random()*100)+1));
	}

}
