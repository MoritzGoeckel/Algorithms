package Numerics;

import java.util.LinkedList;

public class FindPrime {

    public static Integer[] getPrimes(int end){
        LinkedList<Integer> primes = new LinkedList<>();

        Integer[] allNumbesr = new Integer[end + 1];
        for(int i = 0; i < allNumbesr.length; i++)
            allNumbesr[i] = i;

        for(int number = 2; number < allNumbesr.length; number++){
            if(allNumbesr[number] != null) {
                primes.add(number);
                for (int toRemove = 0; toRemove < allNumbesr.length; toRemove += number)
                    allNumbesr[toRemove] = null;
            }
        }

        return primes.toArray(new Integer[primes.size()]);
    }

}
