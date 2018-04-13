package Tests;

import Numerics.NewtonsMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewtonsMethodTest {
    @Test
    void newtonsMethodTest(){
        double xZero = NewtonsMethod.findZero(x -> x + 5, 100, 0.01, 3);
        assertEquals(-5, xZero, "Zero of (x -> x + 5) should be -5");
    }
}
