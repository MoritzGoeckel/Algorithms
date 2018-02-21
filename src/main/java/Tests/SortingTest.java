package Tests;

import Implementation.InsertionSort;
import Implementation.Shuffle;
import Implementation.SortingAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SortingTest {

    @Test
    void testShuffle(){
        //Create sorted list
        Integer[] list = new Integer[100];
        for(int i = 0; i < list.length; i++)
            list[i] = i;

        String beforeShuffle = Arrays.toString(list);

        SortingAlgorithm<Integer> shuffler = new Shuffle<Integer>();
        shuffler.sort(list);

        //Compare
        assertNotEquals(beforeShuffle, Arrays.toString(list));
    }

    @Test
    void testSort(){
        Integer[] list = new Integer[100];
        for(int i = 0; i < list.length; i++)
            list[i] = i;

        SortingAlgorithm<Integer> shuffler = new Shuffle<Integer>();
        shuffler.sort(list);

        //System.out.println("Unsorted: \t" + Arrays.toString(list));

        SortingAlgorithm<Integer> sorter = new InsertionSort<Integer>();
        sorter.sort(list);

        //System.out.println("Sorted: \t" + Arrays.toString(list));

        for(int i = 0; i < list.length; i++)
            assertEquals(new Integer(i), list[i]);
    }

}
