package org.example;

import java.util.List;

public class DrinkVendingMachine implements VendingMachine {
    protected final List<Product> products;
    protected double cash = 0.0;

    public DrinkVendingMachine(List<Product> products) {
        this.products = products;
    }

    @Override
    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                cash += product.getCost();
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    public Drink getProduct(String name, int volume) {
        for (Product product : products) {
            if (product instanceof Drink drink) {
                if (product.getName().equalsIgnoreCase(name) && drink.getVolume() == volume) {
                    cash += product.getCost();
                    return drink;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    public double getCash() {
        return cash;
    }
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                cash += product.getCost();
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт с названием %s не найден.", name));
    }
    public void purchaseProductByName(String name) {
        try {
            Product product = getProductByName(name);
            System.out.println(product);
            System.out.println("Заработанные деньги: " + getCash());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}