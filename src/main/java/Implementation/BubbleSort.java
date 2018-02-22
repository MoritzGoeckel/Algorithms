package Implementation;

public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {
        for (int lastIndex = input.length - 1; lastIndex > 0; lastIndex--){
            for(int i = 0; i < lastIndex; i++)
            {
                if(input[i + 1].compareTo(input[i]) < 0){
                    T tmp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = tmp;
                }
            }
        }
    }

}
