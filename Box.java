/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Zhiyang Lu (Lab 14H)
 */

class Box<T> {
  /**
   * Content of the box with parameterised type T.
   */
  private final T content;

  /**
   * Default empty box, used when a box of null is required.
   */
  private static final Box<?> EMPTY_BOX = new Box<>(null);

  /**
   * Private constructor for Box.
   *
   * @param content  Object that is to be stored in the box.
   */
  private Box(T content) {
    this.content = content;
  }

  /**
   * Factory function to create a box. Null input returns null.
   *
   * @param input  Content that is to be passed into constructor.
   * @return  Box of given content with inferred type.
   */
  static <U> Box<U> of(U input) {
    if (input == null) {
      return null;
    } else {
      return new Box<U>(input);
    }
  }

  /**
   * Factory function to create a box. Null input returns EMPTY_BOX.
   *
   * @param input  Content that is to be passed into constructor.
   * @return  Box of given content with inferred type.
   */
  static <U> Box<U> ofNullable(U input) {
    if (input == null) {
      // Appropriate and safe to do so because EMPTY_BOX is of type
      // Box<?> so it can take the form of a Box with any parameterised
      // types. Thus can safely be casted.
      @SuppressWarnings("unchecked")
      Box<U> result = (Box<U>) EMPTY_BOX;
      return result;
    } else {
      return new Box<U>(input);
    }
  }

  /**
   * Returns an EMPTY_BOX.
   *
   * @return  EMPTY_BOX of inferred type.
   */
  static <U> Box<U> empty() {
    // Appropriate and safe to do so because EMPTY_BOX is of type
    // Box<?> so it can take the form of a Box with any parameterised
    // types. Thus can safely be casted.
    @SuppressWarnings("unchecked")
    Box<U> result = (Box<U>) EMPTY_BOX;
    return result;
  }

  /**
   * Checks if the box has non-null content.
   *
   * @return  True if content is non-null, False if empty.
   */
  public boolean isPresent() {
    return this.content != null
      ? true
      : false;
  }

  /**
   * Return EMPTY_BOX if content fails test, otherwise return box as is.
   *
   * @param bc  BooleanCondition of type T or its super type.
   * @return  Box of type T.
   */
  public Box<T> filter(BooleanCondition<? super T> bc) {
    if (this.isPresent() && bc.test(this.content)) {
      return this;
    }  else {
      // Appropriate and safe to do so because EMPTY_BOX is of type
      // Box<?> so it can take the form of a Box with any parameterised
      // types. Thus can safely be casted.
      @SuppressWarnings("unchecked")
      Box<T> result = (Box<T>) EMPTY_BOX;
      return result;
    }
  }

  /**
   * Transform the content of box from type T to U, then return new box.
   *
   * @param transformer  Transformer that can transform type T or its
   *                     super types into type U.
   * @return  New box of type U.
   */
  public <U> Box<U> map(Transformer<? super T, U> transformer) {
    if (this.isPresent()) {
      return new Box<U>(transformer.transform(this.content));
    } else {
      // Appropriate and safe to do so because EMPTY_BOX is of type
      // Box<?> so it can take the form of a Box with any parameterised
      // types. Thus can safely be casted.
      @SuppressWarnings("unchecked")
      Box<U> result = (Box<U>) EMPTY_BOX;
      return result;
    }
  }

  /**
   * Method to access the content of the box.
   *
   * @return content of type T.
   */
  public T getContent() {
    return this.content;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Box<?>) {
      Box<?> box = (Box<?>) obj;
      return this.content == box.getContent()
        ? true
        : this.content == null || box.getContent() == null
        ? false
        : this.content.equals(box.getContent());
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return this.content != null
      ? "[" + content + "]"
      : "[]";
  }
}
