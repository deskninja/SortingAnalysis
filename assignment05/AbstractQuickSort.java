package assignment05;

import java.util.List;

/**
 * Implementation of common methods for all quick-sort variants.
 * 
 * @author Jonathan Oliveros and Joshua Wells
 *
 * @param <T> type of elements of the collection to be sorted
 */
public abstract class AbstractQuickSort<T extends Comparable<? super T>>
    extends AbstractSorter<T> {
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

    if(list.size() == 1)
    	return left;
    
    T thisPivot = pivot(list, left, right);
    int index = left + 1; //this assumes that {@code thisPivot} is at index position left
    int currentRight = right; //tracks right as new numbers are added to the left which do not need to be sorted
    while(index != currentRight) { 
    	if(list.get(index).compareTo(thisPivot) > 0) { //if the item in the list is greater than the pivot
    		list.add(currentRight + 1, list.get(index)); //insert the element to the position past the current left
    		currentRight--; //ignore the last element already sorted
    		list.remove(index); //remove the element just inserted and now the inserted element should be at location left
    	}
    	else { //less than or equal to the pivot
    		list.add(left, list.get(index)); //insert the element at the position right after the pivot
    		list.remove(index); //remove the element at the previous place
    		index++; //next element
    	}
    }
    
    list.add(index, list.get(left)); //insert the list after the last element less than or equal to it
    
    return index; 
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

    int pivot = this.partition(list, left, right); //sort and get the position of the new pivot
    quickSort(list, left, pivot - 1); //sort the left side excluding the pivot
    quickSort(list, pivot + 1, right); //sorts the right side excluding the pivot
  }

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";

    int left = 0; //far right index of the list
    int right = list.size()	- 1; //get the far left index of the list
    quickSort(list, left, right); //quickSort the list
  }

}
