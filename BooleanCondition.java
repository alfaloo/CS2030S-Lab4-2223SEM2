/**
 * A conditional statement that returns either true of false.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

interface BooleanCondition<T> {
  /**
   * Some condition for the contents inside a Box.
   *
   * @param content  The content inside the box.
   * @return  True if content passes, false otherwise.
   */
  public abstract boolean test(T content);
}
