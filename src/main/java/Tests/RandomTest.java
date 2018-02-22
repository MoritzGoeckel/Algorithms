package Tests;

import Numerics.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomTest {

    /*@Test
    void testRandom(){
        Random r = new Random();
        Integer[] list = new Integer[100];
        for(int i = 0; i < list.length; i++)
            list[i] = r.getNextInt(-5, 5);

        //System.out.println(Arrays.toString(list));
        //fail("Not implemented");
    }*/

    @Test
    void testRandomInt(){
        Random r = new Random();
        for(int i = 0; i < 100; i++)
            r.getNextInt();
    }

    @Test
    void testRandomIntInRange(){
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            int sample = r.getNextInt(-5, 5);
            assertTrue( sample > -5 && sample < 5 , "Should be over -5 and under 5");
        }
    }

    @Test
    void testRandomLong(){
        Random r = new Random();
        for(int i = 0; i < 100; i++)
            r.getNextLong();
    }

    @Test
    void testRandomDouble(){
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            double sample = r.getNextDouble();
            assertTrue( sample >= 0 && sample <= 1 , "Should be over 0 and under 1");
        }
    }

}
