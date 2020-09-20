package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaPractice {
    int getPopulation(List<Country> countries, String continent) {
        int populations = countries.stream()
                .filter(x -> continent.equals(x.getContinent()))
                .map(Country::getPopulation).mapToInt(x -> x).sum();
        int population2 = countries.stream()
                .filter(x -> continent.equals(x.getContinent()))
                .map(Country::getPopulation).reduce(0, Integer::sum);
        return populations;
    }
    /**
     * returns a random subset of arbitrary size.
     * All subsets (including the empty set) should be equally likely to be chosen.
     * */

    public static List<Integer> getRandomSubset(List<Integer> list) {
        int newListSize = getRandom(list.size(), 0);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < newListSize; i++) {
            result.add(list.get(getRandom(list.size()-1, 0)));
        }
        return result;
    }

    private static int getRandom(int max, int min) {
        return (int) (Math.random()*(max - min + 1)) + min;
    }

    /**
     * ask order/duplicate
     * */

    public static List<Integer> getRandomSubsetByLambda(List<Integer> list) {
        Random random = new Random();
        return list.stream().filter(x -> random.nextBoolean()).collect(Collectors.toList());
    }
}

class Country {
    String getContinent() {
      return "";
    }

    int getPopulation() {
        return 0;
    }


}
