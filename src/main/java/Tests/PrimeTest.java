package Tests;

import Numerics.FindPrime;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeTest {

    @Test
    void primeTest(){
        Integer[] primes = FindPrime.getPrimes(120);
        assertEquals(
                "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113]",
                Arrays.toString(primes)
        );
    }

}
