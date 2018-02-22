package Tests;

import Implementation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

        //Check if shuffled
        assertNotEquals(beforeShuffle, Arrays.toString(list));
    }

    @ParameterizedTest
    @ValueSource(classes = {SelectionSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, BubbleSort.class})
    void testSort(Class<? extends SortingAlgorithm> algorithm) throws IllegalAccessException, InstantiationException {
        //Create list with numbers
        Integer[] list = new Integer[100];
        for(int i = 0; i < list.length; i++)
            list[i] = i;

        //Shuffle the list
        SortingAlgorithm<Integer> shuffler = new Shuffle<Integer>();
        shuffler.sort(list);

        System.out.println("");
        System.out.println("Algorithm: \t" + algorithm.getSimpleName());
        System.out.println("Unsorted: \t" + Arrays.toString(list));

        //Sort the list
        SortingAlgorithm<Integer> sorter = algorithm.newInstance();
        sorter.sort(list);

        System.out.println("Sorted: \t" + Arrays.toString(list));

        //Check if sorted
        for(int i = 0; i < list.length; i++)
            assertEquals(new Integer(i), list[i]);
    }

}
