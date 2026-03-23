
import java.util.ArrayList;
import java.util.List;

    public class TrainConsistManagementApp {
        public static void main(String[] args) {
            System.out.println("\n UC2 - Add Passenger Bogies to Train ");

            List<String> passengerBogies = new ArrayList<>();

            passengerBogies.add("Sleeper");
            passengerBogies.add("AC Chair");
            passengerBogies.add("First Class");

            System.out.println("\nAfter Adding Bogies:");
            System.out.println("Passenger Bogies : " + passengerBogies + "\n");

            passengerBogies.remove("AC Chair");

            System.out.println("After Removing 'AC Chair':");
            System.out.println("Passenger Bogies : " + passengerBogies + "\n");

            System.out.println("Checking if 'Sleeper' exists:");
            System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper") + "\n");

            System.out.println("Final Train Passenger Consist:");
            System.out.println(passengerBogies + "\n");

            System.out.println("UC2 operations completed successfully...");
        }
    }
