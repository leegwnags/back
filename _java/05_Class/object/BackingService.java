package object;

class BankAccount {
	String owner;
	int accNum;
	int deposit;
	
	void getAccInfo() {
		System.out.println("예금주 : " + owner);
		System.out.println("계좌번호 : " + accNum);
		System.out.println("잔액 : " + deposit + "원");
	}
	void saving(int money) {
		deposit += money;
	}
	void withdraw(int money) {
		if (money > deposit) {
			System.out.println("잔액부족");
		} else {
			deposit -= money;			
		}
	}
}

public class BackingService {

	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 잔액(deposit)
		// 계좌현황조회, 입금, 출금을 할 수 있다 (메서드)
		
		BankAccount myAcc = new BankAccount();
		myAcc.owner = "이광수";
		myAcc.accNum = 123456;
		myAcc.deposit = 0;
		myAcc.getAccInfo();
		myAcc.saving(50000);
		myAcc.getAccInfo();
		myAcc.withdraw(30000);
		myAcc.getAccInfo();
		myAcc.withdraw(1000000);
		myAcc.getAccInfo();
		
	}

}
