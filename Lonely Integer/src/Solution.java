import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Consider an array of integers ,A , where all but one of the integers occur in
 * pairs. In other words, every element in occurs exactly twice except for one
 * unique element.
 *
 * Given A, find and print the unique element.
 *
 * @author amod0
 *
 */
public class Solution {
	private static int lonelyInteger(final List<Integer> myList, final int sizeOfList) {
		Collections.sort(myList);
		if (sizeOfList == 1) {
			return myList.get(sizeOfList - 1);
		}
		for (int i = 0; i < sizeOfList - 1; i = i + 2) {
			if (myList.get(i).intValue() != myList.get(i + 1).intValue()) {
				return myList.get(i);
			}
		}
		return myList.get(sizeOfList - 1);

	}

	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		final List<Integer> myList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			myList.add(in.nextInt());
		}
		System.out.println(lonelyInteger(myList, n));
		in.close();
	}

}
