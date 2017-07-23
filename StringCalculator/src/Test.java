import java.util.HashSet;
import java.util.Set;

/**
 * Calculator of String, just with one operation.
 * @author amod0
 *
 */
public class Test {
	public static void main(final String[] args) {
		final String exp = "234-23";
		final Set<Character> myOperators = new HashSet<>();
		myOperators.add('+');
		myOperators.add('-');
		myOperators.add('/');
		myOperators.add('*');
		char operator = ' ';
		for (final Character character : myOperators) {
			if (exp.contains(character.toString())) {
				operator = character;
			}
		}
		switch (operator) {
		case '+':
			final String[] myOperation = exp.split("\\+");
			final int a = Integer.parseInt(myOperation[0]);
			final int b = Integer.parseInt(myOperation[1]);
			System.out.println(a + b);
			break;
		case '*':
			final String[] myOperation3 = exp.split("\\*");
			final int a3 = Integer.parseInt(myOperation3[0]);
			final int b3 = Integer.parseInt(myOperation3[1]);
			System.out.println(a3 * b3);
			break;

		case '/':
			final String[] myOperation1 = exp.split("/");
			final int a1 = Integer.parseInt(myOperation1[0]);
			final int b1 = Integer.parseInt(myOperation1[1]);
			System.out.println(a1 / b1);
			break;
		case '-':
			final String[] myOperation2 = exp.split("-");
			final int a2 = Integer.parseInt(myOperation2[0]);
			final int b2 = Integer.parseInt(myOperation2[1]);
			System.out.println(a2 - b2);
			break;

		default:
			break;
		}
	}

}
