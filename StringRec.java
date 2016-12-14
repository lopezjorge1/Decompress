public class StringRec {
	public static void main(String[] args) {
		System.out.println(decompress("5t5t"));
	}

	private static String decompress(String compressedText, String currentString) {
		String newString = currentString;

		if (compressedText.length() == 0) {
			return newString;
		}

		if (Character.isDigit(compressedText.charAt(0))) {
			if (compressedText.length() > 1) {
				if (compressedText.charAt(0) == '1') {
					return decompress(compressedText.substring(1,compressedText.length()),newString);
				} else { 
					char digit = compressedText.charAt(0);
					digit--;

					newString += newString.charAt(newString.length()-1); 
					return decompress(Character.toString(digit) + compressedText.substring(1,compressedText.length()),newString);
				}
			} else if (compressedText.length() == 1) {
				if (compressedText.charAt(0) == '1') {
					return newString;
				} else { 
					char digit = compressedText.charAt(0);
					digit--;
					
					newString += newString.charAt(newString.length()-1); 
					return decompress(Character.toString(digit),newString);
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

	public static String decompress(String compressedText) {
		return decompress(compressedText,"");
	}
}