/**
 * A boolean condition with parameter x that can be applied to
 * a string.  Returns true if the string is longer than x; false
 * otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

class LongerThan implements BooleanCondition<String> {
  /**
   * Length which the contents of a box is compared to.
   */
  private int maxLength;

  /**
   * Constructor for LongerThan.
   *
   * @param maxLength  Sets the maximum length.
   */
  public LongerThan(int maxLength) {
    this.maxLength = maxLength;
  }

  @Override
  public boolean test(String string) {
    return string.length() > this.maxLength;
  }
}
