
public class Test {

	public static int[] product(final int[] input) {
		final int[] output = new int[input.length];
		int product = 1;
		for (final int i : input) {
			product = product * i;
		}

		for (int j = 0; j < input.length; j++) {
			output[j] = product / input[j];
		}
		return output;

	}


	public static void main(final String[] args) {
		final int[] a = new int[] { 3, 1, 6, 4 };
		final int[] b = Test.product(a);
		for (final int i : b) {
			System.out.println(i);
		}
		System.out.println();

	}

}
