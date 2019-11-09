package assignment08;

public class A08String {
  private String str;

  public A08String() {
    this.str = "";
  }

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
