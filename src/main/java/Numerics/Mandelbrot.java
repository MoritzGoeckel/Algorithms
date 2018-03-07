package Numerics;

public class Mandelbrot {

    public static String generate(int width, int height) {

        StringBuilder sb = new StringBuilder();

        final double minReal = -2.0;
        final double maxReal = 1.0;

        final double minImaginary = -1.2;
        final double maxImaginary = minImaginary+(maxReal-minReal)*(double) height / (double)width;

        final double realStep = (maxReal-minReal)/(width-1);
        final double imaginaryStep = (maxImaginary-minImaginary)/(height-1);

        for(int y=0; y<height; ++y) {
            final double imaginary = maxImaginary - y * imaginaryStep;

            for(int x=0; x<width; ++x) {
                final double real = minReal + x * realStep;

                if(checkInMandelbrotSet(real, imaginary, 30))
                    sb.append("X");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static boolean checkInMandelbrotSet(double real, double imaginary, int maxIterations){
        double Z_re = real;
        double Z_im = imaginary;
        for(int iteration=0; iteration<maxIterations; iteration++) {
            double Z_re2 = Z_re*Z_re;
            double Z_im2 = Z_im*Z_im;
            if(Z_re2 + Z_im2 > 4) {
                return false;
            }
            Z_im = 2*Z_re*Z_im + imaginary;
            Z_re = Z_re2 - Z_im2 + real;
        }
        return true;
    }

}
