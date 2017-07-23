import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assumption: input only contains unique element. Complexity: O(nLogn) since we
 * are sorting the array.
 * 
 * @author amod0
 *
 */
public class ComplementaryPairs {


	private static List<Integer> findKCompliment(final int k, final int[] input) {

		final List<Integer> result = new ArrayList<>();

		if ((input == null) || (input.length < 2)) {
			return result;
		}

		Arrays.sort(input);

		int left = 0;
		int right = input.length - 1;

		while (left < right) {
			final int currentSume = input[left] + input[right];

			if (currentSume == k) {
				// we got the pair, check for others
				result.add(input[left]);
				left++;
				right--;
			} else if (currentSume > k) {
				// smallest and largest are making sum larger hence we need to
				// reduce largest to get an appropriate pair
				right--;
			} else {
				// smallest and largest sum is still smaller than k hence we
				// need to increase smallest
				left++;
			}
		}

		return result;
	}

	public static void main(final String[] args) {

		final int[] inputArray = new int[] { 4, -5, -1, 8, -2, 15, 3, 9, 17 };
		final int k = 12;

		final List<Integer> result = findKCompliment(k, inputArray);

		if (!result.isEmpty()) {
			for (final Integer number : result) {
				System.out.println("(" + number + "," + new Integer(k - number) + ")");
			}
		} else {
			System.out.println("There are no k compliment pairs in the given input");
		}
	}
}