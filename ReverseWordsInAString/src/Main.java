public class Main {

	public static void main(final String[] args) {
		final int[] nums = { 5, 2, 3, 4, 5, 6 };
		final int res = checkArray(nums, 0, nums.length - 1);
		System.out.println("res = " + res);
	}

	public static int checkArray(final int[] nums, final int start, final int end) {
		if ((end - start) < 2) {
			return end;
		} else {
			final int middle = (start + end) / 2;
			final int a = nums[start];
			final int b = nums[middle];
			if ((b - a) != (middle - start)) {
				return checkArray(nums, start, middle);
			} else {
				return checkArray(nums, middle, end);
			}
		}
	}
}