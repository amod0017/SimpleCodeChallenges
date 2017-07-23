import java.util.Stack;

public class Braces {
	public static void main(final String[] args) {
		final String s = "[[]]";
		System.out.println(isBalanced(s));
	}

	static String[] braces(final String[] values) {
		final String[] output = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			if (isBalanced(values[i])) {
				output[i] = "YES";
			} else {
				output[i] = "NO";
			}
		}
		return output;

	}

	private static boolean isBalanced(final String input) {
		final Stack<String> stack = new Stack<String>();
		boolean isBalanaced = false;

		for (int i = 0; i < input.length(); i++) {
			final String str = "" + input.charAt(i);
			if (str.equals("(") || str.equals("[") || str.equals("{")) {
				stack.push(str);
			}
			if (str.equals(")") || str.equals("]") || str.equals("}")) {
				if (stack.isEmpty()) {
					return false;
				}
				final String opening = stack.peek();
				if (str.equals(")") && opening.equals("(")) {
					stack.pop();
				}
				if (str.equals("]") && opening.equals("[")) {
					stack.pop();
				}
				if (str.equals("}") && opening.equals("{")) {
					stack.pop();
				}
			}
		}
		if ((input.length() > 0) && stack.isEmpty()) {
			isBalanaced = true;
		}
		return isBalanaced;
	}

}
