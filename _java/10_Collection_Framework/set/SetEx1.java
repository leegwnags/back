package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		Set set = new HashSet();
		int count = 0;
		while (set.size() < 10) {
			set.add((int) (Math.random() * 10) + 1);
			count++;
		}
		System.out.println(count + " : " + set);
	}

}
