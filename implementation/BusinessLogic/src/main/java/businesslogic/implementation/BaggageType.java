package businesslogic.implementation;

import businesslogic.api.baggage.Baggage;

public enum BaggageType {
    SMALL(new BaggageImpl(false, 55, 35, 20, 8, 1)),
    MEDIUM(new BaggageImpl(false, 70, 50, 30, 15, 2)),
    LARGE(new BaggageImpl(false, 90, 60, 40, 25, 3)),
    CARGO(new BaggageImpl(true, 100, 100, 100, 100, 4)),
    ANIMAL(new BaggageImpl(true, 200, 200, 200, 200, 5));;
    private final Baggage baggage;

    BaggageType(Baggage baggage) {
        this.baggage = baggage;
    }

    public static Baggage getBaggage(int id) {
        for (BaggageType type : BaggageType.values()) {
            if (type.baggage.getId() == id) {
                return type.baggage;
            }
        }
        return null;
    }
}
