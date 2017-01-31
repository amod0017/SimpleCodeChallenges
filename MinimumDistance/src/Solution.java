import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		final Map<Integer, List<Integer>> myCountMap = new HashMap<>();
		final Set<Integer> distances = new TreeSet<>();
		final int inputArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i] = in.nextInt();
			if (myCountMap.containsKey(inputArray[i])) {
				final List<Integer> list = myCountMap.get(inputArray[i]);
				list.add(i);
				// System.out.println(list);
			} else {
				final List<Integer> list = new ArrayList<>();
				list.add(i);
				myCountMap.put(inputArray[i], list);
			}
		}
		for (final int i : myCountMap.keySet()) {
			final List<Integer> list = myCountMap.get(i);
			if (list.size() == 1) {
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				final int a = list.get(j);
				if ((j + 1) >= list.size()) {
					break;
				}
				final int b = list.get(j + 1);
				distances.add(Math.abs(b - a));
			}
		}

		if (distances.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(new ArrayList<>(distances).get(0));
		}
		// System.out.println(distances);
		in.close();
	}
}
