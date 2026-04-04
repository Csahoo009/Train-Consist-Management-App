import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("==========================================\n");

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + bogie1.name + " -> " + bogie1.capacity);

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + bogie2.name + " -> " + bogie2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}