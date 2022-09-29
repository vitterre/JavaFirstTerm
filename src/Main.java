import com.vitterre.tasks.CircleBuilder;
import com.vitterre.tasks.SimpleMathTasks;
import com.vitterre.tasks.TreeForce;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println("# 01");
		System.out.println("INPUT: 7");
		TreeForce.build(7);
		System.out.println("=========================");

		System.out.println("# 02");
		System.out.println("INPUT: 1 10");
		SimpleMathTasks.getNumbersBetween(1, 10);
		System.out.println("=========================");

		System.out.println("# 03");
		System.out.println("INPUT 20");
		System.out.println(SimpleMathTasks.sqrt(20));
		System.out.println("=========================");

		System.out.println("# 04");
		System.out.println("INPUT 20");
		CircleBuilder.build(20);
		System.out.println("=========================");

		System.out.println("# 05");
		System.out.println("INPUT 0.5");
		System.out.println(SimpleMathTasks.sin(0.5));
		System.out.println("=========================");

		System.out.println("# 06");
		System.out.println("INPUT 1 -7 6");
		System.out.println(Arrays.toString(SimpleMathTasks.solveSquareEquation(1, -7, 6)));
		System.out.println("=========================");

		System.out.println("# 07");
		System.out.println("INPUT 5 321 654 78119 9186 987");
		System.out.println(SimpleMathTasks.findNumbersWhereDigitsAreDescending(5));
		System.out.println("=========================");

		System.out.println("# 08");
		System.out.println("INPUT 20");
		System.out.println(Arrays.toString(SimpleMathTasks.getArrayOf(20)));
		System.out.println("=========================");

		System.out.println("# 09");
		System.out.println("INPUT 5 7 8 1 2 9");
		System.out.println(SimpleMathTasks.getNumber(args));
		System.out.println(SimpleMathTasks.getReversedNumber(args));
		System.out.println("=========================");

		final String[] strings = {"abafasba", "babblajlbj", "lkbalabbbjhal", "alkjba", "lkbjalabb"};
		final String subString = "abb";
		System.out.println("# 10");
		System.out.println("INPUT " + Arrays.toString(strings) + " " + subString);
		System.out.println(SimpleMathTasks.getIndexesOfElementsThatContainsSubString(strings, subString));
		System.out.println("=========================");
	}
}