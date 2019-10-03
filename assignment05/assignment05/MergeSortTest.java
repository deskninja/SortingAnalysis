package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMergeSort() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		SortUtils.generateTimingReport(mergeSort , 4, 10, 100, 1);
	}
	
	//change insertionSort to public to run this test
	@Test
	public void testInsertionSort() {
		List<String> list1 = new ArrayList<>();
		list1.add("b");
		list1.add("c");
		list1.add("r");
		list1.add("z");
		
		List<String> list2 = new ArrayList<>();	
		list2.add("a");
		list2.add("r");
		list2.add("s");
		list2.add("z");
		MergeSort<String> sort = new MergeSort<>();
		list1 = sort.insertionSort(list1, list2);
		
		List<String> result = new ArrayList<>();	
		result.add("a");
		result.add("b");
		result.add("c");
		result.add("r");
		result.add("r");
		result.add("s");
		result.add("z");
		result.add("z");
		assertEquals(result, list1);
	}
	
	//change partOfList to public to test
	@Test
	public void testPartOfList() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		List<String> list2 = new ArrayList<>();	
		list2.add("r");
		list2.add("s");
		list2.add("z");
		MergeSort<String> sort = new MergeSort<>();
		
		List<String> result = new ArrayList<>();	
		result.add("a");
		result.add("b");
		result.add("c");
		result.add("r");
		result.add("s");
		result.add("z");
		
		List<String> list3 = new ArrayList<>();
		list3 = sort.partOfList(result, 0, result.size() / 2);
		
		List<String> list4 = new ArrayList<>();
		list4 = sort.partOfList(result, result.size()/2, result.size());
		
		assertEquals(list3, list1);
		assertEquals(list2, list4);
	}
	
}
