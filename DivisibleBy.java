/**
 * A boolean condition with an integer parameter y that can be 
 * apply to another integer x.  Returns true if x is divisible 
 * by y, false otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

class DivisibleBy implements BooleanCondition<Integer> {
  /**
   * Number that the contents of a box is to be divided by.
   */
  private int divisor;

  /**
   * Constructor for DivisibleBy.
   *
   * @param divisor  Sets the divisor.
   */
  public DivisibleBy(int divisor) {
    this.divisor = divisor;
  }

  @Override
  public boolean test(Integer dividend) {
    int quotient = dividend / divisor;
    return quotient * divisor == dividend;
  }
}
