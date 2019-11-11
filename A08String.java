package assignment08;

/**
 * @author Garrett Keefe and Joshua Wells
 */
public class A08String {
  /**
   * holds the String data
   */
  private String str;

  /**
   * no argument constructor
   */
  public A08String() {
    this.str = "";
  }

  /**
   * constructor that stores str in this
   * @param str String to be stored
   */
  public A08String(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return str;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null)
      return false;
    if (this == other)
      return true;
    if (!(other instanceof A08String))
      return false;
    A08String that = (A08String) other;
    return this.str.equals(that.str);
  }

  @Override
  public int hashCode() {
    int sum = 0;
    char[] x = str.toCharArray();
    for(int i = 0 ; i < x.length; i++) {
      sum = sum + Integer.valueOf(x[i]);
    }
    sum += x.hashCode();
    return sum * str.length();
  }
}