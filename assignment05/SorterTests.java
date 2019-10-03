package assignment05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class SorterTests {
	
//visual tests with small integers and small arrays

	@Test
	public void quickSortPivotFirsttest() {
		List<Integer> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextInt(10));
		}
		QuickSortPivotFirst<Integer> q = new QuickSortPivotFirst<>();
		q.sort(test);
		System.out.println(test.toString());
		System.out.println(SortUtils.isSorted(test));
	}
	
	@Test
	public void quickSortPivotRandomtest() {
		List<Integer> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextInt(10));
		}
		QuickSortPivotRandom<Integer> q = new QuickSortPivotRandom<>();
		q.sort(test);
		System.out.println(test.toString());
		System.out.println(SortUtils.isSorted(test));
	}
	
//tests for Integer sorting on each sorting type
	
	@Test
	public void testInsertionSort() {
		InsertionSort<Integer> insertionSort = new InsertionSort<>();
		SortUtils.generateTimingReport(insertionSort , 1, 1_000_000, 10_000_001, 10);
	}
	
	@Test
	public void testJavaBuiltInSort() {
		JavaBuitInSort<Integer> javaBuiltInSort = new JavaBuitInSort<>();
		SortUtils.generateTimingReport(javaBuiltInSort , 1, 1_000_000, 10_000_001, 10);
	}
	
	@Test
	public void testMergeSort() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		SortUtils.generateTimingReport(mergeSort , 1, 10_000, 100_001, 10);
	}
	
	@Test
	public void testQuickSortNaive() {
		QuickSortNaive<Integer> quickSortNaive = new QuickSortNaive<>();
		SortUtils.generateTimingReport(quickSortNaive , 1, 10_000, 100_001, 10);
	}
	
	@Test
	public void testQuickSortPivotFirst() {
		QuickSortPivotFirst<Integer> quickSortPivotFirst = new QuickSortPivotFirst<>();
		SortUtils.generateTimingReport(quickSortPivotFirst , 1, 1_000_000, 10_000_001, 10);
	}
	
	@Test
	public void testQuickSortPivotM3() {
		QuickSortPivotM3<Integer> quickSortPivotM3 = new QuickSortPivotM3<>();
		quickSortPivotM3.setThreshold(50);
		SortUtils.generateTimingReport(quickSortPivotM3 , 1, 1_000_000, 10_000_001, 10);
	}
	
	@Test
	public void testQuickSortPivotRandom() {
		QuickSortPivotRandom<Integer> quickSortPivotRandom = new QuickSortPivotRandom<>();
		//quickSortPivotRandom.setThreshold(50);
		SortUtils.generateTimingReport(quickSortPivotRandom , 1, 1_000_000, 10_000_001, 10);
	}
	
//tests for data type that is boolean rather than int on each sorting type
	
	@Test
	public void insertionSortBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		InsertionSort<Boolean> q = new InsertionSort<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void javaBuiltInSortBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		JavaBuitInSort<Boolean> q = new JavaBuitInSort<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void mergeSortBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		MergeSort<Boolean> q = new MergeSort<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void quickSortNaiveBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		QuickSortNaive<Boolean> q = new QuickSortNaive<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void quickSortPivotFirsttestBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		QuickSortPivotFirst<Boolean> q = new QuickSortPivotFirst<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void quickSortPivotM3testBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		QuickSortPivotM3<Boolean> q = new QuickSortPivotM3<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
	
	@Test
	public void quickSortPivotRandomtestBoolean() {
		List<Boolean> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextBoolean());
		}
		QuickSortPivotRandom<Boolean> q = new QuickSortPivotRandom<>();
		q.sort(test);
		boolean isFalse = true;
		boolean failed = false;
		for(Boolean item: test) {
			if(item)
				isFalse = false;
			if(!isFalse && !item)
				failed = true;
		}
		assertEquals(false, failed); //check to see if the list was sorted
	}
}