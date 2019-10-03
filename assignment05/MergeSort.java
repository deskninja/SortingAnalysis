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
	
	public List<T> merge(List<T> list1, List<T> list2){
		boolean sorted = false;
		int index = 0;
		List<T> newArray = new ArrayList<>();
		for(T item: list1) {
			newArray.add(item);
		}
		
		for(T item: list2) {
			while(!sorted) {
				if(newArray.size() == index) {
					newArray.add(item);
					sorted = true;
				}
				else if(item.compareTo(newArray.get(index)) <= 0) {
					newArray.add(index, item);
					sorted = true;
				}
				index++;
			}
			sorted = false;
		}
		return newArray;
	}
	
	private List<T> sortRecursive(List<T> list) {
		if(list.size() > 1) {
    		List<T> firstHalf = new ArrayList<>(); //first half of {@code list}
    		firstHalf = partOfList(list, 0, list.size()/2);
    		
    		
    		List<T> secondHalf = new ArrayList<>(); //second half of {@code list}
    		secondHalf = partOfList(list, list.size()/2, list.size());
    		
    		firstHalf = sortRecursive(firstHalf);
    		
    		secondHalf = sortRecursive(secondHalf);
    		
    		firstHalf = merge(firstHalf, secondHalf);
    		return firstHalf;
    	}
		return list;
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
    	List<T> newList = new ArrayList<>();
    	newList = sortRecursive(list);
    	list = newList;
    	System.out.println(list);
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
