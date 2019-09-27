package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMergeSort() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		SortUtils.generateTimingReport(mergeSort , 4, 100, 1_000_000, 5);
	}
	
	//change insertionSort to public to run this test
	@Test
	public void testInsertionSortMethod() {
		List<String> list1 = new ArrayList<>();
		list1.add("b");
		list1.add("c");
		list1.add("z");
		List<String> list2 = new ArrayList<>();	
		list2.add("a");
		list2.add("r");
		list2.add("s");
		MergeSort<String> sort = new MergeSort<>();
		sort.insertionSort(list1, list2);
		
		List<String> result = new ArrayList<>();	
		result.add("a");
		result.add("b");
		result.add("c");
		result.add("r");
		result.add("s");
		result.add("z");
		assertEquals(result, list1);
	}
	
}
