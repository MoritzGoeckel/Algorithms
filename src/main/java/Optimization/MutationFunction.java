package Optimization;

import java.util.Random;

public interface MutationFunction{
    double[] mutateFeatures(double[] features, Random rng);
}
