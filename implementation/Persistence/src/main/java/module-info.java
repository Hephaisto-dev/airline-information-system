module persistence_module {
    requires datarecords_module;
    requires java.sql;
    requires org.postgresql.jdbc;
    //exports persistence.impl;
    requires java.naming;
    exports persistence.api;
    exports persistence.impl.database;
    exports persistence.impl;
}
