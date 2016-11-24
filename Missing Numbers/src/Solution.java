import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
		final List<Integer> firstList = new ArrayList<>();
		getList(scanner, lengthOfFirstList, firstList);
		final int lengthOfSecondList = scanner.nextInt();
		final List<Integer> secondList = new ArrayList<>();
		getList(scanner, lengthOfSecondList, secondList);
		// System.out.println(firstList + " " + secondList);
		final int totalCountMissing = lengthOfSecondList - lengthOfFirstList;
		final Set<Integer> missingNumber = new TreeSet<>();
		Collections.sort(firstList);
		Collections.sort(secondList);
		int counterOfFirstList = 0;
		for (int i = 0; i < lengthOfSecondList; i++) {
			if (totalCountMissing == missingNumber.size()) {
				break;
			}
			if (counterOfFirstList < lengthOfFirstList) {
				if (firstList.get(counterOfFirstList).intValue() != secondList.get(i).intValue()) {
					missingNumber.add(secondList.get(i));
					counterOfFirstList--;
				}
			} else if (counterOfFirstList >= lengthOfFirstList) {
				missingNumber.add(secondList.get(i));
			}
			counterOfFirstList++;
		}

		for (final Integer number : missingNumber) {
			System.out.print(number + " ");
		}
	}

	private static void getList(final Scanner scanner, final int lengthOfList, final List<Integer> map) {
		// final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= lengthOfList; i++) {
			if (scanner.hasNextInt()) {
				final int number = scanner.nextInt();
				map.add(number);
			}
		}
	}
}