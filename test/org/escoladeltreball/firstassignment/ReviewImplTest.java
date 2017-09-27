/**
 * 
 */
package org.escoladeltreball.firstassignment;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pep Méndez
 *
 */
public class ReviewImplTest {
	
	private static ReviewImpl main;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		main = new ReviewImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		main = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.escoladeltreball.ReviewImpl.Main#frequencyPercentage(int[], int)}.
	 */
	@Test
	public final void testFrequencyPercentage() {
		int[] values = { 3, 4, 3, 5, 1, 2, 3, 0 };
		int[] values2 = {};
		assertEquals(37.5, main.frequencyPercentage(values, 3), 1e-4);
		assertEquals(12.5, main.frequencyPercentage(values, 1), 1e-4);
		assertEquals(0, main.frequencyPercentage(values, 7), 1e-4);
		assertEquals(0, main.frequencyPercentage(values2, 7), 1e-4);
	}

	/**
	 * Test method for
	 * {@link org.escoladeltreball.ReviewImpl.Main#merge(int[], int)}.
	 */
	@Ignore
	@Test
	public final void testMerge() {
		int[] values = { 1, 2, 3, 5, 7, 9, 11, 15 };
		int[] values2 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		assertArrayEquals(new int[] { 0, 1, 2, 3, 5, 7, 9, 11, 15 }, main.merge(values, 0));
		assertArrayEquals(new int[] { 1, 2, 3, 5, 6, 7, 9, 11, 15 }, main.merge(values, 6));
		assertArrayEquals(new int[] { 1, 2, 3, 5, 7, 9, 11, 15, 19 }, main.merge(values, 19));
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 2 }, main.merge(values2, 2));
		assertArrayEquals(new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1 }, main.merge(values2, 0));
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, main.merge(values2, 1));
	}

	/**
	 * Test method for
	 * {@link org.escoladeltreball.ReviewImpl.Main#split(int[])}.
	 */
	@Ignore
	@Test
	public final void testSplit() {
		int[] values = { 1, 2, 3, 5, 7, 9, 11, 15 };
		int[] values2 = { 2, 4, 3, 6, 7, 18, 13, 11 };
		int[] values3 = { };
		assertArrayEquals(new int[] { 2 }, main.split(values)[0]);
		assertArrayEquals(new int[] { 1, 3, 5, 7, 9, 11, 15 }, main.split(values)[1]);
		assertArrayEquals(new int[] { 2, 4, 6, 18 }, main.split(values2)[0]);
		assertArrayEquals(new int[] { 3, 7, 13, 11 }, main.split(values2)[1]);
		assertArrayEquals(new int[] { }, main.split(values3)[0]);
		assertArrayEquals(new int[] { }, main.split(values3)[1]);
	}

}
