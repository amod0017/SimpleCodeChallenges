public class Test {
	public static void main(final String[] args) {
		final String s1 = "FB";

		final String s2 = "Ea";

		System.out.println(s1.equals(s2));

		System.out.println("FB  " + "FB".hashCode());

		System.out.println("Ea  " + "Ea".hashCode());
		final MySet set = new MySet();
		set.add(s1);
		System.out.println(set.size());
		set.add("a");
		System.out.println(set.size());
		set.add(s2);
		System.out.println(set.size());
		set.add(s1);
		System.out.println(set.size());
		System.out.println(set.contains("FBx"));

	}
}
