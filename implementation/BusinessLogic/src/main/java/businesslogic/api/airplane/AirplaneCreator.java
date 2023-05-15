package businesslogic.api.airplane;

import businesslogic.api.manager.AirplaneManager;

public class AirplaneCreator {
    private final AirplaneManager airplaneManager;

    public AirplaneCreator(AirplaneManager airplaneManager) {
        this.airplaneManager = airplaneManager;
    }

    public String createAirplane(String id, String manufacturer, int length, int width, String model, int seats) {

        StringBuilder stringBuilder = new StringBuilder();

        if (id == null || id.isEmpty()) {
            stringBuilder.append("No plane ID was provided");
        } else if (model == null || model.isEmpty()) {
            stringBuilder.append("No model was provided");
        } else if (manufacturer == null || manufacturer.isEmpty()) {
            stringBuilder.append("No manufacturer was provided");
        }


        if (stringBuilder.length() == 0) {
            try {
                Airplane airplane = AirplaneFactory.createAirplane(id, manufacturer, width, length, model, seats);
                airplaneManager.add(airplane);
                return "Airplane was successfully created";
            } catch (Exception e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "If the issue persists, contact the IT department";
            }
        } else {
            stringBuilder.append(". Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
