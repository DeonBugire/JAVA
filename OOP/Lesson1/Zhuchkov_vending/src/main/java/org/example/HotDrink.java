package org.example;

public class HotDrink extends Drink {
    private final int temperature;

    public HotDrink(String name, double cost, int volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + super.getName() + '\'' +
                ", volume=" + super.getVolume() +
                ", temperature=" + temperature +
                ", cost=" + super.getCost() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotDrink)) return false;
        if (!super.equals(o)) return false;

        HotDrink hotDrink = (HotDrink) o;

        return temperature == hotDrink.temperature;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + temperature;
        return result;
    }
}
