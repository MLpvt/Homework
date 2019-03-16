package core;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MassiveTest {

	@Test
	public void testSum() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 8;
		int actualResult = massive.sum();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testNegativeSum() {
		int[] array = { -1, -2, -9 };
		Massive massive = new Massive(array);
		int expectedResult = -12;
		int actualResult = massive.sum();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testSumIsNotNull() {
		int[] array = { 0, 0, 0 };
		Massive massive = new Massive(array);
		Assert.assertNotNull(massive.sum());
	}

	@Test
	public void testSumMaxInt() {
		int[] array = { 2147483645, 2, 0 };
		Massive massive = new Massive(array);
		int expectedResult = 2147483647;
		int actualResult = massive.sum();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testProizved() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 12;
		int actualResult = massive.proizv();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testNegativeProizved() {
		int[] array = { -1, 3, -4, -3 };
		Massive massive = new Massive(array);
		int expectedResult = -36;
		int actualResult = massive.proizv();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testZeroProizved() {
		int[] array = { 1, 3, 4, 0 };
		Massive massive = new Massive(array);
		int expectedResult = 0;
		int actualResult = massive.proizv();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testProizvedMaxInt() {
		int[] array = { 2147483647, 1, 1 };
		Massive massive = new Massive(array);
		int expectedResult = 2147483647;
		int actualResult = massive.proizv();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void getNPEInProizved() {
		Massive massive = new Massive(null);
		Assert.assertNull(massive.proizv());
	}

	@Test
	public void testDivisionByInt() {
		int[] array = { 6, 8, 0 };
		Massive massive = new Massive(array);
		double[] expectedResult = { 3.0, 4.0, 0.0 };
		double[] actualResult = massive.arrayDivisionBy(2);
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testDivisionByNegativeInt() {
		int[] array = { 6, 8, 0 };
		Massive massive = new Massive(array);
		double[] expectedResult = { -6, -8, 0 };
		double[] actualResult = massive.arrayDivisionBy(-1);
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void testDivisionByZeroExeption() {
		int[] array = { 1, 9, 8 };
		Massive massive = new Massive(array);
		massive.arrayDivisionBy(0);

	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testNullArrayDivisionBy() {
		Massive massive = new Massive(null);
		Assert.assertNull(massive.arrayDivisionBy(3));
	}

	@Test(enabled = false)
	public void testReverseArrayNull() {
		Massive massive = new Massive(null);
		int expectedResult[] = null;
		int actualResult[] = massive.reverseArray();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testReverseArray() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult[] = { 4, 3, 1 };
		int actualResult[] = massive.reverseArray();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testReverseArrayEven() {
		int[] array = { 1, 3, 4, 5 };
		Massive massive = new Massive(array);
		int expectedResult[] = { 5, 4, 3, 1 };
		int actualResult[] = massive.reverseArray();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testReverseArraySymmetry() {
		int[] array = { 1, 3, 5, 3, 1 };
		Massive massive = new Massive(array);
		int expectedResult[] = { 1, 3, 5, 3, 1 };
		Assert.assertTrue(Arrays.equals(expectedResult, massive.reverseArray()));
	}

	@Test
	public void testMinElement() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 1;
		int actualResult = massive.minElement();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMinNegativeElement() {
		int[] array = { -1, -3, -4 };
		Massive massive = new Massive(array);
		int expectedResult = -4;
		int actualResult = massive.minElement();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMaxElement() {
		int[] array = { 1, 3, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 4;
		int actualResult = massive.maxElement();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMaxNegativeElement() {
		int[] array = { -1, -3, -4 };
		Massive massive = new Massive(array);
		int expectedResult = -1;
		int actualResult = massive.maxElement();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMinNumber() {
		int[] array = { 1, 3, -4 };
		Massive massive = new Massive(array);
		int expectedResult = 2;
		int actualResult = massive.minNumber();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMaxNumber() {
		int[] array = { 9, 5, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 0;
		int actualResult = massive.maxNumber();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testCountZero() {
		int[] array = { 9, 0, 4 };
		Massive massive = new Massive(array);
		int expectedResult = 1;
		int actualResult = massive.countZeroElement();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testCountZeroNull() {
		Massive massive = new Massive(null);
		Assert.assertNull(massive.countZeroElement());
	}
}
