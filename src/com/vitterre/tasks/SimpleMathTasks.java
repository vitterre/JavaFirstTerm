package com.vitterre.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleMathTasks {
	/**
	 * #02
	 * Prints integers numbers between
	 * {@code k} and {@code m}
	 * that can be divided by 3.
	 *
	 * @param k int value
	 * @param m int value
	 */
	public static void getNumbersBetween(int k, int m) {
		if (k == m) {
			return;
		}
		if (m > k) {
			for (int i = k + 1; i < m; ++i) {
				if (i % 3 == 0) {
					System.out.println(i);
				}
			}
		} else {
			for (int i = k + 1; i > m; --i) {
				if (i % 3 == 0) {
					System.out.println(i);
				}
			}
		}
	}

	/**
	 * Calculates absolute value of {@code x}.
	 *
	 * @param x value
	 * @return absolute value of {@code x}
	 */
	private static double abs(double x) {
		return x > 0 ? x : -x;
	}

	/**
	 * #03
	 * Calculates the square root of {@code x}
	 *
	 * @param x value
	 * @return square root if {@code x}
	 */
	public static double sqrt(double x) {
		double temp;
		double result = x / 2;
		do {
			temp = result;
			result = (temp + x / temp) / 2;
		} while (temp - result != 0);
		return result;
	}

	/**
	 * # 05
	 * Taylor's implementation of {@code sin(x)}.
	 *
	 * @param x argument
	 * @return sin(x)
	 */
	public static double sin(double x) {
		double result = x;
		int k = 2;
		double sum = -(x * x * x) / k / (k + 1);

		while (abs(sum) > 0.00000000001) {
			result += sum;
			sum *= (-1.0) * x * x * (2 * k + 1) / (2 * k);
			++k;
		}

		return result;
	}

	/**
	 * # 06
	 * Solves the square equation.
	 *
	 * @param a coefficient
	 * @param b coefficient
	 * @param c coefficient
	 * @return array of roots of the equation
	 */
	public static double[] solveSquareEquation(double a, double b, double c) {
		double d = (b * b) - 4 * a * c;
		if (d < 0) {
			return new double[]{};
		} else if (d == 0) {
			double x = (-b) / 2 * a;
			return new double[]{x};
		} else {
			double x1 = (sqrt(d) - b) / (2 * a);
			double x2 = (-sqrt(d) - b) / (2 * a);
			return new double[]{x1, x2};
		}
	}

	/**
	 * Checks that number's digits are descending.
	 *
	 * @param n number
	 * @return is number's digits are descending
	 */
	private static boolean isNumberDecrements(int n) {
		int current = n % 10;
		int s = n;

		while (s > 10) {
			s /= 10;
			if (current > s % 10) {
				return false;
			}
			current = s % 10;
		}

		return true;
	}

	/**
	 * # 07
	 * Checks that there are exactly three entered
	 * numbers in which the digits are descending.
	 *
	 * @param n amount of numbers
	 */
	public static boolean findNumbersWhereDigitsAreDescending(int n) {
		final Scanner scanner = new Scanner(System.in);
		int counter = 0;
		for (int i = 0; i < n; ++i) {
			int x = scanner.nextInt();
			if (isNumberDecrements(x)) {
				++counter;
			}
		}
		return counter == 3;
	}

	/**
	 * # 08
	 * Builds an array of integer numbers this way:
	 * {@code a[0]=1, a[1]=-3, a[2]=5, a[3]=-7}.
	 *
	 * @param n length
	 * @return array of integers
	 */
	public static int[] getArrayOf(int n) {
		int[] array = new int[n];
		array[0] = 1;

		for (int i = 1; i < n; ++i) {
			array[i] = (2 * i + 1) * (int)Math.pow(-1, i);
		}

		return array;
	}

	/**
	 * # 09.1
	 * Builds a number from array of digits.
	 *
	 * @param numbers numbers
	 * @return built number
	 */
	public static int getNumber(final String[] numbers) {
		int result = 0;
		int multiplier = 1;

		for (String stringNumber : numbers) {
			int x = Integer.parseInt(stringNumber);
			result += multiplier * x;
			multiplier *= 10;
		}

		return result;
	}

	/**
	 * # 09.2
	 * Does the same thing that {@code getNumber()} does
	 * but reversed.
	 *
	 * @param numbers numbers
	 * @return reversed built number
	 */
	public static int getReversedNumber(final String[] numbers) {
		int result = 0;
		int multiplier = 1;

		for (int i = numbers.length - 1; i >= 0; --i) {
			String stringNumber = numbers[i];
			int x = Integer.parseInt(stringNumber);
			result += multiplier * x;
			multiplier *= 10;
		}

		return result;
	}

	/**
	 * # 10
	 * Finds indexes of elements of string array that
	 * elements contain substring.
	 *
	 * @param strings array of strings
	 * @param subString substring
	 * @return array of indexes of elements of string
	 *         array that elements contain substring
	 */
	public static List<Integer> getIndexesOfElementsThatContainsSubString(final String[] strings, final String subString) {
		int stringLength = strings.length;
		final List<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < stringLength; ++i) {
			if (strings[i].toLowerCase().contains(subString.toLowerCase())) {
				indexes.add(i);
			}
		}

		return indexes;
	}
}
