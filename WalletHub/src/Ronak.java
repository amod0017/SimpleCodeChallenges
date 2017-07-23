import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ronak {
	public static void main(final String[] args) {
		final String[] myInput = new String[9];
		myInput[0] = "tac";
		myInput[1] = "book";
		myInput[2] = "kobo";
		myInput[3] = "act";
		myInput[4] = "atc";
		myInput[5] = "fact";
		myInput[6] = "ate";
		myInput[7] = "tea";
		myInput[8] = "karon";

		System.out.println(multipleAnagram(myInput));
	}

	private static List<String> multipleAnagram(final String[] myInput) {
		final Set<String> myOutput = new HashSet<>();
		final List<String> myOutputList = new ArrayList<>();
		final Set<String> mySortedInput = new HashSet<>();
		for (final String string : myInput) {
			final char[] myStringArray = string.toCharArray();
			Arrays.sort(myStringArray);
			final String sortedString = new String(myStringArray);
			final boolean isAdded = mySortedInput.add(sortedString);
			if(!isAdded){
				myOutput.add(sortedString);
			}
		}
		for(final String string: myInput){
			final char[] stringArray = string.toCharArray();
			Arrays.sort(stringArray);
			final String sortedString = new String(stringArray);
			if (myOutput.contains(sortedString)) {
				myOutputList.add(string);
			}
		}
		return myOutputList;
	}
}