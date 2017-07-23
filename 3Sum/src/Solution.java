import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Given an array S of n integers, are
 * there elements a, b, c in S such that
 * a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 */
/**
 * @author amod0
 */
public class Solution {
	public static void main(final String[] args) {
		final int[] input = new int[] { -2, 0, 1, 1, 2 };
		System.out.println(threeSum(input));
	}

	public static List<List<Integer>> threeSum(final int[] nums) {
		final Set<List<Integer>> triplets = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				if ((nums[i] + nums[left] + nums[right]) < 0) {
					left++;
				} else if ((nums[i] + nums[left] + nums[right]) > 0) {
					right--;
				} else {
					final List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[left]);
					triplet.add(nums[right]);
					triplets.add(triplet);
					left++;
					right--;
				}
			}
		}

		return new ArrayList<>(triplets);
	}

}
