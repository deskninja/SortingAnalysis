package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void testSort() {
		InsertionSort<Integer> insertionSort = new InsertionSort<>();
		SortUtils.generateTimingReport(insertionSort , 10_000, 1_000, 1_000_000, 1);
	}

}
