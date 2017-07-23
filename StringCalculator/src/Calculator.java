import java.util.Stack;

public class Calculator {
	public static int calculate(final String expression) {
		final char[] tokens = expression.toCharArray();
		// Stack for numbers: 'values'
		final Stack<Integer> values = new Stack<Integer>();
		// Stack for Operators: 'operations'
		final Stack<Character> operations = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ') {
				continue;
			}
			// Current token is a number, push it to stack for numbers
			if ((tokens[i] >= '0') && (tokens[i] <= '9')) {
				String str = "";
				// There may be more than one digits in number
				while ((i < tokens.length) && (tokens[i] >= '0') && (tokens[i] <= '9')) {
					str = str + tokens[i];
					i = i + 1;
				}
				values.push(Integer.parseInt(str));
				i--;
			}
			// Current token is an opening brace, push it to 'ops'
			else if (tokens[i] == '(') {
				operations.push(tokens[i]);
			} else if (tokens[i] == ')') {
				while (operations.peek() != '(') {
					values.push(doOperation(operations.pop(), values.pop(), values.pop()));
				}
				operations.pop();
			}
			// Current token is an operator.
			else if ((tokens[i] == '+') || (tokens[i] == '-') || (tokens[i] == '*') || (tokens[i] == '/')) {
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!operations.empty() && hasPrecedence(tokens[i], operations.peek())) {
					values.push(doOperation(operations.pop(), values.pop(), values.pop()));
				}
				// Push current token to 'ops'.
				operations.push(tokens[i]);
			}
		}
		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!operations.empty()) {
			values.push(doOperation(operations.pop(), values.pop(), values.pop()));
		}
		// Top of 'values' contains result, return it
		return values.pop();
	}
	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(final char op1, final char op2) {
		if ((op2 == '(') || (op2 == ')')) {
			return false;
		}
		if (((op1 == '*') || (op1 == '/')) && ((op2 == '+') || (op2 == '-'))) {
			return false;
		} else {
			return true;
		}
	}
	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static int doOperation(final char op, final int b, final int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}
	// Driver method to test above methods
	public static void main(final String[] args) {
		// System.out.println(Calculator.evaluate("10 + 2 * 6"));
		// System.out.println(Calculator.evaluate("100 * 2 + 12"));
		// System.out.println(Calculator.evaluate("100 * ( 2 + 12 )"));
		System.out.println(Calculator.calculate("2 + 3 - 7 * ( 14 / 7)"));
	}
}
