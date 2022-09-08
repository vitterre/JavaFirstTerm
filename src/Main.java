class Operators {
	public static final int OPERATOR_AND = 0;
	public static final int OPERATOR_OR  = 1;
	public static final int OPERATOR_XOR = 2;
	public static final int OPERATOR_NOT = 3;
}

public class Main {
	private static final char[] operatorsChar = {
					'&', '|', '^', '!'
	};

	private static boolean resultOfBooleanFunction(int operator, boolean a, boolean b) {
		switch (operator) {
			case 0 -> {
				return a & b;
			}
			case 1 -> {
				return a | b;
			}
			case 2 -> {
				return a ^ b;
			}
			default -> {
				return false;
			}
		}
	}

	private static void printBooleanTable(int operator) {
		if (operator != 3) {
			System.out.println("+-----+-------+-------+-------+-------+");
			System.out.println("|     |   " +
							operatorsChar[operator] + "   |   " +
							operatorsChar[operator] + "   |   " +
							operatorsChar[operator] + "   |   " +
							operatorsChar[operator] + "   |");
			System.out.println("+-----+-------+-------+-------+-------+");
			System.out.println("|  a  | true  | false | true  | false |");
			System.out.println("|-----|-------|-------|-------|-------|");
			System.out.println("|  b  | true  | true  | false | false |");
			System.out.println("|-----|-------|-------|-------|-------|");
			System.out.println("| res | " +
							resultOfBooleanFunction(operator, true, true) + "  | " +
							resultOfBooleanFunction(operator, false, true) + " | " +
							resultOfBooleanFunction(operator, true, false) + " | " +
							resultOfBooleanFunction(operator, false, false) + " |");
			System.out.println("+-----+-------+-------+-------+-------+");
		} else {
			System.out.println("+-----+-------+-------+");
			System.out.println("|     |   !   |   !   |");
			System.out.println("+-----+-------+-------+");
			System.out.println("|  a  | true  | false |");
			System.out.println("|-----|-------|-------|");
			System.out.println("| res | " + !true + " | " + !false + "  |");
			System.out.println("+-----+-------+-------+");
		}
	}

	public static void main(String[] args) {
		printBooleanTable(Operators.OPERATOR_AND);
		printBooleanTable(Operators.OPERATOR_OR);
		printBooleanTable(Operators.OPERATOR_XOR);
		printBooleanTable(Operators.OPERATOR_NOT);
	}
}
