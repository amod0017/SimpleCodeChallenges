/**
 * Complexity is O(n) where n is the length of the string.
 *
 * @author amod0
 */
public class Plaindrome {

	public static void main(final String[] args) {
		final String string = "aabbaa";
		System.out.println(isPlainDrome(string));
	}

	/**
	 * given an input string return whether it is a plaindrome or not.
	 *
	 * @param string
	 * @return
	 */
	private static boolean isPlainDrome(final String string) {
		final char[] myStringAsArray = string.toLowerCase().toCharArray();
		int left = 0;
		int right = myStringAsArray.length - 1;
		while (left <= right) {
			if (myStringAsArray[left] == myStringAsArray[right]) {
				left = left + 1;
				right = right - 1;
				continue;
			}
			return false;
		}
		return true;
	}

}
