public class Solution {
	public static String reverseWords(final String s) {
		String output = "";
		// s.replaceAll(" ", "")
		final String[] splitedInput = s.split(" ");
		for (int i = splitedInput.length - 1; i >= 0; i--) {
			if (!splitedInput[i].isEmpty()) {
				if (i != 0) {
					output = output + splitedInput[i] + " ";
				} else {
					output = output + splitedInput[i];
				}
			}
		}
		return output;
	}

	public static void main(final String[] args) {
		final String str = "I need a job";
		System.out.println(reverseWords(str));
	}

}