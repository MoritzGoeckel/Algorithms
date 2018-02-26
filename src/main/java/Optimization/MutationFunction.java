package Optimization;

import java.util.Random;

public interface MutationFunction<DNAType>{
    DNAType mutate(DNAType dna, Random rng);
}
