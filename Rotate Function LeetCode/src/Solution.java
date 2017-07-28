public class Solution {
	public static int maxRotateFunction(final int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			final int rotationOutput = rotationFunction(i, A);
			if (rotationOutput > max) {
				max = rotationOutput;
			}
		}
		return max;
	}

	private static int rotationFunction(final int i, final int[] a) {
		int current = a.length - i;
		int result = 0;
		int count = 0;
		while (true) {
			if (count > (a.length - 1)) {
				break;
			}
			if (current == a.length) {
				current = 0;
			}
			result = result + (count * a[current]);
			current++;
			count++;
		}
		return result;
	}

	public static void main(final String[] args) {
		final int a[] = { -2147483648, -2147483648 };
		System.out.println(maxRotateFunction(a));
	}
}