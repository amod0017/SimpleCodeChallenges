import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		int numberOfTestCases = scan.nextInt();
		while (numberOfTestCases != 0) {
			final int startingNumber = scan.nextInt();
			final int endingNumber = scan.nextInt();
			final double numberOfSquare = (Math.floor(Math.sqrt(endingNumber)) - Math.ceil(Math.sqrt(startingNumber)))
					+ 1;
			System.out.println(Double.valueOf(numberOfSquare).intValue());
			numberOfTestCases = numberOfTestCases - 1;
		}
		scan.close();
	}
}