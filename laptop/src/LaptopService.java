import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LaptopService {

    private Set<Laptop> laptops = new HashSet<>();

    public LaptopService() {
        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 1024, "Windows", "Silver"));
        laptops.add(new Laptop("Apple", 8, 256, "macOS", "Gray"));
        laptops.add(new Laptop("Asus", 4, 500, "Linux", "Black"));
        laptops.add(new Laptop("Lenovo", 16, 512, "Windows", "White"));
    }

    public String search(Map<String, String> criteria) {
        return laptops.stream()
                .filter(laptop -> matches(laptop, criteria))
                .map(Laptop::toString)
                .collect(Collectors.joining("\n"));
    }

    private boolean matches(Laptop laptop, Map<String, String> criteria) {
        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toLowerCase();

            switch (key) {
                case "ram":
                    if (laptop.getRam() < Integer.parseInt(value)) {
                        return false;
                    }
                    break;
                case "hdd":
                    if (laptop.getHdd() < Integer.parseInt(value)) {
                        return false;
                    }
                    break;
                case "os":
                    if (!laptop.getOs().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
                case "color":
                    if (!laptop.getColor().equalsIgnoreCase(value)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
