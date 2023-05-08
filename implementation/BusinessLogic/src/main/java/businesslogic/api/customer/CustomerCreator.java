package businesslogic.api.customer;

import businesslogic.api.manager.CustomerManager;

import java.time.LocalDate;

public class CustomerCreator {
    private final static String emailRegex = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
    private final CustomerManager customerManager;

    public CustomerCreator(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public String createCustomer(String firstName, String lastName, LocalDate dob, String email) {
        StringBuilder stringBuilder = new StringBuilder();
        if (firstName == null || firstName.isEmpty()) {
            stringBuilder.append("First name is empty, ");
        }
        if (lastName == null || lastName.isEmpty()) {
            stringBuilder.append("Last name is empty, ");
        }
        if (dob == null) {
            stringBuilder.append("Date of birth is empty, ");
        } else if (dob.isAfter(LocalDate.now())) {
            stringBuilder.append("Date of birth is in the future, ");
        }
        if (email == null || email.isEmpty()) {
            stringBuilder.append("Email is empty, ");
        } else if (!email.matches(emailRegex)) {
            stringBuilder.append("Email is not valid, ");
        }
        if (stringBuilder.length() == 0) {
            try {
                Customer customer = customerManager.add(CustomerFactory.createCustomer("CU_" + email, firstName,
                        lastName, dob, email));
                if (customer == null) {
                    stringBuilder.append("Customer already exists.");
                } else {
                    stringBuilder.append("Customer created successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                stringBuilder.append("Error creating customer.");
            }
        } else {
            stringBuilder.append("Please correct this and try again.");
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }
}
