package Numerics;

public class Random {

    private long lastNumber;

    public Random(){
        this.lastNumber = System.currentTimeMillis();
    }

    public long getNextLong(){
        long A = 1103515245, C = 12345, M = 2^31;
        lastNumber = lastNumber * A + C % M;
        return lastNumber;
    }

    public double getNextDouble(){
        return Math.abs((double) getNextLong()) / Long.MAX_VALUE;
    }

    public int getNextInt(){
        return (int)(
                (double)Integer.MIN_VALUE +
                (getNextDouble() * (Math.abs((long) Integer.MAX_VALUE) + Math.abs((long) Integer.MIN_VALUE)))
        );
    }

    public int getNextInt(int min, int max){
        return (int)(min + getNextDouble() * (Math.abs(max) + Math.abs(min)));
    }

}
