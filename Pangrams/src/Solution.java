import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Roy wanted to increase his typing speed for programming contests. So, his
 * friend advised him to type the sentence "The quick brown fox jumps over the
 * lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences
 * constructed by using every letter of the alphabet at least once.)
 *
 * After typing the sentence several times, Roy became bored with it. So he
 * started to look for other pangrams.
 *
 * Given a sentence , tell Roy if it is a pangram or not.
 *
 * @author amod0
 *
 */
public class Solution {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final String s = scanner.nextLine();
		// System.out.println(s);
		final char sentence[] = s.toCharArray();
		final Map<Character, Boolean> alphabetMap = new HashMap<>();
		alphabetMap.put('a', false);
		alphabetMap.put('b', false);
		alphabetMap.put('c', false);
		alphabetMap.put('d', false);
		alphabetMap.put('e', false);
		alphabetMap.put('f', false);
		alphabetMap.put('g', false);
		alphabetMap.put('h', false);
		alphabetMap.put('i', false);
		alphabetMap.put('j', false);
		alphabetMap.put('k', false);
		alphabetMap.put('l', false);
		alphabetMap.put('m', false);
		alphabetMap.put('n', false);
		alphabetMap.put('o', false);
		alphabetMap.put('p', false);
		alphabetMap.put('q', false);
		alphabetMap.put('r', false);
		alphabetMap.put('s', false);
		alphabetMap.put('t', false);
		alphabetMap.put('u', false);
		alphabetMap.put('v', false);
		alphabetMap.put('w', false);
		alphabetMap.put('x', false);
		alphabetMap.put('y', false);
		alphabetMap.put('z', false);

		for (final Character element : sentence) {
			alphabetMap.put(Character.toLowerCase(element.charValue()), true);
		}
		if (alphabetMap.values().contains(false)) {
			System.out.println("not pangram");
		} else {
			System.out.println("pangram");
		}
	}
}
