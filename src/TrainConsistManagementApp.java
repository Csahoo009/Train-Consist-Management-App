import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 5);
    }

    public void restoreInventory(String roomType) {
        inventory.put(roomType, inventory.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

public class TrainConsistManagementApp {
    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public TrainConsistManagementApp() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            String roomType = reservationRoomTypeMap.get(reservationId);
            inventory.restoreInventory(roomType);
            releasedRoomIds.push(reservationId);
            reservationRoomTypeMap.remove(reservationId);

            System.out.println("Booking Cancellation");
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        }
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }

    public static void main(String[] args) {
        RoomInventory hotelInventory = new RoomInventory();
        TrainConsistManagementApp service = new TrainConsistManagementApp();

        service.registerBooking("Single-1", "Single");

        service.cancelBooking("Single-1", hotelInventory);
        service.showRollbackHistory();

        System.out.println("\nUpdated Single Room Availability: " + hotelInventory.getAvailability("Single"));
    }
}