package assignment05;

import java.util.List;

/**
 * Implements insertion sort using the {@code Sorter} interface.
 * 
 * This class does not implement the {@code setThreshold} method.
 * 
 * @author Joshua Wells and Jonathan Oliveros
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class InsertionSort<T extends Comparable<? super T>> extends AbstractSorter<T> {
	
	  /**
	 * sole constructor
	 * sets complexity class and sets the name of the sorting algorythm 
	 */
	public InsertionSort() {
	    this.name = "InsertionSort";
	    this.complexity = ComplexityClass.NSQUARED;
	  }

	/**
	 * Swaps T elements to their corresponding location.
	 * @param <T> Generic type.
	 * @param index of list.
	 * @param list of T elements.
	 */
	private static <T> void swapItems(int index, List<T> list){
		T temp = list.get(index);
		list.set(index, list.get(index + 1));
		list.set(index + 1, temp);
	}
	
	@Override	
	public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";
    
    int currentIndex = 0;
	boolean postionFound = false;
	int compareIndex = 0;
	
	while(currentIndex + 1 < list.size()) { 
		postionFound = false;
		compareIndex = currentIndex;
		while(!postionFound) { //as long as the number is not sorted
			if(list.get(compareIndex).compareTo(list.get(compareIndex + 1)) <= 0) 
				postionFound = true;
			else { //swap the two values
				swapItems(compareIndex, list);
				compareIndex--;
				if(compareIndex < 0)
					postionFound = true;
			}
		}
		currentIndex++;
	}
  }

}
