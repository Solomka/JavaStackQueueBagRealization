package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Iterable<Item> {

	protected Item[] s;
	protected int n = 0;

	@SuppressWarnings("unchecked")
	public ArrayStack() {

		s = (Item[]) new Object[1];
	}

	public void push(Item item) throws NullPointerException {
		if (item == null) {
			throw new NullPointerException();
		}
		if (n == s.length)
			resize(2 * s.length);
		s[n++] = item;
	}

	public Item pop() throws NoSuchElementException {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return s[--n];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = s[i];
		s = copy;
	}

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {

		private int i = n;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return s[--i];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
