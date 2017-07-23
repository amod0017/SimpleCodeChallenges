import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		final Scanner stdin = new Scanner(System.in);
		final int tests = stdin.nextInt();
		for (int i = 0; i < tests; i++) {
			int length = stdin.nextInt();
			final long[] arr = new long[length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = stdin.nextLong();
			}
			Arrays.sort(arr);
			long result = 1;
			for (int j = arr.length - 1; j >= 0; j--) {
				long diff = length - arr[j];
				if (diff < 0) {
					diff = 0;
				}
				result *= diff;
				result %= 1000000007;
				length -= 1;
			}
			System.out.println(result);
		}
		stdin.close();
	}
}