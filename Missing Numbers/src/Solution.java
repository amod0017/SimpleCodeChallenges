import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Numeros, the Artist, had two lists A and B, such that B was a permutation of
 * A . Numeros was very proud of these lists. Unfortunately, while transporting
 * them from one exhibition to another, some numbers were left out of . Can you
 * find the missing numbers?
 *
 * @author amod0
 *
 */
public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int lengthOfFirstList = scanner.nextInt();
		final Map<Integer, Integer> firstListToCount = new HashMap<>();
		getList(scanner, lengthOfFirstList, firstListToCount);
		final int lengthOfSecondList = scanner.nextInt();
		final Map<Integer, Integer> secondListToCount = new HashMap<>();
		getList(scanner, lengthOfSecondList, secondListToCount);
		// System.out.println(firstListToCount + " " + secondListToCount);
	}

	private static void getList(final Scanner scanner, final int lengthOfFirstList,
			final Map<Integer, Integer> map) {
		// final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= lengthOfFirstList; i++) {
			if (scanner.hasNextInt()) {
				final int number = scanner.nextInt();
				if (map.containsKey(number)) {
					final int value = map.get(number);
					map.put(number, value + 1);
				} else {
					map.put(number, 1);
				}
			}
		}
	}
}