package Implementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public void sort(T[] input) {

        //Create a list of lists from the input array
        ArrayList<LinkedList<T>> list = new ArrayList<LinkedList<T>>();
        for(T item : input) {
            LinkedList<T> sublist = new LinkedList<T>();
            sublist.add(item);
            list.add(sublist);
        }

        //Keep merging
        //as long as there are lists to merge
        while (list.size() > 1) {
            ArrayList<LinkedList<T>> mergedList = new ArrayList<LinkedList<T>>();
            for (int i = 0; i < list.size(); i += 2) {

                //If number of items uneven,
                //just process the last one the next time
                if(i + 1 == list.size()){
                    mergedList.add(list.get(i));
                    break;
                }

                //Merge the two lists into
                //an sorted list.
                LinkedList<T> sortedSublist = new LinkedList<T>();

                //Repeat until both lists are done
                while (list.get(i).size() > 0 || list.get(i + 1).size() > 0) {

                    //Add the lower item to the sortedSublist
                    //or take the last one that is left
                    if (list.get(i).size() != 0 && (list.get(i + 1).size() == 0 || list.get(i).getFirst().compareTo(list.get(i + 1).getFirst()) < 0)) {
                        sortedSublist.add(list.get(i).getFirst());
                        list.get(i).removeFirst();
                    } else {
                        sortedSublist.add(list.get(i + 1).getFirst());
                        list.get(i + 1).removeFirst();
                    }
                }
                mergedList.add(sortedSublist);
            }

            //the list of merged lists
            //is now the new list (like recursion)
            list = mergedList;
        }

        //Write the sorted list of lists
        //back into the array
        for(int i = 0; i < list.get(0).size(); i++)
            input[i] = list.get(0).get(i);
    }

}
