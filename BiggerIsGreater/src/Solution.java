import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int testCases = scanner.nextInt();

		for (int cases = 0; cases < testCases; cases++) {
			final String inputString = scanner.next();
			final char[] inputStringArray = inputString.toCharArray();
			if (inputString.length() == 1) {
				System.out.println("no answer");
				continue;
			}
			int i;
			for (i = inputString.length() - 1; i > 0; i--) {
				if (inputStringArray[i] > inputStringArray[i - 1]) {
					// if (i == (inputString.length() - 1)) {
					i--;
					// }
					break;
				}
			}
			if ((i == 0) && (inputStringArray[i] >= inputStringArray[i + 1])) {
				System.out.println("no answer");
				continue;
			}
			for (int j = inputString.length() - 1; j >= i; j--) {
				if (inputStringArray[i] < inputStringArray[j]) {
					final char temp = inputStringArray[i];
					inputStringArray[i] = inputStringArray[j];
					inputStringArray[j] = temp;
					break;
				}
			}
			int k = inputStringArray.length - 1;
			for (int j = i + 1; j < inputStringArray.length; j++) {
				if (j >= k) {
					break;
				}
				final char temp = inputStringArray[j];
				inputStringArray[j] = inputStringArray[k];
				inputStringArray[k] = temp;
				k = k - 1;
			}
			if (!inputString.equals(new String(inputStringArray))) {
				System.out.println(new String(inputStringArray));
			} else {
				System.out.println("no answer");
			}
		}

		scanner.close();
	}
}