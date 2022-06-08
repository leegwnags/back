package object;

class BankAccount2 {
	String owner;
	int accNum;
	int deposit;
	
	void getAccInfo() {
		System.out.println("예금주 : " + getOwner());
		System.out.println("계좌번호 : " + getAccNum());
		System.out.println("잔액 : " + getDeposit());
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
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getOwner() {
		return this.owner;
	}
	public int getAccNum() {
		return this.accNum;
	}
	public int getDeposit() {
		return this.deposit;
	}
}

public class BackingService2 {

	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 잔액(deposit) 세팅하는 메서드
		// 위의 정보를 조회할 수 있는 메서드
		// 계좌현황조회(변경)ㅂ, 입금, 출금을 할 수 있다 (메서드)
		
		BankAccount2 myAcc = new BankAccount2();
		myAcc.setOwner("kim");
		myAcc.setAccNum(1234567);
		myAcc.setDeposit(0);
		
		myAcc.getAccInfo();
		myAcc.saving(50000);
		myAcc.getAccInfo();
		myAcc.withdraw(30000);
		myAcc.getAccInfo();
		myAcc.withdraw(1000000);
		myAcc.getAccInfo();
	}

}
