import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final String operation = scan.nextLine();
		System.out.println(operation);
		final Stack<Character> operators = new Stack<>();
		final Stack<Integer> value = new Stack<>();
		final Set<Character> myOperators = new HashSet<>();
		myOperators.add('+');
		myOperators.add('-');
		myOperators.add('/');
		myOperators.add('*');
		myOperators.add('(');
		myOperators.add(')');
		final char[] myOperationArray = operation.toCharArray();
		// System.out.println(myOperationArray);
		for (int i = 0; i < myOperationArray.length; i++) {
			if (myOperationArray[i] == ' ') {
				continue;
			} else if (myOperators.contains(myOperationArray[i])) {
				operators.push(myOperationArray[i]);
			} else if ((myOperationArray[i] >= '0') && (myOperationArray[i] <= '9')) {
				String str = "";
				while ((i < myOperationArray.length)
						&& ((myOperationArray[i] >= '0') && (myOperationArray[i] <= '9'))) {
					str = str + myOperationArray[i];
					i = i + 1;
				}
				// System.out.println(str);
				i = i - 1;
				value.push(Integer.parseInt(str));
			}
		}
		System.out.println(operators);
		System.out.println(value);
		scan.close();

	}

}
