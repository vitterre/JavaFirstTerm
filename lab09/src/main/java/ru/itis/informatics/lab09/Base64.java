package ru.itis.informatics.lab09;

import java.util.Arrays;

public final class Base64 {

	/* ----- Fields ----- */

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";


	/* ----- Static methods ----- */

	public static String encode(byte[] input) {
		int length = input.length;
		int length2 = (length / 3) * 3;
		int length3 = length % 3;
		int length4 = length3 > 0 ? (length2 / 3 + 1) * 4 : length2 / 3 * 4;
		byte[] result = new byte[length4];
		int i = 0;
		int j = 0;
		while (i < length2) {
			int b0 = input[i++] & 0xFF;
			int b1 = input[i++] & 0xFF;
			int b2 = input[i++] & 0xFF;
			result[j++] = (byte) ALPHABET.charAt(b0 >> 2);
			result[j++] = (byte) ALPHABET.charAt((b0 << 4 | b1 >> 4) & 0x3F);
			result[j++] = (byte) ALPHABET.charAt((b1 << 2 | b2 >> 6) & 0x3F);
			result[j++] = (byte) ALPHABET.charAt(b2 & 0x3F);
		}
		if (length3 == 1) {
			int b0 = input[i] & 0xFF;
			result[j++] = (byte) ALPHABET.charAt(b0 >> 2);
			result[j++] = (byte) ALPHABET.charAt((b0 << 4) & 0x3F);
			result[j++] = (byte) '=';
			result[j] = (byte) '=';
		} else if (length3 == 2) {
			int b0 = input[i++] & 0xFF;
			int b1 = input[i] & 0xFF;
			result[j++] = (byte) ALPHABET.charAt(b0 >> 2);
			result[j++] = (byte) ALPHABET.charAt((b0 << 4 | b1 >> 4) & 0x3F);
			result[j++] = (byte) ALPHABET.charAt((b1 << 2) & 0x3F);
			result[j] = (byte) '=';
		}
		return new String(result);
	}

	public static String encode(final String input) {
		return encode(input.getBytes());
	}

}
