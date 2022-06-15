package practice.case2;

public class Inventory {
	private Picachu picachu;
	private Ggobugi ggobugi;
	private Isangheacci isangheacci;
	private Piry piry;
	private Character ch;
	
	public Character choiceCharacter(int chNum) {
		switch (chNum) {
		case 1:
			if (picachu == null) {
				picachu = new Picachu();
			}
				ch = picachu;
			break;
		case 2:
			if (ggobugi == null) {
				ggobugi = new Ggobugi();
			}
				ch = ggobugi;
			break;
		case 3:
			if (isangheacci == null) {
				isangheacci = new Isangheacci();
			}
				ch = isangheacci;
			break;
		case 4:
			if (piry == null) {
				piry = new Piry();
			}
				ch = piry;
			break;

		default:
			System.out.println("캐릭터를 잘 못 선택하셨습니다.");
			return null;
		}
		return ch;
	}
	
	
}
