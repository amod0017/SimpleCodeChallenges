import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int fourSumCount(final int[] A, final int[] B, final int[] C, final int[] D) {
		final Map<Integer, Integer> mapAB = new HashMap<>();
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (!mapAB.containsKey(A[i] + B[j])) {
					mapAB.put(A[i] + B[j], 1);
				} else {
					mapAB.put(A[i] + B[j], mapAB.get(A[i] + B[j]) + 1);
				}
			}
		}

		for (final int element : C) {
			for (final int element2 : D) {
				final int sum = -1*(element+element2);
				if(mapAB.containsKey(sum)){
					result += mapAB.get(sum);
				}
			}
		}

		return result;
	}
}