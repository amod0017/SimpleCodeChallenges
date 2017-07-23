public class MostVisitedSprint {
	public static void main(final String[] args) {
		final int[] sprints = new int[4];
		sprints[0] = 9;
		sprints[1] = 7;
		sprints[2] = 3;
		sprints[3] = 1;

		System.out.println(getMostVisited(9, sprints));
	}

	static int getMostVisited(final int n, final int[] sprints) {
		// final int[] sprintsCopy = sprints.clone();
		// Arrays.sort(sprintsCopy);
		// final int maxSprint = sprintsCopy[sprintsCopy.length - 1];
		final int[] positionCount = new int[n];
		int start = sprints[0] - 1;
		for (int i = 1; i < sprints.length; i++) {
			final int end = sprints[i] - 1;
			// if (start < end) {
			while (start <= end) {
				positionCount[start - 1] = positionCount[start - 1] + 1;
				start++;
			}
			start = end - 1;
			// } else {
			// while (start >= end) {
			// positionCount[start - 1] = positionCount[start - 1] + 1;
			// start--;
			// }
			// start++;
			// }

		}

		return getIndex(positionCount) + 1;

	}

	private static int getIndex(final int[] positionCount) {
		int maxIndex = 0;
		for (int i = 1; i < positionCount.length; i++) {
			final int newnumber = positionCount[i];
			if ((newnumber > positionCount[maxIndex])) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
