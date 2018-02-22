package Sorting;

public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {
        for(int i = 1; i < input.length; i++) {
            for (int switchIndex = i; switchIndex > 0 && input[switchIndex].compareTo(input[switchIndex - 1]) < 0; switchIndex--) {
                T tmp = input[switchIndex - 1];
                input[switchIndex - 1] = input[switchIndex];
                input[switchIndex] = tmp;
            }
        }
    }

}
