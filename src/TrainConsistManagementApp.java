import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 50) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();

        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();

        System.out.println("Loop Execution Time (ns): " + (endTimeLoop - startTimeLoop));
        System.out.println("Stream Execution Time (ns): " + (endTimeStream - startTimeStream));

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}