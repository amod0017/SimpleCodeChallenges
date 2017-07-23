package edu.lamar.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MySetTest {
	private MySet mySet;

	@Before
	public void setup() {
		mySet = new MySet();
	}
	@Test
	public void testAdd() {
		mySet.add(1);
		Assert.assertEquals(mySet.contains(1), true);
		mySet.add(1);
		Assert.assertEquals(mySet.size(), 1);
		mySet.add(2);
		mySet.add(3);
		mySet.add(4);
		mySet.add(5);
		mySet.add(6);
		mySet.add(7);
		Assert.assertEquals(mySet.size(), 7);
	}

	@Test
	public void testRemove() {
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		mySet.add(4);
		mySet.add(5);
		mySet.add(6);
		mySet.add(7);
		mySet.remove(4);
		Assert.assertEquals(mySet.contains(1), false);
	}

}
