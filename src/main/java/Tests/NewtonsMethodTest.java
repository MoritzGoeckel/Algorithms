package Tests;

import Numerics.NewtonsMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewtonsMethodTest {
    @Test
    void findZero(){
        double xZero = NewtonsMethod.findZero(x -> x + 5, 100, 0.01, 3);
        assertEquals(-5, xZero, "Zero for (x -> x + 5) should be x = -5");
    }

    @Test
    void findValue(){
        double xValue = NewtonsMethod.findValue(20, x -> x + 5, 100, 0.01, 3);
        assertEquals(15, xValue, "20 for (x -> x + 5) should be x = 15");
    }
}
