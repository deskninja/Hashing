package assignment08;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Random;

public class Timing {

    private HashTableSet<Integer> table;
    private ArrayList<Integer> tableSize;
    private int itemInTable;

    @Before
    public void setUp(){
        table = new HashTableSet<>();
        tableSize = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) { //from 10^1 to 10^6
            tableSize.add((int) (Math.pow(10, i + 1)));
        }

    }

    private HashTableSet<Integer> createTable(int size){
        table = new HashTableSet<Integer>();
        for(int i = 0; i < size; i++){
            //distinct integer {int i} is added to the hashTable
            itemInTable = (i);
            table.add(itemInTable); //add the integer
        }
        return table;
    }

    private long getContainsTime(HashTableSet<Integer> x) {
        Random rand = new Random();
        long start = System.nanoTime();
        x.contains(rand.nextInt());
        long stop = System.nanoTime();

        return stop - start;
    }

    private long averageTime(HashTableSet<Integer> x, long times){
        long average = 0L;
        for (int i = 0; i < times; i++){
            average += getContainsTime(x);
        }
        return average / times;
    }

    @Test
    public void times(){
        for (int num :
                tableSize) {
            HashTableSet<Integer> x = createTable(num);
            System.out.println("The time for " + num + " sized table was: ");
            System.out.println((averageTime(x, 100)));
        }
    }

}