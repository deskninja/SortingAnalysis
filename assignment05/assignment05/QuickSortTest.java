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
		for(int i = 0; i < 6; i++) {
			test.add(r.nextInt(10));
		}
		QuickSortPivotFirst<Integer> q = new QuickSortPivotFirst<>();
		q.sort(test);
		System.out.println(test.toString());
	}

}
