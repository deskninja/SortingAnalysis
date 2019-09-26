package assignment05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Various utility methods for Sorting analysis.
 * 
 * @author Joshua Wells and Jonathan Oliveros
 *
 */
public final class SortUtils {

	
	
  /**
   * Sole constructor -- making it private ensures this class cannot be
   * instantiated.
   * 
   */
  private SortUtils() {
  }

  /**
   * Swaps the elements at the given positions in the list.
   * 
   * @param <T>  type of the elements of the list
   * @param list list in which elements are to be swapped
   * @param i    index of the first element
   * @param j    index of the second element
   * 
   * @requires {@code i} and {@code j} are valid indices
   * 
   * @modifies {@code list}
   * 
   */
  final public static <T> void swapElementsAt(List<T> list, int i, int j) {
    assert list != null : "Violation of: list is not null";
    assert 0 <= i && i < list.size() : "Violation of: i is a valid index";
    assert 0 <= j && j < list.size() : "Violation of: i is a valid index";

    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  /**
   * Reports if the given list is sorted in the increasing order according to
   * its "natural order", i.e., the one described by its {@code compareTo} method.
   * 
   * @param <T>  type of the elements of the list
   * @param list the given list
   * @return true iff {@code list} is sorted
   */
  public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
    assert list != null : "Violation of: list is not null";
    boolean isSorted = true;
    int index = 0;
    
    while(isSorted) {
    	if(list.get(index).compareTo(list.get(index+1)) > 0)
    		isSorted = false;
    }

    return isSorted; 
  }

  /**
   * Creates and returns a list of the given number of random integers.
   * 
   * @param count number of integers to generate
   * @return list of {@code count} number of integers
   * 
   * @requires count >= 0
   */
  public static List<Integer> listOfRandomInts(int count) {
    assert count >= 0 : "Violation of count >= 0";
    
    List<Integer> listOfInts = new ArrayList<>();
    
    Random rand = new Random();
    
    for(int i = 0; i < count; i++) {
    	Integer nextInt = rand.nextInt();;
    	listOfInts.add(nextInt);
    }
    
    return listOfInts; 
  }

  /**
   * Creates and returns a list of the given number of integers in a
   * increasing order.
   * 
   * @param count number of integers to generate
   * @return list of {@code count} number of integers
   * 
   * @requires count >= 0
   */
  public static List<Integer> listOfSortedInts(int count) {
    assert count >= 0 : "Violation of count >= 0";
    
    List<Integer> sortedInts = new ArrayList<>();
    sortedInts = listOfRandomInts(count);
    
    return null; 
  }

  /**
   * Creates and returns a list of the given number of integers in a
   * decreasing order.
   * 
   * @param count number of integers to generate
   * @return list of {@code count} number of integers
   * 
   * @requires count >= 0
   */
  public static List<Integer> listOfReversedSortedInts(int count) {
    assert count >= 0 : "Violation of count >= 0";

    return null; // FIXME implement
  }

  /**
   * Creates and returns a list of the given number of integers where each element
   * is a copy of {@code element}.
   * 
   * @param count   number of integers to generate
   * @param element number to be duplicated
   * @return list of {@code count} number of integers
   * 
   * @requires count >= 0
   * 
   */
  public static List<Integer> listOfDuplicateInts(int count, int element) {
    assert count >= 0 : "Violation of count >= 0";

    
    
    return null;
  }

  /**
   * Measures the running time of the sort method of the given routine on the
   * given list. After running the sorter, if the list is sorted, it returns the
   * time taken by the {@code sortRoutine} in nanoseconds, otherwise returns
   * {@code Long.MIN_VALUE}.
   * 
   * @param sortRoutine the sorting algorithm to test
   * @param list        the list to be sorted
   * @return running time of the given sorter in nanoseconds if the sorting was
   *         correct, {@code Long.MIN_VALUE} otherwise.
   * 
   * @modifies {@code list}
   */
  public static long testAndTime(Sorter<Integer> sortRoutine,
      List<Integer> list) {
    assert sortRoutine != null : "Violation of: sortRoutine not null";
    assert list != null : "Violation of: list is not null";
    
    long start = System.nanoTime();
    
    long stop = System.nanoTime();

    return stop - start; 
  }

  /**
   * Generates the timing report in a specified format for the given sorter. It
   * runs the sorter on various lists (random, sorted, reverse-sorted, duplicates)
   * of various sizes (from {@code startSize} to {@code maxSize}, incremented by
   * {@code sizeIncrement}), ensures the sorter is sorting the list correctly, and
   * prints out the name of the sorter and the time it takes in nanoseconds in the
   * following format:
   * 
   * <sorter_name>;<list_type>;<list_size>;<time_taken>
   * 
   * @param sortRoutine   sorter to be tested
   * @param startSize     start size of the lists
   * @param sizeIncrement how many elements to go up in each iteration
   * @param maxSize       maximum size of the lists to be tested
   * @param timeoutSec    if the last iteration of the test took more time than
   *                      this number, don't do any more tests in this category
   *                      (in seconds)
   * 
   * @requires startSize >= 0 and startSize <= maxSize and timeoutSec > 0
   */
  public static void generateTimingReport(Sorter<Integer> sortRoutine,
      int startSize, int sizeIncrement, int maxSize, int timeoutSec) {
    assert startSize >= 0 : "Violation of: startSize >= 0";
    assert startSize <= maxSize : "Violation of: startSize <= maxSize";
    assert timeoutSec > 0 : "Violation of: timeoutSec > 0";
    assert sortRoutine != null : "Violation of: sortRoutine not null";

    SimpleWriter out = new SimpleWriter1L();
    out.println(sortRoutine.name() + " (Expected runtime: "
        + sortRoutine.getExpectedComplexityClass() + ")");
    out.println("=============================================");
    
    

    out.println("=============================================");
    out.close();
  }

}
