package Numerics;

import java.util.LinkedList;

public class FindPrime {

    public static Integer[] getPrimes(int end){
        LinkedList<Integer> primes = new LinkedList<>();

        //Filling array with numbers
        Integer[] allNumbers = new Integer[end + 1];
        for(int i = 0; i < allNumbers.length; i++)
            allNumbers[i] = i;

        //Starting with 2
        for(int number = 2; number < allNumbers.length; number++){
            if(allNumbers[number] != null) {
                //Found a prime
                primes.add(number);

                //Removing multiples of primes
                for (int toRemove = 0; toRemove < allNumbers.length; toRemove += number)
                    allNumbers[toRemove] = null;
            }
        }

        return primes.toArray(new Integer[primes.size()]);
    }

}
