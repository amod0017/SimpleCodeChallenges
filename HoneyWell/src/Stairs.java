class Stairs {
	static int fib(final int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	static long get_ways(final int n) {
		if (n == 1) {
			return 1;
		}
		long first = 1;
		long second = 2;
		for (int i = 3; i <= n; i++) {
			final long third = first + second;
			first = second;
			second = third;
		}
		return second % 1000000007;

	}

	public static void main(final String args[]) {
		final int s = 50;
		System.out.println("Number of ways = " + get_ways(s));
	}

}