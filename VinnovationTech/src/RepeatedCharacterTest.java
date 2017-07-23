import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepeatedCharacterTest {
	public RepeatedCharacter myClassUnderTest = new RepeatedCharacter();

	@Test
	public void testMaxRepeating() {

		assertEquals(Character.MIN_VALUE, myClassUnderTest.maxRepeating(""));

		assertEquals('t',
				myClassUnderTest.maxRepeating(
						"24541pfxof1xkygp08u0wkdhh26u6tn2gcaq0sa31ifiqftilk5xj7ggg8giap6p333inf9luj3sxpp2se9ak957dtttttmoz8vfqbrdo3rs"));

		assertEquals('a', myClassUnderTest.maxRepeating("aaa333"));
		// should return first max repeated element.
	}

	@Test
	public void testGetType() {
		assertEquals(myClassUnderTest.getType('a'), RepeatedCharacter.ALPHA);
		assertEquals(myClassUnderTest.getType('1'), RepeatedCharacter.NUMERIC);

	}

}
