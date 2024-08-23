package org.example;
import java.util.List;

public class HotDrinkVendingMachine extends DrinkVendingMachine {

    public HotDrinkVendingMachine(List<Product> products) {
        super(products);
    }

    public HotDrink getProduct(String name, int volume, int temperature) {
        for (Product product : super.products) {
            if (product instanceof HotDrink hotDrink) {
                if (product.getName().equalsIgnoreCase(name) && hotDrink.getVolume() == volume && hotDrink.getTemperature() == temperature) {
                    super.cash += product.getCost();
                    return hotDrink;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s и указанным объемом не найден.", name));
    }
    public void purchaseProduct(String name, int volume, int temperature) {
        try {
            HotDrink product = getProduct(name, volume, temperature);
            System.out.println(product);
            System.out.println("Заработанные деньги: " + getCash());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

