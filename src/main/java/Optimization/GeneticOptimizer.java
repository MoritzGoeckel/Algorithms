package Optimization;


import java.util.*;

public class GeneticOptimizer {

    private CreationFunction creationFunction;
    private FitnessFunction rewardFunction;
    private MutationFunction mutationFunction;

    private Random rng;

    private int survivorPoolSize = 10;

    private HashSet<double[]> simulatedParameters = new HashSet<>();
    private TreeMap<Double, double[]> survivorPool = new TreeMap<>();

    private double[] bestOne;
    private double bestScore;

    public GeneticOptimizer(CreationFunction creationFunction, FitnessFunction rewardFunction, MutationFunction mutationFunction){
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

    public double[] optimize(int rounds){

        //Create initial pool without a given dna
        while (survivorPool.size() < survivorPoolSize) {
            double[] dna = creationFunction.create(rng);
            if(!simulatedParameters.contains(dna)) {
                double fitness = rewardFunction.estimateFitness(dna);
                if(fitness > bestScore){
                    bestScore = fitness;
                    bestOne = dna;
                }
                survivorPool.put(fitness, dna);
            }
        }

        for(int round = 0; round < rounds; round++){
            //Mutate and estimate fitness
            TreeMap<Double, double[]> sibblings = new TreeMap<>();

            for(double[] dna : survivorPool.values()){
                double[] mutatedDNA = mutationFunction.mutateFeatures(dna, rng);
                if(!simulatedParameters.contains(mutatedDNA)) {

                    double fitness = rewardFunction.estimateFitness(mutatedDNA);
                    if(fitness > bestScore){
                        bestScore = fitness;
                        bestOne = mutatedDNA;
                    }

                    sibblings.put(fitness, mutatedDNA);
                    simulatedParameters.add(mutatedDNA);
                }
            }
            survivorPool.putAll(sibblings);

            //Select
            ArrayList<Double> keys = new ArrayList<>(survivorPool.keySet());
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
