import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * You are given sticks, where the length of each stick is a positive integer. A
 * cut operation is performed on the sticks such that all of them are reduced by
 * the length of the smallest stick.
 *
 * Suppose we have six sticks of the following lengths:
 *
 * 5 4 4 2 2 8 Then, in one cut operation we make a cut of length 2 from each of
 * the six sticks. For the next cut operation four sticks are left (of non-zero
 * length), whose lengths are the following:
 *
 * 3 2 2 6 The above step is repeated until no sticks are left.
 *
 * Given the length of sticks, print the number of sticks that are left before
 * each subsequent cut operations.
 *
 * Note: For each cut operation, you have to recalcuate the length of smallest
 * sticks (excluding zero-length sticks).
 *
 * Input Format The first line contains a single integer . The next line
 * contains integers: a0, a1,...aN-1 separated by space, where represents the
 * length of the stick.
 *
 * Output Format For each operation, print the number of sticks that are cut, on
 * separate lines.
 *
 * @author amod0
 *
 */
public class Solution {
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final List<Integer> sticks = new ArrayList<>();
		final int numberOfSticks = scanner.nextInt();
		for (int i = 0; i < numberOfSticks; i++) {
			final int stickLength = scanner.nextInt();
			sticks.add(stickLength);
		}
		Collections.sort(sticks);
		while (!sticks.isEmpty()) {
			int count = 0;
			sticks.removeAll(Collections.singleton(0));
			if (!sticks.isEmpty()) {
				final int smallestSize = sticks.get(0);
				for (final ListIterator<Integer> iterator = sticks.listIterator(); iterator.hasNext();) {
					final Integer integer = iterator.next();
					iterator.set(integer - smallestSize);
					count = count + 1;
				}
				System.out.println(count);
			}

		}
		scanner.close();
	}

}
