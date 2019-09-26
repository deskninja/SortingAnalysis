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
	
	  public InsertionSort() {
	    this.name = "QuickSortNaive";
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
	
	while(currentIndex + 1 < list.size()) { //until the last item in the array
		postionFound = false;
		compareIndex = currentIndex;
		while(!postionFound) { //as long as the number is not sorted
			if(list.get(compareIndex).compareTo(list.get(compareIndex + 1)) <= 0) //if the next number is less than the last one
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

  // TODO Override other methods if required

}
