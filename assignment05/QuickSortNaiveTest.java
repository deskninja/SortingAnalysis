package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortNaiveTest {

	@Test
	public void testSort() {
		QuickSortNaive<Integer> quickSortNaive = new QuickSortNaive<>();
		SortUtils.generateTimingReport(quickSortNaive , 50_000, 1_000, 1_000_000, 1);
	}

}
