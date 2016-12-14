public class StringRec {
	public static void main(String[] args) {
		System.out.println(decompress("q9w5e2rt5y4qw2Er3T"));
	}

	public static String decompress(String compressedText) {
		return decompress(compressedText,"");
	}

	private static String decompress(String compressedText, String currentString) {
		String newString = currentString;

		if (compressedText.length() == 0) {
			return newString;
		}

		if (Character.isDigit(compressedText.charAt(0))) {
			if (compressedText.length() > 1) {
				if (compressedText.charAt(0) != '1') {
					char digit = compressedText.charAt(0);
					digit--;

					newString += compressedText.charAt(1);
					return decompress(Character.toString(digit) + compressedText.substring(1,compressedText.length()),newString);
				} else {
					newString += compressedText.charAt(1);
					return decompress(compressedText.substring(2,compressedText.length()),newString);
				}
			} 
		} else {
			if (compressedText.length() > 1) {
				newString += compressedText.charAt(0);
				return decompress(compressedText.substring(1,compressedText.length()),newString);
			} else if (compressedText.length() == 1) {
				return newString + compressedText.charAt(0);
			}
		}
		return newString;
	}
}