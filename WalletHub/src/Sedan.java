
public class Sedan extends Car {

	public Sedan(final int numDoor) {
		super(numDoor);
	}

	@Override
	public int maxPassNum() {
		// return myNumDoor * 1;
		return 1;
	}

}
