public class RepeatedCharacter {
	public static final String NUMERIC = "NUMERIC";
	public static final String ALPHA = "ALPHA";

	public char maxRepeating(final String input) {
		if(input.isEmpty()){
			return Character.MIN_VALUE;
		}
		final char[] inputString = input.toCharArray();
		final int inputLength = inputString.length;
		int maximumCount = 0;
		char maxRepeated = inputString[0];
		int currentCount = 1;
		for (int i = 0; i < inputLength; i++) {
			if ((i < (inputLength - 1)) && (inputString[i] == inputString[i + 1])) {
				currentCount++;
			} else {
				if (currentCount > maximumCount) {
					maximumCount = currentCount;
					maxRepeated = inputString[i];
				}
				currentCount = 1;
			}
		}
		return maxRepeated;
	}

	public String getType(final char c) {
		if (Character.isDigit(c)) {
			return NUMERIC;
		}
		return ALPHA;
	}

}
