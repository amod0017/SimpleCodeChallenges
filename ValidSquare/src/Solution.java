
public class Solution {
	public double dist(final int[] p1, final int[] p2) {
		return ((p2[1] - p1[1]) * (p2[1] - p1[1])) + ((p2[0] - p1[0]) * (p2[0] - p1[0]));
	}

	public boolean check(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
		return (dist(p1, p2) > 0) && (dist(p1, p2) == dist(p2, p3)) && (dist(p2, p3) == dist(p3, p4))
				&& (dist(p3, p4) == dist(p4, p1)) && (dist(p1, p3) == dist(p2, p4));
	}

	public boolean validSquare(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
		return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
	}
}