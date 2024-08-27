package ru.gb.oseminar;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Actor john = new Human("Василий");
        Actor emily = new Human("Дмитрий");

        market.acceptToMarket(john);
        market.acceptToMarket(emily);

        market.update();
    }
}
