/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

class LastDigitsOfHashCode implements Transformer<Object, Integer> {
  /**
   * Number of digits to be taken from the back of the hashcode.
   */
  private int numOfDigits;

  /**
   * Constructor for LastDigitsOfHashCode.
   *
   * @param numOfDigits  Sets the numOfDigits.
   */
  public LastDigitsOfHashCode(int numOfDigits) {
    this.numOfDigits = numOfDigits;
  }  

  @Override
  public Integer transform(Object obj) {
    int hc = obj.hashCode();
    return Math.abs(hc % (int) Math.pow(10, numOfDigits));
  }
}
