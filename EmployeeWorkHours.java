import java.util.HashMap;
import java.util.Map;

public class EmployeeWorkHours {
    public static void main(String[] args) {
        double[] hours = {
            35.5,
            42.0,
            38.0,
            45.0,
            36.0,
            41.0,
            40.0,
            39.0,
            44.0,
            37.5
        };

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> totalMap = new HashMap<>();

        for (double hour : hours) {
            double totalHours = hour * 7.0;

            if (totalHours > 40.0 * 7.0) {
                String range = "More than 40 hours";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + totalHours);
            } else if (totalHours == 40.0 * 7.0) {
                String range = "Exactly 40 hours";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + totalHours);
            } else {
                String range = "Less than 40 hours";
                countMap.putIfAbsent(range, 0);
                totalMap.putIfAbsent(range, 0.0);
                countMap.put(range, countMap.get(range) + 1);
                totalMap.put(range, totalMap.get(range) + totalHours);
            }
        }

        System.out.printf("%-25s%-15s%-15s%-15s%n", "Range", "Number of employees", "Total hours", "Average hours per day");

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double total = totalMap.get(range);
            double average = total / count / 7.0;

            System.out.printf("%-25s%-15d%-15.2f%-15.2f%n", range, count, total, average);
        }
    }
}
