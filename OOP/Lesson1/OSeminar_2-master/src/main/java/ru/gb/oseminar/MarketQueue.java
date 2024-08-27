package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

public class MarketQueue {
    private final List<Actor> queue;

    public MarketQueue() {
        this.queue = new ArrayList<>();
    }

    public void addActorToQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        this.queue.add(actor);
    }

    public void processOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    public void deliverOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder() && !actor.isTakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    public List<Actor> releaseActorsFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
        queue.removeAll(releasedActors);
        return releasedActors;
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}