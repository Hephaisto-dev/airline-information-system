package datarecords;

import java.time.LocalDate;

public record EmployeeData(String id, String firstName, String lastName, String email, String phoneNumber,
                           int employeeTypeId, LocalDate dob) {
}
