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
	
	private int quickSortThreshHold;
	
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
  
  /**
   * Assumes the pivot method moves the pivot to index 0 of {@code list}
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
	  
	  //check the threshold to see if we need to do an insertion sort
	  if(this.threshold() > list.size()) {
	    	InsertionSort<T> simpleSort = new InsertionSort<>();
	    	simpleSort.sort(list);
	  }    
	  
	  //if {@code list} is less than three items long
	  if(right - left < 2) {
		  //if {@code list} is one item long
		  if(right - left == 0)
			  return left;
		  //if {@code list} is two items long
		  if(list.get(left).compareTo(list.get(right)) > 0) { //compare the {@code list} element at postion {@code left} and {@code right}
			  SortUtils.swapElementsAt(list, left, right); //if {@code left} is greater than right swap them
			  return right; //the pivot is now at position {@code right}
		  }
		  //it is a two item sorted array already
		  return left;	  
	  }
	  
	  T pivot = pivot(list, left, right);
	  int pivotPostion = left;
	  left++;
	  
	  while(left < right) { //while the left item is less than the right item
		  
		  	//while the items from the left are less than or equal to the pivot
	    	while(list.get(left).compareTo(pivot) <= 0 && left < right) {
	    		//go left to the next item
	    		left++;
	    	}
	    	
	    	//while the items from the right are less than the pivot
	    	while(list.get(right).compareTo(pivot) > 0 && left < right) {
	    		//go right to the next item
	    		right--;
	    	}
	    	
	    	//if the left item is still to the left of the right item
	    	if(left < right)
	    		//swap the two locations where left is greater than pivot and right is less than pivot
	    		SortUtils.swapElementsAt(list, right, left);
	  }
	  //note that we have two cases now, left can be less than or equal to the pivot if left reached right first
	  //or left can be greater than the pivot if right reached the left index
	  
	  //if the last left item is less than or equal to the pivot
	  if(list.get(left).compareTo(list.get(pivotPostion)) <= 0) {
		  //swap the pivot an the item
		  SortUtils.swapElementsAt(list, pivotPostion, left);
		  //return the position of the pivot
		  return left;
	  }
	  
	  //the left item is greater than pivot
	  else {
		  //swap the item before left
		  SortUtils.swapElementsAt(list, pivotPostion, left - 1); //does nothing if {@code left} - 1 is at the pivot location
		  return left - 1; //return the pivot location
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
    
    //note left is a lower index in list and right is a higher index in list
    //find the pivot after sorting smaller to the left of pivot and larger to the right of pivot
	int pivot = partition(list, left, right);
	//if the pivot is not at positon far left (no left side of the partition)
	if(pivot != left)
		//continue halving and finding a pivot
		quickSort(list, left, pivot - 1); //ignore the item at the pivot location
	//if the pivot is not at position far right (no right side of the partiton)
	if(pivot != right)
		//continue halving and finding a pivot
		quickSort(list, pivot + 1, right); //ignore the item at the pivot location
  }

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";

    int left = 0; //far right index of the list
    int right = list.size()	- 1; //get the far left index of the list
    if(list.size() != 1) { //if the array is bigger than size 1
    	if(list.size() < this.threshold()) {
        	InsertionSort<T> simpleSort = new InsertionSort<>();
        	simpleSort.sort(list);
        }
    	//if the threshold is less than the list size quickSort
    	quickSort(list, left, right); //quickSort the list
    }
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
