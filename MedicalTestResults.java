import java.util.HashMap;
import java.util.Map;

public class MedicalTestResults {
    public static void main(String[] args) {
        double[] results = {
            75.5,
            68.4,
            82.3,
            91.2,
            64.1,
            79.0,
            89.6,
            55.2,
            70.1,
            76.8
        };

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> totalMap = new HashMap<>();

        for (double result : results) {
            if (result < 70.0) {
                String range = "Low";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + result);
            } else if (result < 80.0) {
                String range = "Normal";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + result);
            } else {
                String range = "High";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + result);
            }
        }

        System.out.printf("%-15s%-10s%-15s%-15s%n", "Range", "Number of patients", "Total", "Average");

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double total = totalMap.get(range);
            double average = total / count;

            System.out.printf("%-15s%-10d%-15.2f%-15.2f%n", range, count, total, average);
        }
    }
}
