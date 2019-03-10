package core;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MassiveTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@Test
	public void testSum() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 8;
		int actualResult = massive.sum();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void sumIsNotNull() {
		int[] array = { 0, 0, 0 };
		Massive massive = new Massive(array);
		Assert.assertNotNull(massive.sum());
	}

	@Test
	public void testProizved() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 12;
		int actualResult = massive.proizv();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testZeroProizved() {
		int[] array = { 1, 3, 4, 0 };
		Massive massive = new Massive(array);
		int expectedResult = 0;
		int actualResult = massive.proizv();
		assertEquals(expectedResult, actualResult);
	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void getNPE() {
		Massive massive = new Massive(null);
		Assert.assertNull(massive.proizv());
	}

	@Test(expected = ArithmeticException.class)
	public void testExeption() {
		Massive massive = new Massive(null);
		massive.zeroDivision();

	}

	@Test
	public void testReverseArray() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult[] = { 4, 3, 1 };
		int actualResult[] = massive.reverseArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void testReverseArray2() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult[] = { 4, 3, 1 };
		assertTrue(Arrays.equals(expectedResult, massive.reverseArray()));
	}

	@Test
	public void testMinElement() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 1;
		int actualResult = massive.minElement();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMinNegativeElement() {
		int[] array = { -1, -3, -4 };
		Massive massive = new Massive(array);
		int expectedResult = -4;
		int actualResult = massive.minElement();
		assertEquals(expectedResult, actualResult);
	}

}
