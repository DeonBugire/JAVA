import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {

    private LaptopService service = new LaptopService();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.print("> ");

            String input = scanner.nextLine();
            if (input.equals("n")) {
                System.exit(0);
            }

            try {
                int criterion = Integer.parseInt(input);
                if (criterion < 1 || criterion > 4) {
                    System.out.println("Некорректный выбор. Пожалуйста, введите цифру от 1 до 4.");
                    continue;
                }

                System.out.print("Введите минимальное значение для выбранного критерия: ");
                String value = scanner.nextLine();

                Map<String, String> filterCriteria = new HashMap<>();
                switch (criterion) {
                    case 1 -> filterCriteria.put("ram", value);
                    case 2 -> filterCriteria.put("hdd", value);
                    case 3 -> filterCriteria.put("os", value);
                    case 4 -> filterCriteria.put("color", value);
                }

                String result = service.search(filterCriteria);
                System.out.println(result.isEmpty() ? "Ноутбуков, соответствующих критерию, не найдено." : result);

            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите цифру.");
            }

            System.out.println("Искать еще? (y/n)");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}


