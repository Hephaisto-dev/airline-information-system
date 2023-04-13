package businesslogic.api.employee;

import businesslogic.api.common.Identifiable;

public enum EmployeeType implements Identifiable<Integer> {
    SALES_OFFICER(0),
    SALES_MANAGER(1),
    SALES_EMPLOYEE(2),
    ;
    private final int id;

    EmployeeType(int id) {
        this.id = id;
    }

    public static EmployeeType fromId(int id) {
        for (EmployeeType employeeType : values()) {
            if (employeeType.getId() == id) {
                return employeeType;
            }
        }
        throw new IllegalArgumentException("No EmployeeType with id " + id);
    }

    @Override
    public Integer getId() {
        return id;
    }
}
