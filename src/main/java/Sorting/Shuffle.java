package Sorting;

import java.util.Random;

public class Shuffle<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {
        Random r = new Random();

        for(int i = 0; i < input.length; i++) {
            int randomIndex = (int)Math.floor(r.nextFloat() * input.length);
            T tmp = input[randomIndex];
            input[randomIndex] = input[i];
            input[i] = tmp;
        }
    }

}
