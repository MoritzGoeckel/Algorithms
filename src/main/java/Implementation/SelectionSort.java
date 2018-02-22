package Implementation;

public class SelectionSort<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {
        for(int i = 0; i < input.length; i++) {

            int minIndex = i;
            T min = input[i];
            for (int lookatIndex = i + 1; lookatIndex < input.length; lookatIndex++)
                if(input[lookatIndex].compareTo(min) < 0){
                    min = input[lookatIndex];
                    minIndex = lookatIndex;
                }

            if(minIndex != i){
                T tmp = input[minIndex];
                input[minIndex] = input[i];
                input[i] = tmp;
            }
        }
    }

}
