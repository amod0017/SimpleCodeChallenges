import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final double lowerValue = scanner.nextInt();
		final double upperValue = scanner.nextInt();
		final List<Double> kapekarNumbers = new ArrayList<>();
		for (double i = lowerValue; i <= upperValue; i++) {
			if (isKapekarNumber(i)) {
				kapekarNumbers.add(i);
			}
		}
		if (!kapekarNumbers.isEmpty()) {
			for (final Double double1 : kapekarNumbers) {
				System.out.print((int) Math.floor(double1) + " ");
			}
		} else {
			System.out.println("INVALID RANGE");
		}
		scanner.close();
	}

	private static boolean isKapekarNumber(final double i) {
		final double squareOfNumb = i * i;
		double q = 1;
		double r = 0;
		double d = 10;
		while (q != 0) {
			q = Math.floor(squareOfNumb / d);
			r = squareOfNumb % d;
			if (((q + r) == i) && (r != 0)) {
				return true;
			}
			d = d * 10;
		}

		return false;
	}
}