public class Solution {
	public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			final int tail = x % 10;
			result = (result * 10) + tail;
			if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) {
				return 0;
			}
			x = x / 10;
		}
		return (int) result;
	}
}