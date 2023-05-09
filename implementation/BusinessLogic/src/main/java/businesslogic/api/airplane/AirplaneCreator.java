package businesslogic.api.airplane;

import businesslogic.api.manager.AirplaneManager;

public class AirplaneCreator {
    private final AirplaneManager airplaneManager;

    public AirplaneCreator(AirplaneManager airplaneManager) {
        this.airplaneManager = airplaneManager;
    }

    public String createAirplane(String id, String manufacturer, int length, int width, String model, int seats) {
        boolean errors = false;
        Airplane airplane = null;
        StringBuilder stringBuilder = new StringBuilder();

        if (id == null || id.isEmpty()) {
            errors = true;
            stringBuilder.append("No plane ID was provided");
        } else if (model == null || model.isEmpty()) {
            errors = true;
            stringBuilder.append("No model was provided");
        } else if (manufacturer == null || manufacturer.isEmpty()) {
            errors = true;
            stringBuilder.append("No manufacturer was provided");
        } else {
            try {
                airplane = AirplaneFactory.createAirplane(id, manufacturer, width, length, model, seats);
            } catch (NoAirplaneException na) {
                errors = true;
                stringBuilder.append("An airplane with the provided ID does not exist in our database\n");
            }
        }

        if (!errors) {
            try {
                airplaneManager.add(airplane);
            } catch (Exception e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "If the issue persists, contact the IT department";
            }
            return "Airplane was successfully created";
        } else {
            stringBuilder.append(". Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
