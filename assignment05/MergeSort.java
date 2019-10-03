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
	
	/**
	 * merges the second list into the first one
	 * @param list1 a sorted List<T>
	 * @param list2 a sorted List<T>
	 * @return List<T> of size {@code list1} + {@code list2}
	 */
	public List<T> merge(List<T> list1, List<T> list2){
		boolean sorted = false;
		int index = 0;

		for(T item: list2) {
			while(!sorted) {
				//if every item in list 2 will be greater than every item in list1
				if(list1.size() == index) {
					list1.add(item);
					sorted = true;
				}
				//if the item in {@code list2} is less than or equal to the item in {@code list1}
				else if(item.compareTo(list1.get(index)) <= 0) {					
					list1.add(index, item);
					sorted = true;
				}
				//go to the next postion in {@code list1}
				index++;
			}
			//reset sorted
			sorted = false;
		}
		//return the sorted list
		return list1;
	}
	
	/**
	 * merge sorts {@code list} using divide and conquer recursively
	 * @param list is a List<T>
	 * @return list sorted in ascending order
	 */
	private List<T> sortRecursive(List<T> list) {
		//if the set threshold is greater than {@code list} size
		if(this.threshold() > list.size()) {
			//insertion sort {@code list}
	    	InsertionSort<T> simpleSort = new InsertionSort<>();
	    	simpleSort.sort(list);
	    }
		
		//if the set threshold is less than {@code list} size
		else if(list.size() > 1) {
    		List<T> firstHalf = new ArrayList<>(); //first half of {@code list}
    		firstHalf = partOfList(list, 0, list.size()/2);
    		
    		
    		List<T> secondHalf = new ArrayList<>(); //second half of {@code list}
    		secondHalf = partOfList(list, list.size()/2, list.size());
    		
    		firstHalf = sortRecursive(firstHalf); //recursively sort the first half of {@code list}
    		
    		secondHalf = sortRecursive(secondHalf); //recursively sort the second half of {@code list}
    		
    		return this.merge(firstHalf, secondHalf); //merge the two halves together
    	}
		return list; //return the sorted list
	}
	
	/**
	 * Return part of a list from beginIndex (inclusive) to endIndex (exclusive)
	 * @param list object type List<T>
	 * @param beginIndex 
	 * @param endIndex
	 * @return half object type List<T> with all elements from indecies {@code beginIndex} (inclusive) to {@code endIndex} (exclusive)
	 */
	public List<T> partOfList(List<T> list, int beginIndex, int endIndex){
		List<T> half = new ArrayList<>();
		while(beginIndex < endIndex) {
			half.add(list.get(beginIndex));
			beginIndex++;
		}
		return half;
	}

	/**
	 * sole constructor
	 */
	public MergeSort() {
		this.name = "MergeSort";
	    this.complexity = ComplexityClass.NLOGN;
	    insertionSortThreshold = 0; //default threshold
	}

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";
    
    List<T> temp = new ArrayList<>();
  	temp.addAll(sortRecursive(list));
  	list.clear();
  	list.addAll(temp);
    
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
