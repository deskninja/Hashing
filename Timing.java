package assignment08;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Garrett Keefe & Joshua Wells
 * 
 * Timing Class for Assignment 08
 *
 */

public class Timing {

    private HashTableSet<Integer> table;
    private ArrayList<Integer> tableSize;
    private int itemInTable;
    
/**
 * Initializes the required variables and tables for use
 */
    @Before
    public void setUp(){
        table = new HashTableSet<>();
        tableSize = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) { //from 10^1 to 10^6
            tableSize.add((int) (Math.pow(10, i + 1)));
        }

    }
    
/**
 * creates a table for usage in testing .contains
 * 
 * @param size
 * @return Table of Size {int size}
 */
    private HashTableSet<Integer> createTable(int size){
        table = new HashTableSet<Integer>();
        for(int i = 0; i < size; i++){
            //distinct integer {int i} is added to the hashTable
            itemInTable = (i);
            table.add(itemInTable); //add the integer
        }
        return table;
    }

    /**
     * creates a table for usage in testing .contains
     * 
     * @param size
     * @return Table of Size {int size} with buckets {int buckets}
     */
    private HashTableSet<Integer> createTable(int size, int buckets){
        table = new HashTableSet<Integer>(buckets);
        for(int i = 0; i < size; i++){
            //distinct integer {int i} is added to the hashTable
            itemInTable = (i);
            table.add(itemInTable); //add the integer
        }
        return table;
    }

    /**
     * test contains on given hash table x
     * @param x
     * @return time required to run contains
     */
    private long getContainsTime(HashTableSet<Integer> x) {
        Random rand = new Random();
        long start = System.nanoTime();
        x.contains(rand.nextInt());
        long stop = System.nanoTime();

        return stop - start;
    }

    /**
     * Calculates an average of amount of time to run contains on each size
     * @param x
     * @param times
     * @return Average of the timing for contains
     */
    private long averageTime(HashTableSet<Integer> x, long times){
        long average = 0L;
        for (int i = 0; i < times; i++){
            average += getContainsTime(x);
        }
        return average / times;
    }

    /**
     * Method that tests contains on tables of various sizes and bucket sizes.
     */
    @Test
    public void times(){
        for (int num :
                tableSize) {
            HashTableSet<Integer> x = createTable(num);
            System.out.println("The time for " + num + " sized table was: ");
            System.out.println((averageTime(x, 100)));
        }

        for (int num :
                tableSize) {
            HashTableSet<Integer> x = createTable(num, 1000);
            System.out.println("The time for " + num + " sized table was: ");
            System.out.println((averageTime(x, 100)));
        }
    }

}