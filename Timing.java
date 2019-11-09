package assignment08;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Random;

public class Timing {

    private HashTableSet<A08String> table;
    private ArrayList<Integer> tableSize;
    private A08String itemInTable;

    @Before
    public void setUp(){
        table = new HashTableSet<>();
        tableSize = new ArrayList<Integer>();
        itemInTable = new A08String();
        for (int i = 0; i < 8; i++) { //from 10^1 to 10^8
            tableSize.add((int) (Math.pow(10, i + 1)));
        }

    }

    private long createTable(int size){
        table.clear();
        Random rand = new Random();
        A08String element = new A08String();
        for(int i = 0; i < size; i++){
            //two random ints chained together such that the table is unlikely to contain the element
            itemInTable = new A08String(String.valueOf(rand.nextInt()) + String.valueOf(rand.nextInt()));
            table.add(itemInTable); //add a new number as a A08String
        }
        long start = System.nanoTime();
        table.contains(itemInTable);
        long stop = System.nanoTime();
        return stop - start;
    }

    @Test
    public void times(){
        for (int num :
                tableSize) {
            System.out.println("The time for " + num + " sized table was: ");
            System.out.println(createTable(num));
        }
    }

}
