package intro;

public class Loops {

	public static void main(String[] args) {
		long count = 0;
		outter: for (int i = 1; i <= 100; i++) {
			if (i == 50) {
				continue outter;
			}
			if (i > 80) {
				break outter;
			}
			if (i % 2 == 0) {
				count += i;
			}
		}
		System.out.println(count);
	}

}
