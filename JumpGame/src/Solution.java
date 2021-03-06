/* 	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Determine if you are able to reach the last index.
	For example:
	A = [2,3,1,1,4], return true.
	A = [3,2,1,0,4], return false.
 */

public class Solution {
	public static void main(final String[] args) {
		final int[] a = new int[] { 2, 0, 0 };
		System.out.println(canJump(a));
	}

	public static boolean canJump(final int[] A) {
		if (A.length <= 1) {
			return true;
		}

		int max = A[0]; // max stands for the largest index that can be reached.

		for (int i = 0; i < A.length; i++) {
			// if not enough to go to next
			if ((max <= i) && (A[i] == 0)) {
				return false;
			}

			// update max
			if ((i + A[i]) > max) {
				max = i + A[i];
			}

			// max is enough to reach the end
			if (max >= (A.length - 1)) {
				return true;
			}
		}

		return false;
	}
}