package assignment05;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void quickSortPivotFirsttest() {
		List<Integer> test = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			test.add(r.nextInt());
		}
		QuickSortPivotFirst<Integer> q = new QuickSortPivotFirst<>();
		q.quickSort(test, 0, test.size() - 1);
		System.out.println(SortUtils.isSorted(test));
	}

}
