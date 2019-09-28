package assignment05;

import java.util.List;

/**
 * Implements in-place QuickSort using the {@code Sorter} interface by selecting
 * the first element in the list as the pivot.
 * 
 * This class must implement the {@code setThreshold, threshold} methods.
 * 
 * @author Swaroop Joshi
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class QuickSortPivotFirst<T extends Comparable<? super T>>
    extends AbstractQuickSort<T> {
	
	private int Threshold;
	
	public QuickSortPivotFirst() {
    this.name = "QuickSortPivotFirst";
    this.complexity = ComplexityClass.NLOGN;
    Threshold = 20;
    }

  @Override
  protected T pivot(List<T> list, int start, int end) {
    assert list != null : "Violation of: list is not null";
    return list.get(0);
  }
  
  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";
    quickSort(list, 0, list.size() - 1);    
  }
  
  @Override
  public void setThreshold(int threshold)
      throws UnsupportedOperationException {
    assert threshold >= 0 : "Violation of: threshold non-negative";

    throw new UnsupportedOperationException(
        "This operation is not supported by " + this.name());
  }

  @Override
  public int threshold() throws UnsupportedOperationException {

    throw new UnsupportedOperationException(
        "This operation is not supported by " + this.name());
    
    
  }
  // TODO Override other methods if required
  // TODO Add private helper methods as needed

}
