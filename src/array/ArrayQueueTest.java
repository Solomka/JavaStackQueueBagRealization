package array;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void testArrayQueueConstructor() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		assertNotNull(tester);
	}

	@Test
	public void testArrayQueueEnqueue() throws NullPointerException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");
		assertEquals(3, tester.size());
	}
	
	
	@Test
	public void testArrayQueueEnqueueNull() throws NullPointerException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		try {
			tester.enqueue(null);
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testArrayQueueIsEmptyFalse() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testArrayQueueIsEmptyTrue() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testArrayQueueDequeue() throws NoSuchElementException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");
		assertEquals("a", tester.dequeue());
	}
	
	@Test
	public void testArrayQueueDequeueNotNull() throws NoSuchElementException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");

		assertNotSame(null, tester.dequeue());
	}

	@Test
	public void testArrayQueueDequeueNull() throws NoSuchElementException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		try {
			tester.dequeue();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void estArrayQueueIteratorRemove()
			throws UnsupportedOperationException {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {

		}
	}

	@Test
	public void testArrayQueueIteratorNoHasNext()
			throws NoSuchElementException {
		ArrayQueue<String> tester = new ArrayQueue<String>();

		Iterator<String> iterator = tester.iterator();
		try {
			iterator.next();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testArrayQueueIterator() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("b");
		Iterator<String> iterator = tester.iterator();
		String next = iterator.next();
		System.out.println(next);
		assertEquals("b", next);
	}

	@Test
	public void testArrayQueueHasNextTrue() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");
		Iterator<String> iterator = tester.iterator();
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testArrayQueueHasNextFalse() {
		ArrayQueue<String> tester = new ArrayQueue<String>();
		tester.enqueue("a");
		tester.dequeue();
		Iterator<String> iterator = tester.iterator();
		assertEquals(false, iterator.hasNext());
	}

}
