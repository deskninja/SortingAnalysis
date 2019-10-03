package assignment05;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortPivotFirstTest {

	@Test
	public void testSort() {
		QuickSortPivotFirst<Integer> quickSortPivotFirst = new QuickSortPivotFirst<>();
		SortUtils.generateTimingReport(quickSortPivotFirst , 8, 10, 100, 100000000);
	}

}
