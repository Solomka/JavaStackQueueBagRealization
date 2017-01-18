package array;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayStackTest {

	@Test
	public void testArrayStackConstructor() {
		ArrayStack<String> tester = new ArrayStack<String>();
		assertNotNull(tester);
	}

	@Test
	public void testArrayStackPush() throws NullPointerException {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");
		assertEquals(3, tester.size());
	}

	@Test
	public void testArrayStackPushNull() throws NullPointerException {
		ArrayStack<String> tester = new ArrayStack<String>();
		try {
			tester.push(null);
		} catch (NullPointerException e) {

		}

	}

	@Test
	public void testArrayStackIsEmptyFalse() {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");
		tester.push("b");
		tester.push("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testArrayStackIsEmptyTrue() {
		ArrayStack<String> tester = new ArrayStack<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testArrayStackPop() throws NoSuchElementException {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");
		assertEquals("a", tester.pop());
	}

	@Test
	public void testArrayStackPopNotNull() throws NoSuchElementException {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");

		assertNotSame(null, tester.pop());
	}

	@Test
	public void testArrayStackPopNull() throws NoSuchElementException {
		ArrayStack<String> tester = new ArrayStack<String>();
		try {
			tester.pop();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testArrayStackIteratorRemove()
			throws UnsupportedOperationException {
		ArrayStack<String> tester = new ArrayStack<String>();
		Iterator<String> iterator = tester.iterator();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {

		}
	}

	@Test
	public void testArrayStackIteratorNoHasNext() throws NoSuchElementException {
		ArrayStack<String> tester = new ArrayStack<String>();

		Iterator<String> iterator = tester.iterator();
		try {
			iterator.next();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testArrayStackIterator() {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("b");
		Iterator<String> iterator = tester.iterator();
		String next = iterator.next();
		System.out.println(next);
		assertEquals("b", next);
	}

	@Test
	public void testArrayStackHasNextTrue() {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");
		Iterator<String> iterator = tester.iterator();
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testArrayStackHasNextFalse() {
		ArrayStack<String> tester = new ArrayStack<String>();
		tester.push("a");
		tester.pop();
		Iterator<String> iterator = tester.iterator();
		assertEquals(false, iterator.hasNext());
	}

}
