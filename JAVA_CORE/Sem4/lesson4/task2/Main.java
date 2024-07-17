package lesson4.task2;

import lesson4.task2.enums.Gender;
import lesson4.task2.enums.Holiday;
import lesson4.task2.model.Customer;
import lesson4.task2.model.Employee;
import lesson4.task2.model.Product;
import lesson4.task2.service.GreetingService;
import lesson4.task2.service.OrderService;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("Alice", 1, Gender.FEMALE),
                new Customer("Bob", 2, Gender.MALE),
                new Customer("Charlie", 3, Gender.FEMALE)
        };

        Employee[] employees = {
                new Employee("Dave", 1, Gender.MALE),
                new Employee("Eve", 2, Gender.FEMALE),
                new Employee("Frank", 3, Gender.MALE)
        };

        Product[] products = {
                new Product("Laptop", 1, 1500.0),
                new Product("Phone", 2, 800.0),
                new Product("Tablet", 3, 600.0)
        };

        OrderService orderService = new OrderService(customers, products);

        try {
            orderService.makePurchase("Alice", "Laptop", 1);
        } catch (Exception e) {
            System.out.println("Error making purchase: " + e.getMessage());
        }

        try {
            orderService.makePurchase("Bob", "Phone", 2);
        } catch (Exception e) {
            System.out.println("Error making purchase: " + e.getMessage());
        }

        try {
            orderService.makePurchase("Charlie", "Tablet", -1);
        } catch (Exception e) {
            System.out.println("Error making purchase: " + e.getMessage());
        }

        try {
            orderService.makePurchase("Alice", "Phone", 1);
        } catch (Exception e) {
            System.out.println("Error making purchase: " + e.getMessage());
        }

        try {
            orderService.makePurchase("Unknown", "Laptop", 1);
        } catch (Exception e) {
            System.out.println("Error making purchase: " + e.getMessage());
        }

        System.out.println("Total purchases made: " + orderService.getOrderCount());

        // Поздравление с праздниками
        GreetingService greetingService = new GreetingService();
        greetingService.congratulate(Holiday.NEW_YEAR, customers, employees);
        greetingService.congratulate(Holiday.INTERNATIONAL_WOMEN_DAY, customers, employees);
        greetingService.congratulate(Holiday.DEFENDERS_OF_THE_FATHERLAND_DAY, customers, employees);
    }
}
