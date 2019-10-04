package assignment05;

/**
 * @author Jonathan Oliveros and Joshua Wells
 *
 */
public enum ComplexityClass {
  LOGN("O(log n)"), N("O(n)"), NLOGN("O(n log n)"), NSQUARED("O(n^2)");
  private String value;

  /**
   * sets this.value to the complexity given
 * @param value the complexity of the algorythm
 */
private ComplexityClass(String value) {
    this.value = value;
  }

  /**
 * @return the complexity of the algorythm
 */
public String value() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
