package ru.itis.informatics.lab09;

public final class Hex {

	/* ----- Static methods ----- */

	public static String encode(final byte[] input) {
		int n = input.length;
		final char[] out = new char[n * 2];

		for (int i = 0; i < n; ++i) {
			int low = input[i] & 0xF;
			int hi = (input[i] & 0xF0) >> 4;

			out[2 * i] = intToChar(hi);
			out[2 * i + 1] = intToChar(low);
		}

		return new String(out);
	}

	public static String encode(final String input) {
		return encode(input.getBytes());
	}

	public static String decode(final String encoded) throws Exception {
		if (!encoded.matches("[0-9a-fA-F]+") || encoded.length() % 2 != 0) {
			throw new Exception("The string that was passed as an argument is not a result of HEX encryption!");
		}

		int n = encoded.length() / 2;
		final byte[] out = new byte[n];

		for (int i = 0; i < n; ++i) {
			// todo: optimize
			int low = charToInt(encoded.charAt(2 * i + 1));
			int hi = charToInt(encoded.charAt(2 * i));

			out[i] = (byte)((hi << 4) | low);
		}

		return new String(out);
	}


	/* ----- Private methods ----- */

	private static char intToChar(final int number) {
		return switch (number) {
			case 0 -> '0';
			case 1 -> '1';
			case 2 -> '2';
			case 3 -> '3';
			case 4 -> '4';
			case 5 -> '5';
			case 6 -> '6';
			case 7 -> '7';
			case 8 -> '8';
			case 9 -> '9';
			case 10 -> 'A';
			case 11 -> 'B';
			case 12 -> 'C';
			case 13 -> 'D';
			case 14 -> 'E';
			case 15 -> 'F';
			default -> '-';
		};
	}

	private static int charToInt(final char charAt) {
		if (charAt >= '0' && charAt <= '9') {
			return charAt - '0';
		} else if (charAt >= 'a' && charAt <= 'f') {
			return charAt - 'a' + 10;
		} else if (charAt >= 'A' && charAt <= 'F') {
			return charAt - 'A' + 10;
		} else {
			return -1;
		}
	}

}
