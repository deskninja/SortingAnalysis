package assignment05;

import java.util.List;

/**
 * Implements insertion sort using the {@code Sorter} interface.
 * 
 * This class does not implement the {@code setThreshold} method.
 * 
 * @author Swaroop Joshi
 *
 * @param <T> type of the element of the list this sorter can sort
 */
public class InsertionSort<T extends Comparable<? super T>>
    extends AbstractSorter<T> {

  // TODO add constructor

  @Override
  public void sort(List<T> list) {
    assert list != null : "Violation of: list is not null";

    // FIXME implement; you can reuse YOUR OWN code from Assignment04
  }

  // TODO Override other methods if required
  // TODO Add private helper methods as needed

}
