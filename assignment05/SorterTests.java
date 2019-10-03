package assignment05;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class SorterTests {

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
	public void quickSortPivotM3test() {
		List<Integer> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 6; i++) {
			test.add(r.nextInt(10));
		}
		QuickSortPivotM3<Integer> q = new QuickSortPivotM3<>();
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
	
	@Test
	public void testInsertionSort() {
		InsertionSort<Integer> insertionSort = new InsertionSort<>();
		SortUtils.generateTimingReport(insertionSort , 1, 1, 1_000, 1);
	}
	
	@Test
	public void testJavaBuiltInSort() {
		JavaBuitInSort<Integer> javaBuiltInSort = new JavaBuitInSort<>();
		SortUtils.generateTimingReport(javaBuiltInSort , 100, 10_000, 100_000, 1);
	}
	
	@Test
	public void testMergeSort() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		SortUtils.generateTimingReport(mergeSort , 1, 1, 100, 1);
	}
	
	@Test
	public void testQuickSortNaive() {
		QuickSortNaive<Integer> quickSortNaive = new QuickSortNaive<>();
		SortUtils.generateTimingReport(quickSortNaive , 1, 1, 100, 1);
	}
	
	@Test
	public void testQuickSortPivotFirst() {
		QuickSortPivotFirst<Integer> quickSortPivotFirst = new QuickSortPivotFirst<>();
		SortUtils.generateTimingReport(quickSortPivotFirst , 1, 1, 100, 1);
	}
	
	@Test
	public void testQuickSortPivotM3() {
		QuickSortPivotM3<Integer> quickSortPivotM3 = new QuickSortPivotM3<>();
		SortUtils.generateTimingReport(quickSortPivotM3 , 1, 1, 100, 1);
	}
	
	@Test
	public void testQuickSortPivotRandom() {
		QuickSortPivotRandom<Integer> quickSortPivotRandom = new QuickSortPivotRandom<>();
		SortUtils.generateTimingReport(quickSortPivotRandom , 1, 1, 100, 1, 0);
	}
}