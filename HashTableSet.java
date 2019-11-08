package cs2420;

import components.set.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Hash Table based implementation of a Set.
 *
 * @author Garrett Keefe and Joshua Wells
 *
 * @param <E> type of the elements of this set
 */
public class HashTableSet<E> {

  /*
   * Private members -----
   */
  private static final int DEFAULT_NUM_BUCKETS = 101;
  private ArrayList<Set<E>> hashTable;
  private int size;
  private int buckets;

  private int hashNum(E x) {
    int hashNum = x.hashCode();
    return mod(hashNum, this.numBuckets());
  }

  /**
   * Computes {@code a} mod {@code b} as % should have been defined to work.
   *
   * @param a the number being reduced
   * @param b the modulus
   * @return the result of a mod b, which satisfies {@code 0 <=  mod < b}
   * @requires b > 0
   */
  public static int mod(int a, int b) {
    assert b > 0 : "Violation of: b > 0";
    int r = a-(b*(a/b));
    if(r < 0) {
      r = b + r;
    }
    return r; // TODO implement this method
  }

  /*
   * Constructors -----
   */
  /**
   * No-argument constructor, resulting in a hash table of default size.
   */
  public HashTableSet() {
    this(DEFAULT_NUM_BUCKETS);
  }

  /**
   * Constructor resulting in a hash table of size {@code hashTableSize}.
   *
   * @param hashTableSize size of hash table
   */
  public HashTableSet(int hashTableSize) {
    this.buckets = hashTableSize;
    clear();
  }

  /*
   * Set methods -----
   */
  /**
   * Adds {@code x} to {@code this}.
   *
   * @param x the element to be added
   *
   * @modifies {@code this}
   *
   * @requires {@code x} is not in {@code this}
   *
   */
  public void add(E x) {
    assert x != null : "Violation of: x is not null";
    assert !this.contains(x) : "Violation of: x is not in this";
    int bucketIndex = hashNum(x);
    this.hashTable.get(bucketIndex).add(x);
  }

  /**
   * Removes {@code x} from this.
   *
   * @param x the element to be removed
   *
   * @modifies {@code this}
   *
   * @requires {@code x} is in {@code this}
   *
   */
  public void remove(E x) {
    assert x != null : "Violation of: x is not null";
    assert this.contains(x) : "Violation of: x is in this";
    int bucketIndex = hashNum(x);
    this.hashTable.get(bucketIndex).remove(x);
  }

  /**
   * Reports whether {@code x} is in {@code this}.
   *
   * @param x the element to be checked
   * @return true iff element is in {@code this}
   *
   */
  public boolean contains(E x) {
    assert x != null : "Violation of: x is not null";
    int bucketIndex = hashNum(x);
    return this.hashTable.get(bucketIndex).contains(x);
  }

  /**
   * Reports the number of elements in {@code this}.
   *
   * @return size of this set
   */
  public int size() {
    return this.size; // TODO implement this method
  }

  /**
   * Removes all the elements in {@code this}.
   */
  public void clear() {
    this.hashTable = new ArrayList<Set<E>>();
    for(int i = 0; i < this.numBuckets(); i++) {
      Set<E> x = new SetOnArrayList<E>();
      this.hashTable.add(x);
    }
    this.size = 0;
  }

  /*
   * Methods inherited from Object
   */
  /**
   * String representation of the hash table. Elements in bucket 0, followed by
   * those in bucket 1, and so on, separated by commas and enclosed in {..}.
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("{");
    for (int i = 0; i < numBuckets(); i++) {
      Iterator it = this.hashTable.get(i).iterator();
      while(it.hasNext()){
    	if(s.length() > 1 && s.charAt(s.length()-1) != ',') {
    		s.append(",");
    	}
        s.append(it.next());
        if(it.hasNext()) {
        	s.append(",");
        }
      }
    }
    s.append("}");
    return s.toString();
  }

  /*
   * Other methods specific to hash tables; for testing/performance purposes only
   */
  /**
   * Returns the number of elements in the specified bucket.
   *
   * @param bucketIndex index of the bucket requested
   * @requires 0 <= bucketIndex < numBuckets()
   */
  public int bucketSize(int bucketIndex) {
    return this.hashTable.get(bucketIndex).size();
  }

  /**
   * Reports the number of buckets in this hashtable.
   *
   * @return number of buckets
   */
  public int numBuckets() {
    return this.buckets;
  }

}