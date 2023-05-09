package datarecords;

public record AirplaneData(String id, String manufacturer, int length, int width, String model, int seats) {

    public AirplaneData(String id, String manufacturer, int length, int width, String model, int seats) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.length = length;
        this.width = width;
        this.model = model;
        this.seats = seats;
    }
}
