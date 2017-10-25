package intro;

import java.util.StringTokenizer;

public class StringReverse {

	public static void main(String[] args) {
		StringBuffer reversedString = new StringBuffer();
		String originalString = "Hello! Have a nice day.";
		for (int i = originalString.length() - 1; i >= 0; i--) {
			reversedString.append(originalString.charAt(i));
		}
		System.out.println("Original String: " + originalString);
		System.out.println("Reversed String: " + reversedString);
		System.out.println("Reversed functi: " + reversedString.reverse());
		StringTokenizer tokens = new StringTokenizer(originalString, " ");
		while (tokens.hasMoreElements()) {
			System.out.println(tokens.nextElement());
		}
	}

}
