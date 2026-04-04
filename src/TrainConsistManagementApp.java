import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("==========================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie gb : goodsBogies) {
            System.out.println(gb.type + " -> " + gb.cargo);
        }

        boolean isSafe = goodsBogies.stream()
                .allMatch(gb -> {
                    if (gb.type.equalsIgnoreCase("Cylindrical")) {
                        return gb.cargo.equalsIgnoreCase("Petroleum") || gb.cargo.equalsIgnoreCase("Chemicals");
                    }
                    return true;
                });

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (!isSafe) {
            System.out.println("Train formation is NOT SAFE.");
        } else {
            System.out.println("Train formation is SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}