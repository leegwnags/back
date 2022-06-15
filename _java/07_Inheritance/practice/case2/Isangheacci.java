package practice.case2;

public class Isangheacci extends Character {

	public Isangheacci() {
		hp = 150; // 체력 초기화
		mp = 100; // 마나 초기화
	}

	@Override
	public void eat() { 
		mp += 20;
	}

	@Override
	public void sleep() {
		mp += 40;
	}

	@Override
	public void play() {
		mp -= 30;
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
		if(hp >= 60) {
			hp -= 60;
			level++;
		}
	}

}
