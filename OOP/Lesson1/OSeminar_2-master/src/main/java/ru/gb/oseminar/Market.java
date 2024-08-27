package ru.gb.oseminar;

import java.util.List;

public class Market implements MarketBehaviour {
    private final MarketQueue marketQueue;

    public Market() {
        this.marketQueue = new MarketQueue();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        marketQueue.addActorToQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
        }
    }

    @Override
    public void update() {
        marketQueue.processOrders();
        marketQueue.deliverOrders();
        List<Actor> actorsToRelease = marketQueue.releaseActorsFromQueue();
        if (!actorsToRelease.isEmpty()) {
            releaseFromMarket(actorsToRelease);
        }
    }
}
