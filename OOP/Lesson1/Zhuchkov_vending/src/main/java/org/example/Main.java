package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new HotDrink("Кофе", 150, 200, 85),
                new HotDrink("Чай", 100, 250, 90),
                new Drink("Сок", 50, 250),
                new Drink("Вода", 30, 500)
        );

        HotDrinkVendingMachine drinkMachine = new HotDrinkVendingMachine(products);

        drinkMachine.purchaseProductByName("Сок");
        drinkMachine.purchaseProductByName("Чай");
        drinkMachine.purchaseProductByName("Лимонад");
        drinkMachine.purchaseProduct("Кофе", 200, 85);
        drinkMachine.purchaseProduct("Чай", 300, 90);
        System.out.println("Итоговая сумма заработанных денег: " + drinkMachine.getCash());
    }
}
