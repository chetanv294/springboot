package net.spring.manytomany;

public class Cryptology {

	private static char mapping[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '-', '.' };

	private static char getc(int presentCount, String encryptString) {
		char c = 0;
		if (presentCount < encryptString.length()) {
			c = encryptString.charAt(presentCount);
		}
		return c;
	}

	private static void putc(int i, StringBuffer sbr) {
		sbr.append((char) i);
	}

	public static String encrypt(String s) {

		String encryptString = "";
		StringBuffer sbr = new StringBuffer();

		encryptString = s;
		int bitoffset = 0;
		int firstchar = 0;
		int secondchar = 0;
		int presentCount = 0;

		sbr.delete(0, sbr.length());
		firstchar = getc(presentCount, encryptString);
		if (firstchar > 0) {
			presentCount++;
			secondchar = getc(presentCount, encryptString);
		}

		while (firstchar > 0) {
			while (bitoffset < 8) {
				int i = ((firstchar + secondchar * 256) >> bitoffset) & 63;
				putc(mapping[i], sbr);
				bitoffset += 6;
			}
			bitoffset -= 8;
			firstchar = secondchar;
			presentCount++;
			secondchar = getc(presentCount, encryptString);
		}

		String t = sbr.toString();
		sbr = null;

		return t;
	}

	public static String decrypt(String s1) {

		String encryptString = "";
		StringBuffer sbr = new StringBuffer();

		int bitoffset = 0;
		int outchar = 0;
		int c = 0;
		int mapping1[] = new int[256];
		sbr.delete(0, sbr.length());
		int charCount = 0;
		for (int j = 0; j < mapping.length; j++) {
			mapping1[mapping[j]] = j;
		}

		encryptString = s1;
		c = getc(charCount, encryptString);

		int t2 = 0;
		while (c > 0) {
			outchar |= mapping1[c] << bitoffset;
			bitoffset += 6;
			if (bitoffset >= 8) {
				t2 = outchar & 127;
				putc(t2, sbr);
				bitoffset -= 8;
				outchar >>= 8;
			}
			charCount++;
			c = getc(charCount, encryptString);
		}

		String t = sbr.toString();
		sbr = null;

		  return t;
	}

	public static void main(String[] args) {

		String test = encrypt("abcd@1234");

		System.out.println(test);

		String decTest = decrypt("Hj2yKbumYmdn");

		System.out.println("<<"+decTest+">>");
		
		String testa = encrypt("admin.1234");

		System.out.println(testa);

		String decTesta = decrypt("HrwBP5MlXiZm0a");

		System.out.println("<<"+decTesta+">>");
	}

} // end Cryptology
