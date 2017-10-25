package intro;

import java.util.ArrayList;

public class StringTest {

	public static void main(String[] args) {
		String name = "Sri Ranga Sai";
		ArrayList<Integer> positions = new ArrayList<Integer>();
		int currentPos = 0;
		while (true) {
			currentPos = name.toLowerCase().indexOf('a', currentPos);
			if (currentPos < 0)
				break;
			positions.add(currentPos);
			currentPos++;
		}
		System.out.println("Number of occurances of \"a\": " + positions.size());
		System.out.println("Indexes of \"a\": " + positions.toString());
	}

}
