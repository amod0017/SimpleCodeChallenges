import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		while (numberOfTestCases != 0) {
			String string1 = scanner.next();
			String string2 = scanner.next();
			// final List<Character> myString1List =
			// convertCharArrayToList(string1);
			// final List<Character> myString2List =
			// convertCharArrayToList(string2);
			String string = "";
			final int max = string1.length() + string2.length();
			for (int i = 0; i < max; i++) {
				if (string1.isEmpty()) {
					string = string + string2;
					break;
				} else if (string2.isEmpty()) {
					string = string + string1;
					break;
				} else {
					if (string1.charAt(0) < string2.charAt(0)) {
						string = string + string1.charAt(0);
						string1 = string1.substring(1);
					} else {
						string = string + string2.charAt(0);
						string2 = string2.substring(1);
					}
				}
			}
			System.out.println(string);
			numberOfTestCases = numberOfTestCases - 1;
		}

		scanner.close();
	}
}