package persistence.impl;

import datarecords.AirplaneData;
import persistence.api.AirplaneStorageService;

import javax.sql.DataSource;

public class AirplaneStorageServiceImpl implements AirplaneStorageService {
    private final DataSource dataSource;

    public AirplaneStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AirplaneData add(AirplaneData customerData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
