package ru.gb.oseminar;

public abstract class Actor implements ActorBehaviour {
    protected final String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        this.isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean takeOrder) {
        this.isTakeOrder = takeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return this.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return this.isTakeOrder;
    }
}
