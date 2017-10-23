package intro;

public class Salary {

	public static void main(String[] args) {
		double salary = 35000.00;
		int hike = 5;
		System.out.println(salaryHike(salary, hike));
	}

	/**
	 * Function to calculate hiked salary
	 * 
	 * @author Z003U7PX
	 * @param salary
	 *            Current salary
	 * @param hike
	 *            Percentage to increase
	 * @return Hiked salary
	 */
	public static double salaryHike(double salary, int hike) {
		salary += salary * (hike / 100.00);
		if (hike < 5) {
			System.out.println("Hike is bad");
		} else if (hike < 10) {
			System.out.println("Hike is average");
		} else if (hike < 15) {
			System.out.println("Hike is good");
		} else if (hike < 20) {
			System.out.println("Hike is very good");
		} else {
			System.out.println("Hike is exceptional");
		}
		return salary;
	}
}
