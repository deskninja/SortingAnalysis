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
	
	/**
	 * sole constructor
	 */
	public QuickSortPivotRandom() {
		this.name = "QuickSortPivotRandom";
		this.complexity = ComplexityClass.NLOGN;
		this.setThreshold(0); // default threshold
	}

	@Override
	protected T pivot(List<T> list, int start, int end) {
		assert list != null : "Violation of: list is not null";
		Random r = new Random();
		//creates a new random number between {@code start} and {@code end}
		int position = r.nextInt(end - start) + start;
		//swap the element at the random postion with the element at postion start
		SortUtils.swapElementsAt(list, start, position);
		//return the location of the new pivot at position start
		return list.get(start);
	}
}