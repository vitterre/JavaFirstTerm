import java.util.Arrays;

public class Main {
	public static int getMaxStringLength(final String[] strings) {
		int maxLength = 0;

		for (String string : strings) {
			if (string.length() > maxLength) {
				maxLength = string.length();
			}
		}

		return maxLength;
	}

	public static char[][] getCharsFromStrings(final String[] strings) {
		final int maxStringLength = getMaxStringLength(strings);
		final char[][] symbolsOfStrings = new char[strings.length][maxStringLength];

		for (int i = 0; i < symbolsOfStrings.length; ++i) {
			strings[i].getChars(0, strings[i].length(), symbolsOfStrings[i], 0);
		}

		return symbolsOfStrings;
	}

	public static char[][] sortCharsFromStrings(final char[][] symbolsOfStrings, boolean reversed) {
		final char[][] sortedChars = new char[symbolsOfStrings.length][symbolsOfStrings[0].length];
		final char[] firstSymbols = new char[symbolsOfStrings.length];

		for (int i = 0; i < symbolsOfStrings.length; ++i) {
			firstSymbols[i] = symbolsOfStrings[i][0];
		}

		Arrays.sort(firstSymbols);

		for (int i = 0; i < symbolsOfStrings.length; ++i) {
				if (symbolsOfStrings[i][0] == firstSymbols[i]) {
					sortedChars[i] = symbolsOfStrings[i];
				}
		}

		return sortedChars;
	}

	// Args: I hope you still remember early morning rain
	public static void main(String[] args) {
		final char[][] charsFromStrings = getCharsFromStrings(args);
		System.out.println(Arrays.deepToString(sortCharsFromStrings(charsFromStrings, false)));
	}
}