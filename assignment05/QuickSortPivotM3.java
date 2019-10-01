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
public class QuickSortPivotM3<T extends Comparable<? super T>>
    extends AbstractQuickSort<T> {
	
	private int quickSortThreshHold;

  public QuickSortPivotM3() {
	  	this.name = "QuickSortPivotM3";
	    this.complexity = ComplexityClass.NLOGN;
	    this.setThreshold(40); //default threshold
  }

  @Override
  protected T pivot(List<T> list, int start, int end) {
    assert list != null : "Violation of: list is not null";
    return null; // FIXME
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

  // TODO Override other methods if required
  // TODO Add private helper methods as needed

}
