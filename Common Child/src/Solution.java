import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final String string1 = scanner.next();
		final String string2 = scanner.next();
		final char[] s1 = string1.toCharArray();
		final char[] s2 = string2.toCharArray();
		final int[][] dp = new int[string2.length() + 1][string1.length() + 1];
		for (int i = 0; i < (string2.length() + 1); i++) {
			for (int j = 0; j < (string1.length() + 1); j++) {
				if ((i == 0) || (j == 0)) {
					dp[i][j] = 0;
				} else if (s2[i - 1] == s1[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[string2.length()][string1.length()]);
		scanner.close();

	}
}