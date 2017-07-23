
public class SG {

	public static void main(final String[] args) {
		final int[] arr = { 1, 1, 1, 2, 2, 2, 3 };
		int result = 0;

		for (final int a : arr) {
			System.out.println(Integer.toBinaryString(a));

			result ^= a;
		}
		System.out.println(result);
	}

}
