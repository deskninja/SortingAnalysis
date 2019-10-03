package assignment05;

import java.util.List;
import java.util.Random;

/**
 * Implements in-place QuickSort using the {@code Sorter} interface by selecting
 * a random element in the list as the pivot.
 * 
 * This class must implement the {@code setThreshold, threshold} methods.
 * 
 * @author Josh Wells, Jonathan Oliveros
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class QuickSortPivotRandom<T extends Comparable<? super T>> extends AbstractQuickSort<T> {

	public QuickSortPivotRandom() {
		this.name = "QuickSortPivotRandom";
		this.complexity = ComplexityClass.NLOGN;
		this.setThreshold(5); // default threshold
	}

	@Override
	protected T pivot(List<T> list, int start, int end) {
		assert list != null : "Violation of: list is not null";
		Random r = new Random();
		int position = r.nextInt(list.size());
		SortUtils.swapElementsAt(list, start, position);
		return list.get(start);
	}

	// TODO Override other methods if required
	// TODO Add private helper methods as needed

}