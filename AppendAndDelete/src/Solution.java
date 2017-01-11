import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.next();
		String tString = in.next();
		int k = in.nextInt();
		if (string.equals(tString)) {
			int output = string.length() * 2 + 1;
			if (output == k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else if (string.length() > tString.length()) {
			char[] stringArray = string.toCharArray();
			char[] tStringArray = tString.toCharArray();
			getoutPut(k, stringArray, tStringArray);
		} else if (string.length() < tString.length()) {
			char[] stringArray = string.toCharArray();
			char[] tStringArray = tString.toCharArray();
			getoutPut(k, tStringArray, stringArray);
		} else {
			char[] stringArray = string.toCharArray();
			char[] tStringArray = tString.toCharArray();
			getoutPut(k, stringArray, tStringArray);
		}
	}

	private static void getoutPut(int k, char[] stringArray, char[] tStringArray) {
		int count;
		for (count = 0; count < tStringArray.length; count++) {
			if (tStringArray[count] != stringArray[count]) {
				break;
			}
		}
		int output = 0;
		output = (stringArray.length - (count)) + (tStringArray.length - (count));
		// System.out.println(output);
		if (new String(stringArray).contains(new String(tStringArray))) {
			output = output + 2;
			if (output == k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else if (count != 0) {
			if (output == k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else {
			output = output + 3;
			if (output == k) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
