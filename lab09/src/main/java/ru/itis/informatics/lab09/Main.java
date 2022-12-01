package ru.itis.informatics.lab09;

public class Main {

	/* ----- Entry point ----- */

	public static void main(String[] args) throws Exception {
		final String hi = "hi";

		// HEX encoding usage
		final String hiHexEncoded = Hex.encode(hi);
		final String hiHexDecoded = Hex.decode(hiHexEncoded);

		System.out.println("HEX encoded: " + hiHexEncoded);
		System.out.println("HEX decoded: " + hiHexDecoded);

		// Base64 encoding usage
		final String hiBase64Encoded = Base64.encode(hi);
		System.out.println("Base64 encoded: " + hiBase64Encoded);
	}

}