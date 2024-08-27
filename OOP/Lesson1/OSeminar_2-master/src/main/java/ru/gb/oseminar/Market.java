package ru.gb.oseminar;

import java.util.List;

public class Market implements MarketBehaviour {
    private final MarketQueue queue;

    public Market() {
        this.queue = new MarketQueue();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        queue.takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
        }
    }

    @Override
    public void update() {
        queue.takeOrders();
        queue.giveOrders();
        queue.releaseFromQueue();
    }
}