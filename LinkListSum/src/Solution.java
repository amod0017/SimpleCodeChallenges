import java.util.Stack;

public class Solution {
	public static void main(final String[] args) {
		final ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		final ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		final ListNode a = addTwoNumbers(l1, l2);
		ListNode current = a;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}

		final Long i = Long.parseLong("033999999999");

	}
	public ListNode addTwoNumbers1(final ListNode l1, final ListNode l2) {
		ListNode currentOfL1 = l1;
		ListNode currentOfL2 = l2;
		ListNode newList = null;
		ListNode currentOfNewList = newList;
		int val1 = 0;
		int val2 = 0;
		int sum = 0;
		int carry = 0;
		int lastCarry = 0;
		while ((currentOfL1 != null) || (currentOfL2 != null)) {
			if (currentOfL1 != null) {
				val1 = currentOfL1.val;
			}
			if (currentOfL2 != null) {
				val2 = currentOfL2.val;
			}
			lastCarry = carry;
			sum = val1 + val2 + lastCarry;
			if (sum >= 10) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			if (currentOfNewList != null) {
				currentOfNewList.next = new ListNode(sum);
				currentOfNewList = currentOfNewList.next;
			} else if (currentOfNewList == null) {
				currentOfNewList = new ListNode(sum);
				newList = currentOfNewList;
			}
			if (currentOfL1 != null) {
				currentOfL1 = currentOfL1.next;
			}

			if (currentOfL2 != null) {
				currentOfL2 = currentOfL2.next;
			}

			sum = 0;
			lastCarry = 0;
			val1 = 0;
			val2 = 0;
		}

		if (carry != 0) {
			currentOfNewList.next = new ListNode(carry);
		}
		return newList;
	}

	public static ListNode addTwoNumbersWithoutStacks(final ListNode l1, final ListNode l2) {
		ListNode currentOfL1 = l1;
		ListNode currentOfL2 = l2;
		ListNode newList = null;
		String l1Number = "0";
		String l2Number = "0";

		while (currentOfL1 != null) {
			l1Number = l1Number + Integer.toString(currentOfL1.val);
			currentOfL1= currentOfL1.next;
		}

		while (currentOfL2 != null) {
			l2Number = l2Number + Integer.toString(currentOfL2.val);
			currentOfL2 = currentOfL2.next;
		}

		// add two numbers
		final Long finalNumber = Long.parseLong(l2Number) + Long.parseLong(l1Number);
		if (finalNumber != 0) {
			final char[] a = finalNumber.toString().toCharArray();
			newList = new ListNode(a[0] - 48);
			ListNode current = newList;
			for (int i = 1; i < a.length; i++) {
				current.next = new ListNode(a[i] - 48);
				current = current.next;
			}
		}

		System.out.println(finalNumber.toString());

		return newList;

	}

	public static ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		final Stack<Integer> stack1 = new Stack<>();
		final Stack<Integer> stack2 = new Stack<>();
		final Stack<Integer> result = new Stack<>();
		ListNode currentOfL1 = l1;
		ListNode currentOfL2 = l2;
		final ListNode newList = null;
		final ListNode currentOfNewList = newList;
		while (currentOfL1 != null) {
			stack1.push(currentOfL1.val);
			currentOfL1 = currentOfL1.next;
		}
		while (currentOfL2 != null) {
			stack2.push(currentOfL2.val);
			currentOfL2 = currentOfL2.next;
		}

		int sum = 0;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int val1 = 0;
			int val2 = 0;
			if (!stack1.isEmpty()) {
				val1 = stack1.pop();
			}
			if (!stack2.isEmpty()) {
				val2 = stack2.pop();
			}

			sum = val1 + val2 + carry;
			if (sum >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}

			result.push(sum%10);
			// if (newList == null) {
			// newList = new ListNode(sum % 10);
			// currentOfNewList = newList;
			// } else {
			// currentOfNewList.next = new ListNode(sum % 10);
			// currentOfNewList = currentOfNewList.next;
			// }
			sum = 0;
		}

		if (carry != 0) {
			result.push(1);
		}
		return createListFromStack(result);
	}

	private static ListNode createListFromStack(final Stack<Integer> result) {
		final ListNode list = new ListNode(result.pop());
		ListNode current = list;
		while (!result.isEmpty()) {
			current.next = new ListNode(result.pop());
			current = current.next;
		}
		return list;
	}

}