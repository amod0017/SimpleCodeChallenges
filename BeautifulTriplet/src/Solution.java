import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int sizeOfArray = scanner.nextInt();
		final int beautifulDistance = scanner.nextInt();
		final int[] array = new int[sizeOfArray];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		int totalCount = 0;
		for (int i = 0; i < array.length; i++) {
			int next1 = array[i] + beautifulDistance;
			final int next2 = next1 + beautifulDistance;
			int count = 0;
			for (int j = i; j < array.length; j++) {
				if (array[j] > next1) {
					break;
				}
				if (next1 == array[j]) {
					count = count + 1;
					next1 = next2;
					// continue;
				}
				if (count == 2) {
					totalCount = totalCount + 1;
					break;
				}

			}

		}
		System.out.println(totalCount);
		scanner.close();
	}

}