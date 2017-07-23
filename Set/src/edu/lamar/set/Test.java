package edu.lamar.set;

public class Test {

	public static void main(final String[] args) {
		final String s = "<b>hey!</b>";
		System.out.println(s.replaceAll("\\<.*?>", ""));
		System.out.println(s);

	}

}
