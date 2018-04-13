package Numerics;

import java.util.function.Function;

public class NewtonsMethod {
    public static double findZero(Function<Double, Double> f, double start, double delta, int iterations){

        double x = start;
        for(int i = 0; i < iterations; i++){
            //Cache fx
            double fx = f.apply(x);

            //Find derivative
            double dFx = (f.apply(x + delta) - fx) / delta;

            //Calculate next x
            x = x - fx / dFx;
        }

        return x;
    }

    public static double findValue(double value, Function<Double, Double> f, double start, double delta, int iterations){
        return findZero(x -> f.apply(x) - value, start, delta, iterations);
    }
}
