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
}
