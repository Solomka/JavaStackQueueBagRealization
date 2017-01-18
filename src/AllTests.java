import linked.LinkedQueueTest;
import linked.LinkedStackTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import array.ArrayQueueTest;
import array.ArrayStackTest;
import bag.BagTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ArrayQueueTest.class, ArrayStackTest.class,
		BagTest.class, LinkedQueueTest.class, LinkedStackTest.class })
public final class AllTests {
}