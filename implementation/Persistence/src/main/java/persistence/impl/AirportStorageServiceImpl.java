package persistence.impl;

import datarecords.AirportData;
import persistence.api.AirportStorageService;

import javax.sql.DataSource;

public class AirportStorageServiceImpl implements AirportStorageService {
    private final DataSource dataSource;
    public AirportStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AirportData add(AirportData customerData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
