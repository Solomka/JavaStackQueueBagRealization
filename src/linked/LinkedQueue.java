package linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> {
	protected Node first, last;
	protected int count = 0;

	private class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) throws NullPointerException {
		if (item == null) {
			throw new NullPointerException();
		}
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		count++;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
	}

	public Item dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = first.item;
		first = first.next;
		count--;
		if (isEmpty())
			last = null;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
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
