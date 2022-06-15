package practice.case2;

public class Piry extends Character {
	
	public Piry() {
		hp = 150; // 체력 초기화
		mp = 125; // 마나 초기화
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
