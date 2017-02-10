import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		while (numberOfTestCases != 0) {
			final String inputString = scanner.next();
			int count = 0;
			int mapCount = 0;
			if ((inputString.length() % 2) != 0) {
				System.out.println(-1);
				numberOfTestCases = numberOfTestCases - 1;
				continue;
			}
			final char[] string1 = inputString.substring(0, inputString.length() / 2).toCharArray();
			final char[] string2 = inputString.substring(inputString.length() / 2).toCharArray();
			final SortedMap<Character, Integer> myMap = new TreeMap<>();
			for (final char c : string1) {
				if(myMap.containsKey(c)){
					final Integer value = myMap.get(c);
					myMap.put(c, value.intValue()+1);
				} else {
					myMap.put(c, 1);
				}
			}
			for (final char c : string2) {
				if (myMap.containsKey(c)) {
					final int value = myMap.get(c);
					if (value != 0) {
						myMap.put(c, value - 1);
					} else {
						myMap.remove(c);
					}
				}
				count = count + 1;
			}
			for (final int value : myMap.values()) {
				mapCount = mapCount + value;
			}
			System.out.println(Math.min(mapCount, count));
			numberOfTestCases = numberOfTestCases - 1;
		}
		scanner.close();
	}
}