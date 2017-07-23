
public class ChangeCalulator {

	public static void main(final String[] args) {

		System.out.println(calculateChange("10.09"));

	}

	static int calculateChange(final String money) {
		int count = 0;
		Double amount = Double.parseDouble(money) * 100;
		Double tmp;
		if (amount >= 50) {
			tmp = amount / 50;
			count = count + tmp.intValue();
			amount = amount % 50;
		}

		if (amount >= 25) {
			tmp = amount / 25;
			count = count + tmp.intValue();
			amount = amount % 25;
		}
		if (amount >= 10) {
			tmp = amount / 10;
			count = count + tmp.intValue();
			amount = amount % 10;
		}
		if (amount >= 05) {
			tmp = amount / 05;
			count = count + tmp.intValue();
			amount = amount % 05;
		}
		if (amount >= 01) {
			tmp = amount / 01;
			count = count + tmp.intValue();
			amount = amount % 01;
		}
		return count;

	}
}
