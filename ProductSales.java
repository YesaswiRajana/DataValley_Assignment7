import java.util.HashMap;
import java.util.Map;

public class ProductSales {
    public static void main(String[] args) {
        int[] sales = {30, 150, 220, 40, 120, 50, 300, 80, 200, 100};
        int[] lowerBounds = {0, 50, 100, 200, 500, 1000, 5000, 10000};
        int[] upperBounds = {50, 100, 200, 500, 1000, 5000, 10000, Integer.MAX_VALUE};

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> revenueMap = new HashMap<>();

        for (int i = 0; i < lowerBounds.length; i++) {
            countMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), 0);
            revenueMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), 0.0);
        }

        for (int sale : sales) {
            for (int i = 0; i < lowerBounds.length; i++) {
                if (sale >= lowerBounds[i] && sale <= upperBounds[i]) {
                    int count = countMap.get(String.format("$%d-%d", lowerBounds[i], upperBounds[i]));
                    countMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), count + 1);

                    double revenue = revenueMap.get(String.format("$%d-%d", lowerBounds[i], upperBounds[i]));
                    revenueMap.put(String.format("$%d-%d", lowerBounds[i], upperBounds[i]), revenue + sale);
                    break;
                }
            }
        }

        System.out.println("Price range | Number of products sold | Total revenue");
        for (String key : countMap.keySet()) {
            System.out.printf("%s | %d | $%.2f\n", key, countMap.get(key), revenueMap.get(key));
        }
    }
}
