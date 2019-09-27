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
	
	public void insertionSort(List<T> list1, List<T> list2){
		boolean sorted = false;
		int index = 0;
		for(T item: list2) {
			while(!sorted) {
				if(list1.size() == index) {
					list1.add(item);
				}
				else if(item.compareTo(list1.get(index)) < 0) {
					list1.add(index, item);
					sorted = true;
				}
				index++;
			}
			sorted = false;
		}
	}
	
	private void sortRecursive(List<T> list) {
		if(list.size() > 1) {
    		List<T> firstHalf = new ArrayList<>(); //first half of {@code list}
    		firstHalf = partOfList(list, 0, list.size()/2);
    		sortRecursive(firstHalf);
    		
    		List<T> secondHalf = new ArrayList<>(); //second half of {@code list}
    		secondHalf = partOfList(list, list.size()/2, list.size());
    		sortRecursive(secondHalf);
    		
    		insertionSort(firstHalf, secondHalf);
    	}
	}
	
	public List<T> partOfList(List<T> list, int beginIndex, int endIndex){
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
	    insertionSortThreshold = 10; //default threshold
	}

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";
    
    //if the list is smaller than the threshold insertion sort it
    if(this.threshold() >= list.size()) {
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
