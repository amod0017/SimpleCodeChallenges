import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool
 * together dollars for ice cream. On any given day, the parlor offers a line of
 * flavors. Each flavor, , is numbered sequentially with a unique ID number from
 * to and has a cost, , associated with it.
 *
 * Given the value of and the cost of each flavor for trips to the Ice Cream
 * Parlor, help Sunny and Johnny choose two flavors such that they spend their
 * entire pool of money () during each visit. For each trip to the parlor, print
 * the ID numbers for the two types of ice cream that Sunny and Johnny purchase
 * as two space-separated integers on a new line. You must print the smaller ID
 * first and the larger ID second.
 *
 * Note: Two ice creams having unique IDs and may have the same cost (i.e., ).
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of trips to the ice
 * cream parlor. The subsequent lines describe all of Sunny and Johnny's trips
 * to the parlor; each trip is described as follows:
 *
 * The first line contains . The second line contains . The third line contains
 * space-separated integers denoting the cost of each respective flavor. The
 * integer corresponding to the cost, , for the ice cream with ID number (where
 * ). Constraints
 *
 * , where It is guaranteed that there will always be a unique solution. Output
 * Format
 *
 * Print two space-separated integers denoting the respective ID numbers for the
 * flavors they choose to purchase, where the smaller ID is printed first and
 * the larger ID is printed second. Recall that each ice cream flavor has a
 * unique ID number in the inclusive range from to .
 *
 * Sample Input
 *
 * 2 4 5 1 4 5 3 2 4 4 2 2 4 3 Sample Output
 *
 * 1 4 1 2 Explanation
 *
 * Sunny and Johnny make the following two trips to the parlor:
 *
 * The first time, they pool together dollars. There are five flavors available
 * that day and flavors and have a total cost of . Thus, we print 1 4 on a new
 * line. The second time, they pool together dollars. There are four flavors
 * available that day and flavors and have a total cost of . Thus, we print 1 2
 * on a new line.
 *
 * @author amod0
 *
 */
public class Solution {
	public static void main(final String[] args) {
		// first input is count of Trip
		final Scanner scanner = new Scanner(System.in);
		int numberOfTrips = scanner.nextInt();
		while (numberOfTrips != 0) {
			final int amountOfMoney = scanner.nextInt();
			int numberOfIcecreamFlavor = scanner.nextInt();
			final Map<Integer, Integer> iceCreamMap = new HashMap<>();
			int count = 1;
			while (numberOfIcecreamFlavor != 0) {
				iceCreamMap.put(count, scanner.nextInt());
				count++;
				numberOfIcecreamFlavor--;
			}
			Solution.printTheChosenIceCreamFlavour(amountOfMoney, iceCreamMap);

			//System.out.println(iceCreamMap);
			numberOfTrips--;
		}
		scanner.close();
	}

	private static void printTheChosenIceCreamFlavour(final int amountOfMoney,
			final Map<Integer, Integer> iceCreamMap) {
		final List<Integer> flavoursCost = new ArrayList<>(iceCreamMap.values());
		Collections.sort(flavoursCost);
		int moneyPool = amountOfMoney;
		int count = 1;
		while (moneyPool != 0) {
			moneyPool = moneyPool - 1;
			if (Collections.binarySearch(flavoursCost, moneyPool) >= 0) {
				if (Collections.binarySearch(flavoursCost, count) >= 0) {
					int keyFromByValue = getKeyFromByValue(iceCreamMap, count);
					if(moneyPool == count){
						iceCreamMap.remove(keyFromByValue);
					}
					int keyFromByValue2 = getKeyFromByValue(iceCreamMap, moneyPool);
					System.out.println(keyFromByValue + " "
							+ keyFromByValue2);
					break;
				}
			}
			count++;
		}
	}

	private static int getKeyFromByValue(Map<Integer, Integer> iceCreamMap, int value) {
		List<Integer> myKeys = new ArrayList<>(iceCreamMap.keySet());
		for (Integer key : myKeys) {
			if (iceCreamMap.get(key) == value)
				return key;
		}
		return 0;

	}
}
