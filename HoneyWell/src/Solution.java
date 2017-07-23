import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(final String[] args) {
		final String[] input = new String[5];
		input[0] = "start :):)";
		input[1] = "(:)";
		input[2] = "today (:()";
		input[3] = ")(";
		input[4] = ":((";

		// final String s = ":):)( )";
		System.out.println(Arrays.asList(is_balanced(input)));
	}

	static String[] is_balanced(final String[] expression) {
		final String[] output = new String[expression.length];
		for(int i =0; i<expression.length; i++){
			output[i]=isBalancedExperssion(expression[i]);
		}
		return output;
	}

	public static String isBalancedExperssion(final String s) {
		if (s.length() == 0) {
			return "YES";
		}
		final String[] tokens = s.split("(?=(:\\(|:\\)))|(?<=(:\\(|:\\)))");
		final List<Integer> tokenIndex = new ArrayList<>();
		int i = 0;
		int totalSmileyTokens = 0;
		for (final String token : tokens) {
			if (token.equals(":)") || token.equals(":(")) {
				tokenIndex.add(i);
				totalSmileyTokens++;
			}
			i++;
		}
		final String origStr = removeBracs(s);
		if (isValidString(origStr)) {
			return "YES";
		}
		if (totalSmileyTokens > 0) {
			for (i = totalSmileyTokens; i >= 1; i--) {
				final String[] variations = getVariations(tokens, totalSmileyTokens, tokenIndex, i);
				for (String variation : variations) {
					if (variation != null) {
						variation = removeBracs(variation);
						if (isValidString(variation)) {
							return "YES";
						}
					}
				}
			}
		}
		return "NO";
	}



	public static boolean isValidString(final String str) {
		final char[] characters = str.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			if (!(((characters[i] <= 122) && (characters[i] >= 97)) || (characters[i] == 32)
					|| (characters[i] == 58))) {
				return false;
			}
		}
		return true;
	}

	public static String[] getVariations(final String[] tokens, final int totalSmileyTokens,
			final List<Integer> tokenIndex, final int tokensToRemove) {
		final List<Set<Integer>> subTokenIndexesToRemove = getSubTokenIndexesToRemove(tokenIndex, tokensToRemove);
		final String[] variations = new String[subTokenIndexesToRemove.size()];
		int i = 0;
		for (final Set<Integer> subTokenIndexToRemove : subTokenIndexesToRemove) {
			try {
				variations[i] = joinTokens(tokens, subTokenIndexToRemove);
			} catch (final Exception e) {
			}
			i++;
		}
		return variations;
	}

	public static String joinTokens(final String[] tokens, final Set<Integer> subTokenIndexToRemove) {
		String retrnStr = "";
		int i = 0;
		for (final String token : tokens) {
			if (!subTokenIndexToRemove.contains(i)) {
				retrnStr += token;
			}
			i++;
		}
		return retrnStr;
	}

	public static String removeBracs(String s) {
		while (true) {
			final int startIndex = s.indexOf("(");
			final int endIndex = s.indexOf(")");
			if ((startIndex >= 0) && (endIndex > 0) && (endIndex > startIndex)) {
				s = s.replaceFirst("\\(", "");
				s = s.replaceFirst("\\)", "");
			} else {
				break;
			}
		}
		return s;
	}


	private static void getSubTokenIndexesToRemove(final List<Integer> superSet, final int k, final int idx,
			final Set<Integer> current, final List<Set<Integer>> solution) {
		if (current.size() == k) {
			solution.add(new HashSet<>(current));
			return;
		}
		if (idx == superSet.size()) {
			return;
		}
		final Integer x = superSet.get(idx);
		current.add(x);
		getSubTokenIndexesToRemove(superSet, k, idx + 1, current, solution);
		current.remove(x);
		getSubTokenIndexesToRemove(superSet, k, idx + 1, current, solution);
	}

	public static List<Set<Integer>> getSubTokenIndexesToRemove(final List<Integer> superSet, final int k) {
		final List<Set<Integer>> res = new ArrayList<>();
		getSubTokenIndexesToRemove(superSet, k, 0, new HashSet<Integer>(), res);
		return res;
	}
}
