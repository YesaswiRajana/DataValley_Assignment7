import java.util.HashMap;
import java.util.Map;

public class WeatherData {
    public static void main(String[] args) {
        double[][] data = {
            {-1.0, 80.0},
            {2.0, 60.0},
            {10.0, 40.0},
            {15.0, 50.0},
            {22.0, 70.0},
            {-5.0, 90.0},
            {20.0, 30.0},
            {-3.0, 75.0},
            {12.0, 55.0},
            {18.0, 65.0}
        };

        Map<Integer, Integer> tempCounts = new HashMap<>();
        Map<Integer, Double> tempTotals = new HashMap<>();

        for (double[] d : data) {
            int temp = (int) Math.floor(d[0]);
            double humidity = d[1];

            if (!tempCounts.containsKey(temp)) {
                tempCounts.put(temp, 0);
                tempTotals.put(temp, 0.0);
            }

            tempCounts.put(temp, tempCounts.get(temp) + 1);
            tempTotals.put(temp, tempTotals.get(temp) + humidity);
        }

        System.out.printf("%-20s%-15s%-15s%n", "Temperature range", "Number of days", "Average humidity");

        for (Map.Entry<Integer, Integer> entry : tempCounts.entrySet()) {
            int temp = entry.getKey();
            int count = entry.getValue();
            double total = tempTotals.get(temp);
            double avgHumidity = total / count;

            System.out.printf("%-20.0f°C - %-10.0f°C%-15d%-15.1f%%%n", Math.floor(temp), Math.ceil(temp + 1.0), count, avgHumidity);
        }
    }
} 
