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
	
	private int quickSortThreshHold;

	  public QuickSortPivotM3() {
		  	this.name = "QuickSortPivotM3";
		    this.complexity = ComplexityClass.NLOGN;
		    this.setThreshold(40); //default threshold
	  }
	
	  @Override
	  protected T pivot(List<T> list, int start, int end) {
	    assert list != null : "Violation of: list is not null";
	    int middle = end / 2;
	    if(list.get(middle).compareTo(list.get(start)) > 0) {
	    	if(list.get(end).compareTo(list.get(middle)) > 0){
	    		SortUtils.swapElementsAt(list, start, middle);
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
	    SortUtils.swapElementsAt(list, middle, start);
	    if(list.get(end).compareTo(list.get(middle)) > 0){
    		SortUtils.swapElementsAt(list, start, middle);
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
	  
	  @Override
		 public void setThreshold(int threshold)
		     throws UnsupportedOperationException {
			 assert threshold >= 0 : "Violation of: threshold non-negative";
	
			 quickSortThreshHold = threshold;
		 }
	
	  @Override
	  public int threshold() throws UnsupportedOperationException {
		  return quickSortThreshHold;
	  }

}
