package practice;

public class Piry extends Character {
	
	public Piry() {
		hp = 150; // 체력 초기화
		mp = 125; // 마나 초기화
		System.out.println("파이리 생성~ 파이리 파이리~");
		printStatus(); // 상태정보 출력
	}

	@Override
	public void eat() { 
		mp += 25;
	}

	@Override
	public void sleep() {
		mp += 25;
	}

	@Override
	public void play() {
		mp -= 25;
		hp += 15;
	}

	@Override
	public boolean train() {
		mp -= 15;
		hp += 15;
		levelUp();
		return checkMp();
	}

	@Override
	public void levelUp() {
		if(hp >= 45) {
			hp -= 45;
			level++;
		}
	}

}
