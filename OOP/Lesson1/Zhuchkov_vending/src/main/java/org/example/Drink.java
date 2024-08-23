package org.example;

public class Drink extends Product {
    private final int volume;

    public Drink(String name, double cost, int volume) {
        super(name, cost);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + super.getName() + '\'' +
                ", volume=" + volume +
                ", cost=" + super.getCost() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;
        if (!super.equals(o)) return false;

        Drink drink = (Drink) o;

        return volume == drink.volume;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + volume;
        return result;
    }
}
