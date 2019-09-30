package assignment05;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements in-place QuickSort using the {@code Sorter} interface by selecting
 * the first element in the list as the pivot.
 * 
 * This class must implement the {@code setThreshold, threshold} methods.
 * 
 * @author Jonathan Oliveros and Joshua Wells
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class QuickSortPivotFirst<T extends Comparable<? super T>>
    extends AbstractQuickSort<T> {
	
	private void swap(List<T> list, int position1, int position2) {
		T temp = list.get(position1);
		list.set(position1, list.get(position2));
		list.set(position2, temp);
	}

	public QuickSortPivotFirst() {
		this.name = "QuickSortPivotFirst";
	    this.complexity = ComplexityClass.NLOGN;
	    super.setThreshold(40);
	}
	
	@Override
	public final void sort(List<T> list) {
		//set the pivot to list(0) then swap the array with the last number sorted lower than it
		//recurse left and right side
	}

	@Override
	protected T pivot(List<T> list, int start, int end) {
		return list.get(start);
	}
}
