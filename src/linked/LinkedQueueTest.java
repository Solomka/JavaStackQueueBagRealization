package linked;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedQueueTest {

	@Test
	public void testLinkedQueueConstructor() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		assertNotNull(tester);
	}

	@Test
	public void testLinkedQueueEnqueue() throws NullPointerException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");
		assertEquals(3, tester.size());
	}

	@Test
	public void testLinkedQueueEnqueueNull() throws NullPointerException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		try {
			tester.enqueue(null);
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testLinkedQueueIsEmptyFalse() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testLinkedQueueIsEmptyTrue() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testLinkedQueueDequeue() throws NoSuchElementException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		assertEquals("a", tester.dequeue());
	}
	@Test
	public void testLinkedQueueDequeueLastNull() throws NoSuchElementException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		tester.dequeue();
		assertEquals(null, tester.last);
	}
	@Test
	public void testLinkedQueueDequeueNotNull() throws NoSuchElementException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");

		assertNotSame(null, tester.dequeue());
	}

	@Test
	public void testLinkedQueueDequeueNull() throws NoSuchElementException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		try {
			tester.dequeue();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testLinkedQueueIteratorRemove()
			throws UnsupportedOperationException {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {

		}
	}

	@Test
	public void testLinkedQueueIteratorNohasNext()
			throws NoSuchElementException {
		LinkedQueue<String> tester = new LinkedQueue<String>();

		Iterator<String> iterator = tester.iterator();
		try {
			iterator.next();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testLinkedQueueIterator() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("b");
		Iterator<String> iterator = tester.iterator();
		String next = iterator.next();
		System.out.println(next);
		assertEquals("b", next);
	}

	@Test
	public void testLinkedQueuehasNextTrue() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		Iterator<String> iterator = tester.iterator();
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testLinkedQueuehasNextFalse() {
		LinkedQueue<String> tester = new LinkedQueue<String>();
		tester.enqueue("a");
		tester.dequeue();
		Iterator<String> iterator = tester.iterator();
		assertEquals(false, iterator.hasNext());
	}

}
