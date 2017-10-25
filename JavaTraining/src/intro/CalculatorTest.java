package intro;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculatable c = new Calculator();
		System.out.println(c.add(25, 5));
		System.out.println(c.multiply(25, 5));
		System.out.println(c.divide(25, 0));

	}

}
