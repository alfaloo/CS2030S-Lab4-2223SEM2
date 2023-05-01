/**
 * The Transformer interface that can transform a type T
 * to type U.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

interface Transformer<T, U> {
  /**
   * Transforms object of type T to object of type U.
   * 
   * @param t  Object to be transformed.
   * @return  Object of type U.
   */
  public U transform(T t);
}
