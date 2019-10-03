package assignment05;

import java.util.List;

/**
 * Implements in-place QuickSort using the {@code Sorter} interface by selecting
 * the "median of three" as the pivot.
 * 
 * This class must implement the {@code setThreshold, threshold} methods.
 * 
 * @author Jonathan Oliveros and Joshua Wells	
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class QuickSortPivotM3<T extends Comparable<? super T>> extends AbstractQuickSort<T> {

	/**
	   * Returns the pivot around which to quick-sort the list. This method may modify
	   * the {@code list}, e.g., median of three will move smallest value to front of
	   * the list. Requires that the element at index {@code start} in {@code list}
	   * is less than the element at index {@code start} in {@code list}
	   * 
	   * @param list  the list to find the pivot in
	   * @param start start-index of the sublist to consider
	   * @param end   end-index of the sublist to consider
	   * @return pivot for quick-sort
	   * 
	   * @requires start <= end
	   * @requires list value at index start is less than list value at index middle
	   * 
	   * @modifies {@code list}
	   */
	private T findPivot(List<T> list, int start, int end) {
		int middle = end / 2;
		//if the end is greater than the middle
		if(list.get(end).compareTo(list.get(middle)) > 0){
			//set the pivot (median of the three values) to position start
    		SortUtils.swapElementsAt(list, start, middle);
    		//return the pivot 
    		return list.get(start);
    	}
		
    	if(list.get(end).compareTo(list.get(start)) > 0) {
	    	SortUtils.swapElementsAt(list, start, end);
			SortUtils.swapElementsAt(list, end, middle);
	    	return list.get(start);
    	}
    	SortUtils.swapElementsAt(list, middle, end);
    	return list.get(start);
	}
	
	 /*
	 * sole constructor
	 */
	public QuickSortPivotM3() {
		  	this.name = "QuickSortPivotM3";
		    this.complexity = ComplexityClass.NLOGN;
		    this.setThreshold(0); //default threshold
	  }
	
	  @Override
	  protected T pivot(List<T> list, int start, int end) {
	    assert list != null : "Violation of: list is not null";
	    int middle = end / 2;
	    //if the element in {@code list} at position middle is greater than or equal to the element in {@code list} at position start
	    if(list.get(middle).compareTo(list.get(start)) > 0) {
	    	//find the pivot and return it
	    	return findPivot(list, start, end);
	    }
	    //if middle was not greater than start, swap them so middle is greater than start
	    SortUtils.swapElementsAt(list, middle, start);
	    //find the pivot and return it
	    return findPivot(list, start, end);
	  }

}
