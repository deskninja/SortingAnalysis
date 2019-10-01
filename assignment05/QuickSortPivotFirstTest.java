package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortPivotFirstTest {

	@Test
	public void testSort() {
		QuickSortPivotFirst<Integer> quickSortPivotFirst = new QuickSortPivotFirst<>();
		SortUtils.generateTimingReport(quickSortPivotFirst , 5, 100, 1_000, 1);
	}

}
