class FindValue {

	private static final char SEPARATOR = 0x20;
	private static final int MESSAGE_TYPE = 1;

	static void login() {

		System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");

	}

	public static void main(final String[] args) {

		login();

		final FindValue f = new FindValue();
		try {
			f.wait();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}