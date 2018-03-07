package Tests;

import Numerics.Mandelbrot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MandelbrotTest {

    @Test
    void mandelbrotTest(){
        String output = Mandelbrot.generate(30, 30);

        assertEquals(
        "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                  X           \n" +
                "                  XX          \n" +
                "                  X           \n" +
                "              XXXXXXXXX       \n" +
                "             XXXXXXXXXX       \n" +
                "             XXXXXXXXXXX      \n" +
                "        XXXX XXXXXXXXXXX      \n" +
                "        XXXX XXXXXXXXXXX      \n" +
                "       XXXXXXXXXXXXXXXX       \n" +
                "        XXXXXXXXXXXXXXX       \n" +
                "        XXXX XXXXXXXXXX       \n" +
                "        XX   XXXXXXXXXXX      \n" +
                "             XXXXXXXXXXX      \n" +
                "             XXXXXXXXXX       \n" +
                "              X XXXXXXX       \n" +
                "                  XX          \n" +
                "                  XX          \n" +
                "                              \n" +
                "                              \n" +
                "                              \n" +
                "                              \n", output);
    }

}
