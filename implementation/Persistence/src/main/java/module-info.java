module persistence_module {
    requires datarecords_module;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.naming;
    exports persistence.api;
}
