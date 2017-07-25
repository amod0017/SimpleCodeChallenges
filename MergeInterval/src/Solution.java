import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> merge(final List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return Collections.emptyList();
		}
		intervals.sort((interval1, interval2) -> Integer.compare(interval1.start, interval2.start));
		final List<Interval> mergedInterval = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (final Interval interval : intervals) {
			if (end >= interval.start) {
				end = Math.max(interval.end, end);
			} else {
				mergedInterval.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// time limit exceed.
		// for (int i = 0; i < intervals.size(); i++) {
		// if (end >= intervals.get(i).start) {
		// end = Math.max(intervals.get(i).end, end);
		// } else {
		// mergedInterval.add(new Interval(start, end));
		// start = intervals.get(i).start;
		// end = intervals.get(i).end;
		// }
		// }
		mergedInterval.add(new Interval(start, end));
		return mergedInterval;
	}

	// public static void main(String[] args) {
	// List<Interval> l1
	// }
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(final int s, final int e) {
		start = s;
		end = e;
	}
}