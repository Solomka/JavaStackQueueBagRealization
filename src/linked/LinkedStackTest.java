package linked;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedStackTest {

	@Test
	public void testLinkedStackConstructor() {
		LinkedStack<String> tester = new LinkedStack<String>();
		assertNotNull(tester);
	}

	@Test
	public void testLinkedStackPush() throws NullPointerException {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");
		assertEquals(3, tester.size());
	}

	@Test
	public void testLinkedStackPushNull() throws NullPointerException {
		LinkedStack<String> tester = new LinkedStack<String>();
		try {
			tester.push(null);
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testLinkedStackIsEmptyFalse() {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testLinkedStackIsEmptyTrue() {
		LinkedStack<String> tester = new LinkedStack<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testLinkedStackPop() throws NoSuchElementException {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");
		assertEquals("a", tester.pop());
	}

	@Test
	public void testLinkedStackPopNotNull() throws NoSuchElementException {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");

		assertNotSame(null, tester.pop());
	}

	@Test
	public void testLinkedStackPopNull() throws NoSuchElementException {
		LinkedStack<String> tester = new LinkedStack<String>();
		try {
			tester.pop();
		} catch (NoSuchElementException e) {

		}
	}
	
	@Test
	public void testLinkedStackIteratorRemove() throws UnsupportedOperationException {
		LinkedStack<String> tester = new LinkedStack<String>();
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {

		}
	}
	
	@Test
	public void testLinkedStackIteratorNohasNext() throws NoSuchElementException {
		LinkedStack<String> tester = new LinkedStack<String>();
		
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.next();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testLinkedStackIterator() {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("b");

		Iterator<String> iterator = tester.iterator();

		String next = iterator.next();
		System.out.println(next);

		assertEquals("b", next);
	}

	@Test
	public void testLinkedStackhasNextTrue() {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");

		Iterator<String> iterator = tester.iterator();

		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testLinkedStackhasNextFalse() {
		LinkedStack<String> tester = new LinkedStack<String>();
		tester.push("a");

		tester.pop();

		Iterator<String> iterator = tester.iterator();

		assertEquals(false, iterator.hasNext());
	}

}
