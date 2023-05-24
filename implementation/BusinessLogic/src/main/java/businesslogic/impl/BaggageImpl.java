package businesslogic.impl;

import businesslogic.api.baggage.Baggage;

public class BaggageImpl implements Baggage {
    private final boolean cargo;
    private final int height;
    private final int width;
    private final int length;
    private final int weight;
    private final Integer id;

    public BaggageImpl(boolean cargo, int height, int width, int length, int weight, Integer id) {
        this.cargo = cargo;
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.id = id;
    }

    @Override
    public boolean isCarryOn() {
        return !isCargo();
    }

    @Override
    public boolean isCargo() {
        return cargo;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
