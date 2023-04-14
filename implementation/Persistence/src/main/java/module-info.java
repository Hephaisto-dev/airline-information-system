module persistence_module {
    requires datarecords_module;
    requires java.sql;
    requires org.postgresql.jdbc;
    exports persistence;
    exports persistence.database;
    requires java.naming;
    exports persistence.api;
}
