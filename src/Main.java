public class Main {
	private static double exp(double x) {
		double result = 1.0d;
		double current = x;
		int i = 1;

		while (current >= 0.00001d) {
			result += current;
			current *= x / (i + 1);
			++i;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(exp(20));
	}
}