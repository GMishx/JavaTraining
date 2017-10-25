package intro;

public class Calculator implements Calculatable {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

	@Override
	public double multiply(double a, double b) {
		return a - b;
	}

	@Override
	public double divide(double a, double b) {
		if (b == 0) {
			return Double.POSITIVE_INFINITY;
		} else {
			return a / b;
		}
	}

}
