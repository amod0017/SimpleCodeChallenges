import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PangramDetectorTest {
	PangramDetector myClassUnderTest = new PangramDetector();

	@Test
	public final void testFindMissingLetters() {
		assertEquals("abcdefghijklmnopqrstuvwxyz", myClassUnderTest.findMissingLetters(""));
		assertEquals("abc", myClassUnderTest
				.findMissingLetters("defghijklmnopqrstuvwxyz defghijklmnopqrstuvwxyz defghijklmnopqrst"));
		assertEquals("", myClassUnderTest.findMissingLetters("nopqrstuvwxyz nopqrstuvwxyzabcdef ghijklm"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", myClassUnderTest.findMissingLetters(null));
		assertEquals("abcdefghijklmnopqrstuvwxyz", myClassUnderTest.findMissingLetters("#$&("));
	}
}
