module businesslogic_module {
    requires transitive datarecords_module;
    requires transitive persistence_module;

    exports businesslogic.api;
    exports businesslogic.api.airplane;
    exports businesslogic.api.flight;
    exports businesslogic.api.route;
    exports businesslogic.api.customer;
    exports businesslogic.api.common;
    exports businesslogic.api.manager;
    exports businesslogic.api.airport;
    exports businesslogic.api.booking;
    exports businesslogic.api.employee;
}
