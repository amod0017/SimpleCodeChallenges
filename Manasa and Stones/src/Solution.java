import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		while (numberOfTestCases != 0) {
			final int numberOfStones = scanner.nextInt();
			final int a = scanner.nextInt();
			final int b = scanner.nextInt();
			final Set<Integer> myresult = new TreeSet<>();
			for (int i = 0, j = numberOfStones - 1; j >= 0; i++, j--) {
				myresult.add((j * b) + (i * a));
			}
			for (final Integer integer : myresult) {
				System.out.print(integer + " ");
			}
			System.out.println("");
			numberOfTestCases = numberOfTestCases - 1;
		}
		scanner.close();

	}
}