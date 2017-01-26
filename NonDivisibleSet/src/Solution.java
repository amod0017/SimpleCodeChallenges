import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int totalNumber = scanner.nextInt();
		final int k = scanner.nextInt();
		final int[] set = new int[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
			set[i] = scanner.nextInt();
		}
		final Map<Integer, Integer> remaindersToValue = new HashMap<>();
		for (int i = 0; i < set.length; i++) {
			set[i] = set[i] % k;
			remaindersToValue.compute(set[i], (key, value) -> ((value == null) || (key == 0)) ? 1 : (value + 1));
		}
		int numberOfSubset = remaindersToValue.getOrDefault(0, 0);
		int i = 1;
		for (; (i * 2) < k; i++) {
			numberOfSubset = numberOfSubset
					+ Math.max(remaindersToValue.getOrDefault(i, 0), remaindersToValue.getOrDefault(k - i, 0));
		}
		if ((i * 2) == k) {
			numberOfSubset = numberOfSubset + 1;
		}
		System.out.println(numberOfSubset);
		scanner.close();
	}
}