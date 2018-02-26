package Optimization;

import java.util.Random;

public interface CreationFunction<DNAType>{
    DNAType create(Random rng);
}
