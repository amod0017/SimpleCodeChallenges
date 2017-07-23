import java.math.BigInteger;

public class Solution {
	public static boolean isAdditiveNumber(final String num) {
		final int n = num.length();
		for (int i = 1; i <= (n / 2); ++i) {
			for (int j = 1; Math.max(j, i) <= (n - i - j); ++j) {
				if (isValid(i, j, num)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isValid(final int i, final int j, final String num) {
		if ((num.charAt(0) == '0') && (i > 1)) {
			return false;
		}
		if ((num.charAt(i) == '0') && (j > 1)) {
			return false;
		}
		String sum;
		BigInteger x1 = new BigInteger(num.substring(0, i));
		BigInteger x2 = new BigInteger(num.substring(i, i + j));
		for (int start = i + j; start != num.length(); start += sum.length()) {
			x2 = x2.add(x1);
			x1 = x2.subtract(x1);
			sum = x2.toString();
			if (!num.startsWith(sum, start)) {
				return false;
			}
		}
		return true;
	}

	public static void main(final String[] args) {
		final String s = "199100199";
		System.out.println(isAdditiveNumber(s));
	}
}
