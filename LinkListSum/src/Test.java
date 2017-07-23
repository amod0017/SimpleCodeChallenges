import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(final String[] args) {
		final List<List<String>> parts = new ArrayList<>();
		final List<String> l1 = new ArrayList<>();
		l1.add("a");
		l1.add("a2");
		l1.add("a3");
		l1.add("a4");

		final List<String> l2 = new ArrayList<>();
		l2.add("a5");
		l2.add("a6");
		l2.add("a7");
		l2.add("a8");

		final List<String> l3 = new ArrayList<>();
		l3.add("a9");
		l3.add("a10");
		l3.add("a11");
		l3.add("a12");

		final List<String> list = new ArrayList<>();
		list.add("a13");
		list.add("a14");
		list.add("a15");

		parts.add(l1);
		parts.add(l2);
		parts.add(l3);
		parts.add(list);

		int loopNumber = 0;
		while (!parts.isEmpty()) {
			System.out.println("Loop" + loopNumber);
			parts.remove(0);
			loopNumber++;
			System.out.println(parts);
		}

	}
}
