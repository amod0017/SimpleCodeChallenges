package edu.lamar.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set<Integer> {
	private Integer[] set = new Integer[5];
	private int max = 5;
	private int size = 0;

	@Override
	public boolean add(final Integer arg0) {
		if (!contains(arg0)) {
			if (size < max) {
				set[size] = arg0;
				size = size + 1;

			} else {
				set = Arrays.copyOf(set, set.length * 2);
				max = set.length;
				set[size] = arg0;
				size = size + 1;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(final Collection<? extends Integer> arg0) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean contains(final Object arg0) {
		for (final Integer current : set) {
			if ((current != null) && current.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(final Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}

	@Override
	public boolean remove(final Object arg0) {
		if (contains(arg0)) {
			for (int i = 0; i < set.length; i++) {
				if ((set[i] != null) && set[i].equals(arg0)) {
					set[i] = null;
					moveNullToLast(i);
					size = size - 1;
					return true;
				}
			}
		}
		return false;
	}

	private void moveNullToLast(final int index) {
		for (int i = index + 1; i < size; i++) {
			set[i - 1] = set[i];
			set[i] = null;
		}
	}

	@Override
	public boolean removeAll(final Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean retainAll(final Collection<?> arg0) {
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(final T[] arg0) {
		return null;
	}

}
