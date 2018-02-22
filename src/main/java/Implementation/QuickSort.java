package Implementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {
        List<T> list = Arrays.asList(input);

        LinkedList<T> output = new LinkedList<T>();
        splitList(list, output);

        //Write back to array
        int i = 0;
        for(T item : output) {
            input[i] = item;
            i++;
        }
    }

    private void splitList(List<T> listToSort, LinkedList<T> sorted){
        T pivotElement = listToSort.get(listToSort.size() - 1);

        //Divide into two lists, lower and higher
        //than the pivot
        LinkedList<T> lessThan = new LinkedList<T>();
        LinkedList<T> moreThan = new LinkedList<T>();

        for(T item : listToSort) {
            if(pivotElement != item) {
                if (item.compareTo(pivotElement) < 0)
                    lessThan.add(item);
                else
                    moreThan.add(item);
            }
        }

        //Splitting and adding the lower list
        if(lessThan.size() > 0)
            splitList(lessThan, sorted);

        //Adding the pivot element as sorted
        sorted.add(pivotElement);

        //Splitting and adding the higher list
        if(moreThan.size() > 0)
            splitList(moreThan, sorted);
    }

}
