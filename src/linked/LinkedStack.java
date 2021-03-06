package linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {

	protected Node first = null;
	protected int count = 0;

	private class Node {
		Item item;
		Node next;
	}

	public void push(Item item) throws NullPointerException {
		if (item == null) {
			throw new NullPointerException();
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		count++;
	}

	public Item pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = first.item;
		first = first.next;
		count--;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
