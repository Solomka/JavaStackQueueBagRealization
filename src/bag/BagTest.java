package bag;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class BagTest {

	@Test
	public void testBagConstructor() {
		Bag<String> tester = new Bag<String>();
		assertNotNull(tester);
	}

	@Test
	public void testBagPush() throws NullPointerException {
		Bag<String> tester = new Bag<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");
		assertEquals(3, tester.size());
	}

	@Test
	public void testBagPushNull() throws NullPointerException {
		Bag<String> tester = new Bag<String>();
		try {
			tester.push(null);
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testBagIsEmptyFalse() {
		Bag<String> tester = new Bag<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testBagIsEmptyTrue() {
		Bag<String> tester = new Bag<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testBagIteratorRemove() throws UnsupportedOperationException {
		Bag<String> tester = new Bag<String>();
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {

		}
	}

	@Test
	public void testBagIteratorNohasNext() throws NoSuchElementException {
		Bag<String> tester = new Bag<String>();

		Iterator<String> iterator = tester.iterator();
		try {
			iterator.next();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testBagQueueIterator() {
		Bag<String> tester = new Bag<String>();
		tester.push("a");
		Iterator<String> iterator = tester.iterator();
		String next = iterator.next();
		System.out.println(next);
		assertEquals("a", next);
	}

	@Test
	public void testBaghasNextTrue() {
		Bag<String> tester = new Bag<String>();
		tester.push("a");
		Iterator<String> iterator = tester.iterator();
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testBaghasNextFalse() {
		Bag<String> tester = new Bag<String>();
		Iterator<String> iterator = tester.iterator();
		assertEquals(false, iterator.hasNext());
	}

}
