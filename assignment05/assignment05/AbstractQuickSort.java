package assignment05;

import java.util.List;

/**
 * Implementation of common methods for all quick-sort variants.
 * 
 * @author Jonathan Oliveros and Joshua Wells
 *
 * @param <T> type of elements of the collection to be sorted
 */
public abstract class AbstractQuickSort<T extends Comparable<? super T>> extends AbstractSorter<T> {
	/**
	 * Returns the pivot around which to quick-sort the list. This method may modify
	 * the {@code list}, e.g., median of three will move smallest value to front of
	 * the list.
	 * 
	 * @param list  the list to find the pivot in
	 * @param start start-index of the sublist to consider
	 * @param end   end-index of the sublist to consider
	 * @return pivot for quick-sort
	 * 
	 * @requires start <= end
	 * 
	 * @modifies {@code list}
	 */
	protected abstract T pivot(List<T> list, int start, int end);
	
	private int quickSortThreshHold;
	/**
	 * Determines a pivot and partitions the {@code list} between {@code left} and
	 * {@code right} such that all elements less than pivot are on its left and all
	 * elements greater than pivot are to its right.
	 * 
	 * @param list  the list to be partitioned
	 * @param left  start-index of the sublist to partition
	 * @param right end-index of the sublist to partition
	 * @return the location of the pivot in the resulting list
	 * 
	 * @modifies {@code list}
	 */
	protected int partition(List<T> list, int left, int right) {
		assert list != null : "Violation of: list is not null";
		if (right - left <= 1)
			// only position the pivot can be at is 0
			return left;
		else if (right - left == 2) {
			if (list.get(left).compareTo(list.get(right)) > 0) {
				SortUtils.swapElementsAt(list, left, right);
				return right;
			}
			// pivot position is at 0
			return left;
		} else {
			T pivot = pivot(list, left, right);
			int pivotLocation = left;
			int lastLessThanPivot = right;
			while (left < right) {
				left++;
				T first = list.get(left);
				while (first.compareTo(pivot) < 0 && right > left) {
					left++;
					first = list.get(left);
				}
				T second = list.get(right);
				while (second.compareTo(pivot) > 0 && right > left) {
					right--;
					second = list.get(right);
				}
				if (first.compareTo(second) > 0 && right > left) {
					lastLessThanPivot = left;
					SortUtils.swapElementsAt(list, left, right);
				}
				right--;
			}
			if(left != pivotLocation + 1 || (pivotLocation + 1 == left && list.get(pivotLocation).compareTo(list.get(pivotLocation + 1)) > 0)) {
				SortUtils.swapElementsAt(list, pivotLocation, lastLessThanPivot);
				pivotLocation = lastLessThanPivot;
			}
			return pivotLocation;
		}
	}

	/**
	 * Sorts the virtual {@code list} between indexes {@code left} and {@code right}
	 * using the Quick-Sort algorithm.
	 * 
	 * @param list  the list to be sorted
	 * @param left  start-index of the sublist to be sorted
	 * @param right end-index of the sublist to be sorted
	 * 
	 * @modifies {@code list}
	 */
	 protected void quickSort(List<T> list, int left, int right) {
	    assert list != null : "Violation of: list is not null";
	    
	    if(list.size() < this.threshold()) {
	    	InsertionSort<T> simpleSort = new InsertionSort<>();
	    	simpleSort.sort(list);
	    }
	    
	    else if(right - left == 2) {
	    	if(list.get(right).compareTo(list.get(left)) > 0)
	    		SortUtils.swapElementsAt(list, right, left);;
	    }
	    
	    else if(right - left > 2) {
	    	int pivot = partition(list, left, right);
	    	if(pivot != left)
	    		quickSort(list, left, pivot - 1);
	    	if(pivot != right)
	    		quickSort(list, pivot + 1, right);
	    }
	  }
	 @Override
	  public void sort(List<T> list) {
	    assert list != null : "Violation of: list is not null";

	    int left = 0; //far right index of the list
	    int right = list.size()	- 1; //get the far left index of the list
	    quickSort(list, left, right); //quickSort the list
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