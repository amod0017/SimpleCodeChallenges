import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given a list of unsorted integers, , can you find the pair of elements that
 * have the smallest absolute difference between them? If there are multiple
 * pairs, find them all.
 * @author amod0
 *
 */

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int lengthOfTheList = scanner.nextInt();
		final List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < lengthOfTheList; i++) {
			final int integer = scanner.nextInt();
			myList.add(integer);
		}
		Collections.sort(myList);
		// System.out.println(myList);
		final List<Integer> myPairs = new ArrayList<>();
		for (int i = 0; i < lengthOfTheList - 1; i++) {
			final int firstInt = myList.get(i);
			final int secondInt = myList.get(i + 1);
			final int currentDifference = Math.abs(secondInt - firstInt);
			if (i == 0) {
				myPairs.add(firstInt);
				myPairs.add(secondInt); // considering this is the ideal
				// solution.
				continue;
			}
			final int bestDifference = Math.abs(myPairs.get(0) - myPairs.get(1));
			if (currentDifference < bestDifference) {
				myPairs.clear();
				myPairs.add(myList.get(i));
				myPairs.add(myList.get(i + 1));
			} else if (currentDifference == bestDifference) {
				myPairs.add(myList.get(i));
				myPairs.add(myList.get(i + 1));
			}
		}
		for (final Object element : myPairs) {
			final Integer integer = (Integer) element;
			System.out.print(integer + " ");
		}
		scanner.close();
	}
}