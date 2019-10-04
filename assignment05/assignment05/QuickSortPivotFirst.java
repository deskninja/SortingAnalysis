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

	/**
	 * sole constructor
	 */
	public QuickSortPivotFirst() {
		this.name = "QuickSortPivotFirst";
	    this.complexity = ComplexityClass.NLOGN;
	    this.setThreshold(0); //default threshold
	}

	@Override
	protected T pivot(List<T> list, int start, int end) {
		//the pivot is the first item in this segment of the {@code list}
		return list.get(start);
	}
	
}
