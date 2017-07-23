
public class MySet {

	private final int[] hashCodes = new int[Constants.ITEM_COUNT];
	private final String[][] array = new String[Constants.ITEM_COUNT][Constants.ITEM_COUNT];
	private int size = 0;
	private int currentHashCodeIndex = 0;
	private final int[] itemCount = new int[Constants.ITEM_COUNT];
	private int numberOfHashCodeAdded = 0;

	public void add(final String input) {
		if (input == null) {
			return;
		}
		final int hashCode = input.hashCode();
		int count = 0;
		boolean isHashCodePresent = false;

		for(final int code : hashCodes) {
			if(code == hashCode) {
				for(int i=0; i < array.length; i++) {
					if ((array[count][i] != null) && array[count][i].equals(input)) {
						return;
					}
				}
				isHashCodePresent = true;
				break;
			}
			count++;
		}

		if(isHashCodePresent) {
			array[count][itemCount[count]] = input;
			size++;
			itemCount[count] = itemCount[count] + 1;
		} else {
			hashCodes[currentHashCodeIndex] = hashCode;
			array[currentHashCodeIndex][0] = input;
			currentHashCodeIndex++;
			itemCount[numberOfHashCodeAdded] = itemCount[numberOfHashCodeAdded] + 1;
			numberOfHashCodeAdded++;
			size++;
		}
	}



	public boolean contains(final String s) {
		final int hashCode = s.hashCode();
		int count = 0;
		for (final int code : hashCodes) {
			if (hashCode == code) {
				for (int i = 0; i < array.length; i++) {
					if ((array[count][i] != null) && array[count][i].equals(s)) {
						return true;
					}
				}
			}
			count++;
		}
		return false;
	}

	public boolean isEmpty() {
		if (size != 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	/*
	 * should not have get since it's not a linear data structure.
	 */
	public String get(final int index) {
		return null;
	}

	/*
	 * should work with Object rather than index as set is not a linear data
	 * structure
	 */
	public boolean remove(final int index) {
		return false;
	}
}
