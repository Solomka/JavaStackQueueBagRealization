package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<Item> implements Iterable<Item> {
	protected Item[] array;
	protected int head = 0;
	protected int tail = 0;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		array = (Item[]) new Object[1];
	}

	@SuppressWarnings("unchecked")
	public void enqueue(Item item) throws NullPointerException {
		if (item == null) {
			throw new NullPointerException();
		}
		if (tail == array.length) {
			tail -= head;
			if (tail + 1 <= array.length / 2) {
				for (int i = 0; i < tail; i++)
					array[i] = array[head + i];
			} else {
				Item[] copy = (Item[]) new Object[array.length * 2];
				for (int i = 0; i < tail; i++)
					copy[i] = array[head + i];
				array = copy;
			}
			head = 0;
		}
		array[tail++] = item;
	}

	@SuppressWarnings("unchecked")
	public Item dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item data = array[head++];
		if (tail - head <= array.length / 4) {
			tail -= head;
			Item[] copy = (Item[]) new Object[array.length / 2];
			for (int i = 0; i < tail; i++)
				copy[i] = array[head + i];
			array = copy;
			head = 0;
		}
		return data;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return tail - head;
	}

	public Iterator<Item> iterator() {
		return new ArrayQueueIterator();
	}

	private class ArrayQueueIterator implements Iterator<Item> {
		private int i = head;

		public boolean hasNext() {
			return i < tail;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return array[i++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
