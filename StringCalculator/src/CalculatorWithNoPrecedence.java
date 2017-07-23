import java.util.Stack;

public class CalculatorWithNoPrecedence {
	public static void main(final String[] args) {
		final String input = "14/7*7";
		final char[] myExperssion = input.toCharArray();
		final Stack<Integer> myOperands = new Stack<>();
		char operator = ' ';
		for (int i = 0; i < myExperssion.length; i++) {
			if ((myExperssion[i] >= '0') && (myExperssion[i] <= '9')) {
				// integer
				String str = "";
				while ((i < myExperssion.length) && (myExperssion[i] >= '0') && (myExperssion[i] <= '9')) {
					str = str + myExperssion[i];
					i = i + 1;
				}
				myOperands.push(Integer.parseInt(str));
				if ((myOperands.size() == 2) && (operator != ' ')) {
					myOperands.push(doOperation(myOperands.pop(), myOperands.pop(), operator));
				}
				i = i - 1;
			} else if ((myExperssion[i] == '+') || (myExperssion[i] == '-') || (myExperssion[i] == '*')
					|| (myExperssion[i] == '/')) {
				operator = myExperssion[i];
			}

		}
		if (myOperands.size() > 1) {
			System.out.println("edefrf ");
		} else {
			System.out.println(myOperands.pop());
		}
	}

	private static int doOperation(final Integer a, final Integer b, final char operator) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return b / a;
		}
		return 0;
	}

}
