package Tests;

import Optimization.GeneticOptimizer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GeneticTest {

    @Test
    void geneticTest(){

        GeneticOptimizer<double[], Double> optimizer = new GeneticOptimizer<>(
                (rng) -> (new double[]{rng.nextDouble(), rng.nextDouble(), rng.nextDouble()}),
                (features) -> (features[0] + features[1] - features[2]),
                (features, rng) -> (
                        new double[]{
                                features[0] + ((rng.nextDouble() / 10d) - (1d / 10d / 2)),
                                features[1] + ((rng.nextDouble() / 10d) - (1d / 10d / 2)),
                                features[2] + ((rng.nextDouble() / 10d) - (1d / 10d / 2))
                        })
        );

        optimizer.setSurvivorPoolSize(40);

        /*for(int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(optimizer.optimize(100)));
        }*/

        double[] winner = optimizer.optimize(100);

        assertTrue(winner[0] > 0, "Should be positive to be optimal");
        assertTrue(winner[1] > 0, "Should be positive to be optimal");
        assertTrue(winner[2] < 0, "Should be negative to be optimal");
    }

    //@Test //Todo: Enable again. Quite an expensive test.
    void testDistribution(){
        Random r = new Random();
        HashMap<Integer, Integer> distribution = new HashMap<>();

        int buckets = 10;

        for(int i = 0; i < 10000; i++){
            int number = GeneticOptimizer.getWightedRandomIndex(r, buckets);
            if(!distribution.containsKey(number))
                distribution.put(number, 0);
            distribution.put(number, distribution.get(number) + 1);
        }

        //System.out.println(distribution);

        for(int i = 1; i < 10; i++)
            assertTrue(distribution.get(i) < distribution.get(i - 1), "Low indices should be hit more often than high ones:" + distribution.get(i) +">"+ distribution.get(i - 1));
    }
}
