package assignment05;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the merge sort using the {@code Sorter} interface.
 * 
 * This class must implement the {@code setThreshold, threshold} methods.
 * 
 * @author Joshua Wells and Jonathan Oliveros
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class MergeSort<T extends Comparable<? super T>> extends AbstractSorter<T> {
	
	private int insertionSortThreshold;
	
	private List<T> insertionSort(List<T> list1, List<T> list2){
		boolean sorted = false;
		int index = 0;
		for(T item: list2) {
			while(!sorted) {
				if(item.compareTo(list1.get(index)) > 0) {
					list1.add(index, item);
					sorted = true;
				}
				index++;
			}
		}
		return list1;
	}
	
	private void sortRecursive(List<T> list) {
		if(list.size() > 1) {
    		List<T> firstHalf = new ArrayList<>(); //first half of {@code list}
    		firstHalf = partOfList(list, 0, list.size()/2);
    		sortRecursive(firstHalf);
    		List<T> secondHalf = new ArrayList<>(); //second hald of {@code list}
    		secondHalf = partOfList(list, list.size()/2, list.size());
    		sortRecursive(secondHalf);
    		insertionSort(firstHalf, secondHalf);
    	}
	}
	
	private List<T> partOfList(List<T> list, int beginIndex, int endIndex){
		List<T> half = new ArrayList<>();
		while(beginIndex < endIndex) {
			half.add(list.get(beginIndex));
			beginIndex++;
		}
		return half;
	}

	public MergeSort() {
		this.name = "MergeSort";
	    this.complexity = ComplexityClass.NLOGN;
	    insertionSortThreshold = 20; //default threshold
	}

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";
    
    //if the list is smaller than the threshold insertion sort it
    if(threshold() <= list.size()) {
    	InsertionSort<T> simpleSort = new InsertionSort<>();
    	simpleSort.sort(list);
    }
    
    //if the list is larger than the threshold merge sort it
    else {
    	sortRecursive(list);
    }  
 }
  
  @Override
  public void setThreshold(int threshold)
      throws UnsupportedOperationException {
    assert threshold >= 0 : "Violation of: threshold non-negative";

    insertionSortThreshold = threshold;
  }

  @Override
  public int threshold() throws UnsupportedOperationException {
	  return insertionSortThreshold;
  }
}