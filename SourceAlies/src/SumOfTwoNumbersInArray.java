import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbersInArray {

	public static void main(final String[] args) {
		final int[] a = new int[10];
		a[0] = 18;
		a[1] = 11;
		a[2] = 21;
		a[3] = 28;
		a[4] = 31;
		a[5] = 38;
		a[6] = 40;
		a[7] = 55;
		a[8] = 60;
		a[9] = 62;
		System.out.println(isSumPossible(a, 66));

	}

	static int isSumPossible(final int[] a, final int N) {
		final Map<Integer, Boolean> numberPresent = new HashMap<>();

		for (final int element : a) {
			final int temp = N - element;
			if ((temp >= 0) && numberPresent.containsKey(temp)) {
				return 1;
			}
			numberPresent.put(element, true);
		}

		return 0;
	}
}
