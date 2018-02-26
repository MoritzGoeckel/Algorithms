package Optimization;

import java.util.*;

public class GeneticOptimizer<DNAType, FITNESSType extends Comparable> {

    private CreationFunction<DNAType> creationFunction;
    private FitnessFunction<FITNESSType, DNAType> rewardFunction;
    private MutationFunction<DNAType> mutationFunction;

    private Random rng;

    private int survivorPoolSize = 10;

    private HashSet<DNAType> simulatedParameters = new HashSet<>();
    private TreeMap<FITNESSType, DNAType> survivorPool = new TreeMap<>();

    private DNAType bestOne;
    private FITNESSType bestScore;

    public GeneticOptimizer(CreationFunction<DNAType> creationFunction, FitnessFunction<FITNESSType, DNAType> rewardFunction, MutationFunction<DNAType> mutationFunction){
        this.creationFunction = creationFunction;
        this.rewardFunction = rewardFunction;
        this.mutationFunction = mutationFunction;
        this.rng = new Random();
    }

    public int getSurvivorPoolSize() {
        return survivorPoolSize;
    }

    public void setSurvivorPoolSize(int survivorPoolSize) {
        this.survivorPoolSize = survivorPoolSize;
    }

    public DNAType optimize(int rounds){

        //Create initial pool without a given dna
        while (survivorPool.size() < survivorPoolSize) {
            DNAType dna = creationFunction.create(rng);
            if(!simulatedParameters.contains(dna)) {
                FITNESSType fitness = rewardFunction.estimateFitness(dna);
                if(bestScore == null || fitness.compareTo(bestScore) > 0){
                    bestScore = fitness;
                    bestOne = dna;
                }
                survivorPool.put(fitness, dna);
            }
        }

        for(int round = 0; round < rounds; round++){
            //Mutate and estimate fitness
            TreeMap<FITNESSType, DNAType> sibblings = new TreeMap<>();

            for(DNAType dna : survivorPool.values()){
                DNAType mutatedDNA = mutationFunction.mutate(dna, rng);
                if(!simulatedParameters.contains(mutatedDNA)) {

                    FITNESSType fitness = rewardFunction.estimateFitness(mutatedDNA);
                    if(fitness.compareTo(bestScore) > 0){
                        bestScore = fitness;
                        bestOne = mutatedDNA;
                    }

                    sibblings.put(fitness, mutatedDNA);
                    simulatedParameters.add(mutatedDNA);
                }
            }
            survivorPool.putAll(sibblings);

            //Select
            ArrayList<FITNESSType> keys = new ArrayList<>(survivorPool.keySet());
            while (survivorPool.size() > survivorPoolSize) {
                int index = getWightedRandomIndex(rng, keys.size());
                survivorPool.remove(keys.get(index));
                keys.remove(index);
            }
        }

        //Return the best
        return bestOne;
    }

    public static int getWightedRandomIndex(Random r, int buckets){
        //Massively increases the chance of picking low indexes
        //Decreases the chance of picking high indexes
        return (int) Math.floor(Math.pow(Math.E, (r.nextDouble() * Math.log(buckets + 1))) - 1);
    }
}
