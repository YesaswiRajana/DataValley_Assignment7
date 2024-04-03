import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HousingPrices {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<Integer>();
        prices.add(150000);
        prices.add(250000);
        prices.add(300000);
        prices.add(180000);
        prices.add(220000);
        prices.add(50000);
        prices.add(400000);
        prices.add(120000);
        prices.add(350000);
        prices.add(200000);

        ArrayList<Integer> squareFootages = new ArrayList<Integer>();
        squareFootages.add(1500);
        squareFootages.add(2500);
        squareFootages.add(3000);
        squareFootages.add(1800);
        squareFootages.add(2200);
        squareFootages.add(1000);
        squareFootages.add(4000);
        squareFootages.add(1400);
        squareFootages.add(3200);
        squareFootages.add(2000);

        int[] lowerBounds = {0, 100000, 200000, 300000, 400000};
        int[] upperBounds = {100000, 200000, 300000, 400000, Integer.MAX_VALUE};

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> squareFootageMap = new HashMap<>();
        Map<String, Double> avgSquareFootageMap = new HashMap<>();

        for (int i = 0; i < lowerBounds.length; i++) {
            countMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), 0);
            squareFootageMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), 0.0);
            avgSquareFootageMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), 0.0);
        }

        for (int i = 0; i < prices.size(); i++) {
            int price = prices.get(i);
            int squareFootage = squareFootages.get(i);

            for (int j = 0; j < lowerBounds.length; j++) {
                if (price >= lowerBounds[j] && price <= upperBounds[j]) {
                    int count = countMap.get(String.format("$%d-%d", lowerBounds[j], upperBounds[j]));
                    countMap.put(String.format("$%d-%d", lowerBounds[j], upperBounds[j]), count + 1);

                    double squareFootageSum = squareFootageMap.get(String.format("$%d-%d", lowerBounds[j], upperBounds[j]));
                    squareFootageMap.put(String.format("$%d-%d", lowerBounds[j], upperBounds[j]), squareFootageSum + squareFootage);
                    break;
                }
            }
        }

        for (String key : countMap.keySet()) {
            int count = countMap.get(key);
            double squareFootageSum = squareFootageMap.get(key);
            double avgSquareFootage = squareFootageSum / count;

            avgSquareFootageMap.put(key, avgSquareFootage);
        }

        System.out.println("Price range | Number of houses sold | Average square footage");
        for (String key : countMap.keySet()) {
            System.out.printf("%s | %d | %.2f\n", key, countMap.get(key), avgSquareFootageMap.get(key));
        }
    }
}
