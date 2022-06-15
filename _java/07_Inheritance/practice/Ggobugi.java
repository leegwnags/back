package practice;

public class Ggobugi extends Character {

	public Ggobugi() {
		hp = 200; // 체력 초기화
		mp = 100; // 마나 초기화
		System.out.println("꼬부기 생성~ 꼬북 꼬북~");
		printStatus(); // 상태정보 출력
	}

	@Override
	public void eat() {
		mp += 20;
	}

	@Override
	public void sleep() {
		mp += 30;
	}

	@Override
	public void play() {
		mp -= 30;
		hp += 15;
	}

	@Override
	public boolean train() {
		mp -= 20;
		hp += 20;
		levelUp();
		return checkMp();
	}

	@Override
	public void levelUp() {
		if (hp >= 80) {
			hp -= 80;
			level++;
		}
	}

}
