package ru.gb.oseminar;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Actor actor1 = new Human("Василий");
        Actor actor2 = new Human("Дмитрий");
        Actor actor3 = new Human("Аня");

        market.acceptToMarket(actor1);
        market.acceptToMarket(actor2);
        market.acceptToMarket(actor3);

        market.update();
    }
}
