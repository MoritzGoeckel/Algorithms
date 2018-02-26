package Optimization;

public interface FitnessFunction<FITNESSType extends Comparable, DNAType>{
    FITNESSType estimateFitness(DNAType dna);
}
