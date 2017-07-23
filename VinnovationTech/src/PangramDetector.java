public class PangramDetector {
	final char[] alphabets = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public String findMissingLetters(final String sentence) {
		if ((sentence == null) || sentence.isEmpty()) {
			return String.copyValueOf(alphabets);
		}
		final StringBuilder missingLetters = new StringBuilder();
		for (final char letter : alphabets) {
			if (sentence.toLowerCase().indexOf(letter) == -1) {
				missingLetters.append(letter);
			}
		}
		return missingLetters.toString();

	}
}
